package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    String pin;
    TextField text;
    JButton b1, b2;
    Withdraw(String pin){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1400, 700);
        add(l3);

        JLabel label1 = new JLabel("ENTER THE AMOUNT YOU WANT TO WITHDRAW");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("SYSTEM", Font.BOLD, 16));
        label1.setBounds(380, 140, 500, 18);
        l3.add(label1);

        JLabel label2 = new JLabel("MAXIMUM WITHDRAWL IS 50,000");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("SYSTEM", Font.BOLD, 10));
        label2.setBounds(400, 220, 500, 16);
        l3.add(label2);

        text = new TextField();
        text.setBounds(400, 180, 350, 32);
        text.setFont(new Font("Vintage", Font.BOLD, 18));
        l3.add(text);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(580, 310, 180, 25);
        b1.setFont(new Font("Arial", Font.BOLD, 18));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(0xB4CBBE));
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(580, 350, 180, 25);
        b2.setFont(new Font("Arial", Font.BOLD, 18));
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(0xB4CBBE));
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550, 800);
        setLocation(0, 0);
        setVisible(true);

    }@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
        try{
            String amount = text.getText();
            Date date = new Date();
            int balance = 0;
            if (amount.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill the withdrawl Amount");
            } else {

                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                while(resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));

                    }else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                if (balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdraw','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
                setVisible(false);
                new main_class(pin);

            }

        }catch (Exception E){
            E.printStackTrace();

        }}else if(e.getSource()==b2){
            setVisible(false);
            new main_class(pin);
        }

    }
    public static void main(String[] args){
        new Withdraw("");

    }
}
