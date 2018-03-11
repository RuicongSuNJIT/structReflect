package struts.request.mapping;

public class XMLResultEntity {
	private String name;
	private String type;
	private String[] params;

	public XMLResultEntity(String name, String type, String[] params) {
		this.name = name;
		this.type = type;
		this.params = params;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}
}
