import controller.*;
import view.*;
import model.*;

public class GUI_Main {
	
	public static void main(String[] args)
	{
		MainModel mainModel = new MainModel();
		MainViewPanel mainView = new MainViewPanel();
		Controller controller = new Controller(mainModel, mainView);
		
		mainView.setVisible(true);
	}
}
