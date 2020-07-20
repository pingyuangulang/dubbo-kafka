package com.five.monkey.provider.filter;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 *
 * @author jim
 * @date 2020/7/20 16:53
 */
@Component
@WebFilter
public class MyFilter implements Filter {

    /**
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();
        httpServletRequest.setCharacterEncoding("UTF-8");

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (1 < hour && hour <= 7) {
            String msg = "接口" + url + "在[1-8)点之间拒绝访问";
            httpServletResponse.getWriter().write(msg);
            return;
        }
        chain.doFilter(request, response);
    }


    @Override
    public void destroy() {

    }
}
