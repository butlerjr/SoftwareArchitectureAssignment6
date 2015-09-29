package edu.rosehulman.jam.assignment6.testplugins;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.rosehulman.jam.assignment6.PluginCommons.IExecuteView;
import edu.rosehulman.jam.assignment6.PluginCommons.IPlugin;
import edu.rosehulman.jam.assignment6.PluginCommons.IStatusController;

public class JamDriver implements IPlugin{
    IExecuteView view;
    IStatusController statusController;

	public static void main(String[] args) {

	}

	@Override
	public void load(IExecuteView view, IStatusController statusController) {
        this.view = view;
        this.statusController = statusController;
        this.statusController.newPluginLoaded();
		
	}

	@Override
	public void run() {
        String echo = "WOOO JAMMING";
        System.out.println(echo);
        JPanel jp = view.getJPanel();
        JLabel label = new JLabel(echo, JLabel.CENTER);
        jp.setLayout(new FlowLayout());
        jp.add(label);
        this.statusController.printToWindow(echo);
        jp.revalidate();
        jp.repaint();
        
		
	}

	@Override
	public void unload() {
		// TODO Auto-generated method stub
		
	}

}
