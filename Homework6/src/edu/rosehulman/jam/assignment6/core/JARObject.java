package edu.rosehulman.jam.assignment6.core;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.jar.JarFile;

import edu.rosehulman.jam.assignment6.PluginCommons.IPlugin;

public class JARObject {
	
	private Path filename;
	private JarClassLoader jarClassLoader;
	private Class pluginClass;

	public JARObject(Path filename) throws IOException {
		//Any plugin is required to have a class that kicks things off called JamDriver
		this.filename = filename;
		URL[] urlArray = {filename.toUri().toURL()};
		System.out.println(urlArray) ;
		URLClassLoader urlClassLoader = URLClassLoader.newInstance(urlArray);
		try {
			this.pluginClass = urlClassLoader.loadClass("edu.rosehulman.jam.assignment6.testplugins.ChandanEcho");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		this.jarClassLoader = new JarClassLoader(filename.toString());
		JarFile jf = new JarFile(new File(filename.toString()));
		if(jf.getManifest().getEntries().containsKey("Main-Class")) {
		    String mainClassName = jf.getManifest().getEntries().get("Main-Class").toString();
			try {
				this.pluginClass = this.jarClassLoader.loadClass(mainClassName, true);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/

		

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
	
	public IPlugin newPluginInstance() throws InstantiationException, IllegalAccessException{
		return (IPlugin) this.pluginClass.newInstance();
	}
	
	

}
