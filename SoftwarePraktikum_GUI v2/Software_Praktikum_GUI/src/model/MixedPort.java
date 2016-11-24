package model;

public class MixedPort extends Port {
	int id;
	int i;
	int bufferSize = 1000;
	Object[] inputBuffer;
	
	MixedPort(int id)
	{
		super(id);
		inputBuffer = new Object[bufferSize];
		portType = MainModel.MIXED_PORT;
		i = 0;
	}
	
	void send(Port port, Object o)
	{
		port.receive(o);
	}
	
	void receive(Object o)
	{
		inputBuffer[i++] = o;
	}
}
