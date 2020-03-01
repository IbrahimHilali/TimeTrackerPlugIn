package org.ibrahimhilali.TimeTracker.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.DialogWrapper;
import org.ibrahimhilali.TimeTracker.dialogs.SettingsDialog;
import org.jetbrains.annotations.NotNull;

public class Settings extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        SettingsDialog settingsDialog = new SettingsDialog();
        if (settingsDialog.showAndGet() ) {
            settingsDialog.close(DialogWrapper.OK_EXIT_CODE);
        }
    }
}
