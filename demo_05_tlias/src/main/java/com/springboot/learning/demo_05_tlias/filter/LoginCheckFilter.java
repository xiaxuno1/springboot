package com.springboot.learning.demo_05_tlias.filter;

import com.alibaba.fastjson.JSONObject;
import com.springboot.learning.demo_05_tlias.utils.JwtUtils;
import com.springboot.learning.demo_05_tlias.utils.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//过滤器实现，登录校验，所有的请求都要执行登录校验，成功放行，失败重定向到登录界面
//通过这个属性指定过滤器要拦截哪些请求
@Slf4j
//@WebFilter(urlPatterns ="/*")//配置过滤器要拦截的请求路径（ /* 表示拦截浏览器的所有请求 ）
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        获取请求
         HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;//强转，需要使用其方法
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;

        String url = httpServletRequest .getRequestURI().toString();  //判断请求是否为登录请求，登录请求放行
        log.info("请求的url: {}",url);
        if (url.contains("login")) {
            log.info("登录操作, 放行...");
            filterChain.doFilter(servletRequest, servletResponse); //放行
            return;
        }
//        解析校验token
        String jwt = httpServletRequest.getHeader("token"); //获取token
        if (!StringUtils.hasLength(jwt)) { //jwt为空，返回错误信息
            log.info("请求头token为空,返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--json --------> 阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            httpServletResponse.getWriter().write(notLogin); //响应错误
            return;
        }
        try {
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){  //jwt校验失败，重定向到登录界面
            e.printStackTrace();//打印异常堆栈跟踪信息
            log.info("解析令牌失败, 重定向到登录页面");
//            Result error = Result.error("NOT_LOGIN");
//            //手动转换 对象--json --------> 阿里巴巴fastJSON
//            String notLogin = JSONObject.toJSONString(error);
//            httpServletResponse.getWriter().write(notLogin);//将 JSON 字符串写入响应中，向客户端返回未登录的错误信息。
            httpServletResponse.setStatus(HttpServletResponse.SC_FOUND); //302重定向，浏览器自动识别重定向
            String loginPageurl = httpServletRequest.getContextPath()+"/login";
            httpServletResponse.setHeader("Location",loginPageurl); //请求头中携带重定向地址
            return;//结束当前方法的执行，避免继续执行过滤链
        }

//        放行或返回
        log.info("令牌合法, 放行");
        filterChain.doFilter(servletRequest, servletResponse);
//        调用过滤链中的下一个过滤器或目标资源。如果这个过滤器是链中的最后一个，
//        那么它将最终处理请求（例如，调用实际的请求处理器或控制器）
    }


}
