package model;

import java.util.HashMap;

class Composite implements Component {
	
	HashMap<String, Component> composite = new HashMap<String, Component>();
	
	void addComponent(Component component)
	{
		composite.put(component.name, component);
	}
	
	Component removeComponent(String key)
	{
		return composite.remove(key);
	}
	
	boolean containsKey(String key)
	{
		return composite.containsKey(key);
	}
}
