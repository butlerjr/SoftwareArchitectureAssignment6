package edu.rosehulman.jam.assignment6.core;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FolderObserver implements Runnable {
	
	Path path;

	public FolderObserver(File folder) {
		this.path = folder.toPath();
		//Remember to load everything on launch
	}
	
	public void beginObserving(){
		importCurrentFiles();
		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
			try {
			    WatchKey key = this.path.register(watcher,
			    		StandardWatchEventKinds.ENTRY_CREATE,
			    		StandardWatchEventKinds.ENTRY_DELETE,
			    		StandardWatchEventKinds.ENTRY_MODIFY);
			    
			    for (;;) {

				    // wait for key to be signaled
				    try {
				        key = watcher.take();
				    } catch (InterruptedException x) {
				        return;
				    }

				    for (WatchEvent<?> event: key.pollEvents()) {
				        WatchEvent.Kind<?> kind = event.kind();

				        // This key is registered only
				        // for ENTRY_CREATE events,
				        // but an OVERFLOW event can
				        // occur regardless if events
				        // are lost or discarded.
				        if (kind == StandardWatchEventKinds.OVERFLOW) {
				            continue;
				        }

				        // The filename is the
				        // context of the event.
				        WatchEvent<Path> ev = (WatchEvent<Path>)event;
				        Path filename = ev.context();

				        // Verify that the new
				        //  file is a text file.

				        // Email the file to the
				        //  specified email alias.
				        JARObject jarObject = new JARObject(filename);
				        if (kind == StandardWatchEventKinds.ENTRY_CREATE){
				        	System.out.format("You've added the file %s%n", filename);
				        	
				        	PluginUpdater.installPlugin(jarObject);
				        }
				        else if (kind == StandardWatchEventKinds.ENTRY_DELETE){
				        	System.out.format("You've deleted the file %s%n", filename);
				        	PluginUpdater.removePlugin(jarObject);
				        }
				        //Details left to reader....
				    }

				    // Reset the key -- this step is critical if you want to
				    // receive further watch events.  If the key is no longer valid,
				    // the directory is inaccessible so exit the loop.
				    boolean valid = key.reset();
				    if (!valid) {
				        break;
				    }
				}
			} catch (IOException x) {
			    System.err.println(x);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/*
	 * This class should observe a given folder. If a new plugin is added to the folder,
	 * it should send a message to the core to install and register the plugin.
	 */

	private void importCurrentFiles() {
		String pathString = this.path.toString();
		File file = new File(pathString);
		File[] childFiles = file.listFiles();
		for (File f : childFiles){
			JARObject jo = new JARObject(f.toPath());
			PluginUpdater.installPlugin(jo);
		}
		
	}

	@Override
	public void run() {
		beginObserving();
		
	}
}
