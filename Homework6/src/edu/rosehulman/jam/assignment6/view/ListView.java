package edu.rosehulman.jam.assignment6.view;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.rosehulman.jam.assignment6.core.JARObject;
import edu.rosehulman.jam.assignment6.core.PluginUpdater;
import edu.rosehulman.jam.assignment6.model.ListModel;

public class ListView extends JPanel implements ListSelectionListener{
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	JList<String> pluginList  = new JList<String>(listModel);
	
	private JScrollPane scrollPane;
	/*
	 * Model of the List Panel
	 */
	public ListView(){
		super();

		pluginList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pluginList.setLayoutOrientation(JList.VERTICAL);
		pluginList.setVisibleRowCount(-1);
		pluginList.addListSelectionListener(this);
		HashMap<String, JARObject> jarRegistry2 = PluginUpdater.jarRegistry;
		this.updatePluginList(jarRegistry2.keySet());
		this.scrollPane = new JScrollPane(pluginList);
		
	}
	

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void updatePluginList(Set<String> fList){
		listModel = new DefaultListModel<String>();
		for(String plugin: fList){
			listModel.addElement(plugin.replaceAll(".jar", ""));
			System.out.println(plugin);
				
		}
		pluginList.setModel(listModel);
		this.paint(this.getGraphics());
	}
	
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(!e.getValueIsAdjusting()){
			String selectedPlugin = this.listModel.get(((JList<String>)e.getSource()).getSelectedIndex());
			
		}
		
	}
}
