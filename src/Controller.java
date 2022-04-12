import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Controller {
	
	private Model model;
	private ViewMenu viewMenu;
	private ViewCreate viewCreate;
	private ViewDeposit viewDeposit;
	private ViewDelete viewDelete;
	private ViewWithdraw viewWithdraw;
	private ViewSelect viewSelect;
	
	private View view;

	public Controller (Model myModel, ViewMenu myViewMenu, ViewCreate myViewCreate, ViewDeposit myViewDeposit, View myView, ViewDelete myViewDelete,  ViewWithdraw myViewWithdraw, ViewSelect myViewSelect) {
		model = myModel;
		viewMenu = myViewMenu;
		viewCreate = myViewCreate;
		viewDeposit = myViewDeposit;
		viewDelete = myViewDelete;
		viewWithdraw = myViewWithdraw;
		viewSelect = myViewSelect;
		
		view = myView;
		
		viewMenu.addViewCreateListener((ActionEvent e) -> onViewCreate(e));
		viewMenu.addViewDeleteListener((ActionEvent e) -> onViewDelete(e));
		viewMenu.addViewDepositListener((ActionEvent e) -> onViewDeposit(e));
		viewMenu.addViewSelectListener((ActionEvent e) -> onViewSelect(e));
		viewMenu.addViewWithdrawListener((ActionEvent e) -> onViewWithdraw(e));
		viewMenu.addViewListener((ActionEvent e) -> onView(e));
		viewMenu.addQuitListener((ActionEvent e) -> onQuit(e));
		
		viewCreate.addCancelListener((ActionEvent e) -> onCancel(e));
		viewCreate.addAccountListener((ActionEvent e) -> addAccount(e));
		
		viewDeposit.addCancelListener((ActionEvent e) -> onCancel(e));
		viewDeposit.addDepositListener((ActionEvent e) -> addDeposit(e));
		
		view.addCancelListener((ActionEvent e) -> onCancel(e));
		
		viewWithdraw.addCancelListener((ActionEvent e) -> onCancel(e));
		viewWithdraw.withdrawListener((ActionEvent e) -> withdraw(e));
		
		viewDelete.addCancelListener((ActionEvent e) -> onCancel(e));
		viewDelete.deleteAccountListener((ActionEvent e) -> deleteAccount(e));
		
		viewSelect.addCancelListener((ActionEvent e) -> onCancel(e));
		viewSelect.selectAccountListener((ActionEvent e) -> selectAccount(e));
		
	}
	
	// ------------------------------------------------------------- event handlers
	private void onViewCreate(ActionEvent e) {
		viewMenu.setVisible(false);
		viewCreate.setVisible(true);
	}
	
	private void onViewDelete(ActionEvent e) {
		viewDelete.setVisible(true);
		if (model.getAccounts().size() == 0) {
			ViewDelete.setCurrentAccount("no account retreived");
		}else {
			ViewDelete.setCurrentAccount(model.getListItems());
		}
		viewMenu.setVisible(false);	
	}
	
	private void onViewDeposit(ActionEvent e) {
		viewDeposit.setVisible(true);
		viewMenu.setVisible(false);
	}
	
	private void onViewSelect(ActionEvent e) {
		viewSelect.setVisible(true);
		
		viewMenu.setVisible(false);
	}
	
	private void onViewWithdraw(ActionEvent e) {
		viewWithdraw.setVisible(true);
		viewMenu.setVisible(false);
	}
	
	private void onQuit(ActionEvent e) {
		viewMenu.setVisible(false);
	}
	
	private void onView(ActionEvent e) {
		view.setVisible(true);
		viewMenu.setVisible(false);
		view.setReport(model.getReport());
	}
	
	private void addAccount(ActionEvent e) {
		viewCreate.validateMe();
		
		if (viewCreate.getTextValidatorDescription().getValidateStatus() == true && viewCreate.getTextValidatorAmount().getValidateStatus() == true) {
			model.addAccount(viewCreate.getDescription(), viewCreate.getInitialBalance(), viewCreate.getAccountTypeIndex());
			viewMenu.enableButton();
			viewCreate.setVisible(false);
			viewMenu.setVisible(true);
			viewSelect.getlistModel().removeAllElements();
			for(Account p : model.getAccounts()){
				ViewSelect.updateSelectionList(p.getDescription());
			} 
			viewSelect.getList().setSelectedIndex(0);
			viewCreate.resetMe();
		}
	}
	
	private void onCancel(ActionEvent e) {
		viewCreate.resetMe();
		viewWithdraw.resetMe();
		viewDeposit.resetMe();
		viewSelect.getList().setSelectedIndex(0);
		
		viewCreate.setVisible(false);
		viewDeposit.setVisible(false);
		viewWithdraw.setVisible(false);
		viewSelect.setVisible(false);
		view.setVisible(false);
		viewDelete.setVisible(false);
		viewMenu.setVisible(true);
	}
	
	private void addDeposit(ActionEvent e) {
		viewDeposit.validateMe();
		
		if (viewDeposit.getTextValidatorDescription().getValidateStatus() == true && viewDeposit.getTextValidatorAmount().getValidateStatus() == true) {
			model.addDeposit(viewDeposit.getDescription(), viewDeposit.getAmount());
			viewDeposit.setVisible(false);
			viewMenu.setVisible(true);
			viewDeposit.resetMe();
		}
		
	}
	
	private void withdraw(ActionEvent e) {
		viewWithdraw.validateMe();
		
		if (viewWithdraw.getTextValidatorDescription().getValidateStatus() == true && viewWithdraw.getTextValidatorAmount().getValidateStatus() == true) {	
			model.withdraw(viewWithdraw.getDescription(), viewWithdraw.getAmount());
			viewWithdraw.setVisible(false);
			viewMenu.setVisible(true);
			viewWithdraw.resetMe();
		}
	}
	
	private void deleteAccount(ActionEvent e) {
		model.deleteAccount();
		viewDelete.setVisible(false);
		viewMenu.setVisible(true);
		viewMenu.enableButton();
		viewSelect.getlistModel().removeAllElements();
		for(Account p : model.getAccounts()){
			// static method
			ViewSelect.updateSelectionList(p.getDescription());
		} 
		if (model.getAccounts().size() == 0) {
			ViewDelete.setCurrentAccount("no account retreived");
		}else {
			ViewDelete.setCurrentAccount(model.getListItems());
		}
		viewSelect.getList().setSelectedIndex(0);
	}
	
	private void selectAccount(ActionEvent e) {
		
		model.selectAccount(viewSelect.getAccountTypeIndex());
		viewSelect.setVisible(false);
		viewMenu.setVisible(true);
		viewSelect.getList().setSelectedIndex(0);
	}
	

	
}
