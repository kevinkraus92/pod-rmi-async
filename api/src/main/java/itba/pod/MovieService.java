package itba.pod;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MovieService extends Remote {
    void suscribe(ClientHandle handle, String genre) throws RemoteException;
}