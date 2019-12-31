package org.ibrahimhilali.TimeTracker.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.NotNull;

public class Settings extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        org.ibrahimhilali.TimeTracker.dialogs.Settings settingsDialog = new org.ibrahimhilali.TimeTracker.dialogs.Settings();
        if (settingsDialog.showAndGet()) {
            settingsDialog.close(DialogWrapper.OK_EXIT_CODE);
        }
    }
}
