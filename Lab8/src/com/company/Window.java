package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    public Window()
    {

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Task 1", new ImageIcon(""), new Task1(), "Lists");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        tabbedPane.addTab("Task 3", new ImageIcon(""), new Task3(), "RadioButtons");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        add(tabbedPane);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

    class Task1 extends JPanel {
        public Task1() {
            setLayout(new BorderLayout());
            JPanel central = new JPanel();
            central.setLayout(new BorderLayout());
            JButton right = new JButton(new ImageIcon("right.png"));
            central.add(right, BorderLayout.NORTH);
            JButton left = new JButton(new ImageIcon("left.png"));
            central.add(left, BorderLayout.SOUTH);
            add(central, BorderLayout.CENTER);

            final String[] DATA1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            final String[] DATA2 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

            DefaultListModel leftlistModel = new DefaultListModel();
            JList leftlist = new JList(leftlistModel);
            leftlist.setFont(new Font(getFont().getFontName(), Font.ROMAN_BASELINE, 30));
            DefaultListModel rightlistModel = new DefaultListModel();
            JList rightlist = new JList(rightlistModel);
            rightlist.setFont(new Font(getFont().getFontName(), Font.BOLD, 30));

            for (String el : DATA1)
                leftlistModel.addElement(el);

            for (String el : DATA2)
                rightlistModel.addElement(el);

            add(leftlist, BorderLayout.WEST);
            add(new JScrollPane(leftlist, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.WEST);
            add(rightlist, BorderLayout.EAST);
            add(new JScrollPane(rightlist, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.EAST);
            right.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!leftlist.isSelectionEmpty()) {
                        rightlistModel.addElement(leftlist.getSelectedValue());
                        leftlistModel.remove(leftlist.getSelectedIndex());
                        if (!leftlistModel.isEmpty())
                            leftlist.setSelectedIndex(0);
                    }
                }
            });
            left.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!rightlist.isSelectionEmpty()) {
                        leftlistModel.addElement(rightlist.getSelectedValue());
                        rightlistModel.remove(rightlist.getSelectedIndex());
                        if (!rightlistModel.isEmpty())
                            rightlist.setSelectedIndex(0);
                    }
                }
            });
            pack();

        }
    }

    class Task3 extends JPanel {
        public Task3() {
            Box box = new Box(1);
            ButtonGroup radioGroup = new ButtonGroup();
            final ImageIcon[] icons = new ImageIcon[]{
                    new ImageIcon("fpm1.png"),
                    new ImageIcon("fpm2.png"),
                    new ImageIcon("fpm3.png"),
                    new ImageIcon("1.png"),
            };

            for (int i = 0; i < 4; i++) {
                JRadioButton temp = new JRadioButton(icons[0]);
                temp.setPressedIcon(icons[1]);
                temp.setSelectedIcon(icons[2]);
                temp.setRolloverIcon(icons[3]);
                radioGroup.add(temp);
                box.add(temp);
            }
            add(box);
        }
    }
}
