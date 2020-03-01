package org.ibrahimhilali.TimeTracker.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.ibrahimhilali.TimeTracker.dialogs.TimerDialog;
import org.jetbrains.annotations.NotNull;

public class Toggle extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
       /* Timer timer = new Timer();
        timer.start();
        timer.stop();
        Objects.requireNonNull(Storage.getInstance().getState()).setTimer(timer);
        Timer t=Storage.getInstance().getState().getTimer();
        System.out.println(t.getStart());
        System.out.println(timer.getStart());*/
        TimerDialog timerDialog = new TimerDialog();
        timerDialog.show();

    }
}
