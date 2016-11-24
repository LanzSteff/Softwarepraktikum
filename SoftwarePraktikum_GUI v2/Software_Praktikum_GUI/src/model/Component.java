package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Component {
	public int parentID;
	public int id;
	boolean isLeaf;
	public String name;
	public String value;
	ArrayList<Component> children;
	ArrayList<Port> ports;
	HashMap<String, Object> properties;
	
	public Component()
	{
		this.parentID = -1;
		this.id = -1;
		this.name = "";
		this.value = "";
	}
	
	public Component(int parentID, int id, String name, String value)
	{
		this.parentID = parentID;
		this.id = id;
		this.name = name;
		this.value = value;
		isLeaf = true;
		children = new ArrayList<Component>();
		properties = new HashMap<String, Object>();
		ports = new ArrayList<Port>();
	}
	
	public HashMap<String, Object> getProperties()
	{
		return properties;
	}
	
	public ArrayList<Port> getPorts()
	{
		return ports;
	}
	
	public void addPort(Port port)
	{
		ports.add(port);
	}
	
	public void removePort(Port port)
	{
		ports.remove(port);
	}
	
	public void addProperty(String name, Object value)
	{
		properties.put(name, value);
	}
	
	public void removeProperty(String key)
	{
		properties.remove(key);
	}
	
	public int getID()
	{
		return id;
	}
}
