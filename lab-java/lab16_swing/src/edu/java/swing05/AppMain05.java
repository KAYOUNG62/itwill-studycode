package edu.java.swing05;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import java.awt.event.ActionEvent;

public class AppMain05 {

    private JFrame frame;

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
    
    private String[] imagesFile = {"images/flower1.jpg" , "images/flower2.jpg", "images/flower3.jpg", "images/flower4.jpg", "images/flower5.jpg"};

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 700, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblImage = new JLabel(new ImageIcon("images/flower3.jpg"));
        lblImage.setBounds(12, 10, 640, 640);
        frame.getContentPane().add(lblImage);
        
        JButton btnPrev = new JButton("Prev");
        btnPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedImage image;
                    File file = new File("image");
                    image = ImageIO.read(file);
                    lblImage.setText(image.toString());
                    
                } catch (Exception e1) { 
                    e1.printStackTrace();
                }
            }
        });
        btnPrev.setFont(new Font("굴림", Font.BOLD, 15));
        btnPrev.setBounds(12, 671, 160, 61);
        frame.getContentPane().add(btnPrev);
        
        
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNext.setFont(new Font("굴림", Font.BOLD, 15));
        btnNext.setBounds(492, 671, 160, 61);
        frame.getContentPane().add(btnNext);
    }

}
