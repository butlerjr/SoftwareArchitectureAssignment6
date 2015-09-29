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
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList<String> pluginList  = new JList<String>(listModel);
	
	private JScrollPane scrollPane;
	private JFrame frame;
	 ExecuteController ec = new ExecuteController();
	/*
	 * Model of the List Panel
	 */
	public ListView(){
		super();

		this.pluginList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.pluginList.setLayoutOrientation(JList.VERTICAL);
		this.pluginList.setVisibleRowCount(-1);
		this.pluginList.addListSelectionListener(this);
		HashMap<String, JARObject> jarRegistry2 = PluginUpdater.jarRegistry;
		this.updatePluginList(jarRegistry2.keySet());
		this.scrollPane = new JScrollPane(this.pluginList);
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(new BoxLayout(this.frame.getContentPane(), BoxLayout.X_AXIS));
		this.frame.getContentPane().add(getScrollPane());
		this.frame.setVisible(true);
		
	}
	

	public JScrollPane getScrollPane() {
		return this.scrollPane;
	}

	public void updatePluginList(Set<String> fList){
		this.listModel = new DefaultListModel<String>();
		for(String plugin: fList){
			this.listModel.addElement(plugin.replaceAll(".jar", ""));
			System.out.println(plugin);
				
		}
		this.pluginList.setModel(this.listModel);
		this.revalidate();
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
//				e1.printStackTrace();
			}

			
		}
		
	}
}
