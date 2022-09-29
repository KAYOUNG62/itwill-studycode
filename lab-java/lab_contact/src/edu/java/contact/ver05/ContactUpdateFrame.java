package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver04.Contact;
import edu.java.contact.ver04.ContactDaoImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame { // extends(상속)
    @FunctionalInterface
    public interface ContactUpdateListener {
        void contactUpdateNotify();
    }
    
    private ContactUpdateListener listener;

    private Component parent; // 업데이트 창을 실행시킨 부모 컴포넌트.
    private int index; // 수정할 연락처의 인덱스
    private ContactDaoImpl dao; //연락처 검색(read) , 업데이트(update) ...

    private JPanel contentPane;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    

    /**
     * Launch the application.
     */
    public static void newContactUpdateFrame(Component parent, int index, ContactUpdateListener listener) { // try , catch 는 EventQueue 에서 오류를 잡고있기 때문에 삭제가능.
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContactUpdateFrame frame = new ContactUpdateFrame(parent, index, listener);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */

    public ContactUpdateFrame(Component parent, int index, ContactUpdateListener listener) {
        this.parent = parent; // 부모 컴포넌트를 초기화.
        this.index = index; // 수정할 연락처의 인덱스를 멤버로 저장
        this.dao = ContactDaoImpl.getInstance(); //DAO 싱클턴 객체를 가져옴.
        this.listener = listener; // 업데이트 창을 만든 메인 창의 주소를 저장.
        
        initialize(); // UI 컴포넌트 생성, 초기화
        
        initializeContactInfo(); // 수정하려는 인덱스의 연락처 정보를 JTextField에 채움.
    }
    
    private void initializeContactInfo() {
        Contact contact = dao.read(index); // 수정하려는 연락처 정보
        
        // 각 JTextField에 연락처 정보를 씀.
        textName.setText(contact.getName());
        textPhone.setText(contact.getPhone());
        textEmail.setText(contact.getEmail());
        
    }

    /**
     *  initialize UI components.
     */

    private void initialize() {
        setTitle("연락처 수정"); // JFrame.setTitle이 아닌 이유 : JFrame을 상속(extends)받기 때문
        // 닫기버튼을 클릭했을때의 기본동작 설정 > DISPOSE_ON_CLOSE : 현재창만 닫기
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
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
        
        JButton btnSave = new JButton("수정");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContact();
                
            }
        });
        btnSave.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        btnSave.setBounds(119, 176, 95, 37);
        contentPane.add(btnSave);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        btnCancel.setBounds(226, 176, 95, 37);
        contentPane.add(btnCancel);
    }

    private void updateContact() {
        //각 JTextField에 입력된 내용을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        // Contact 타입 객체 생성
        Contact contact = new Contact(name, phone, email);
        
        //DAO의 메서드를 사용해서 연락처 정보(파일) 업데이트
        dao.update(index, contact);
        
        // 창닫기 
        dispose();
        
        //메인창(window)에게 연락처 정보 업데이트 됐다고 알림.
        listener.contactUpdateNotify();
        
        
        
        
    
        
        
    }

}
