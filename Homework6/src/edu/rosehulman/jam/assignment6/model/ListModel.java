package edu.rosehulman.jam.assignment6.model;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class ListModel {
	/*
	 * Model of the List Panel
	 */
	
	private File[] pluginList;
	public ListModel() {
		
	}
	
	public File[] getPlugins(){
		
		File pluginDirectory = new File("plugin");
		this.pluginList = pluginDirectory.listFiles(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(".jar");
		    }
		});
//		System.out.println(fList[0].getName());
//		for(File plugin: fList){
//			pluginList.add(plugin.getName());
//		}
		return pluginList;
	}
}

