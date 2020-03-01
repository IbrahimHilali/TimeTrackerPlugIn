package org.ibrahimhilali.TimeTracker.settings;

import com.google.gson.Gson;
import org.ibrahimhilali.TimeTracker.classes.Timer;
import org.ibrahimhilali.TimeTracker.classes.User;

public class PluginState {

    protected String user = "";
    protected String timer = "";

    public User getUser() {
        return (new Gson().fromJson(this.user, User.class));
    }

    public void setUser(User user) {
        this.user = (new Gson()).toJson(user);
    }

    public Timer getTimer() {
        return (new Gson().fromJson(this.timer, Timer.class));
    }

    public void setTimer(Timer timer) {
        this.timer = (new Gson()).toJson(timer);
    }
}
