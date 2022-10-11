package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogDetailFrame extends JFrame {
    
    public interface OnBlogUpdateListener {
        void onBlogUpdated();
    }

    private OnBlogUpdateListener listener;
    private Component parent;
    private Integer blogNo;
    private BlogDaoImpl dao;

    private JPanel contentPane;
    private JTextArea textContent;
    private JTextField textBlogNo;
    private JTextField textTitle;
    private JTextField textAuthor;
    private JTextField textCreatedDate;
    private JTextField textModifiedDate;
    
    

    /**
     * Launch the application.
     */
    public static void newBlogDetailFrame(Component parent, Integer blogNo, OnBlogUpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                    BlogDetailFrame frame = new BlogDetailFrame(parent, blogNo, listener);
                    frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */
    public BlogDetailFrame(Component parent, Integer blogNo, OnBlogUpdateListener listener) {
        this.listener = listener; // 블로그 글 업데이트 결과를 통지할 수 있는 메서드를 가지고 있는 객체.
        this.blogNo = blogNo; // 상세보기/수정할 블로그 글 번호.
        this.parent = parent;
        this.dao = BlogDaoImpl.getInstance();
        initialize(); // UI 컴포넌트 생성, 초기화.
        
        initializeBlogData(); // JTextField와 JTextArea의 내용을 DB에서 검색한 내용으로 채움
    }
    
    
    private void initializeBlogData() {
        Blog blog = dao.select(blogNo);
        if (blog != null) {
            textBlogNo.setText(blog.getBlogNo().toString());
            textTitle.setText(blog.getTitle());
            textContent.setText(blog.getContent());
            textAuthor.setText(blog.getAuthor());
            textCreatedDate.setText(blog.getCreateDate().toString());
            textModifiedDate.setText(blog.getModifiedDate().toString());
        }
        
    }

    private void initialize() {
        setTitle("블로그 상세 보기");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = parent.getX();
        int y = parent.getY();
        setBounds(x, y, 400, 680);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblBlogNo = new JLabel("번호");
        lblBlogNo.setHorizontalAlignment(SwingConstants.LEFT);
        lblBlogNo.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblBlogNo.setBounds(12, 10, 62, 36);
        contentPane.add(lblBlogNo);
        
        textBlogNo = new JTextField();
        textBlogNo.setEditable(false);
        textBlogNo.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        textBlogNo.setBounds(60, 10, 312, 36);
        contentPane.add(textBlogNo);
        textBlogNo.setColumns(10);
        
        JLabel lblTitle = new JLabel("제목");
        lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblTitle.setBounds(12, 56, 76, 36);
        contentPane.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        textTitle.setColumns(10);
        textTitle.setBounds(12, 97, 360, 36);
        contentPane.add(textTitle);
        
        JLabel lblContent = new JLabel("내용");
        lblContent.setHorizontalAlignment(SwingConstants.LEFT);
        lblContent.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblContent.setBounds(12, 143, 76, 36);
        contentPane.add(lblContent);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 183, 360, 263);
        contentPane.add(scrollPane);

        textContent = new JTextArea();
        textContent.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        scrollPane.setViewportView(textContent);
        
        JLabel lblAuthor = new JLabel("작성자");
        lblAuthor.setHorizontalAlignment(SwingConstants.LEFT);
        lblAuthor.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lblAuthor.setBounds(12, 456, 76, 36);
        contentPane.add(lblAuthor);
        
        textAuthor = new JTextField();
        textAuthor.setEditable(false);
        textAuthor.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        textAuthor.setColumns(10);
        textAuthor.setBounds(92, 456, 280, 36);
        contentPane.add(textAuthor);
        
        JLabel lblCreatedDate = new JLabel("작성 시간");
        lblCreatedDate.setHorizontalAlignment(SwingConstants.LEFT);
        lblCreatedDate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lblCreatedDate.setBounds(12, 502, 85, 36);
        contentPane.add(lblCreatedDate);
        
        textCreatedDate = new JTextField();
        textCreatedDate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        textCreatedDate.setEditable(false);
        textCreatedDate.setColumns(10);
        textCreatedDate.setBounds(92, 502, 280, 36);
        contentPane.add(textCreatedDate);
        
        JLabel lblModifiedDate = new JLabel("수정 시간");
        lblModifiedDate.setHorizontalAlignment(SwingConstants.LEFT);
        lblModifiedDate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lblModifiedDate.setBounds(12, 548, 85, 36);
        contentPane.add(lblModifiedDate);
        
        textModifiedDate = new JTextField();
        textModifiedDate.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        textModifiedDate.setEditable(false);
        textModifiedDate.setColumns(10);
        textModifiedDate.setBounds(92, 548, 280, 36);
        contentPane.add(textModifiedDate);
        
        JButton btnUpdate = new JButton("수정 완료");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateBlog();
            }
        });
        btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnUpdate.setBounds(267, 594, 105, 37);
        contentPane.add(btnUpdate);
    }

    private void UpdateBlog() {
        // 수정할 title, content 읽음.
        String title = textTitle.getText();
        String content = textContent.getText();
        
        if (title.equals("")||content.equals("")) {
            JOptionPane.showMessageDialog(this, "제목과 내용을 입력하세요", "ERROR" , JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // dao.update() 호출
        Blog blog = new Blog(blogNo, title, content, null, null, null);
                
        int result = dao.update(blog);
        
        // BlogMain 업데이트 성공을 알려줌.
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "수정 완료");
            listener.onBlogUpdated();
        } else {
            JOptionPane.showMessageDialog(this, "수정 실패");
        }
        
        // DetailFrame은 닫음
        dispose();
        
    }
}
