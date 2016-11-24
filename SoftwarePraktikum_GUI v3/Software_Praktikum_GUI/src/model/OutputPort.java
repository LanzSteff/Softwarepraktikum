package model;

public class OutputPort extends Port {
	int id;
	
	OutputPort(int id)
	{
		super(id);
		portType = MainModel.OUTPUT_PORT;
		isConnected = false;
	}
	
	void send(Port port, Object o)
	{
		port.receive(o);
	}
	
	void connect(Port port)
	{
		isConnected = true;
		connectedPort = port;
	}
}
