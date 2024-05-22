package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;

    JButton c,s;
    String formno;
    Signup3(String formno){
        super("Account Details Form");
        this.formno = formno;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel l1 = new JLabel("PAGE:3");
        l1.setFont(new Font("Raleway",Font.BOLD,20));
        l1.setBounds(150,20,600,40);
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(150,70,600,30);
        add(l2);

        JLabel l3 = new JLabel("Account Type :");
        l3.setFont(new Font("Raleway",Font.BOLD,20));
        l3.setBounds(160,120,600,22);
        add(l3);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Ralway",Font.BOLD,20));
        r1.setBackground(new Color(0x4FA0D2));
        r1.setBounds(180,160,180,22);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Ralway",Font.BOLD,20));
        r2.setBackground(new Color(0x4FA0D2));
        r2.setBounds(400,160,300,22);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Ralway",Font.BOLD,20));
        r3.setBackground(new Color(0x4FA0D2));
        r3.setBounds(180,200,200,22);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Ralway",Font.BOLD,20));
        r4.setBackground(new Color(0x4FA0D2));
        r4.setBounds(400,200,300,22);
        add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        JLabel l4 = new JLabel("Card Number :");
        l4.setFont(new Font("Raleway",Font.BOLD,22));
        l4.setBounds(160,240,400,22);
        add(l4);

        JLabel l5 = new JLabel("(Your 16 digit card number)");
        l5.setFont(new Font("Raleway",Font.BOLD,10));
        l5.setBounds(160,260,600,22);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-4841");
        l6.setFont(new Font("Raleway",Font.BOLD,20));
        l6.setBounds(400,240,400,22);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on atm/cheque book and statement)");
        l7.setFont(new Font("Raleway",Font.BOLD,10));
        l7.setBounds(400,260,400,22);
        add(l7);


        JLabel l8 = new JLabel("PIN :");
        l8.setFont(new Font("Raleway",Font.BOLD,22));
        l8.setBounds(160,300,400,22);
        add(l8);


        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway",Font.BOLD,20));
        l9.setBounds(400,300,400,22);
        add(l9);

        JLabel l10 = new JLabel("(4 Digit Password)");
        l10.setFont(new Font("Raleway",Font.BOLD,10));
        l10.setBounds(160,320,400,22);
        add(l10);

        JLabel l11 = new JLabel("Services Required :");
        l11.setFont(new Font("Raleway",Font.BOLD,22));
        l11.setBounds(160,360,400,22);
        add(l11);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(new Color(0x4FA0D2));
        c1.setFont(new Font("Raleway",Font.BOLD,20));
        c1.setBounds(160,400,200,22);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(0x4FA0D2));
        c2.setFont(new Font("Raleway",Font.BOLD,20));
        c2.setBounds(400,400,200,22);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(0x4FA0D2));
        c3.setFont(new Font("Raleway",Font.BOLD,20));
        c3.setBounds(160,440,200,22);
        add(c3);

        c4 = new JCheckBox("Email Alerts");
        c4.setBackground(new Color(0x4FA0D2));
        c4.setFont(new Font("Raleway",Font.BOLD,20));
        c4.setBounds(400,440,200,22);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(0x4FA0D2));
        c5.setFont(new Font("Raleway",Font.BOLD,20));
        c5.setBounds(160,480,200,22);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(0x4FA0D2));
        c6.setFont(new Font("Raleway",Font.BOLD,20));
        c6.setBounds(400,480,200,22);
        add(c6);

        c7 = new JCheckBox("I hereby, declare all details that I have entered are correct",true);
        c7.setBackground(new Color(0x4FA0D2));
        c7.setFont(new Font("Raleway",Font.BOLD,15));
        c7.setBounds(160,520,600,22);
        add(c7);

        JLabel l12 = new JLabel("Form No :");
        l12.setFont(new Font("Ralway",Font.BOLD,20));
        l12.setBounds(650,20,100,22);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Ralway",Font.BOLD,18));
        l13.setBounds(760,20,400,22);
        add(l13);

        s = new JButton("Submit");
        s.setFont(new Font("Ralway",Font.BOLD,20));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(360,560,200,22);
        s.addActionListener(this);
        add(s);

        c = new JButton("Cancel");
        c.setFont(new Font("Ralway",Font.BOLD,20));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.setBounds(560,560,200,22);
        c.addActionListener(this);
        add(c);

        setLayout(null);
        setSize(850,650);
        setLocation(350,30);
        getContentPane().setBackground(new Color(0x4FA0D2));
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String atype = null;
        if(r1.isSelected()){
            atype="Saving Account";
        } else if (r2.isSelected()) {
            atype="Fixed Deposit Account";
        } else if (r3.isSelected()) {
            atype="Current Account";
        } else if (r4.isSelected()) {
            atype="Recurring Deposit Account";
        }
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L)+1457282000000000L;
        String cardno =  "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String fac = "";
        if(c1.isSelected()){
            fac += "ATM Card";
        } else if (c2.isSelected()) {
            fac += "Internet Banking";
        } else if (c3.isSelected()) {
            fac += "Mobile Banking";
        } else if (c4.isSelected()){
            fac+= "Email Alerts";
        } else if (c5.isSelected()) {
            fac += "Cheque Book";
        } else if (c6.isSelected()) {
            fac += "E-Statement";
        }
        try{
            if(e.getSource()==s){
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the required fields");
                }else {
                    Conn c1 = new Conn();
                    String q1 = "insert into signupthree values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+fac+"')";
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number :"+cardno+"\n Pin :"+pin);
                    new Login();
                    setVisible(false);

                }
                
            } else if (e.getSource()==c) {
                System.exit(0);
                
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        new Signup3("");
    }
}
