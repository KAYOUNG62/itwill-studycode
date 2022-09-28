package edu.java.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AppMain08 {

    private JFrame frame;
    private JTextField textField;
    private JList<String> list;

    // JList의 원소들을 관리하는 객체
    // JList에 새로운 원소 추가, 삭제, 선택된 원소에 대한 정보, ...
    private DefaultListModel<String> listModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain08 window = new AppMain08();
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
    public AppMain08() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 488, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        textField.setBounds(12, 21, 356, 69);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputBtn();
            }
        });
        btnInput.setBackground(new Color(255, 250, 240));
        btnInput.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnInput.setBounds(380, 48, 80, 42);
        frame.getContentPane().add(btnInput);

        JButton btnDelete = new JButton("삭제");
        btnDelete.setBackground(new Color(255, 218, 210));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteBtn();
            }
        });
        btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        btnDelete.setBounds(380, 112, 80, 42);
        frame.getContentPane().add(btnDelete);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 112, 356, 346);
        frame.getContentPane().add(scrollPane);

        list = new JList<>(); // JList 객체 생성 
        list.setBackground(SystemColor.text); 
        listModel = new DefaultListModel<>();// JList 원소들을 관리하는 listModel객체를 생성
        list.setModel(listModel); // JList 에 listModel을 설정.
        list.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        scrollPane.setViewportView(list);

    }

    protected void deleteBtn() {
        int index = list.getSelectedIndex();

//        if (index < 0) {
//            JOptionPane.showMessageDialog(frame, "삭제할값을 선택해주세요.", "안내", JOptionPane.WARNING_MESSAGE);
//        } else {
//
//            int result = JOptionPane.showConfirmDialog(frame, "정말 삭제할까요?", "삭제확인", JOptionPane.YES_NO_CANCEL_OPTION,
//                    JOptionPane.WARNING_MESSAGE);
//
//            if (result == JOptionPane.YES_OPTION) {
//                listModel.remove(index);
//            }
//        }
        if (index < 0) { // if (index == -1 ) 
            JOptionPane.showMessageDialog(frame, "삭제할값을 선택해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int result = JOptionPane.showConfirmDialog(frame, "삭제하시겠습니까?", "삭제확인", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            listModel.remove(index);
        }

    }

    protected void inputBtn() {
        //JTextField에 입력된 내용을 읽고 새로운 원소로 추가
        
        String textInput = textField.getText();

    
        if (textInput.equals("")) {
            JOptionPane.showMessageDialog(frame, "입력된값이 없습니다.", "안내", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int result = JOptionPane.showConfirmDialog(frame, "저장하시겠습니까?", "확인", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            listModel.addElement(textInput);
        }

//        listModel.addElement(textInput);
//        JOptionPane.showMessageDialog(frame, "저장하시겠습니까?", "확인", JOptionPane.QUESTION_MESSAGE);

        textField.setText("");

    }
}
