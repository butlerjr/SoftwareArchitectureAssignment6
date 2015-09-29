package edu.rosehulman.jam.assignment6.controller;

import edu.rosehulman.jam.assignment6.PluginCommons.IPlugin;
import edu.rosehulman.jam.assignment6.view.ExecuteView;

public class ExecuteController {
    ExecuteView view = new ExecuteView();
    StatusController statusController = new StatusController();

    public void executePlugin(IPlugin plugin) {
    	view.removeAll();
        plugin.load(view, statusController);
        plugin.run();
        plugin.unload();
    }
    
    public ExecuteView getView(){
    	return view;
    }
}
