package top.seiei.filter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器
 */
@Configuration
public class Filters {

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    /**
     * 过滤器1
     * 创建 FilterRegistrationBean 并返回，创建 FilterResgistrationBean 需要使用 setFilter 导入具体的拦截功能
     * @return FilterRegistrationBean 实例
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean1() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new Filter1()); // 导入具体的拦截功能
        registration.addUrlPatterns("/*"); // 拦截的路径
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("Filter1"); // 拦截器名称
        registration.setOrder(1); // 拦截器执行排序
        return registration;
    }

    /**
     * 过滤器1 的具体拦截功能
     * 实现 Filter 接口
     * 主要实现 doFilter 方法
     */
    public class Filter1 implements Filter {
        @Override
        public void destroy() {
        }

        @Override
        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
                throws IOException, ServletException {
            // HttpServletRequest 对象可以获取 url 路径以及 Session 对象
            HttpServletRequest request = (HttpServletRequest) srequest;
            System.out.println("this is Filter1,url :"+request.getRequestURI());
            // 在操作完所有内容的时候，如果不需要把请求拦截下来，就需要将请求的控制权交给下一个拦截器
            filterChain.doFilter(srequest, sresponse);
        }

        @Override
        public void init(FilterConfig arg0) throws ServletException {
        }
    }

    /**
     * 拦截器2
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new Filter2());
        registration.addUrlPatterns("/hello");
        registration.setName("Filter2");
        registration.setOrder(2); // 排序为 2
        return registration;
    }

    public class Filter2 implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response=(HttpServletResponse) servletResponse;
            System.out.println("this is Filter2");
            response.sendRedirect("test.html"); // 把请求拦截下来，并转向到别的页面，常用于用户权限接口
        }

        @Override
        public void destroy() {
        }
    }
}
