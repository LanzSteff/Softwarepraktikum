package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;

public class Controller {
	
	MainModel model;
	MainViewPanel view;
	
	public Controller(MainModel model, MainViewPanel view)
	{
		this.model = model;
		this.view = view;
		
		view.addAddListenerComponent(new listenerComponent());
		
		view.addAddListenerPort(new listenerPort());
		
		view.addAddComponentButton(new dialog1Listener());
		
		view.addRemoveComponent(new removeComponentListener());
	}
	
	class removeComponentListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			String key = view.getComponentName();
			model.remove(key);
			view.removeComponent();
		}
		
	}
	
	class listenerComponent implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			view.showAddDialogComponent();
		}
	}
	
	class listenerPort implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			view.showAddDialogPort();
		}
	}
	
	class dialog1Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			String name = view.getCompName();
			String value = view.getCompValue();
			
			model.add(name, value);
			view.addTreeNode(name);
		}
	}
}
