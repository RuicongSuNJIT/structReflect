package struts.request.mapping;

public class XMLActionEntity {
	private String url;
	private String className;
	private String methodName;
	private XMLResultEntity[] results;

	public XMLActionEntity(String url, String className, String methodName,
			XMLResultEntity[] results) {
		this.url = url;
		this.className = className;
		this.methodName = methodName;
		this.results = results;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public XMLResultEntity[] getResults() {
		return results;
	}

	public void setResults(XMLResultEntity[] results) {
		this.results = results;
	}
}
