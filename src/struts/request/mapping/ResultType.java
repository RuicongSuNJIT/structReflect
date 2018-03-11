package struts.request.mapping;

import java.lang.reflect.Method;

public class ResultType {
	private Class<?> rClass;
	private Method method;

	public ResultType(String className) {
		// Use reflect to get the result types.
	}

	public Class<?> getrClass() {
		return rClass;
	}

	public void setrClass(Class<?> rClass) {
		this.rClass = rClass;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}
}
