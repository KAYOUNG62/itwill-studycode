package edu.java.swing07;

import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

public class AppMain07 {

    private JFrame frame;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rbPrivate;
    private JRadioButton rbPackage;
    private JRadioButton rbProtected;
    private JRadioButton rbPublic;
    private JCheckBox cbAbstract;
    private JCheckBox cbFinal;
    private JCheckBox cbStatic;
    private JComboBox<String> comboBox;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain07 window = new AppMain07();
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
    public AppMain07() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 445, 454);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        rbPrivate = new JRadioButton("private");
        rbPrivate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPrivate);
        rbPrivate.setFont(new Font("?????? ??????", Font.BOLD, 15));
        rbPrivate.setBounds(21, 28, 94, 55);
        frame.getContentPane().add(rbPrivate);

        rbPackage = new JRadioButton("package");
        rbPackage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPackage);
        rbPackage.setFont(new Font("?????? ??????", Font.BOLD, 15));
        rbPackage.setBounds(119, 28, 94, 55);
        frame.getContentPane().add(rbPackage);

        rbProtected = new JRadioButton("protected");
        rbProtected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbProtected);
        rbProtected.setFont(new Font("?????? ??????", Font.BOLD, 15));
        rbProtected.setBounds(217, 28, 94, 55);
        frame.getContentPane().add(rbProtected);

        rbPublic = new JRadioButton("public");
        rbPublic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPublic);
        rbPublic.setFont(new Font("?????? ??????", Font.BOLD, 15));
        rbPublic.setBounds(315, 28, 94, 55);
        frame.getContentPane().add(rbPublic);

        cbAbstract = new JCheckBox("abstract");
        cbAbstract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printCheckBoxStatus(e);
            }
        });
        cbAbstract.setFont(new Font("?????? ??????", Font.BOLD, 15));
        cbAbstract.setBounds(21, 85, 83, 23);
        frame.getContentPane().add(cbAbstract);

        cbFinal = new JCheckBox("final");
        cbFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printCheckBoxStatus(e);
            }
        });
        cbFinal.setFont(new Font("?????? ??????", Font.BOLD, 15));
        cbFinal.setBounds(119, 85, 68, 23);
        frame.getContentPane().add(cbFinal);

        cbStatic = new JCheckBox("static");
        cbStatic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printCheckBoxStatus(e);
            }
        });
        cbStatic.setFont(new Font("?????? ??????", Font.BOLD, 15));
        cbStatic.setBounds(217, 85, 68, 23);
        frame.getContentPane().add(cbStatic);

        comboBox = new JComboBox<>();
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                textArea.setText(selected + "??????");
            }
        });
        comboBox.setFont(new Font("?????? ??????", Font.BOLD, 15));
        final String[] items = { "naver.com", "gmail.com", "hanmail.net", "kakao.ocm" };
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
        comboBox.setModel(model);
        comboBox.setBounds(21, 122, 388, 27);
        frame.getContentPane().add(comboBox);

        JButton btnShowInfo = new JButton("??????");
        btnShowInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printInfo();
            }
        });
        btnShowInfo.setFont(new Font("?????? ??????", Font.BOLD, 15));
        btnShowInfo.setBounds(21, 159, 126, 29);
        frame.getContentPane().add(btnShowInfo);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(22, 198, 387, 173);
        frame.getContentPane().add(scrollPane);

        textArea = new JTextArea();
        textArea.setFont(new Font("?????? ??????", Font.BOLD, 14));
        scrollPane.setViewportView(textArea);
    }

    protected void printInfo() {
        StringBuilder buffer = new StringBuilder(); // textArea??? ????????? ???????????? ????????? ?????? ??????
        // ????????? ????????? ????????? ?????? ????????? ???????????????
        if (rbPrivate.isSelected()) {
            buffer.append(rbPrivate.getText());
        } else if (rbPackage.isSelected()) {
            buffer.append(rbPackage.getText());
        } else if (rbProtected.isSelected()) {
            buffer.append(rbProtected.getText());
        } else if (rbPublic.isSelected()) {
            buffer.append(rbPublic.getText());
        }
        buffer.append("????????? ?????? ??????\n");

        // ??????????????? ????????? ?????? ????????? ???????????????
        if (cbAbstract.isSelected()) {
            buffer.append(cbAbstract.getText()).append(" ");;
        }
        if (cbFinal.isSelected()) {
            buffer.append(cbFinal.getText()).append(" ");
        }
        if (cbStatic.isSelected()) {
            buffer.append(cbStatic.getText()).append(" ");;
        }
        buffer.append("???????????? ??????\n");
        
        // ??????????????? ???????????? ????????? ?????? ???????????? ???????????????
        String item = (String)comboBox.getSelectedItem();
        buffer.append(item).append(" ???????????? ????????? ??????\n");
        
        // ????????? ????????? ??????
        textArea.setText(buffer.toString());

    }

    protected void printCheckBoxStatus(ActionEvent e) {
        JCheckBox checkBoxButton = (JCheckBox) e.getSource(); // ???????????? ????????? ????????????
                                                              // getSource ??? Object ???????????? ????????? JCheckBox??? ???????????? ????????????.
        String checkBoxText = checkBoxButton.getText(); // ??????????????? ?????????
        boolean selected = checkBoxButton.isSelected(); // ???????????? ??????
        textArea.setText(checkBoxText + " : " + selected);
    }

    private void printRadioButtonStatus(ActionEvent e) {
        JRadioButton radioButton = (JRadioButton) e.getSource(); // ???????????? ????????? ????????? ??????
        String btnText = radioButton.getText(); // ????????? ????????? ?????????
        boolean selected = radioButton.isSelected(); // ????????? ??????/ ?????? ??????
        textArea.setText(btnText + " : " + selected);
    }

}
