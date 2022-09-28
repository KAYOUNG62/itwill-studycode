package edu.java.contact.ver05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.ver04.Contact;
import edu.java.contact.ver04.ContactDaoImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import edu.java.contact.ver05.ContactCreateFrame.ContactInsertListener;

public class ContactMain05 implements ContactInsertListener{
    private static final String[] COLUMN_NAME = {"이름" , "전화번호"};

    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private ContactDaoImpl dao;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactMain05 window = new ContactMain05();
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
    public ContactMain05() {
        initialize(); //UI 컴포넌트 생성, 초기화
        dao = ContactDaoImpl.getInstance(); // 연락처 데이터 관리(추가, 삭제, 변경, 검색...)
        loadContactDataFromFile(); // 데이터 파일에 저장된 데이터를 불러와서 로드에서 테이블에 설정.
        
    }
    
    private void loadContactDataFromFile() {
        List<Contact> list = dao.read();
        for (Contact c : list ) {
            addContactToTableModel(c);
        }
    }

    private void addContactToTableModel(Contact c) {
        // 테이블 모델에 추가할 행(row) 데이터
        Object[] rowData = {c.getName(), c.getPhone()};
        // 테이블 모델에 데이터 추가
        model.addRow(rowData);
        
        
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("연락처 프로그램 ver05"); // 애플리케이션 타이틀을 설정
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        JButton btnCreate = new JButton("연락처 등록");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactCreateFrame.newContactCreateFrame(frame, ContactMain05.this);
                // TODO
                
            }
        });
        btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        buttonPanel.add(btnCreate);
        
        JButton btnUpdate = new JButton("연락처 수정");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactUpdateFrame.newContactUpdateFrame(frame);
                // TODO
            }
        });
        btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        buttonPanel.add(btnUpdate);
        
        JButton btnDelete = new JButton("연락처 삭제");
        btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        buttonPanel.add(btnDelete);
        
        JButton btnSearch = new JButton("연락처 검색");
        btnSearch.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        buttonPanel.add(btnSearch);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        model = new DefaultTableModel(null , COLUMN_NAME);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table.setModel(model);
        frame.setBounds(100, 100, 497, 463);
        scrollPane.setViewportView(table);
    }

    //ContactCreateFrame.ContactInsertListener 인터페이스의 메서드를 구현.
    @Override
    public void contactInsertNotify(Contact c) {
        System.out.println(c);
        
    }

}
