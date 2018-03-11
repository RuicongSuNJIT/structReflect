package struts.request.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class XMLLoader {
	public static Map<String, ResultType> resultTypes;

	public static List<XMLActionEntity> getXMLActions() {
		List<XMLActionEntity> xmlActions = new LinkedList<>();
		xmlActions.add(new XMLActionEntity("login", "action.LoginRegister",
				"login",
				new XMLResultEntity[] {
						new XMLResultEntity("success", "jsp",
								new String[] { "location", "/succLogin.jsp" }),
						new XMLResultEntity("error", "jsp",
								new String[] { "location", "/error.jsp" }) }));
		xmlActions.add(new XMLActionEntity("register", "action.LoginRegister",
				"register",
				new XMLResultEntity[] {
						new XMLResultEntity("success", "jsp",
								new String[] { "location",
										"/succRegister.jsp" }),
						new XMLResultEntity("error", "jsp",
								new String[] { "location", "/error.jsp" }) }));
		return xmlActions;
	}

	public static List<XMLResultType> getXMLResultType() {
		List<XMLResultType> resultTypes = new LinkedList<>();
		resultTypes.add(new XMLResultType("jsp", "result.type.JSPResultType"));
		resultTypes.add(
				new XMLResultType("stream", "result.type.StreamResultType"));
		return resultTypes;
	}

	public static Map<String, ResultType> mappingResultTypes() {
		Map<String, ResultType> map = new HashMap<>();
		List<XMLResultType> xmlResultTypes = getXMLResultType();
		for (XMLResultType xmlResultType : xmlResultTypes) {
			System.out.println("ResultType:");
			System.out.println(xmlResultType.getClassName() + " - "
					+ xmlResultType.getTypeName());
			System.out.println();
			map.put(xmlResultType.getTypeName(),
					new ResultType(xmlResultType.getClassName()));
		}
		return map;
	}

	public static Map<String, ResultEntity> mappingResults(
			XMLResultEntity[] xmlResults) {
		Map<String, ResultEntity> map = new HashMap<>();
		for (XMLResultEntity xmlResult : xmlResults) {
			System.out.println("Result: " + xmlResult.getName() + " - "
					+ xmlResult.getType());
			String[] xmlParams = xmlResult.getParams();
			int len = xmlParams.length;
			List<MapPair> params = new ArrayList<>(len / 2);
			for (int i = 0; i < len; i += 2) {
				params.add(new MapPair(xmlParams[i], xmlParams[i + 1]));
			}
			ResultType type = resultTypes.get(xmlResult.getType());
			ResultEntity result = new ResultEntity(type, params);
			map.put(xmlResult.getName(), result);
		}
		return map;
	}

	public static Map<String, ActionEntity> mappingActions() {
		resultTypes = mappingResultTypes();
		List<XMLActionEntity> xmlActions = getXMLActions();
		Map<String, ActionEntity> map = new HashMap<>();

		for (XMLActionEntity xmlAction : xmlActions) {
			System.out.println("Action:");
			System.out.println(
					xmlAction.getUrl() + " - " + xmlAction.getClassName());
			Map<String, ResultEntity> results = mappingResults(
					xmlAction.getResults());
			ActionEntity action = new ActionEntity(xmlAction.getClassName(),
					xmlAction.getMethodName(), results);
			map.put(xmlAction.getUrl(), action);

			System.out.println();
		}
		return map;
	}
}
