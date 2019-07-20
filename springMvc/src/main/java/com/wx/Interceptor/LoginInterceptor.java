package com.wx.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
   /**在请求处理之前进行调用。 */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //登陆拦截判断
        String method = httpServletRequest.getMethod();
        //httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest,httpServletResponse);
        //重定向
        httpServletResponse.sendRedirect("/login");
        System.out.println(method);
        return false;
    }
    /**在请求处理之后进行调用。 */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    /**整个请求结束之后（渲染了对应的视图之后）调用。*/
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
