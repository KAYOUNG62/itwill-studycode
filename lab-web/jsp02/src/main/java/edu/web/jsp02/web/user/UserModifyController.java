package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.dto.UserUpdateDto;
import edu.web.jsp02.service.UserService;
import edu.web.jsp02.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserUpdateController
 */
@Slf4j
@WebServlet(name = "userUpdateController", urlPatterns = { "/user/userModify" })
public class UserModifyController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifyController() {
        userService = UserServiceImpl.getInstance();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("doGet()호출");
        
        Integer id = Integer.valueOf(request.getParameter("id"));
        log.info("id={}",id);
        
        User user= userService.readById(id);
        
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/user/userModify.jsp").forward(request, response);
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("doPost()호출");
        
        Integer id = Integer.valueOf(request.getParameter("id"));
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        UserUpdateDto dto = UserUpdateDto.builder()
                .id(id).password(password).email(email)
                .build();
        log.info("dto = {}",dto);
        
        int result = userService.update(dto);
        log.info("update(dto={})",result);
        
        response.sendRedirect("/jsp02/user/userDetail?id=" + id);
        
    }

}
