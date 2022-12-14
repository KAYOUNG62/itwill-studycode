package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver04.Contact;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame { // extends(상속)

    @FunctionalInterface
    public interface ContactInsertListener {
        void contactInsertNotify (Contact c);
    }
    
    private ContactInsertListener listener;

    private JPanel contentPane;
    private Component parent;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    

    /**
     * Launch the application.
     */
    public static void newContactCreateFrame(Component parent, ContactInsertListener listener) { // try , catch 는 EventQueue 에서 오류를 잡고있기 때문에 삭제가능.
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContactCreateFrame frame = new ContactCreateFrame(parent, listener);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */

    public ContactCreateFrame(Component parent, ContactInsertListener listener) {
        this.parent = parent; // 부모 컴포넌트를 초기화.
        this.listener = listener; // contactInsertNotify() 메서드를 가지고 있는 객체를 초기화.
        initialize(); // UI 컴포넌트 생성, 초기화
    }
    
    /**
     *  initialize UI components.
     */

    private void initialize() {
        setTitle("연락처 추가"); // JFrame.setTitle이 아닌 이유 : JFrame을 상속(extends)받기 때문
        // 닫기버튼을 클릭했을때의 기본동작 설정 > DISPOSE_ON_CLOSE : 현재창만 닫기
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //JFrame이 화면에 보이게 될 좌표와 크기(가로/세로)를 설정.
        int x = parent.getX(); // 부모컴포넌트의 x 좌표
        int y = parent.getY(); // 부모컴포넌트의 y 좌표
        setBounds(x, y, 385, 290);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lblName.setBounds(43, 27, 79, 37);
        contentPane.add(lblName);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lblPhone.setBounds(43, 74, 79, 37);
        contentPane.add(lblPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lblEmail.setBounds(43, 121, 79, 37);
        contentPane.add(lblEmail);
        
        textName = new JTextField();
        textName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        textName.setBounds(134, 27, 187, 37);
        contentPane.add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        textPhone.setColumns(10);
        textPhone.setBounds(134, 74, 187, 37);
        contentPane.add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        textEmail.setColumns(10);
        textEmail.setBounds(134, 121, 187, 37);
        contentPane.add(textEmail);
        
        JButton btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewContact();
            }
        });
        btnSave.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        btnSave.setBounds(119, 176, 95, 37);
        contentPane.add(btnSave);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 창만 닫고, 부모 컴포넌트는 계속 실행
            }
        });
        btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        btnCancel.setBounds(226, 176, 95, 37);
        contentPane.add(btnCancel);
    }

    private void createNewContact() {
        // 3개의 JTextField 에 입력된 문자열을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        // Contact 객체 생성
        Contact contact = new Contact(name, phone, email);
        
        //현재 창 닫기
        dispose();
        
        // 새 연락처가 생성됐음을 (contactMain에게) 알려줌.  
        listener.contactInsertNotify(contact);
        
    }

}
