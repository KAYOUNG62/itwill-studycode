package edu.web.jsp02.web.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.Post;
import edu.web.jsp02.dto.postUpdateDto;
import edu.web.jsp02.service.PostService;
import edu.web.jsp02.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class PostModifyController
 */
@Slf4j
@WebServlet(name = "postModifyController", urlPatterns = { "/post/modify" })
public class PostModifyController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PostService postService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostModifyController() {
        postService = PostServiceImpl.getInstance();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("doGet() 호출");
        
        //요청파라미터 id 찾기
        Integer id = Integer.valueOf(request.getParameter("id"));
        log.info("id={}", id);
        
        // id로 레코드 찾기.
        Post post = postService.readById(id);
        
        //뷰에 전달
        request.setAttribute("post", post);
        request.getRequestDispatcher("/WEB-INF/post/modify.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("doPost() 호출");
        
        Integer id = Integer.valueOf(request.getParameter("id"));
        log.info("id = {}", id);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        postUpdateDto dto = postUpdateDto.builder().id(id).title(title).content(content).build();
        log.info("dto={}", dto);
        
        int result = postService.update(dto);
        
        
        response.sendRedirect("/jsp02/post/detail?id=" +id );
        
        //PRG(Post - Redirect - Get) 패턴
        
//        int result = postService.update(post, id);
//        post = postService.readById(id);
//        request.setAttribute("post", post);
//        request.getRequestDispatcher("/WEB-INF/post/detail.jsp").forward(request, response);
                
                
    }

}
