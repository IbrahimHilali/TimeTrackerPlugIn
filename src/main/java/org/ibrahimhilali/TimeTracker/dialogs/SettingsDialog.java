package org.ibrahimhilali.TimeTracker.dialogs;

import com.google.common.collect.ImmutableMap;
import com.intellij.ui.components.JBLabel;
import com.intellij.util.ui.GridBag;
import com.intellij.util.ui.JBUI;
import com.intellij.util.ui.UIUtil;
import org.ibrahimhilali.TimeTracker.classes.User;
import org.ibrahimhilali.TimeTracker.settings.Storage;

import javax.swing.*;
import java.util.Objects;

public class SettingsDialog extends AbstractDialog {

    public SettingsDialog() {
        super();
        setTitle("Settings");
        WIDTH = 400;
        HEIGHT = 200;
    }

    @Override
    protected void checkState() {
        setUserData(Objects.requireNonNull(Storage.getInstance().getState()).getUser());
    }

    @Override
    protected void updateState() {
        Objects.requireNonNull(Storage.getInstance().getState()).setUser(
                new User(
                        ((JTextField) components.get("User Name")).getText(),
                        ((JTextField) components.get("Email")).getText(),
                        ((JPasswordField) components.get("Token")).getPassword().toString()
                )
        );
    }

    @Override
    protected ImmutableMap<String, JComponent> setComponents() {
        return ImmutableMap.of(
                "User Name", new JTextField(),
                "Email", new JTextField(),
                "Token", new JPasswordField()
        );
    }

    @Override
    protected void addComponentsToPanel(GridBag grid) {
        components.forEach((text, component) -> {
            addLabelTextField(text, component, grid);
        });
    }

    protected void setUserData(User user) {
        ((JTextField) components.get("User Name")).setText(user.getName());
        ((JTextField) components.get("Email")).setText(user.getEmail());
        ((JPasswordField) components.get("Token")).setText(String.valueOf(user.getToken()));
    }


    protected void addLabelTextField(String text, JComponent component, GridBag grid) {
        panel.add(label(text), grid.nextLine().next().weightx(0.2));
        panel.add(component, grid.next().weightx(0.8));
    }

    protected JComponent label(String text) {
        JBLabel label = new JBLabel(text);
        label.setComponentStyle(UIUtil.ComponentStyle.SMALL);
        label.setFontColor(UIUtil.FontColor.BRIGHTER);
        label.setBorder(JBUI.Borders.empty(0, 5, 2, 0));
        return label;
    }

}