package com.springboot.learning.demo_05_tlias.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//filter实现统一拦截请求

public class DemoFilter implements Filter {
//    init方法：过滤器的初始化方法。在web服务器启动的时候会自动的创建Filter过滤器对象，
//    在创建过滤器对象的时候会自动调用init初始化方法，这个方法只会被调用一次。
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化方法执行了");
    }
//    doFilter方法：这个方法是在每一次拦截到请求之后都会被调用，所以这个方法是会被调用多次的，
//    每拦截到一次请求就会调用一次doFilter()方法。
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo 拦截到了请求...放行前逻辑");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("Demo 拦截到了请求...放行后逻辑");
    }
//destroy方法： 是销毁的方法。当我们关闭服务器的时候，它会自动的调用销毁方法destroy，
// 而这个销毁方法也只会被调用一次。
    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
