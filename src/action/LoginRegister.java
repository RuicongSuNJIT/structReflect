package action;

import struts.util.ActionSupport;

public class LoginRegister extends ActionSupport {
	private String username;
	private String password;

	public String login() {
		if ("surc".equals(username) && "1414213".equals(password)) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String register() {
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
