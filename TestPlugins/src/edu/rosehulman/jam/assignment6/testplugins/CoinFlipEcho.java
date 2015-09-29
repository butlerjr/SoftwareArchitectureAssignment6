package edu.rosehulman.jam.assignment6.testplugins;

import edu.rosehulman.jam.assignment6.PluginCommons.IExecuteView;
import edu.rosehulman.jam.assignment6.PluginCommons.IPlugin;
import edu.rosehulman.jam.assignment6.PluginCommons.IStatusController;

import java.awt.FlowLayout;

import javax.swing.*;

/**
 * Created by maken on 9/28/15.
 */
public class CoinFlipEcho implements IPlugin {
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
        Double rand = Math.random();
        String coinSide;
        if (rand > 0.5) {
            coinSide = "Heads";
        } else {
            coinSide = "Tails";
        }
        JPanel jp = view.getJPanel();
        JLabel label = new JLabel(coinSide, JLabel.CENTER);
        jp.setLayout(new FlowLayout());
        this.statusController.printToWindow(coinSide);
        jp.add(label);
        jp.revalidate();
        jp.repaint();
    }

    @Override
    public void unload() {
        this.statusController.printToWindow("Unloaded CoinFlipEcho");
    }
}
