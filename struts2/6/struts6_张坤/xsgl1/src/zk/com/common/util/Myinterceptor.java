package zk.com.common.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Myinterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		String actionName = ActionContext.getContext().getName();
		if(actionName.indexOf("login")>-1){
			return arg0.invoke();
		}
		if(ActionContext.getContext().getSession().get("user")==null){
			return "login";
		}else{
			return arg0.invoke();
		}
		
	}

}
