package org.ibrahimhilali.TimeTracker.dialogs;

import com.google.common.collect.ImmutableMap;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.components.JBLabel;
import com.intellij.uiDesigner.core.AbstractLayout;
import com.intellij.util.ui.GridBag;
import com.intellij.util.ui.JBUI;
import com.intellij.util.ui.UIUtil;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractDialog extends DialogWrapper {

    protected static int WIDTH = 400;
    protected static int HEIGHT = 200;
    protected static String TITLE = "Dialog";

    protected JPanel panel;
    protected ImmutableMap<String, JComponent> components;

    public AbstractDialog() {
        super(true);
        setTitle(TITLE);
        components = setComponents();
        panel = new JPanel(new GridBagLayout());
        checkState();
        init();
    }

    protected abstract void checkState();

    protected abstract void updateState();

    protected abstract ImmutableMap<String, JComponent> setComponents();

    protected abstract void addComponentsToPanel(GridBag grid);

    @Override
    protected JComponent createCenterPanel() {

        GridBag grid = new GridBag()
                .setDefaultInsets(JBUI.insets(0, 0, AbstractLayout.DEFAULT_VGAP, AbstractLayout.DEFAULT_HGAP))
                .setDefaultWeightX(1.0)
                .setDefaultFill(GridBagConstraints.HORIZONTAL);

        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        addComponentsToPanel(grid);

        return panel;
    }

    @Override
    protected void doOKAction() {
        updateState();
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