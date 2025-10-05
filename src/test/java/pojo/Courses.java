package pojo;

import java.util.List;

public class Courses {

	private List<WebAutomation> webAutomation;
	private List<APIClass> api;
	private List<MobileClass> mobile;
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<APIClass> getApi() {
		return api;
	}
	public void setApi(List<APIClass> api) {
		this.api = api;
	}
	public List<MobileClass> getMobile() {
		return mobile;
	}
	public void setMobile(List<MobileClass> mobile) {
		this.mobile = mobile;
	}
}
