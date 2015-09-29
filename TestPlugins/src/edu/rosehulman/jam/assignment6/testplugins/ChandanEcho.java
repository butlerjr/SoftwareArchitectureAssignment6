package edu.rosehulman.jam.assignment6.testplugins;

import edu.rosehulman.jam.assignment6.PluginCommons.IExecuteView;
import edu.rosehulman.jam.assignment6.PluginCommons.IPlugin;
import edu.rosehulman.jam.assignment6.PluginCommons.IStatusController;

import javax.swing.*;

/**
 * Created by maken on 9/28/15.
 */
public class ChandanEcho implements IPlugin {
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
        String echo = "Hey Chandan, nice hat!";
        System.out.println(echo);
        JPanel jp = view.getJPanel();
        JLabel label = new JLabel(echo);
        this.statusController.printToWindow(echo);
        jp.add("Center", label);
        jp.paint(jp.getGraphics());
        view.setJPanel(jp);
    }

    @Override
    public void unload() {

    }
}
