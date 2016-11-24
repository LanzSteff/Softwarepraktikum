package model;

public class InputPort extends Port {
	int id;
	int i;
	int bufferSize = 1000;

	InputPort(int id)
	{
		super(id);
		inputBuffer = new Object[bufferSize];
		portType = MainModel.INPUT_PORT;
		isConnected = false;
		i = 0;
	}
	
	void receive(Object o)
	{
		inputBuffer[i++] = o;
	}
	
	void connect(Port port)
	{
		isConnected = true;
		connectedPort = port;
	}
}
