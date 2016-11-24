package model;

abstract class Port {
	int id;
	int portType;
	Port connectedPort;
	boolean isConnected;
	Object[] inputBuffer;
	
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
	
	void connect(Port port)
	{
	}
	
	void disconnect()
	{
	}
}
