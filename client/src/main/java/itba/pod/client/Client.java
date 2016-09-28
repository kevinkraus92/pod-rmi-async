package itba.pod.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import itba.pod.Analyzer;
import itba.pod.ClientHandle;
import itba.pod.MovieService;

public class Client {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Analyzer auxi = new Analyzer(args);
		Object port = auxi.get("PORT");
		Object hostname = auxi.get("HOSTNAME");
		Object service = auxi.get("SERVICE");
		auxi.dump();

		MovieService handle = (MovieService) Naming.lookup(String.format("//%s:%s/%s", hostname, port, service));

		ClientHandle me = new ClientHandleImpl();


		handle.suscribe(me, "Drama");

	}
}