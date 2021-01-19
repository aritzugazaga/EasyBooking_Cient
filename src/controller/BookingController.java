package controller;

import java.rmi.RemoteException;

import DTO.VueloDTO;
import remote.ServiceLocator;

public class BookingController {
	
	public static BookingController instance;
	
	public BookingController() {
	}
	
	public List<VueloDTO> buscarVuelos(String aeropuertoOrigen, String aeropuertoDestino) throws RemoteException {
		return ServiceLocator.getInstance().getService().buscarVuelos(aeropuertoOrigen, aeropuertoDestino);
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
