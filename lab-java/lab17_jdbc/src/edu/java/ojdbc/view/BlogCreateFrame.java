package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;
import javax.swing.JTextArea;
import java.awt.Color;

public class BlogCreateFrame extends JFrame {
    
    @FunctionalInterface
    public interface OnBlogInsertListener {
        void onBlogInserted();
    }
    
    private OnBlogInsertListener listener;
    private Component parent; // 부모 컴포넌트를 저장하기 위한 필드.
    private BlogDaoImpl dao; // DB 테이블 insert 기능을 가지고 있는 객체.

    private JPanel contentPane;
    private JTextField textTitle;
    private JTextField textAuthor;
    private JTextArea textContent;


    /**
     * Launch the application.
     */
    public static void newBlogCreateFram(Component parent, OnBlogInsertListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                BlogCreateFrame frame = new BlogCreateFrame(parent, listener);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */
    public BlogCreateFrame(Component parent, OnBlogInsertListener listener) {
        this.listener = listener;
        this.parent = parent;
        this.dao = BlogDaoImpl.getInstance();
        initialize(); // UI 컴포넌트들(JLabel, JTextFiedl, JTextArea, ..) 생성, 초기화
    }

    private void initialize() {
        
        
        setTitle("새글작성");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // JFram의 닫기 동작 > 현재 창 닫기

        int x = parent.getX(); 
        int y = parent.getY();
        setBounds(x, y, 465, 565);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("제목");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblTitle.setBounds(12, 10, 76, 36);
        contentPane.add(lblTitle);

        JLabel lblContent = new JLabel("내용");
        lblContent.setHorizontalAlignment(SwingConstants.CENTER);
        lblContent.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblContent.setBounds(12, 84, 76, 36);
        contentPane.add(lblContent);

        textTitle = new JTextField();
        textTitle.setHorizontalAlignment(SwingConstants.LEFT);
        textTitle.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        textTitle.setBounds(12, 43, 418, 36);
        contentPane.add(textTitle);
        textTitle.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 123, 418, 252);
        contentPane.add(scrollPane);
        
        textContent = new JTextArea();
        textContent.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        scrollPane.setViewportView(textContent);

        
        JLabel lblAuthor = new JLabel("작성자");
        lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
        lblAuthor.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblAuthor.setBounds(12, 380, 76, 36);
        contentPane.add(lblAuthor);
        
        textAuthor = new JTextField();
        textAuthor.setHorizontalAlignment(SwingConstants.LEFT);
        textAuthor.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        textAuthor.setColumns(10);
        textAuthor.setBounds(12, 426, 418, 36);
        contentPane.add(textAuthor);
        
        JButton btnCreate = new JButton("작성완료");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewBlogPost();
            }
        });
        btnCreate.setBackground(Color.LIGHT_GRAY);
        btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnCreate.setBounds(12, 472, 418, 29);
        contentPane.add(btnCreate);
    }

    private void createNewBlogPost() {
        // 제목, 내용, 작성자 정보 읽음.
        String title = textTitle.getText();
        String content = textContent.getText();
        String author = textAuthor.getText();
        
        if(title.equalsIgnoreCase("") || content.equals("")|| author.equals("")) {
            JOptionPane.showMessageDialog(this, // parentComponent . this > BlogCreateFram의 인스턴스 주소
                    "제목, 내용, 작성자를 입력하세요.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return; // insert 못하도록 메서드 종료
        }
        
        // 제목, 내용, 작성자 > Blog 객체 생성
        Blog blog = new Blog(null, title, content, author, null, null);
        // dao의 insert 메서드를 호출 > DB에 저장
        int result = dao.insert(blog);
        
        if (result == 1 ) { //insert 성공 
            JOptionPane.showMessageDialog(this, "새글 작성 성공");
            dispose();
            // 테이블 갱신
        listener.onBlogInserted();
            
        } else {
            JOptionPane.showConfirmDialog(this, "작성실패" , "ERROR" ,JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
