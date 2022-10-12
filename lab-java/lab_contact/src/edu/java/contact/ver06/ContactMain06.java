package edu.java.contact.ver06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.ver06.ContactCreateFrame.OnContactCreateListener;
import edu.java.contact.ver06.ContactUpdateFrame.OnContactUpdateFrameListener;

import static edu.java.contact.ver06.Contact.Entity.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactMain06 implements OnContactCreateListener, OnContactUpdateFrameListener {
    private static final String[] COLUMN_NAME = { COL_CID, COL_NAME, COL_PHONE };

    private DefaultTableModel model;
    private ContactDaoImpl dao;

    private JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactMain06 window = new ContactMain06();
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
    public ContactMain06() {
        initialize();
        dao = ContactDaoImpl.getInstance();
        initializeTable();
    }

    private void initializeTable() {
        model = new DefaultTableModel(null, COLUMN_NAME);
        table.setModel(model);

        List<Contact> list = dao.read();

        for (Contact c : list) {
            Object[] row = { c.getCid(), c.getName(), c.getPhone() };
            model.addRow(row);
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 490, 460);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JButton btnCreate = new JButton("연락처 등록");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactCreateFrame.newContactCreateFrame(frame, ContactMain06.this);
            }
        });
        btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        panel.add(btnCreate);

        JButton btnUpdate = new JButton("연락처 수정");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactUpdateFrame.newContactUpdateFrame(frame, ContactMain06.this);
            }
        });
        btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        panel.add(btnUpdate);

        JButton btnDelete = new JButton("연락처 삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });
        btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        panel.add(btnDelete);

        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);
    }

    protected void deleteContact() {
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(frame, "삭제할 연락처를 선택하세요", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer contactNo = (Integer) model.getValueAt(row, 0);

        int confirm = JOptionPane.showConfirmDialog(frame, "정말 삭제하시겠습니까", "안내", JOptionPane.WARNING_MESSAGE,
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            int result = dao.delete(contactNo);
            if (result == 1) {
                JOptionPane.showConfirmDialog(frame, "삭제완료");
                initializeTable();
            }
        }

    }

    @Override
    public void onContactCreate() {
        initializeTable();
    }

    @Override
    public void onContactUpdate() {
        initializeTable();

    }

}
