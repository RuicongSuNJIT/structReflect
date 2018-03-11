package result.type;

import struts.util.ResultType;

public class JSPResultType implements ResultType {

	private String location;

	@Override
	public void execute() {
		System.out.println("Show JSP: " + location);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
