package server;

import another.Request;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerApp {

    private byte[] bytes;

    private SocketChannel s;

    public void read() throws IOException, ClassNotFoundException {
        byte[] b = new byte[1024];
        SocketAddress a = new InetSocketAddress(2020);
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(a);
        s = ss.accept();

        ByteBuffer f = ByteBuffer.wrap(b);
        f.clear();
        s.read(f);

        Request request;
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(b));
        request = (Request) inputStream.readObject();

        System.out.println("requestName: " + request.getName() + ",\nrequestValue: " + request.getValue());

        write();
    }

    public void write() throws IOException {
        byte[] bytes1 = {31, 69};
        bytes = bytes1;
        ByteBuffer t = ByteBuffer.wrap(bytes);
        s.write(t);
    }
}
