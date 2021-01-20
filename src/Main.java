import javax.swing.SwingUtilities;

import controller.LoginController;
import gui.LoginDialog;
import remote.ServiceLocator;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new LoginDialog(new LoginController()));
		ServiceLocator.getInstance().setService(args[0], args[1], args[2]);

	}

}
