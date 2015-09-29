package edu.rosehulman.jam.assignment6.model;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class ListModel {
	/*
	 * Model of the List Panel
	 */
	
	private List<String> pluginList;
	public ListModel() {
		
	}
	
	public List<String> getPlugins(){
		pluginList = new ArrayList<String>();
		File pluginDirectory = new File("plugins");
		File[] fList = pluginDirectory.listFiles(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(".jar");
		    }
		});
		System.out.println(fList[0].getName());
		for(File plugin: fList){
			pluginList.add(plugin.getName());
		}
		return pluginList;
	}
}

