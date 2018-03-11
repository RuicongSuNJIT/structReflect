package struts.request.mapping;

import java.lang.reflect.Method;
import java.util.Map;

public class ActionEntity {
	private Class<?> aClass;
	private Method method;
	private Map<String, ResultEntity> results;

	public ActionEntity(String className, String methodName,
			Map<String, ResultEntity> results) {
		// Use Reflect get the action class and processing method
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
}
