import java.util.ArrayList;
import ModelController.*;
import Views.*;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		model.readObject();
		
		ViewMenu viewMenu = new ViewMenu(model);
		ViewCreate viewCreate = new ViewCreate(model);
		ViewDeposit viewDeposit = new ViewDeposit(model);
		View view = new View(model);
		ViewDelete viewDelete = new ViewDelete(model);
		ViewWithdraw viewWithdraw = new ViewWithdraw(model);
		ViewSelect viewSelect = new ViewSelect(model);
		Controller controller = new Controller(model, viewMenu, viewCreate, viewDeposit, view, viewDelete, viewWithdraw, viewSelect);
		
		viewMenu.setVisible(true);
        
	}

}
