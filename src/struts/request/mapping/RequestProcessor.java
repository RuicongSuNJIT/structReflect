package struts.request.mapping;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class RequestProcessor {
	private static Map<String, ActionEntity> actionMap = XMLLoader
			.mappingActions();

	public void init() {
		for (Map.Entry<String, ActionEntity> action : actionMap.entrySet()) {
			System.out.println(action.getValue());
		}
	}

	public void process(String url, List<MapPair> params) {
		ActionEntity action = actionMap.get(url);
		try {
			Class<?> aClass = action.getaClass();
			Object aObj = aClass.newInstance();
			Method aMethod = action.getMethod();

			for (MapPair param : params) {
				Field aField = aClass.getDeclaredField(param.getKey());
				boolean access = aField.isAccessible();
				aField.setAccessible(true);
				aField.set(aObj, param.getValue());
				aField.setAccessible(access);
			}

			String resultName = (String) aMethod.invoke(aObj, new Object[0]);
			ResultEntity result = action.getResults().get(resultName);
			Class<?> rClass = result.getResultType().getrClass();
			Object rObj = rClass.newInstance();

			for (MapPair param : result.getParams()) {
				Field rField = rClass.getDeclaredField(param.getKey());
				boolean access = rField.isAccessible();
				rField.setAccessible(true);
				rField.set(rObj, param.getValue());
				rField.setAccessible(access);
			}

			Method rMethod = result.getResultType().getMethod();
			rMethod.invoke(rObj, new Object[0]);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

}
