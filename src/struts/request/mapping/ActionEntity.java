package struts.request.mapping;

import java.lang.reflect.Method;
import java.util.Map;

public class ActionEntity {
	private Class<?> aClass;
	private Method method;
	private Map<String, ResultEntity> results;

	public ActionEntity(String className, String methodName,
			Map<String, ResultEntity> results) {
		try {
			aClass = Class.forName(className);
			method = aClass.getMethod(
					methodName == null ? "execute" : methodName,
					new Class<?>[0]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		this.results = results;
	}

	public Class<?> getaClass() {
		return aClass;
	}

	public void setaClass(Class<?> aClass) {
		this.aClass = aClass;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Map<String, ResultEntity> getResults() {
		return results;
	}

	public void setResults(Map<String, ResultEntity> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		String str = "Action: \n";
		str += "Class:" + aClass + "\n";
		str += "Method:" + method + "\n";
		str += "Results:\n";
		for (Map.Entry<String, ResultEntity> result : results.entrySet()) {
			str += "  " + result.getValue() + "\n";
		}
		return str;
	}
}
