package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserSignOutController
 */
@Slf4j
@WebServlet(name = "userSignOutController", urlPatterns = { "/user/signout" })
public class UserSignOutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("doGet()");
        // (1) 세션에 저장된 속성(Attribute)를 제거
        HttpSession session = request.getSession();
        session.removeAttribute("signInUser");
        
        // (2) 세선 객체 무효화 (2번만 실행되도 문제는 없음)
        session.invalidate();
        
        //로그아웃 이후에는 로그인 페이지로 이동
        response.sendRedirect("/jsp02/");
        
        
    }

}
