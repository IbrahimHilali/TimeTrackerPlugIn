package org.ibrahimhilali.TimeTracker.classes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Timer {

    protected long start;
    protected long end;
    protected long duration;
    protected String localDateTime;
    protected String description;
    protected String project;
    protected String id;

    public Timer() {
        reset();
    }

    @Override
    public String toString() {
        return (new Gson()).toJson(this);
    }

    public String log() {
        JsonObject object = new JsonObject();
        object.addProperty("description", getDescription());
        object.addProperty("created_with", "JetBrains");
        object.addProperty("start", getStart());
        object.addProperty("duration", getEnd() - getStart());
        return "{\"time_entry\":" + object.toString() + "}";
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public long getStart() {
        return start;
    }

    public void start() {
        localDateTime = getDataTime();
        this.start = System.currentTimeMillis();
    }

    public void stop() {
        this.end = System.currentTimeMillis();
        duration += end - start;
    }

    public void pause() {
        this.end = System.currentTimeMillis();
        duration += end - start;
    }

    public void play() {

        start = System.currentTimeMillis();
    }

    public void reset() {
        start = System.currentTimeMillis();
        end = 0;
        localDateTime = getDataTime();
        duration = 0;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration += duration;
    }

    private String getDataTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public long getEnd() {
        return end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
