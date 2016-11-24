package model;

class ConcreteComponent implements Component {
	
	int id;
	String name;
	String value;
	
	ConcreteComponent(int id, String name, String value)
	{
		this.id = id;
		this.name = name;
		this.value = value;
	}
}
