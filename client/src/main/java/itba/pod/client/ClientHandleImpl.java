package itba.pod.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import itba.pod.ClientHandle;

public class ClientHandleImpl implements ClientHandle {
	
	public ClientHandleImpl() throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);
	}

	@Override
	public void notify(String movieName) throws RemoteException {
		System.out.println("hola mundo alta peli " + movieName);
		
	}

}
