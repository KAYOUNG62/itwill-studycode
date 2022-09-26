package edu.java.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain04 {

    private JFrame frame;
    private JLabel lblNum1;
    private JTextField textNum1;
    private JTextField textNum2;
    private JButton btnPlus;
    private JButton btnMin;
    private JButton btnMul;
    private JButton btnDiv;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain04 window = new AppMain04();
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
    public AppMain04() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 377, 413);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblNum1 = new JLabel("num1");
        lblNum1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNum1.setFont(new Font("궁서", Font.BOLD, 17));
        lblNum1.setBounds(36, 44, 95, 49);
        frame.getContentPane().add(lblNum1);

        JLabel lblNum2 = new JLabel("num2");
        lblNum2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNum2.setFont(new Font("궁서", Font.BOLD, 17));
        lblNum2.setBounds(36, 103, 95, 49);
        frame.getContentPane().add(lblNum2);

        textNum1 = new JTextField();
        textNum1.setHorizontalAlignment(SwingConstants.CENTER);
        textNum1.setFont(new Font("궁서", Font.BOLD, 15));
        textNum1.setBounds(143, 45, 178, 49);
        frame.getContentPane().add(textNum1);
        textNum1.setColumns(10);

        textNum2 = new JTextField();
        textNum2.setHorizontalAlignment(SwingConstants.CENTER);
        textNum2.setFont(new Font("궁서", Font.BOLD, 15));
        textNum2.setColumns(10);
        textNum2.setBounds(143, 103, 178, 49);
        frame.getContentPane().add(textNum2);

        btnPlus = new JButton("+");
        // 파라미터 e: 이벤트가 발생한 컴포넌트, 이벤트의 종류 등에 대한 정보를 출력
        // e.getSource() : 이벤트가 발생한 컴포넌트를 리턴.
        // System.out.println(e.getSource());
        btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performCalculation(e);
            }
        });

        btnPlus.setFont(new Font("굴림", Font.BOLD, 30));
        btnPlus.setBounds(36, 172, 55, 55);
        frame.getContentPane().add(btnPlus);

        btnMin = new JButton("-");
        btnMin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performCalculation(e);
            }
        });
        btnMin.setFont(new Font("굴림", Font.BOLD, 30));
        btnMin.setBounds(113, 172, 55, 55);
        frame.getContentPane().add(btnMin);

        btnMul = new JButton("x");
        btnMul.addActionListener(e ->performCalculation(e));
        btnMul.setFont(new Font("굴림", Font.BOLD, 30));
        btnMul.setBounds(191, 172, 55, 55);
        frame.getContentPane().add(btnMul);

        btnDiv = new JButton("/");
        btnDiv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performCalculation(e);
            }
        });
        btnDiv.setFont(new Font("굴림", Font.BOLD, 30));
        btnDiv.setBounds(266, 172, 55, 55);
        frame.getContentPane().add(btnDiv);

        textArea = new JTextArea();
        textArea.setBounds(36, 245, 285, 102);
        frame.getContentPane().add(textArea);

    }

    private void performCalculation(ActionEvent e) {
        double number1 =0;
        double number2 =0;
        // JTextField에 입력된 문자열을 읽고. double 타입으로 변환
        String s1 = textNum1.getText();
        String s2 = textNum2.getText();
        String op = " ";

        try {
        // 문자열을 double 타입으로 변환
        number1 = Double.parseDouble(s1);
        number2 = Double.parseDouble(s2);
        } catch (NumberFormatException e1) {
            textArea.setText("숫자 타입으로 입력하세요");
            return;
        }
        double result = 0; // 산술 연산 결과를 저장하기 위한 변수
        Object source = e.getSource(); // 이벤트가 발생한 컴포넌트.
        
        if (source == btnPlus) {
            result = number1 + number2;
            op = "+";
        } else if (source == btnMin) {
            result = number1 - number2;
            op = "-";
        } else if (source == btnMul) {
            result = number1 * number2;
            op = "*";
        } else if (source == btnDiv) {
            result = number1 / number2;
            op = "/";
        }
     

        String output = String.format("%.2f %s %.2f = %.2f", number1, op, number2, result);
        textArea.setText(output);
    }

}
