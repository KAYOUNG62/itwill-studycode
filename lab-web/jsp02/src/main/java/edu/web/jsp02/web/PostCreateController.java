package edu.web.jsp02.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.dto.PostCreateDto;
import edu.web.jsp02.repository.PostDao;
import edu.web.jsp02.repository.PostDaoImpl;
import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class PostCreateController
 */
@Slf4j
@WebServlet(name = "postCreateController", urlPatterns = { "/post/create" })
public class PostCreateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PostService postService = PostServiceImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostCreateController() {

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("doGet()");

        request.getRequestDispatcher("/WEB-INF/post/create.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("doPost()");
        request.setCharacterEncoding("UTF-8");
//        
//        // 요청 파라미터 분석: title, content, author 값을 찾음
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String author = request.getParameter("author");
        log.info(title);
        log.info(content);
        log.info(author);
        
//        // PostCreateDto 타입 객체 생성
        PostCreateDto dto = new PostCreateDto();

        dto.setTitle(title);
        dto.setContent(content);
        dto.setAuthor(author);
        
//        // PostService create() 메서드 호출 - postDao호출 - DB에 저장
        log.info("create(dto={})", dto);
        postService.create(dto);
        
//        // 포스트 목록 페이지로 이동(redirect)
        response.sendRedirect("/jsp02/post");

    }

}
