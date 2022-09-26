package edu.java.swing01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AppMain01 {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // 쓰레드를 EventQueue에 등록-> 자바 가상머신이 쓰레드를 실행시킴 -> run() 실행
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain01 window = new AppMain01();
                    window.frame.setVisible(true); // false 로 되어있으면 실행은 되지만 화면은 보이지않음
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain01() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(241, 241, 239));
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.setBounds(100, 100, 600, 400); // 100, 100 > 시작되는 위치 / 450(가로), 300(세로) > 프레임의 크기
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼을 클릭했을때 동작방식을 설정. EXIT_ON_CLOSE > 버튼을 클릭하면 프로그램 종료

        JLabel lblText = new JLabel("안녕하세요 swing"); // JLabel 객체 생성
        lblText.setHorizontalAlignment(SwingConstants.CENTER);
        lblText.setFont(new Font("궁서", Font.PLAIN, 40));
        frame.getContentPane().add(lblText, BorderLayout.CENTER);
    }

}
