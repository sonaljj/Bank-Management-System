package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    JButton  b1, b2, b3, b4, b5, b6, b7;
    String pin;
    main_class(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1500, 800);
        add(l3);

        JLabel label = new JLabel("PLEASE SELECT THE REQUIRED OPTION");
        label.setBounds(350,150,400,22);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD, 20));
        l3.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(330, 244, 180, 28);
        b1.setFont(new Font("Arial", Font.BOLD, 18));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(0xB4CBBE));
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("CASH WITHDRAW");
        b2.setBounds(545, 244, 210, 28);
        b2.setFont(new Font("Arial", Font.BOLD, 18));
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(0xB4CBBE));
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBounds(330, 286, 180, 28);
        b3.setFont(new Font("Arial", Font.BOLD, 18));
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(0xB4CBBE));
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("BANK STATEMENT");
        b4.setBounds(545, 286, 210, 28);
        b4.setFont(new Font("Arial", Font.BOLD, 18));
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(0xB4CBBE));
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(330, 330, 180, 28);
        b5.setFont(new Font("Arial", Font.BOLD, 18));
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(0xB4CBBE));
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(545, 330, 210, 28);
        b6.setFont(new Font("Arial", Font.BOLD, 18));
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(0xB4CBBE));
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("EXIT");
        b7.setBounds(330, 370, 180, 28);
        b7.setFont(new Font("Arial", Font.BOLD, 18));
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(0xB4CBBE));
        b7.addActionListener(this);
        l3.add(b7);

        setSize(1550, 800);
        setLocation(0,0);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            new Deposit(pin);
            setVisible(false);
        } else if (e.getSource()==b2) {
            new Withdraw(pin);
            setVisible(false);

        }else if (e.getSource()==b3) {
            new FastCash(pin);
            setVisible(false);
        }else if (e.getSource()==b4) {
            new Bank(pin);
            setVisible(false);

        }else if (e.getSource()==b5) {
            new Pin(pin);
            setVisible(false);
        }else if (e.getSource()==b6) {
            new BalanceEnquiry(pin);
            setVisible(false);

        }else if (e.getSource()==b7) {
            System.exit(0);

        }

    }

    public static void main (String[] args){
        new main_class("");
    }
}
