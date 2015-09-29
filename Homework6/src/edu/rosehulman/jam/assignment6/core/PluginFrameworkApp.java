package edu.rosehulman.jam.assignment6.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import edu.rosehulman.jam.assignment6.PluginCommons.IPlugin;
import edu.rosehulman.jam.assignment6.controller.ExecuteController;
import edu.rosehulman.jam.assignment6.controller.StatusController;
import edu.rosehulman.jam.assignment6.view.List;
import edu.rosehulman.jam.assignment6.view.ListView;

public class PluginFrameworkApp {

	public static void main(String[] args) throws IOException {
//		String uri = args[0];
		File folder = new File("plugin");
		
		HashMap<String, JARObject> jarRegistry2 = PluginUpdater.jarRegistry;
		
		FolderObserver folderObserver = new FolderObserver(folder);
		Thread folderObserverThread = new Thread(folderObserver);
		folderObserverThread.start();
		ListView lc = new ListView();
//		ExecuteController ec = new ExecuteController();
//		try {
//			IPlugin wooPlugin = PluginUpdater.jarRegistry.get("C:\\testForAssignment6\\woo.jar").newPluginInstance();
//			ec.executePlugin(wooPlugin);
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//ListController lc = new ListController();
		
		
	}

}
