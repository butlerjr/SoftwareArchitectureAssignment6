package edu.rosehulman.jam.assignment6.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.ListSelectionModel;

public class List {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List window = new List();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public List() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		

		File pluginDirectory = new File("plugins");
		File[] fList = pluginDirectory.listFiles(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(".jar");
		    }
		});
		System.out.println(fList[0].getName());
		for(File plugin: fList){
			listModel.addElement(plugin.getName().replaceAll(".jar", ""));
				
		}
		JList pluginList = new JList(listModel);
		pluginList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pluginList.setLayoutOrientation(JList.VERTICAL);
		pluginList.setVisibleRowCount(-1);
		JScrollPane scrollPane = new JScrollPane(pluginList);
		frame.getContentPane().add(scrollPane);
	}

}
