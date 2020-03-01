package org.ibrahimhilali.TimeTracker.connectors;

import com.intellij.util.Base64;
import org.ibrahimhilali.TimeTracker.classes.User;

import java.io.IOException;
import java.util.HashMap;

public class ToggleManager {

    protected Connector connector;

    protected User user;

    public ToggleManager() {
        connector = new Connector() {
            @Override
            public HashMap<String, String> configure() {
                HashMap<String, String> config = new HashMap<String, String>();
                String encoded = Base64.encode(("1c4e0566e1df245e37fa97aacde3dc80:api_token").getBytes());
                config.put(Configuration.TOKEN, encoded);
                return config;
            }
        };
    }
    public Object start(HashMap<String,String> data){
        try {
            return connector.getServices().post(ToggleAPI.TIMES_ENTRY.concat("/start"),data);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Object stop(String id){
        try {
            return connector.getServices().put(ToggleAPI.TIMES_ENTRY.concat("/"+id+"/stop"),null);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object update(String id,HashMap<String,String> data){
        try {
            return connector.getServices().put(ToggleAPI.TIMES_ENTRY.concat("/"+id),data);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object delete(String id){
        try {
            return connector.getServices().delete(ToggleAPI.TIMES_ENTRY.concat("/"+id));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Object current(){
        try {
            return connector.getServices().get(ToggleAPI.TIMES_ENTRY.concat("/current"));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
