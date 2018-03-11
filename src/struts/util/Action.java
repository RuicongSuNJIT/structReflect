package struts.util;

public interface Action {
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";

	public String execute();
}
