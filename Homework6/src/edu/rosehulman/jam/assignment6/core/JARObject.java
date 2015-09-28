package edu.rosehulman.jam.assignment6.core;

import java.nio.file.Path;

public class JARObject {
	
	private Path filename;
	private JarClassLoader jarClassLoader;

	public JARObject(Path filename) {
		//Any plugin is required to have a class that kicks things off called JamDriver
		this.filename = filename;
		this.jarClassLoader = new JarClassLoader(filename.toString());
		/*
		 * Then to instantiate an object you can do something like:
		try {
			Class c = this.jarClassLoader.loadClass("JamDriver", true);
			try {
				Object o = c.newInstance();
				(IPlugin) plugin = (IPlugin) o;
				o.doSomething;
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
	}
	
	public Path getFilename(){
		return this.filename;
	}
	
	public JarClassLoader getJarClassLoader(){
		return this.jarClassLoader;
	}

}
