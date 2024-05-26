package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField text;
    JButton b1, b2;
    Deposit(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1400, 700);
        add(l3);

        JLabel label1 = new JLabel("ENTER THE AMOUNT THAT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("SYSTEM", Font.BOLD, 16));
        label1.setBounds(365, 140, 500, 18);
        l3.add(label1);

        text = new TextField();
        text.setBounds(400, 180, 350, 30);
        text.setFont(new Font("Vintage", Font.BOLD, 18));
        l3.add(text);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(650, 310, 120, 30);
        b1.setFont(new Font("Arial", Font.BOLD, 18));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(0xB4CBBE));
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(650, 350, 120, 30);
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
        try{
            String amount = text.getText();
            Date date = new Date();
            if (e.getSource()==b1){
                if(amount.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter the amount to deposit");
                }else{
                    Conn c = new Conn();
                    c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new main_class(pin);
                }

            } else if (e.getSource()==b2) {
                setVisible(false);
                new main_class(pin);
                
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }
    public static void main(String[] args){
        new Deposit("");
    }


}

