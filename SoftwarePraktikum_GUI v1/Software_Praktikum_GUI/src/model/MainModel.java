package model;

public class MainModel {
	Composite composite = new Composite();
	
	int id = 0;
	
	public void add(String name, String value)
	{
		if(!composite.containsKey(name)) 
		{
			Component component = new ConcreteComponent(id++, name, value);
			composite.addComponent(component);
		}
	}
	
	public void remove(String name)
	{
		composite.removeComponent(name);
		
		id--;
	}
}
