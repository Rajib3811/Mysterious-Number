package randomg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.*;

public class RandomGame extends JFrame implements ActionListener {

    JTextField guest;
    JButton b1, guesb, plagb, clmb;
    JLabel wl, ins, rule, guesl, chancel, lsl;
    static String  rules, inst = "***** INSTRUCTION *****", large = "Your number is  large", small = "Your number is  small";

    int start = 1, end = 100, attempt = 0, GuessNumber, rest = 10;
    static String username = "";
    int RNumber = 0;
    File fl = new File("MaxNo.txt"), fl1 = new File("Leaderboard.txt");
    File kgndr = new File("KQGender.txt");
    File gndr = new File("Gender.txt");
    static int brek = 1;

    static String king_name = "", curGender = "", KQgen = "", gender = "", tit = "", OldGender = "", OldTit = "";
    static int rec = 0;
    int count = 0;

    JLabel cl;
    JLabel sr, wlbl, akl, cngl, kl, fcngl, atmpl, pkl, matmptl;

    RandomGame() {

        RNumber = (int) ((Math.random() * 100) + 1);
        if (RNumber > 100) {
            RNumber--;
        }
        System.out.println(RNumber);

        b1 = new JButton("Start Game");
        b1.setBounds(300, 250, 200, 50);
        b1.addActionListener(this);
        add(b1);

        //welcome Label : 
        wl = new JLabel();
        wl.setBounds(120, 5, 650, 50);
        wl.setForeground(Color.magenta);
        wl.setFont(new Font("Tahoma", Font.BOLD, 25));
        wl.setVisible(false);
        add(wl);

        //Instruction
        ins = new JLabel();
        ins.setBounds(320, 60, 260, 30);
        ins.setFont(new Font("Bodoni MT Black", Font.PLAIN, 15));
        ins.setVisible(false);
        add(ins);

        rules = "Rules is : Sysytem took a number, just you have to guess the number and you will have 10 chance to reach the system number.";
        rule = new JLabel(rules);
        rule.setBounds(30, 90, 750, 30);
        rule.setVisible(false);
        add(rule);

        lsl = new JLabel();
        lsl.setBounds(335, 128, 150, 30);
        lsl.setVisible(false);
        add(lsl);

        guesl = new JLabel();
        guesl.setBounds(30, 160, 280, 30);
        guesl.setVisible(false);
        add(guesl);

        guest = new JTextField();
        guest.setBounds(305, 160, 200, 30);
        guest.setVisible(false);
        add(guest);

        guesb = new JButton("Submit");
        guesb.setBounds(510, 160, 90, 30);
        guesb.setVisible(false);
        guesb.addActionListener(this);
        add(guesb);

        chancel = new JLabel();
        chancel.setBounds(300, 195, 250, 30);
        chancel.setVisible(false);
        add(chancel);

        cl = new JLabel();
        cl.setBounds(310, 195, 250, 30);
        add(cl);
        cl.setVisible(false);

        sr = new JLabel();
        sr.setBounds(310, 210, 250, 30);
        add(sr);
        sr.setVisible(false);

        wlbl = new JLabel();
        wlbl.setBounds(30, 240, 670, 30);
        add(wlbl);
        wlbl.setVisible(false);

        akl = new JLabel();
        akl.setBounds(30, 260, 400, 30);
        add(akl);
        akl.setVisible(false);

        cngl = new JLabel();
        cngl.setBounds(30, 240, 700, 30);
        add(cngl);
        cngl.setVisible(false);

        kl = new JLabel();
        kl.setBounds(30, 260, 400, 30);
        add(kl);
        kl.setVisible(false);

        fcngl = new JLabel();
        fcngl.setBounds(30, 240, 750, 30);
        add(fcngl);
        fcngl.setVisible(false);

        atmpl = new JLabel();
        atmpl.setBounds(350, 280, 400, 30);
        add(atmpl);
        atmpl.setVisible(false);

        pkl = new JLabel();
        pkl.setBounds(310, 370, 500, 30);
        add(pkl);
        pkl.setVisible(false);

        matmptl = new JLabel();
        matmptl.setBounds(200, 240, 500, 30);
        add(matmptl);
        matmptl.setVisible(false);

        plagb = new JButton("Replay");
        plagb.setBounds(240, 450, 300, 35);
        plagb.addActionListener(this);
        plagb.setVisible(false);
        add(plagb);

        clmb = new JButton("Reset");
        clmb.setBounds(560, 450, 150, 35);
        clmb.addActionListener(this);
        clmb.setVisible(false);
        add(clmb);

        //Frame 
        setBounds(350, 10, 800, 600);
        setLayout(null);
        setVisible(true);

        getContentPane().setBackground(Color.yellow);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            b1.setVisible(false);
            username = FirstPage.un();
            try {
                //Gender File
                Scanner sc = new Scanner(gndr);
                curGender = sc.nextLine();
            } catch (Exception e) {
            }

            if (curGender.equals("Male")) {
                wl.setText("Welcome to this game Mr. " + username);
            }
            if (curGender.equals("Female")) {
                wl.setText("Welcome to this game Mrs. " + username);
            }
            wl.setVisible(true);

            try {

                if (!fl1.exists()) {
                    fl1.createNewFile();
                    FileWriter fwrn = new FileWriter("Leaderboard.txt");
                    fwrn.write(username);
                    fwrn.close();
                    brek = 0;
                } else if (fl1.exists() && brek == 0) {
                    FileWriter fwrn = new FileWriter("Leaderboard.txt");
                    fwrn.write(username);
                    fwrn.close();
                    brek = 0;
                }

                if (!fl.exists()) {
                    fl.createNewFile();
                    FileWriter fwrr = new FileWriter("MaxNo.txt");
                    fwrr.write("10");
                    fwrr.close();
                    brek = 0;
                } else if (fl.exists() && brek == 0) {
                    FileWriter fwrr = new FileWriter("MaxNo.txt");
                    fwrr.write("10");
                    fwrr.close();
                    brek = 0;
                }

                if (!kgndr.exists()) {
                    kgndr.createNewFile();
                    FileWriter fwrr = new FileWriter("KQGender.txt");
                    fwrr.write(curGender);
                    fwrr.close();
                    brek = 0;
                } else if (kgndr.exists() && brek == 0) {
                    FileWriter fwrr = new FileWriter("KQGender.txt");
                    fwrr.write(curGender);
                    fwrr.close();
                    brek = 0;
                }

            } catch (Exception ob) {
            }

            ins.setText(inst);
            ins.setVisible(true);
            rule.setVisible(true);
            plagb.setVisible(true);
            clmb.setVisible(true);

        }

        try {

            //Name File
            Scanner in1 = new Scanner(fl1);
            king_name = in1.nextLine();

            //King's Gender
            Scanner kgn = new Scanner(kgndr);
            KQgen = kgn.nextLine();

            // Record File
            Scanner in = new Scanner(fl);
            rec = Integer.parseInt(in.nextLine());

        } catch (Exception ob) {
        }

        guesl.setVisible(true);
        guest.setVisible(true);
        guesb.setVisible(true);
        chancel.setVisible(true);

        guesl.setText("Guess The Number ( " + start + " to " + end + " ) range : ");
        chancel.setText("You have " + rest + " Chance to reach the number ");

        if (ae.getSource() == guesb) {

            try {
                GuessNumber = Integer.parseInt(guest.getText());
                attempt++;
                guest.setText("");
            } catch (Exception e) {
            }

            //set King / Qeen and Mr. / Mrs.  : 
            if (curGender.equals("Male")) {
                tit = "Mr.";
                gender = "KING";
            } else {
                gender = "QEEN";
                tit = "Mrs.";
            }

            //Storing from database : 
            if (KQgen.equals("Male")) {
                OldTit = "Mr.";
                OldGender = "KING";
            } else {
                OldTit = "Mrs.";
                OldGender = "QEEN";
            }

            if (attempt <= 10) {

                rest = 10 - attempt;

                if (GuessNumber == RNumber) {

                    chancel.setVisible(false);

                    cl.setText("WOOHOO..CORRECT NUMBER!!!");
                    cl.setVisible(true);

                    sr.setText("The system generated number is : " + RNumber);
                    sr.setVisible(true);

                    if (rec > attempt) {

                        if (username.equals(king_name) && brek == 1) {

                            wlbl.setText("Welcome back " + tit + " " + gender + " " + username + " You have cracked your previous record"
                                    + " and your previous"
                                    + " attempt(s) was : " + rec);

                            akl.setText("AGAIN YOU ARE THE " + gender + " WITH NEW RECORD !!!");
                            wlbl.setVisible(true);
                            akl.setVisible(true);

                            //Insert new King's Data  in the file : 
                            //Inserting attempt :                     
                            String record = String.valueOf(attempt);
                            try {
                                FileWriter filewriter_attempt = new FileWriter("MaxNo.txt");
                                filewriter_attempt.write(record);
                                filewriter_attempt.close();
                            } catch (Exception e) {
                            }

                        } else {
                            if (brek == 1) {

                                cngl.setText("Congratulatin!!! " + tit + " " + username + " You have made a new record,"
                                        + " before you the " + gender + " was : " + king_name + ", "
                                        + " and attempt(s) was : " + rec);
                                cngl.setVisible(true);

                                kl.setText("NOW YOU ARE THE " + gender + " !!!");
                                kl.setVisible(true);

                            } else {

                                fcngl.setText("Congratulatin!!! " + tit + " " + username + " You are the first person "
                                        + "who played this game, Your data has been recorded as " + gender + "'s data.");
                                fcngl.setVisible(true);

                                kl.setText("NOW YOU ARE THE " + gender + " !!!");
                                kl.setVisible(true);
                                brek = 1;

                            }

                            //Insert new King's Data  in the file : 
                            //Inserting attempt :                     
                            String record = String.valueOf(attempt);

                            try {
                                FileWriter filewriter_attempt = new FileWriter("MaxNo.txt");
                                filewriter_attempt.write(record);
                                filewriter_attempt.close();

                                //Inserting new king name : 
                                FileWriter filewriter_name = new FileWriter("LeaderBoard.txt");
                                filewriter_name.write(username);
                                filewriter_name.close();

                                //Inserting gender : 
                                FileWriter filewriter_gender = new FileWriter("KQGender.txt");
                                filewriter_gender.write(curGender);
                                filewriter_gender.close();

                            } catch (Exception e) {
                            }
                        }

                        count = 1;
                    }

                    atmpl.setText("You did it in " + (attempt) + " attempt(s).");
                    atmpl.setVisible(true);

                    if (count == 0) {
                        pkl.setText("The " + OldGender + " is : " + OldTit + " " + king_name + ", and attempt(s) is : " + rec);
                        pkl.setVisible(true);
                    }

                    guesl.setVisible(false);
                    guest.setVisible(false);
                    guesb.setVisible(false);
                    lsl.setVisible(false);

                } else if (GuessNumber > RNumber) {
                    if (GuessNumber <= end) {
                        end = GuessNumber - 1;
                    }

                    lsl.setText("Your number is  large");
                    lsl.setVisible(true);

                } else {
                    if (GuessNumber >= start) {
                        start = GuessNumber + 1;
                    }

                    lsl.setText("Your number is  small");
                    lsl.setVisible(true);
                }

                guesl.setText("Guess The Number ( " + start + " to " + end + " ) range : ");
                chancel.setText("You have " + rest + " Chance to reach the number ");

            } else {

                guesl.setVisible(false);
                guest.setVisible(false);
                guesb.setVisible(false);
                chancel.setVisible(false);
                lsl.setVisible(false);

                matmptl.setText("Sorry!!! you have tried maximum attempts.\nBetter luck next time.");
                matmptl.setVisible(true);
            }

        }
        if (ae.getSource() == plagb) {

            this.setVisible(false);
            new FirstPage();
        }

        if (ae.getSource() == clmb) {

            FirstPage.pc = 0;

            try {
                FileWriter filewriter_attempt = new FileWriter("MaxNo.txt");
                filewriter_attempt.write("");
                filewriter_attempt.close();

                FileWriter filewriter_name = new FileWriter("LeaderBoard.txt");
                filewriter_name.write("");
                filewriter_name.close();

                FileWriter filewriter_gender = new FileWriter("KQGender.txt");
                filewriter_gender.write("");
                filewriter_gender.close();

                brek = 0;

            } catch (Exception e) {
            }
            this.setVisible(false);
            new FirstPage();

        }

    }

}
