package client;

import java.rmi.RemoteException;

import DTO.VueloDTO;

public class BookingController {
	
	public static BookingController instance;
	
	public boolean buscarVuelos(String aeropuertoOrigen, String aeropuertoDestino, String fechaSalida) throws RemoteException {
		return ServiceLocator.getInstance().getService().buscarVuelos(aeropuertoOrigen, aeropuertoDestino, fechaSalida);
	}
	
	public boolean hacerReserva(VueloDTO vuelo, String email, boolean paymentmethod) throws RemoteException{
		return ServiceLocator.getInstance().getService().hacerReserva(vuelo, email, paymentmethod);
	}
	
	public static BookingController getInstance() {
		if (instance == null) {
			try {
				instance = new BookingController();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		return instance;
	
	}

}
