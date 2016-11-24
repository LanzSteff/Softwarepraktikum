package model;

public class InputPort extends Port {
	int id;
	int i;
	int bufferSize = 1000;
	Object[] inputBuffer;

	InputPort(int id)
	{
		super(id);
		inputBuffer = new Object[bufferSize];
		portType = MainModel.INPUT_PORT;
		i = 0;
	}
	
	void receive(Object o)
	{
		inputBuffer[i++] = o;
	}
}
