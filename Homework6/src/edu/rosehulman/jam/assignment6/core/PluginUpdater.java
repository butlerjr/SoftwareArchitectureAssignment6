package edu.rosehulman.jam.assignment6.core;

import java.util.HashSet;

public class PluginUpdater {
	/*
	 * This class installs the plugins and... does some other stuff, probably
	 */
	
	HashSet<JARObject> jarRegistry;
	
	public PluginUpdater(){
		this.jarRegistry = new HashSet<JARObject>();
	}
	
	public void installPlugin(JARObject jarObject){
		if (!this.jarRegistry.contains(jarObject)){
			this.jarRegistry.add(jarObject);
		}
		else System.out.println("This plugin is already installed!");
	}

}
