package edu.rosehulman.jam.assignment6.core;

import java.util.HashMap;
import java.util.HashSet;

import edu.rosehulman.jam.assignment6.controller.StatusController;
import edu.rosehulman.jam.assignment6.view.ExecuteView;
import edu.rosehulman.jam.assignment6.view.List;
import edu.rosehulman.jam.assignment6.view.ListView;

public class PluginUpdater {
	/*
	 * This class installs the plugins and... does some other stuff, probably
	 */
	static ExecuteView executeView;
	
	public static HashMap<String, JARObject> jarRegistry = new HashMap<String, JARObject>();

	private static StatusController statusController;
	static ListView listViewUpdater;
	
	static void installPlugin(JARObject jarObject){
		if (!jarRegistry.containsKey(jarObject.getFilename().toString())){
			jarObject.getFilename();
			jarRegistry.put(jarObject.getFilename().toString(), jarObject);
			System.out.println("Installing JARObject " + jarObject.getFilename());
			//godListView.update(jarRegistry.keySet());
			listViewUpdater.updatePluginList(jarRegistry.keySet());
		}
		else System.out.println("This plugin is already installed!");
	}
	
	static void removePlugin(JARObject jarObject){
		if (jarRegistry.containsKey(jarObject.getFilename().toString())){
			jarRegistry.remove(jarObject.getFilename().toString());
			listViewUpdater.updatePluginList(jarRegistry.keySet());
		}
		else System.out.println("The plugin was not installed, so you cannot uninstall it.");
		System.out.println("Registry is now: ");
	}
	public static void setListView(ListView lv){
		listViewUpdater = lv;
	}
	public static ListView getListView(){
		return listViewUpdater;
	}
	public static void setExecuteView(ExecuteView ev){
		executeView = ev;
	}
	
	public static ExecuteView getExecuteView(){
		return executeView;
	}

	public static void setStatusController(StatusController sc) {
		statusController = sc;	
	}
	
	public static StatusController getStatusController(){
		return statusController;
	}
}
