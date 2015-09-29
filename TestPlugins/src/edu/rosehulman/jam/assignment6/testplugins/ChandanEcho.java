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

    @Override
    public void load(IExecuteView view, IStatusController statusController) {
        this.view = view;
        this.statusController = statusController;
        this.statusController.newPluginLoaded();
    }

    @Override
    public void run() {
        String echo = "Hey Chandan, nice hat!";
        JPanel jp = view.getJPanel();
        JLabel label = new JLabel(echo);
        this.statusController.printToWindow(echo);
        jp.add("Center", label);
        jp.repaint();
    }

    @Override
    public void unload() {

    }
}
