package edu.java.swing09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AppMain09 {

    private JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain09 window = new AppMain09();
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
    public AppMain09() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 525, 421);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        table = new JTable(); // JTable 생성
        // 테이블 데이터 - 2차원 배열
        Object[][] data = { { 1, "맥북프로", 400, "IT", 1 }, { 2, "갤럭시폴드", 200, "가전", 10 }, { 3, "박카스", 10, "식품", 100 } };

        // 테이블의 컬럼 이름
        Object[] colName = { "상품 번호", " 상품 이름", "가격", "카테고리", "재고" };
        // 테이블 데이터를 관리하는 DefaultTableModel 객체를 생성.
        DefaultTableModel model = new DefaultTableModel(data, colName);

        // 테이블에 데이터를 관리(추가, 삭제, ...)하는 TableModel을 JTable에 세팅(설정)
        table.setModel(model);
//                new DefaultTableModel(
//                new Object[][] { { "1", "\uB9E5\uBD81 \uD504\uB85C", "400", "IT", "1" },
//                        { "2", "\uAC24\uB7ED\uC2DC \uD3F4\uB4DC", "50", "\uD1B5\uC2E0\uAE30\uAE30", "10" },
//                        { "3", "\uBC15\uCE74\uC2A4", "10", "\uC2DD\uD488 ", "300" }, },
//                new String[] { "\uC0C1\uD488 \uBC88\uD638", "\uC0C1\uD488 \uC774\uB984", "\uC0C1\uD488 \uAC00\uACA9",
//                        "\uCE74\uD14C\uACE0\uB9AC", "\uC7AC\uACE0" }));

        // JTable을 JScrollPane의 viewport에 설정 > 스트롤패널 안에 테이블을 넣음.
        scrollPane.setViewportView(table);
    }

}
