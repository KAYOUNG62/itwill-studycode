package edu.web.jsp02.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@Slf4j
@WebFilter(filterName = "encodingFilter", urlPatterns = { "/*" })
public class EncodingFilter extends HttpFilter implements Filter {

    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncodingFilter() {
        log.info("EncodingFilter 생성자 호출");
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // Filter 객체가 소멸될 때 WAS에서 호출되는 메서드.
        log.info("destroy 생성자 호출");
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 클라이언트에서 온 요청을 서블릿(controller)로 전달하기 전에 실행할 코드들.
        log.info("doFilter 호출 전");
        
        // 모든 요청의 인코딩 값을 "UTF-8"로 설정
        ((HttpServletRequest) request).setCharacterEncoding("UTF-8");
        
        // pass the request along the filter chain
        chain.doFilter(request, response); // 요청을 처리할 Servlet(controller)로 요청을 전달. 
        log.info("doFilter 호출 후");
        
        // 서블릿 클래스의 메서드 (doGet, doPost)가 종료된후에 실행할 코드들
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // WAS가 Filter 객체를 생성하고 초기화할 때 호출하는 메서드.
        log.info("init 호출");
    }

}
