package org.ibrahimhilali.TimeTracker.connectors;

public interface Connection {

    public String getType();

    public Object services();

    public void start();

    public void stop();

}
