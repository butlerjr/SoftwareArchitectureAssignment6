package edu.rosehulman.jam.assignment6.view;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StatusView extends JPanel implements java.util.Observer {
    private TextArea textArea;
//    private Panel panel;
    JFrame frame = new JFrame();
    private JScrollPane scrollPane;
    private Stack<String> statusStack;
    public StatusView() {
    	statusStack = new Stack<String>();
        this.textArea = new TextArea();
        this.textArea.setEditable(false);
        this.scrollPane = new JScrollPane(this.textArea);
//        panel = new Panel();
//        panel.add("TextArea", textArea);
        frame.add(getScrollPane());
        frame.setSize(500,200);
        frame.setLocation(100,100);
        frame.setVisible(true);
    }
    
    public JScrollPane getScrollPane() {
		return scrollPane;
	}
//    public Panel getPanel() {
//        return panel;
//    }
    public void update(String status){
    	statusStack.push(status);
    	StringBuilder sb = new StringBuilder();
        for (String s : statusStack) {
            sb.append(s + "\n");
        }
        this.textArea.setText(sb.toString());
        this.revalidate();
        this.paint(this.getGraphics());
    }
    
    @Override
    public void update(Observable o, Object arg) {
        StringBuilder sb = new StringBuilder();
        List<String> sl = (List<String>) arg;
        for (String s : sl) {
            sb.append(s + "\n");
        }
        textArea.setText(sb.toString());
        this.revalidate();
        this.paint(this.getGraphics());
        
    }
}
