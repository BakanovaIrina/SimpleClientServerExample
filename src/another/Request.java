package another;

import java.io.Serializable;

public class Request implements Serializable {
    private String name;
    private Integer value;

    public Request(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }
}
