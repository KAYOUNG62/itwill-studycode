package edu.java.contact.ver06;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {
    @FunctionalInterface
    public interface OnContactCreateListener {
        void onContactCreate();
    }

    private OnContactCreateListener listener;
    private ContactDaoImpl dao;
    private Component parent;
    private JPanel contentPane;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;

    /**
     * Launch the application.
     */
    public static void newContactCreateFrame(Component parent, OnContactCreateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContactCreateFrame frame = new ContactCreateFrame(parent, listener);
                frame.setVisible(true);
            }
        });
    }

    public ContactCreateFrame(Component parent, OnContactCreateListener listener) {
        this.listener = listener;
        this.parent = parent;
        this.dao = ContactDaoImpl.getInstance();
        initialize();
    }

    /**
     * Create the frame.
     */
    public void initialize() {
        setTitle("연락처 추가");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int x = parent.getX();
        int y = parent.getY();
        setBounds(x, y, 420, 321);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("이름");
        lblName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setBounds(48, 46, 71, 37);
        contentPane.add(lblName);

        textName = new JTextField();
        textName.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        textName.setBounds(131, 46, 227, 37);
        contentPane.add(textName);
        textName.setColumns(10);

        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblPhone.setBounds(37, 93, 82, 37);
        contentPane.add(lblPhone);

        textPhone = new JTextField();
        textPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        textPhone.setColumns(10);
        textPhone.setBounds(131, 93, 227, 37);
        contentPane.add(textPhone);

        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblEmail.setBounds(48, 140, 71, 37);
        contentPane.add(lblEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        textEmail.setColumns(10);
        textEmail.setBounds(131, 140, 227, 37);
        contentPane.add(textEmail);

        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        btnCancel.setBounds(264, 210, 94, 33);
        contentPane.add(btnCancel);

        JButton btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createContact();
            }
        });
        btnSave.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        btnSave.setBounds(158, 210, 94, 33);
        contentPane.add(btnSave);
    }

    private void createContact() {
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();

        if (name.equals("") || phone.equals("") ) {
            JOptionPane.showMessageDialog(this, "정보를 입력하세요", "ERROR", JOptionPane.ERROR_MESSAGE);
            ;
            return;
        }

        Contact contact = new Contact(null, name, phone, email);
        int result = dao.create(contact);
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "저장완료");
            dispose();
            listener.onContactCreate();
        }

    }
}
