package client;

import another.Request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientApp {

    private SocketChannel socketChannel;

    public void read(){
        try {
            ByteBuffer buffer1 = ByteBuffer.allocate(256);
            socketChannel.read(buffer1);
            buffer1.flip();
            byte[] x = buffer1.array();

            System.out.println("I received some bytes: ");
            for (int i = 0; i < 4; i++){
                System.out.println(x[i]);
            }
            System.out.println("etc.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write(Request request) throws IOException {

        SocketAddress address = new InetSocketAddress("localhost",2020);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(request);
        objectOutputStream.flush();
        byte[] bytes = byteArrayOutputStream.toByteArray();

        socketChannel = SocketChannel.open(address);
        ByteBuffer buffer = ByteBuffer.allocate(256);
        buffer.put(bytes);
        buffer.flip();
        socketChannel.write(buffer);
    }
}
