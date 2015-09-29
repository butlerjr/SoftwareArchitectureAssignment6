package edu.rosehulman.jam.assignment6.view;

import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		ListModel lm = new ListModel();
		this.updatePluginList(lm.getPlugins());
		this.scrollPane = new JScrollPane(pluginList);
		
	}
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void updatePluginList(File[] newPluginList){
		listModel = new DefaultListModel<String>();
		File[] fList = newPluginList;
		for(File plugin: fList){
			listModel.addElement(plugin.getName().replaceAll(".jar", ""));
			System.out.println(plugin.getName());
				
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
