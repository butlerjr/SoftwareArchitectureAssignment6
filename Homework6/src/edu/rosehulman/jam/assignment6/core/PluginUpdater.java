package edu.rosehulman.jam.assignment6.core;

import java.util.HashMap;
import java.util.HashSet;

public class PluginUpdater {
	/*
	 * This class installs the plugins and... does some other stuff, probably
	 */
	
	public static HashMap<String, JARObject> jarRegistry = new HashMap<String, JARObject>();
	
	static void installPlugin(JARObject jarObject){
		if (!jarRegistry.containsKey(jarObject.getFilename().toString())){
			jarObject.getFilename();
			jarRegistry.put(jarObject.getFilename().toString(), jarObject);
			System.out.println("Installing JARObject " + jarObject.getFilename());
			
		}
		else System.out.println("This plugin is already installed!");
	}
	
	static void removePlugin(JARObject jarObject){
		if (jarRegistry.containsKey(jarObject.getFilename().toString())){
			jarRegistry.remove(jarObject.getFilename().toString());
		}
		else System.out.println("The plugin was not installed, so you cannot uninstall it.");
		System.out.println("Registry is now: ");
	}

}
