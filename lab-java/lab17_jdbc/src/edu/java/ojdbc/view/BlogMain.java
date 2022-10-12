package edu.java.ojdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;
import edu.java.ojdbc.view.BlogCreateFrame.OnBlogInsertListener;
import edu.java.ojdbc.view.BlogDetailFrame.OnBlogUpdateListener;

import static edu.java.ojdbc.model.Blog.Entity.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;

public class BlogMain implements OnBlogInsertListener, OnBlogUpdateListener {
    // 메인 화면에서 보여줄 JTable의 컬럼 이름들
    private static final String[] COLUMN_NAMES = { COL_BLOG_NO, COL_TITLE, COL_AUTHOR, COL_MODIFIED_DATE };

    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JComboBox<String> comboBox;

    private BlogDaoImpl dao;
    private JTextField textKeyword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogMain window = new BlogMain();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public BlogMain() {
        initialize(); // GUI 컴포넌트 생성 초기화
        dao = BlogDaoImpl.getInstance();
        initializeTable(); // 메인 화면에서의 JTable 데이터 초기화
    }

    private void initializeTable() {
        // 데이터는 없는, 컬럼 이름들만 설정된 테이블 모델 객체를 생성. > 데이터 초기화
        model = new DefaultTableModel(null, COLUMN_NAMES);
        // 테이블에 모델 객체를 설정.
        table.setModel(model);

        List<Blog> list = dao.select();
        // DB에서 데이터를 검색
        for (Blog b : list) {
            Object[] row = { b.getBlogNo(), b.getTitle(), b.getAuthor(), b.getModifiedDate() };
            // 테이블 모델에 행(row 데이터로 추가)
            model.addRow(row);
        }

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 660, 580);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 255, 255));
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

        JButton btnCreate = new JButton("새 글 작성");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 새 글 작성 Fram 만들기
                BlogCreateFrame.newBlogCreateFram(frame, BlogMain.this);
                // this만 작성시 익명클래스(ActionListener)의 주소를 가져온다.
            }
        });

        JButton btnReadAll = new JButton("전체 보기");
        btnReadAll.setBackground(SystemColor.activeCaption);
        btnReadAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeTable();
            }
        });
        btnReadAll.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        buttonPanel.add(btnReadAll);
        btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        buttonPanel.add(btnCreate);

        JButton btnRead = new JButton("상세보기");
        btnRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetailFrame();
            }
        });
        btnRead.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        buttonPanel.add(btnRead);

        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBlog();
            }
        });
        btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        buttonPanel.add(btnDelete);

        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);

        JPanel searchPanel = new JPanel();
        frame.getContentPane().add(searchPanel, BorderLayout.SOUTH);

        comboBox = new JComboBox<>();
        String[] comboBoxItems = { "제목", "내용", "제목 + 내용", "작성자" };
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(comboBoxItems);
        comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        comboBox.setModel(comboBoxModel);
        comboBox.setSelectedIndex(0);
        searchPanel.add(comboBox);

        textKeyword = new JTextField();
        textKeyword.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        searchPanel.add(textKeyword);
        textKeyword.setColumns(10);

        JButton btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBlogsByKeword();
            }
        });
        btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        searchPanel.add(btnSearch);

    }

    private void searchBlogsByKeword() {
        String keyword = textKeyword.getText();
        if (keyword.equals("")) {
            JOptionPane.showMessageDialog(frame, "검색어를 입력하세요.", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int type = comboBox.getSelectedIndex();
        System.out.println(type + " " + keyword);

        // TODO: DAO에 검색 타입과 검색어를 argument로 갖는 검색 메서드 호출
        List<Blog> list = dao.select(type, keyword);
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        for (Blog b : list) {
            Object[] row = { b.getBlogNo(), b.getTitle(), b.getAuthor(), b.getModifiedDate() };
            model.addRow(row);
        }
    }

    private void showDetailFrame() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(frame, "테이블의 행을 먼저 선택하세요.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Integer blogNo = (Integer) model.getValueAt(row, 0);

        BlogDetailFrame.newBlogDetailFrame(frame, blogNo, BlogMain.this); // BlogMain.this = this

    }

    private void deleteBlog() {
        int row = table.getSelectedRow(); // 테이블에서 선택된 행 인덱스

        if (row == -1) { // 선택된 행이 없는 경우.
            JOptionPane.showMessageDialog(frame, "삭제할 행을 선택해주세요.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 선택된 행에서 인덱스 0번 컬럼의 값(BLOG_NO)을 읽음.
        Integer blogNo = (Integer) model.getValueAt(row, 0);

        int confirm = JOptionPane.showConfirmDialog(frame, blogNo + "번 글을 정말 삭제하시겠습니까?", "삭제 확인",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Dao 객체의 delete 메서드를 사용해서 DB에서 삭제
            int result = dao.delete(blogNo);
            if (result == 1) {
                JOptionPane.showMessageDialog(frame, blogNo + "번 글 삭제 완료");
                initializeTable(); // 테이블 갱신
            } else {
                JOptionPane.showConfirmDialog(frame, "삭제 실패", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override // BlogCreateFram.OnBlogInsertListener 인터페이스의 메서드 구현
    public void onBlogInserted() {
        initializeTable();
    }

    @Override
    public void onBlogUpdated() {
        initializeTable();

    }
}
