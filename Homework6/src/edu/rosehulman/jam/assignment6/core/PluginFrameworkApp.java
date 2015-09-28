package edu.rosehulman.jam.assignment6.core;

import java.io.File;

public class PluginFrameworkApp {

	public static void main(String[] args) {
		String uri = args[0];
		File folder = new File(uri);
		
		FolderObserver folderObserver = new FolderObserver(folder);
		Thread folderObserverThread = new Thread(folderObserver);
		folderObserverThread.start();
	}

}
