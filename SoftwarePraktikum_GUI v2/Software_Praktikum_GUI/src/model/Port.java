package model;

abstract class Port {
	int id;
	int portType;
	
	Port(int id)
	{
		this.id = id;
	}
	
	void send(Port port, Object o)
	{
	}
	
	void receive(Object o)
	{
	}
}
