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
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

import edu.java.ojdbc.model.Blog;
import edu.java.ojdbc.model.Blog.*;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class BlogCreateFrame extends JFrame {
    
    @FunctionalInterface
    public interface BlogCreateListener {
        void blogCreateNotify (Blog blog);
    }

    private BlogCreateListener listner;
    
    private Component parent;

    private JPanel contentPane;
    private JTextField textTitle;
    private JTextField textCreate;
    private JTextField textModified;
    private JTextField textAuthor;
    private JTextArea textArea;


    /**
     * Launch the application.
     */
    public static void newBlogCreateFram(Component parent, BlogCreateListener listner) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                BlogCreateFrame frame = new BlogCreateFrame(parent, listner);
                frame.setVisible(true);

            }
        });
    }

    /**
     * Create the frame.
     */
    public BlogCreateFrame(Component parent, BlogCreateListener listner) {
        this.parent = parent;
        this.listner = listner;
        initialize();
    }

    private void initialize() {
        setTitle("새글작성");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int x = parent.getX();
        int y = parent.getY();
        setBounds(x, y, 660, 580);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblAuthor = new JLabel("작성자:");
        lblAuthor.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
        lblAuthor.setBounds(328, 463, 76, 29);
        contentPane.add(lblAuthor);

        JLabel lblTitle = new JLabel("제목 >");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lblTitle.setBounds(12, 10, 93, 36);
        contentPane.add(lblTitle);

        JLabel lblCreateDate = new JLabel("작성날짜");
        lblCreateDate.setHorizontalAlignment(SwingConstants.CENTER);
        lblCreateDate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lblCreateDate.setBounds(218, 385, 88, 29);
        contentPane.add(lblCreateDate);

        JLabel lblModifiedDate = new JLabel("수정날짜");
        lblModifiedDate.setHorizontalAlignment(SwingConstants.CENTER);
        lblModifiedDate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lblModifiedDate.setBounds(218, 424, 88, 29);
        contentPane.add(lblModifiedDate);


        textTitle = new JTextField();
        textTitle.setHorizontalAlignment(SwingConstants.LEFT);
        textTitle.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        textTitle.setBounds(117, 10, 515, 36);
        contentPane.add(textTitle);
        textTitle.setColumns(10);

        textCreate = new JTextField();
        textCreate.setColumns(10);
        textCreate.setBounds(318, 385, 314, 29);
        contentPane.add(textCreate);

        textModified = new JTextField();
        textModified.setColumns(10);
        textModified.setBounds(318, 424, 314, 29);
        contentPane.add(textModified);

        textAuthor = new JTextField();
        textAuthor.setColumns(10);
        textAuthor.setBounds(416, 463, 216, 29);
        contentPane.add(textAuthor);

        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnCancel.setBounds(557, 502, 75, 29);
        contentPane.add(btnCancel);

        JButton btnInsert = new JButton("완료");
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createBlogBT();
            }
        });
        btnInsert.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnInsert.setBounds(470, 502, 75, 29);
        contentPane.add(btnInsert);
        
        textArea = new JTextArea();
        textArea.setBounds(12, 56, 620, 319);
        contentPane.add(textArea);

    }

    protected void createBlogBT() {
        String title = textTitle.getText();
        String content = textArea.getText();
        String author = textAuthor.getText();
        
        LocalDateTime.now();
              
    }
}
