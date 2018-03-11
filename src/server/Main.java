package server;

import java.util.LinkedList;
import java.util.List;

import struts.request.mapping.MapPair;

public class Main {
	public static void main(String[] args) {
		Server server = new Server();
		server.init();

		// Request 1
		List<MapPair> params = new LinkedList<>();
		params.add(new MapPair("username", "surc"));
		params.add(new MapPair("password", "1243"));
		server.getRequest("login", params);

		// Request 2
		params = new LinkedList<>();
		params.add(new MapPair("username", "surc"));
		params.add(new MapPair("password", "1243"));
		server.getRequest("register", params);
	}
}
