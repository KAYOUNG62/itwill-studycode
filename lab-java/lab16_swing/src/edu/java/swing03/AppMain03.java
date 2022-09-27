package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;

public class AppMain03 {

    private JFrame frame;
    private JTextField textName;
    private JLabel lblPhone;
    private JLabel lblEmail;
    private JTextField textPhone;
    private JTextField textEmail;
    private JTextArea textArea;
    private JButton btnInput;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain03 window = new AppMain03();
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
    public AppMain03() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setBackground(new Color(255, 255, 255));
        lblName.setFont(new Font("굴림", Font.BOLD, 16));
        lblName.setHorizontalAlignment(SwingConstants.LEFT);
        lblName.setBounds(37, 24, 75, 43);
        frame.getContentPane().add(lblName);
        
        lblPhone = new JLabel("전화번호");
        lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
        lblPhone.setFont(new Font("굴림", Font.BOLD, 16));
        lblPhone.setBounds(37, 77, 75, 43);
        frame.getContentPane().add(lblPhone);
        
        lblEmail = new JLabel("이메일");
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmail.setFont(new Font("굴림", Font.BOLD, 16));
        lblEmail.setBounds(37, 130, 75, 43);
        frame.getContentPane().add(lblEmail);
        
        textName = new JTextField();
        textName.setBounds(146, 24, 165, 43);
        frame.getContentPane().add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setColumns(10);
        textPhone.setBounds(146, 77, 165, 43);
        frame.getContentPane().add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(146, 130, 165, 43);
        frame.getContentPane().add(textEmail);
        
        btnInput = new JButton("입력");
        // 버튼의 이벤트 핸들러를 등록
        // 이벤트 핸들러: 이벤트가 발생됐을때 자동으로 호출되는 메서드
        btnInput.addActionListener((e) -> printInfo());
        btnInput.setBounds(323, 130, 97, 43);
        frame.getContentPane().add(btnInput);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("굴림", Font.BOLD, 15));
        textArea.setBounds(12, 186, 411, 54);
        frame.getContentPane().add(textArea);
    }
    // "입력" 버튼을 클릭했을 때 실행할 내용
    private void printInfo() {
     // JTextField에 입력된 내용을 읽음
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        //JTextArea에 출력할 문자열 만들기
        StringBuilder buffer = new StringBuilder();
        buffer.append("이름: ").append(name).append("\n");
        buffer.append("전화번호: ").append(phone).append("\n");
        buffer.append("이메일: ").append(email);
        
        //만들어진 문자열을 JTextArea에 출력
        textArea.setText(buffer.toString());
    }
}
