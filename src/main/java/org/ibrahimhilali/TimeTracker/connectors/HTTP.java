package org.ibrahimhilali.TimeTracker.connectors;

import java.io.IOException;
import java.util.HashMap;

public interface HTTP {


    public Object post(String url, HashMap<String, String> data) throws IOException, InterruptedException;

    public Object put(String url, HashMap<String, String> data) throws IOException, InterruptedException;

    public Object get(String url) throws IOException, InterruptedException;

    public Object delete(String url) throws IOException, InterruptedException;
}
