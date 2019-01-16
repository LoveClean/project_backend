package com.graduation.project.interceptor;

import com.graduation.project.annotation.ACS;
import com.graduation.project.contants.Errors;
import com.graduation.project.dao.entity.Admin;
import com.graduation.project.dao.entity.SysLog;
import com.graduation.project.service.SysLogService;
import com.graduation.project.service.UserSessionService;
import com.graduation.project.util.ExceptionUtil;
import com.graduation.project.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 权限控制拦截器.
 *
 * @author leihe@uworks.cc
 */
@Component
public class AccessControlInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private UserSessionService userSessionService;
    @Autowired
    private SysLogService sysLogService;

    private static final List<String> noLoginResources = new ArrayList<String>() {
        private static final long serialVersionUID = 1L;

        {
            // swagger相关资源不需要登
            add("/swagger-ui.html");
            add("/configuration");
            add("/swagger-resources");
            add("/api-docs");
            add("/v2/api-docs");
            add("/admin/login");
            add("/devicerequest/*");

            add("/sms/*");

            add("/error");
        }
    };

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 不需要进行访问控制的资源过滤
        String uri = request.getRequestURI();
        for (String resource : noLoginResources) {
            if (uri.startsWith(resource)) {
                return true;
            }
        }
        if (handler instanceof HandlerMethod) {
            ACS acs = ((HandlerMethod) handler).getMethodAnnotation(ACS.class);
            // 判断是否允许匿名访问
            if (acs != null && acs.allowAnonymous()) {
                return true;
            }
        }
        // 缓存获取验证
        AdminVO user = userSessionService.getSessionUser(request);
        if (user == null) {
            ExceptionUtil.throwException(Errors.SYSTEM_NOT_LOGIN);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        //请求日志记录
        //User user =(User)request.getSession().getAttribute(Const.CURRENT_USER);
        AdminVO user = userSessionService.getSessionUser(request);
        SysLog sysLog = new SysLog();
        sysLog.setException(ex != null ? ex.toString() : "");
        sysLog.setType("1");
        sysLog.setMethod(request.getMethod());
        sysLog.setRequestUri(request.getRequestURI());
        sysLog.setRemoteAddr(userSessionService.getRemoteIP(request));

        Enumeration<String> e = request.getHeaders("Accept-Encoding");
        StringBuffer userAgent = new StringBuffer();
        while (e.hasMoreElements()) {
            userAgent.append(e.nextElement());
        }
//	  sysLog.setUserAgent(userAgent!=null?userAgent.toString():null);

        sysLogService.add(sysLog, user);

    }

}
