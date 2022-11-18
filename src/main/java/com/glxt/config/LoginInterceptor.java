package com.glxt.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录拦截器
 *
 * @author luo
 * @date 2022-11-14
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * url
     */
    private List<String> url = new ArrayList();
    /**
     * 前处理
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理程序
     * @return boolean
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("currentuser") != null) {
            return true;
        } else {
            response.sendRedirect("/login");
            return false;
        }

    }

    /**
     * 处理后
     *
     * @param request      请求
     * @param response     响应
     * @param handler      处理程序
     * @param modelAndView 模型和视图
     * @throws Exception 异常
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 完成后
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理程序
     * @param ex       前女友
     * @throws Exception 异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 获取url
     *
     * @return {@link List}<{@link String}>
     */
    public List<String> getUrl() {
        url.add("/login");
        url.add("/gologin");
        url.add("/register");
        url.add("/goregister");
        url.add("/css/**");
        url.add("/js/**");
        url.add("/img/**");
        return url;

    }
}
