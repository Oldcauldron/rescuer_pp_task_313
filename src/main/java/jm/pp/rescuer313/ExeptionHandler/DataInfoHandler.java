package jm.pp.rescuer313.ExeptionHandler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DataInfoHandler {

    private String info;

    public DataInfoHandler(String info) {
        this.info = info;
    }

    public DataInfoHandler() {
    }

    public String getInfo() {
        return info;
    }

    public DataInfoHandler getInstanceWithInfo(String info) {
        return new DataInfoHandler(info);
    }
}
