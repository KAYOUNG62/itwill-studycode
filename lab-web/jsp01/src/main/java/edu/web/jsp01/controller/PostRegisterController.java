package edu.web.jsp01.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp01.domain.Post;

/**
 * Servlet implementation class PostRegisterController
 */
@WebServlet(name = "postRegisterController", urlPatterns = { "/post/register" })
public class PostRegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostRegisterController() {
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/post/register.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Integer id = Integer.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        LocalDateTime createTime = LocalDateTime.parse(request.getParameter("createTime"));

        // post 타입 객체 생성
        Post post = new Post(id, title, content, createTime);
        System.out.println(post);
        // post 객체를 request의 속성 값으로 추가 -> view에 전달
        request.setAttribute("post", post);
        // view로 이동
        request.getRequestDispatcher("/WEB-INF/post/register-result.jsp").forward(request, response);

    }

}
