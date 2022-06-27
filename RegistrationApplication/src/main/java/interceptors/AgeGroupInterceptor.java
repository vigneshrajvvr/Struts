package interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class AgeGroupInterceptor implements Interceptor {

	@Override
	public void destroy() {
		System.out.println("AgeGroupInterceptor-destory() called");
	}

	@Override
	public void init() {
		System.out.println("AgeGroupInterceptor-init() called");
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
		System.out.println("AgeGroupInterceptor-Pre-processing");
		ValueStack valueStack = actionInvocation.getStack();
		Integer age = (Integer) valueStack.findValue("age");
		//String age = valueStack.findString("age");
		String ageGroup = "";
		if(age <= 18) {
			ageGroup = "Children";
		} else if(age > 18 && age <= 50) {
			ageGroup = "Adult";
		} else {
			ageGroup = "Senior";
		}
		valueStack.set("age", age + "(" + ageGroup + ")");
		String result = actionInvocation.invoke();
		System.out.println("AgeGroupInterceptor-Post-processing");
		return result;
	}

}
