package struts.request.mapping;

public class XMLResultType {
	private String typeName;
	private String className;

	public XMLResultType(String typeName, String className) {
		this.typeName = typeName;
		this.className = className;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
