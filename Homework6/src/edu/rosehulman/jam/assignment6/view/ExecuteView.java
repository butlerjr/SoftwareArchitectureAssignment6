package edu.rosehulman.jam.assignment6.view;

import edu.rosehulman.jam.assignment6.PluginCommons.IExecuteView;

import javax.swing.*;
import java.awt.*;

public class ExecuteView implements IExecuteView {
    JPanel panel = new JPanel();
    Frame frame = new Frame("Execute Window");

    public ExecuteView() {
        frame.add(panel);

        frame.setSize(500,500);
        frame.setLocation(100,100);
        frame.setVisible(true);
    }

    public JPanel getJPanel() {
        return this.panel;
    }
}
