package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
// To Know Total Balance
public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel label2;
    JButton b1;
    String pin;
    BalanceEnquiry(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1400, 700);
        add(l3);

        JLabel label1 = new JLabel("Your Current Balance is Rs. ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("SYSTEM", Font.BOLD, 16));
        label1.setBounds(380, 140, 500, 18);
        l3.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("SYSTEM", Font.BOLD, 10));
        label2.setBounds(400, 160, 500, 16);
        l3.add(label2);

        b1 = new JButton("BACK");
        b1.setBackground(new Color(0xB4CBBE));
        b1.setFont(new Font("Arial", Font.BOLD, 18));
        b1.setBounds(440,250,200,18);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        int balance = 0;
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            while(resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));

                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        label2.setText(""+balance);



        setLayout(null);
        setUndecorated(true);
        setSize(1550, 800);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_class(pin);

    }

    public static void main(String[] args){
        new BalanceEnquiry("");
    }
}
