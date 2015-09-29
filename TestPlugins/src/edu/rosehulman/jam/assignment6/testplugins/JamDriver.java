package edu.rosehulman.jam.assignment6.testplugins;

import edu.rosehulman.jam.assignment6.PluginCommons.IExecuteView;
import edu.rosehulman.jam.assignment6.PluginCommons.IPlugin;
import edu.rosehulman.jam.assignment6.PluginCommons.IStatusController;

public class JamDriver implements IPlugin{

	public static void main(String[] args) {

	}

	@Override
	public void load(IExecuteView view, IStatusController statusController) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		System.out.println("YOU LOADED ME! WOOOOO");
		
	}

	@Override
	public void unload() {
		// TODO Auto-generated method stub
		
	}

}
