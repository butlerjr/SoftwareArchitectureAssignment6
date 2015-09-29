package edu.rosehulman.jam.assignment6.view;

import java.awt.*;
import java.util.List;
import java.util.Observable;

import javax.swing.JFrame;

public class StatusView implements java.util.Observer {
    private TextArea textArea;
    private Panel panel;
    JFrame frame = new JFrame();

    public StatusView() {
        this.textArea = new TextArea();
        this.textArea.setEditable(false);

        panel = new Panel();
        panel.add("TextArea", textArea);
        frame.add(panel);
        frame.setSize(500,200);
        frame.setLocation(100,100);
        frame.setVisible(true);
    }

    public Panel getPanel() {
        return panel;
    }

    @Override
    public void update(Observable o, Object arg) {
        StringBuilder sb = new StringBuilder();
        List<String> sl = (List<String>) arg;
        for (String s : sl) {
            sb.append(s + "\n");
        }
        textArea.setText(sb.toString());
    }
}
