package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainModel {
	public static final int INPUT_PORT = 1;
	
	public static final int OUTPUT_PORT = 2;
	
	public static final int MIXED_PORT = 3;
	
	private int size = 0;
	
	private Component tree;
	
	private Component returnComponent = new Component();
	
	private ArrayList<Port> portList = new ArrayList<Port>();
	
	public MainModel()
	{
		tree = new Component(-1, 0, "Root", "");
	}
	
	public String[] getPorts(int id)
	{
		findComponent(id, tree);
		Component component = returnComponent;
		
		String[] s = new String[component.ports.size()];
		for(int i = 0; i < component.ports.size(); i++)
		{
			s[i] = String.valueOf(component.ports.get(i).id);
		}
		return s;
	}
	
	public void addPort(int id, int portNumber)
	{
		Port port = findPort(portNumber);
		findComponent(id, tree);
		Component component = returnComponent;
		
		component.addPort(port);
	}
	
	public Port findPort(int portNumber)
	{
		for(Port port : portList)
		{
			if(port.id == portNumber)
			{
				return port;
			}
		}
		return null;
	}
	
	public void removePort(int id, int portNumber)
	{
		Port port = findPort(portNumber);
		findComponent(id, tree);
		Component component = returnComponent;
		
		component.removePort(port);
	}
	
	public void addPortNumber(int portType, int portNumber)
	{
		if(portType == INPUT_PORT)
		{
			InputPort newPort = new InputPort(portNumber);
			portList.add(newPort);
		}
		else if(portType == OUTPUT_PORT)
		{
			OutputPort newPort = new OutputPort(portNumber);
			portList.add(newPort);
		}
		else if(portType == MIXED_PORT)
		{
			MixedPort newPort = new MixedPort(portNumber);
			portList.add(newPort);
		}
	}
	
	public String[] getPortNumberList()
	{
		String[] s = new String[portList.size()];
		for(int i = 0; i < portList.size(); i++)
		{
			s[i] = String.valueOf(portList.get(i).id);
		}
		return s;
	}
	
	public void addProperty(int id, String name, Object value)
	{
		findComponent(id, tree);
		Component component = returnComponent;
		component.addProperty(name, value);
	}
	
	public void removeProperty(int id, String key)
	{
		findComponent(id, tree);
		Component component = returnComponent;
		component.removeProperty(key);
	}
	
	public String[][] getProperties(int id)
	{
		findComponent(id, tree);
		Component component = returnComponent;
		size = component.getProperties().size();
		HashMap<String, Object> properties = component.getProperties();
		String[][] matrix = new String[size][2];
		
		Set<Map.Entry<String, Object>> set = properties.entrySet();

		int i = 0;
	    for (Map.Entry<String, Object> currentEntry : set) 
	    {
	    	matrix[i][0] = currentEntry.getKey();
	    	matrix[i][1] = (String)currentEntry.getValue();
	    	i++;
	    }
		
		return matrix;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void add(int parentID, int childID, String name, String value)
	{
		Component child = new Component(parentID, childID, name, value);
		Component parent = new Component();
		child.addProperty("Name", name);
		child.addProperty("Value", value);
		findComponent(parentID, tree);
		parent = returnComponent;
		
		parent.children.add(child);
	}
	
	public void remove(int id)
	{
		findComponent(id, tree);
		Component component = returnComponent;		
		findComponent(component.parentID, tree);
		Component arrayList = returnComponent;
		arrayList.children.remove(arrayList.children.indexOf(component));
	}
	
	public String[] getPorts(String componentName)
	{
		findComponent(componentName, tree);
		Component component = returnComponent;
		ArrayList<Port> ports = component.getPorts();
		String[] s = new String[ports.size()];
		
		for(int i = 0; i < ports.size(); i++)
		{
			s[i] = String.valueOf(ports.get(i).id);
		}
		
		return s;
	}
	
	private void findComponent(String name, Component component)
	{
		if(name == "Root") returnComponent = tree;
		
		for(int i = 0; i < component.children.size(); i++)
		{
			if(component.children.get(i).name == name)
			{
				returnComponent = component.children.get(i);
			}
			else
			{
				findComponent(name, component.children.get(i)); 
			}
		}
	}
	
	private void findComponent(int id, Component component)
	{
		if(id == 0) returnComponent = tree;
		
		for(int i = 0; i < component.children.size(); i++)
		{
			if(component.children.get(i).id == id)
			{
				returnComponent = component.children.get(i);
			}
			else
			{
				findComponent(id, component.children.get(i)); 
			}
		}
	}
}
