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

import edu.rosehulman.jam.assignment6.PluginCommons.IPlugin;
import edu.rosehulman.jam.assignment6.controller.ExecuteController;
import edu.rosehulman.jam.assignment6.core.JARObject;
import edu.rosehulman.jam.assignment6.core.PluginUpdater;
import edu.rosehulman.jam.assignment6.model.ListModel;

public class ListView extends JPanel implements ListSelectionListener{
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	JList<String> pluginList  = new JList<String>(listModel);
	
	private JScrollPane scrollPane;
	private JFrame frame;
	 ExecuteController ec = new ExecuteController();
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.getContentPane().add(getScrollPane());
		frame.setVisible(true);
		
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
			String selectedPlugin = this.listModel.get(((JList<String>)e.getSource()).getSelectedIndex())+".jar";
			JARObject jo = PluginUpdater.jarRegistry.get(selectedPlugin);
			try {
				IPlugin plugin = jo.newPluginInstance();
				ec.executePlugin(plugin);
//				plugin.load(PluginUpdater.getExecuteView(), PluginUpdater.getStatusController());
//				plugin.run();
			} catch (InstantiationException | IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
		}
		
	}
}
