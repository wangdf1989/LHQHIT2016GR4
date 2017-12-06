package com.qhit.nhx.common.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String actionName = ActionContext.getContext().getName();
		if(actionName.indexOf("login")>-1){
			return invocation.invoke();
		}
		if(ActionContext.getContext().getSession().get("user")==null){
			return "login";
		}else{
		return invocation.invoke();
		}
	}

}
