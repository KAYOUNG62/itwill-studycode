package edu.java.contact.ver06;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver06.ContactDaoImpl;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {
    @FunctionalInterface
    public interface OnContactUpdateFrameListener {
        void onContactUpdate();
    }

    private OnContactUpdateFrameListener listener;
    private Component parent;
    private ContactDaoImpl dao;
    private Integer cid;

    private JPanel contentPane;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private JTextField textCid;

    /**
     * Launch the application.
     */
    public static void newContactUpdateFrame(Component parent, OnContactUpdateFrameListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContactUpdateFrame frame = new ContactUpdateFrame(parent, listener);
                frame.setVisible(true);
            }
        });
    }

    public ContactUpdateFrame(Component parent, OnContactUpdateFrameListener listener) {
        this.listener = listener;
        this.parent = parent;
        this.dao = ContactDaoImpl.getInstance();
        initialize();
        initializeDate();

    }
    private void initializeDate() {
        Contact contact = dao.select(cid);
        if (contact != null) {
            textCid.setText(contact.getCid().toString());
            textName.setText(contact.getName());
            textPhone.setText(contact.getPhone());
            textEmail.setText(contact.getEmail());
        }
    }

    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("연락처 수정");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int x = parent.getX();
        int y = parent.getY();
        setBounds(x, y, 420, 321);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        getContentPane().setLayout(null);

        JLabel lblName = new JLabel("이름");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblName.setBounds(65, 56, 72, 34);
        getContentPane().add(lblName);

        JLabel lblphone = new JLabel("전화번호");
        lblphone.setHorizontalAlignment(SwingConstants.CENTER);
        lblphone.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblphone.setBounds(53, 100, 84, 34);
        getContentPane().add(lblphone);

        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblEmail.setBounds(65, 144, 72, 34);
        getContentPane().add(lblEmail);

        textName = new JTextField();
        textName.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        textName.setColumns(10);
        textName.setBounds(149, 56, 225, 34);
        getContentPane().add(textName);

        textPhone = new JTextField();
        textPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        textPhone.setColumns(10);
        textPhone.setBounds(149, 101, 225, 34);
        getContentPane().add(textPhone);

        textEmail = new JTextField();
        textEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        textEmail.setColumns(10);
        textEmail.setBounds(149, 144, 225, 34);
        getContentPane().add(textEmail);

        JButton btnUpdate = new JButton("저장");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateContact();
            }
        });
        btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        btnUpdate.setBounds(194, 216, 84, 34);
        getContentPane().add(btnUpdate);

        JButton btnUpdate_1 = new JButton("취소");
        btnUpdate_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnUpdate_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        btnUpdate_1.setBounds(290, 216, 84, 34);
        getContentPane().add(btnUpdate_1);
        
        textCid = new JTextField();
        textCid.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        textCid.setBounds(267, 25, 107, 21);
        contentPane.add(textCid);
        textCid.setColumns(10);

    }

    protected void updateContact() {
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();

        if (name.equals("") || phone.equals("")) {
            JOptionPane.showMessageDialog(this, "정보를 입력하세요", "ERROR", JOptionPane.ERROR_MESSAGE);
            ;
            return;
        }
        
        Contact contact = new Contact(cid, name, phone, email);
        
        int result = dao.update(contact);
        if(result == 1  ) {
            JOptionPane.showMessageDialog(this, "수정완료");
            listener.onContactUpdate();
        }
        dispose();
        
    }

}
