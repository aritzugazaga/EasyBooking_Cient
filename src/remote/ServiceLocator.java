package remote;

import java.rmi.Naming;

import facade.IRemoteFacade;

public class ServiceLocator {
	
	private IRemoteFacade service;
	
	private static ServiceLocator instance;

	public void setService(String ip, String port, String serverName) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {		
			String URL = "//" + ip + ":" + port + "/" + serverName;
			this.service = (IRemoteFacade) Naming.lookup(URL);
		} catch (Exception e) {
			System.err.println(e);
		}		
	}

	public IRemoteFacade getService() {
		return this.service;
	}
	
	public static ServiceLocator getInstance() {
		if(instance == null) {
			try {
				instance = new ServiceLocator();
			}catch(Exception e) {
				System.err.println(e);
			}
		}
		return instance;
	}
}
