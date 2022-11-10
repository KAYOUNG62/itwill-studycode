package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.dto.UserSignUpDto;
import edu.web.jsp02.service.UserService;
import edu.web.jsp02.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserCreateController
 */
@Slf4j
@WebServlet(name = "userSignUpController", urlPatterns = { "/user/signup" })
public class UserSignUpController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUpController() {
        userService = UserServiceImpl.getInstance();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("doGet() 호출");
        
        request.getRequestDispatcher("/WEB-INF/user/userSignup.jsp").forward(request, response);
        
    
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("doPost() 호출");
        
        //요청 파라미터를 분석
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        UserSignUpDto dto = UserSignUpDto.builder()
                .username(username).password(password).email(email)
                .build();
        
        int result = userService.signUp(dto);
        log.info("signUp(dto={}", dto);
        
        if(result == 1 ) {
            response.sendRedirect("/jsp02/user/signin"); //로그인 페이지로 이동
        } else {
            response.sendRedirect("/jsp02/user/signup");
        }
        
    }

}
