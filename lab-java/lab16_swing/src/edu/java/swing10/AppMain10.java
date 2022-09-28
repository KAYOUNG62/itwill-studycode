package edu.java.swing10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain10 {
    private static final String[] COLNAME = { "국어", "영어", "수학", "총점", "평균" };

    private JFrame frame;
    private JTable table;
    private JLabel lblKR;
    private JLabel lblEng;
    private JLabel lblMath;
    private DefaultTableModel model;
    private JTextField textKR;
    private JTextField textEng;
    private JTextField textMath;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain10 window = new AppMain10();
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
    public AppMain10() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 448, 478);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblKR = new JLabel("국어");
        lblKR.setHorizontalAlignment(SwingConstants.CENTER);
        lblKR.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblKR.setBounds(27, 25, 91, 48);
        frame.getContentPane().add(lblKR);

        lblEng = new JLabel("영어");
        lblEng.setHorizontalAlignment(SwingConstants.CENTER);
        lblEng.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblEng.setBounds(27, 83, 91, 48);
        frame.getContentPane().add(lblEng);

        lblMath = new JLabel("수학");
        lblMath.setHorizontalAlignment(SwingConstants.CENTER);
        lblMath.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblMath.setBounds(27, 141, 91, 48);
        frame.getContentPane().add(lblMath);

        textKR = new JTextField();
        textKR.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        textKR.setBounds(130, 25, 176, 48);
        frame.getContentPane().add(textKR);
        textKR.setColumns(10);

        textEng = new JTextField();
        textEng.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        textEng.setColumns(10);
        textEng.setBounds(130, 83, 176, 48);
        frame.getContentPane().add(textEng);

        textMath = new JTextField();
        textMath.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        textMath.setColumns(10);
        textMath.setBounds(130, 141, 176, 48);
        frame.getContentPane().add(textMath);

        JButton btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputScore();
            }
        });
        btnInput.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        btnInput.setBounds(27, 210, 91, 33);
        frame.getContentPane().add(btnInput);

        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRow();
            }
        });
        btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        btnDelete.setBounds(130, 210, 91, 33);
        frame.getContentPane().add(btnDelete);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 263, 408, 153);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));

        model = new DefaultTableModel(null, COLNAME); // 컬럼 이름만 갖는 테이블 모델 생성

        table.setModel(model); // 테이블 모델을 테이블에 세팅.

        scrollPane.setViewportView(table);
    }

    private void deleteRow() {
        // 테이블에서 삭제하기위해서 선택된 행(row) 인덱스를 찾음.
        int index = table.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(frame, "삭제할 데이터를 선택하세요.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 행 인덱스를 사용해서 테이블 모델에서 행을 삭제.
        int confirm = JOptionPane.showConfirmDialog(frame, (index + 1) + "번째 행을 정말 삭제하시겠습니까?", "확인",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            model.removeRow(index);
        }

    }

    private void inputScore() {

        // 3개의 JTextField 에서 읽은 문자열을 정수(int)로 변환
        int korean = 0;
        int english = 0;
        int math = 0;

        try {
            korean = Integer.parseInt(textKR.getText());
            english = Integer.parseInt(textEng.getText());
            math = Integer.parseInt(textMath.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "숫자를 입력하세요", "error", JOptionPane.ERROR_MESSAGE);
            return;
        } finally {
            clearAllTextFields();
        }
        // 입력값들을 사용해서 Score 객체 생성
        Score score = new Score(korean, english, math);

        // 테이블의 행(row)에 추가할 데이터를 1차원 배열로 만듦.
        Object[] rowData = { score.getKorean(), score.getEnglish(), score.getMath(), score.sum(), score.average() };

        // row 데이터를 모델에 추가
        model.addRow(rowData);

    }

    private void clearAllTextFields() {
        textKR.setText("");
        textEng.setText("");
        textMath.setText("");

    }
}
