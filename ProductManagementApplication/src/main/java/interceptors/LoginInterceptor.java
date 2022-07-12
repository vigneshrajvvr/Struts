package interceptors;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import action.LoginAction;

public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		System.out.println("destory() called");
	}

	@Override
	public void init() {
		System.out.println("init() called");
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		
		Object user = ServletActionContext.getRequest().getAttribute("loggedinUser");
		if(user == null) {
			if(ai.getAction().getClass().getName().equals(LoginAction.class)) {
				return ai.invoke();
			}
			return "input";
		}
		
		return ai.invoke();
	}

}
