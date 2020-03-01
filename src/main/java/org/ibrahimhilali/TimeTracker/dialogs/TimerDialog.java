package org.ibrahimhilali.TimeTracker.dialogs;

import com.google.common.collect.ImmutableMap;
import com.intellij.util.ui.GridBag;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class TimerDialog extends AbstractDialog{

    public TimerDialog() {
        WIDTH = 100;
        HEIGHT = 50;
    }


    @Override
    protected void checkState() {

    }

    @Override
    protected void updateState() {

    }

    @Override
    protected ImmutableMap<String, JComponent> setComponents() {
        return ImmutableMap.of(
                "start", new JTextField(),
                "end", new JTextField(),
                "play", new JButton()
        );
    }

    @Override
    protected void addComponentsToPanel(GridBag grid) {
        grid.setDefaultFill(GridBagConstraints.VERTICAL);
        components.forEach((text,component)->{
            panel.add(label(text), grid.nextLine().next().weightx(0.2));
            panel.add(component, grid.next().weightx(0.8));
        });
    }


    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return null;
    }
}
