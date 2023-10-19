package randomg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import javax.swing.*;

public class FirstPage extends JFrame implements ActionListener {

    JLabel l, s, sl;
    JTextField name;
    JButton submit, prevUser;
    JRadioButton male, female;
    static String username = "";
    File fl = new File("Gender.txt");

    static int pc = 0;

    FirstPage() {

        l = new JLabel("Enter your name : ");
        l.setBounds(30, 145, 105, 30);
        add(l);

        name = new JTextField();
        name.setBounds(140, 145, 200, 30);
        add(name);

        prevUser = new JButton("Previous User");
        prevUser.setBounds(350, 145, 120, 30);
        prevUser.addActionListener(this);
        add(prevUser);
        prevUser.setVisible(false);

        if (pc == 1) {
            prevUser.setVisible(true);
        }

        s = new JLabel("Select your gender : ");
        s.setBounds(30, 200, 150, 30);
        add(s);

        male = new JRadioButton("Male");
        male.setBounds(155, 190, 100, 50);
        male.setBackground(Color.cyan);

        female = new JRadioButton("Female");
        female.setBounds(270, 190, 100, 50);
        female.setBackground(Color.cyan);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        add(female);
        add(male);

        submit = new JButton("Submit");
        submit.setBounds(190, 350, 150, 35);
        submit.addActionListener(this);
        add(submit);

        sl = new JLabel("Guess Game Welcomes You !!!");
        sl.setBounds(50, 75, 500, 30);
        sl.setForeground(Color.magenta);
        sl.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(sl);

        setBounds(450, 10, 550, 500);
        setLayout(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.cyan);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == prevUser) {

            new RandomGame();
            this.setVisible(false);
        }

        if (e.getSource() == submit) {

            username = name.getText();

            if (male.isSelected()) {
                try {
                    if (!fl.exists()) {
                        fl.createNewFile();
                    }
                    FileWriter fwrn = new FileWriter("Gender.txt");
                    fwrn.write("Male");
                    fwrn.close();

                } catch (Exception ee) {
                }
            }

            if (female.isSelected()) {
                try {
                    if (!fl.exists()) {
                        fl.createNewFile();
                    }
                    FileWriter fwrn = new FileWriter("Gender.txt");
                    fwrn.write("Female");
                    fwrn.close();
                } catch (Exception ee) {
                }
            }

            pc = 1;

            new RandomGame();
            this.setVisible(false);

        }
    }

    public static String un() {
        return username;
    }

    public static void main(String[] args) {
        new FirstPage();
    }

}
