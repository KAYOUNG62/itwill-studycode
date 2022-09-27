package edu.java.swing05;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class AppMain05 {
    // FileMain10 의 54번줄부터 이용하면 강제로 저장하지 않더라도 폴더를 읽어와서 할 수 있음.
    private static String[] IMAGES = { "images/flower1.jpg", // 이미지 파일의 경로를 저장한 배열.
            "images/flower2.jpg", "images/flower3.jpg", "images/flower4.jpg", "images/flower5.jpg" };

    private JFrame frame;
    private JLabel lblImage;

    private int index; // 현재 화면에 보여지는 이미지의 인덱스

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain05 window = new AppMain05();
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
    public AppMain05() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblImage = new JLabel(new ImageIcon(IMAGES[index]));
        lblImage.setBounds(12, 10, 640, 640);
        frame.getContentPane().add(lblImage);

        JButton btnPrev = new JButton("Prev");
        btnPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPrevImages(); // 내부 클래스에서는 외부 클래스의 메서드도 사용 가능.
//                if (index > 0) {
//                    index --;
//                    lblImage.setIcon(new ImageIcon(IMAGES[index]));
//                } else { 
//                    lblImage.setIcon(new ImageIcon(IMAGES[index]));
//                }
            }
        });
        btnPrev.setFont(new Font("굴림", Font.BOLD, 15));
        btnPrev.setBounds(12, 671, 160, 61);
        frame.getContentPane().add(btnPrev);

        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showNextImages();
//                if (index > 0) {
//                    index --;
//                    lblImage.setIcon(new ImageIcon(IMAGES[index]));
//                }
            }
        });
        btnNext.setFont(new Font("굴림", Font.BOLD, 15));
        btnNext.setBounds(492, 671, 160, 61);
        frame.getContentPane().add(btnNext);
    }

    private void showPrevImages() {
        // 현재 보여지는 이미지가 첫번째 이미지가 아니면 인덱스 1감소 > 새로운 이미지를 보여줌.
        // 현재 보여지는 이미지가 첫번째 이미지이면 마지막 이미지(index = length-1)를 보여줌
        if (index > 0) {
            index--;
        } else {
            index = IMAGES.length - 1;
        }
        lblImage.setIcon(new ImageIcon(IMAGES[index]));
    }

    private void showNextImages() {
        // 현재 보여지는 이미지가 마지막 이미지가 아니면 인덱스를 1 증가 > 새로운 이미지를 보여줌
        // 현배 보여지는 이미지가 가장 마지막 이미지이면 첫번째 이미지를 보여줌
        if (index < IMAGES.length - 1) { // 이미지의 개수가 5개이지만 인덱스는 0부터 4까지임
            index++;
        } else {
            index = 0;
        }
        lblImage.setIcon(new ImageIcon(IMAGES[index]));
    }

}
