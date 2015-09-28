package edu.rosehulman.jam.assignment6.core;

import java.util.HashSet;

public class PluginUpdater {
	/*
	 * This class installs the plugins and... does some other stuff, probably
	 */
	
	public static HashSet<JARObject> jarRegistry = new HashSet<JARObject>();
	
	static void installPlugin(JARObject jarObject){
		if (!jarRegistry.contains(jarObject)){
			jarRegistry.add(jarObject);
			System.out.println("Installing JARObject " + jarObject.getFilename());
			
		}
		else System.out.println("This plugin is already installed!");
		System.out.println("Registry is now: ");
		for (JARObject jo : jarRegistry){
			System.out.println(jo.getFilename());
		}
	}
	
	static void removePlugin(JARObject jarObject){
		if (jarRegistry.contains(jarObject)){
			jarRegistry.remove(jarObject);
		}
		else System.out.println("The plugin was not installed, so you cannot uninstall it.");
		System.out.println("Registry is now: ");
		for (JARObject jo : jarRegistry){
			System.out.println(jo.getFilename());
		}
	}

}
