package server;

import java.util.List;
import struts.request.mapping.MapPair;
import struts.request.mapping.RequestProcessor;

public class Server {
	private RequestProcessor processor = new RequestProcessor();

	public void init() {
		processor.init();
	}

	public void getRequest(String url, List<MapPair> params) {
		processor.process(url, params);
	}
}
