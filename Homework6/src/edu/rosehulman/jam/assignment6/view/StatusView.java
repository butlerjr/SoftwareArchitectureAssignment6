package edu.rosehulman.jam.assignment6.view;

import java.awt.*;
import java.util.List;
import java.util.Observable;

public class StatusView implements java.util.Observer {
    private TextArea textArea;
    private Panel panel;

    public StatusView() {
        this.textArea = new TextArea();
        this.textArea.setEditable(false);

        panel = new Panel();
        panel.add("TextArea", textArea);
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
