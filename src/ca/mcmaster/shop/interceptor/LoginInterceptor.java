package ca.mcmaster.shop.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 11, 2018 3:16:09 PM
 */
@SuppressWarnings("serial")
public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> map = invocation.getInvocationContext().getSession();
		if(map.containsKey("userInfo")){
			return invocation.invoke();
		}else{
			ActionSupport action = (ActionSupport) invocation.getAction();
			action.addActionError("Please login first!");
			return "login";
		}
	}

}
