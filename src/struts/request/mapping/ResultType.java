package struts.request.mapping;

import java.lang.reflect.Method;

public class ResultType {
	private Class<?> rClass;
	private Method method;

	public ResultType(String className) {
		try {
			rClass = Class.forName(className);
			method = rClass.getMethod("execute", new Class<?>[] {});
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
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
	@Override
	public String toString() {
		String str = "";
		str += "Class: " + rClass + " - ";
		str += "Method: " + method;
		return str;
	}
}
