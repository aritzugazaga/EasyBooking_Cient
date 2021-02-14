package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DTO.VueloDTO;
import remote.ServiceLocator;

public class BookingController {
	
	public List<VueloDTO> list = new ArrayList<VueloDTO>();
	
	public static BookingController instance;
	
	public BookingController() {
	}
	
	public List<VueloDTO> buscarVuelos(String aeropuertoOrigen, String aeropuertoDestino)  {
		try {
			list =  ServiceLocator.getInstance().getService().getVuelos(aeropuertoOrigen, aeropuertoDestino);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
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
