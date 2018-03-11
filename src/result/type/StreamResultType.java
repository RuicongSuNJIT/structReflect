package result.type;

import struts.util.ResultType;

public class StreamResultType implements ResultType {
	private String fileName;

	@Override
	public void execute() {
		System.out.println("Download File: " + fileName);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
