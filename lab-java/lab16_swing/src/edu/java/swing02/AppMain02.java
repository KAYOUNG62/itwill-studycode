package edu.java.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AppMain02 {

    //field
    private JFrame frame;
    private JTextField textInput;
    private JLabel lblResult;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain02 window = new AppMain02();
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
    public AppMain02() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null); // absolute layout
        
        lblResult = new JLabel("New label");
        lblResult.setFont(new Font("궁서", Font.BOLD | Font.ITALIC, 20));
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);
        lblResult.setBounds(12, 10, 410, 65);
        frame.getContentPane().add(lblResult); // JLabel 이 화면에 추가
        
        textInput = new JTextField();
        textInput.setBackground(new Color(255, 255, 255));
        textInput.setHorizontalAlignment(SwingConstants.CENTER);
        textInput.setBounds(12, 85, 410, 78);
        frame.getContentPane().add(textInput);//JTextField가 화면에 추가
        textInput.setColumns(10); 
        
        JButton btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                //버튼이 클릭됐을때 할 일을 정의. 
                // 1) JTextField에 입력된 내용을 읽음.
                String input = textInput.getText();
                
                // 2) 그 내용을 JLabel에 씀
                lblResult.setText(input);
            }
        });
        btnInput.setFont(new Font("궁서", Font.BOLD | Font.ITALIC, 20));
        btnInput.setBounds(12, 196, 410, 55);
        frame.getContentPane().add(btnInput); //Jbutton을 화면에 추가
    }
}
