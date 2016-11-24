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
		
		view.addListenerPortList(new listenerPortList());
		
		//Component
		view.addEditComponent(new listenerEdit());
		
		view.addAddComponentButton(new addComponentListener());
		
		view.addRemoveComponent(new removeComponentListener());
		
		//Properties
		view.addAddPropertyButton1(new addPropertyListener1());
		
		view.addAddPropertyButton2(new addPropertyListener2());
		
		view.addRemovePropertyButton(new removePropertyListener());
		
		//Port
		view.addAddPortListener1(new addPortListener1());
		
		view.addAddPortListener2(new addPortListener2());
		
		view.addAddPortToCompListener1(new addPortToCompListener1());
		
		view.addAddPortToCompListener2(new addPortToCompListener2());
		
		view.addRemovePortFromCompListener1(new removePortFromCompListener());
		
		view.addConnectPortListener1(new ConnectPortListener1());
		
		view.addConnectPortListener2(new ConnectPortListener2());
		
		view.addSendListener1(new SendListener1());
		
		view.addSendListener2(new SendListener2());
		
		view.addReceiveListener(new ReceiveListener());
	}
	
	class ReceiveListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			view.setTextArea(model.getReceiveText());
			view.showReceiveDialog();
		}
	}
	
	class ConnectPortListener1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			view.setList5(model.getFreeInputPorts());
			view.setList6(model.getFreeOutputPorts());
			view.showConnectDialog1();
		}
	}
	
	class ConnectPortListener2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			model.connectPorts(view.getSelectedValueList5(), view.getSelectedValueList6());
			view.hideConnectDialog1();
		}
	}
	
	class SendListener1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			view.showDialogSend1();
		}
	}
	
	class SendListener2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			model.send(view.getCompID(), view.getSendValue());
			view.hideDialogSend1();
		}
	}
	
	class addPortToCompListener1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			String[] portList = model.getPortNumberList();
			view.setList4(portList);
			view.showDialogAddPortToComp();
		}
	}
	
	class removePortFromCompListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int portNumber = view.getPortToComp();
			int id = view.getCompID();
			model.removePort(id, portNumber);
			String[] portList = model.getPorts(id);
			view.setList3(portList);
		}
	}
	
	class addPortToCompListener2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			int portNumber = view.getPortToComp();
			int id = view.getCompID();
			model.addPort(id, portNumber);
			String[] portList = model.getPorts(id);
			view.setList3(portList);
			view.hideDialogAddPortToComp();
		}
	}
	
	class listenerEdit implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int id = view.getCompID();
			String[][] properties = model.getProperties(id);
			int size = model.getSize();
			view.setList1(size, properties);
			String[] portList = model.getPorts(id);
			view.setList3(portList);
			view.showAddDialogEdit();
		}
	}
	
	class listenerComponent implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			view.showAddDialogComponent();
		}
	}
	
	class listenerPortList implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			view.showDialogPortList();
		}
	}
	
	class addPortListener1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			view.showDialogAddPort();
		}
	}
	
	class addPortListener2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			int portNumber = view.getPortNumber();
			int portType = -1;
			String portName = view.getPortType();
			
			if(portName.equals("Input Port"))
			{
				portType = model.INPUT_PORT;
			}
			else if(portName.equals("Output Port"))
			{
				portType = model.OUTPUT_PORT;
			}
			else if(portName.equals("Mixed Port"))
			{
				portType = model.MIXED_PORT;
			}
			
			model.addPortNumber(portType, portNumber);
			String[] portList = model.getPortNumberList();
			view.setList2(portList);
			view.showDialogPortList();
			view.hideDialogAddPort();
		}
	}
	
	class addComponentListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			int parentID = view.getCompID();
			int childID = view.getCurrentID();
			String name = view.getCompName();
			String value = view.getCompValue();
			
			model.add(parentID, childID, name, value);
			view.addTreeNode(name);
		}
	}
	
	class removeComponentListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			int id = view.getCompID();
			model.remove(id);
			view.removeComponent();
		}
	}
	
	class propertyListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int id = view.getCompID();
		}
	}
	
	class editPropertyListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int id = view.getCompID();
		}
	}
	
	class addPropertyListener1 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			view.showAddDialogEditProperty();
		}
	}
	
	class addPropertyListener2 implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int id = view.getCompID();
			String name = view.getPropName();
			Object value = view.getPropValue();
			model.addProperty(id, name, value);
			String[][] properties = model.getProperties(id);
			int size = model.getSize();
			view.setList1(size, properties);
			view.showAddDialogEdit();
			view.hideAddDialogEditProperty();
		}
	}
	
	class removePropertyListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int id = view.getCompID();
			int propertyIndex = view.getSelectedIndexList1();
			String[][] properties = model.getProperties(id);
			String key = properties[propertyIndex][0];
			model.removeProperty(id, key);
			properties = model.getProperties(id);
			int size = model.getSize();
			view.setList1(size, properties);
		}
	}
}
