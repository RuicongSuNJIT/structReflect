package struts.request.mapping;

import java.util.List;
import java.util.Map;

public class RequestProcessor {
	private static Map<String, ActionEntity> actionMap = XMLLoader.mappingActions();

	public void init() {
		
	}

	public void process(String url, List<MapPair> params) {
		ActionEntity action = actionMap.get(url);

		// further process
	}

}
