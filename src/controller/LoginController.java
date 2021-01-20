package controller;

import java.rmi.RemoteException;


import remote.ServiceLocator;

public class LoginController {
	
	public static LoginController instance;

	public LoginController() {
	}
	
	public void login(String email, String password){
		try {
			ServiceLocator.getInstance().getService().login(email, password);
		} catch (RemoteException e) {
			System.err.println(e);
		}	
	}
	
	public void register(String email, String password) {
		try {
			ServiceLocator.getInstance().getService().registrarUsuario(email, password);
		} catch (RemoteException e) {
			System.err.println(e);
		}	
	}
	
	public static LoginController getInstance() {
		if (instance == null) {
			try {
				instance = new LoginController();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		return instance;
	
	}
}
