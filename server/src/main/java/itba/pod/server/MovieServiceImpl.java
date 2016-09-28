package itba.pod.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;

import itba.pod.ClientHandle;
import itba.pod.Movie;
import itba.pod.MovieService;

public class MovieServiceImpl implements MovieService {

	public MovieServiceImpl() throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);
	}

	List<Movie> db = Arrays.asList(new Movie("Garganta Profunda", "Drama"));

	org.slf4j.Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

	@Override
	public void suscribe(ClientHandle handle, String genre) throws RemoteException {
		logger.info("received request for ()", handle);
		for (int i = 0; i < db.size(); i++) {
			if (db.get(i).getGenre().equalsIgnoreCase(genre)) {
				handle.notify(db.get(i).getName());

			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				logger.debug("Interrupted while sleeping", e);
			}
		}

	}

}
