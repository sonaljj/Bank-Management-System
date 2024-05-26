package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton  b1, b2, b3, b4, b5, b6, b7;
    String pin;
    FastCash(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1500, 800);
        add(l3);

        JLabel label = new JLabel("SELECT THE WITHDRAWL AMOUNT");
        label.setBounds(350,150,400,22);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD, 20));
        l3.add(label);

        b1 = new JButton("Rs. 1000");
        b1.setBounds(330, 244, 180, 28);
        b1.setFont(new Font("Arial", Font.BOLD, 18));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(0xB4CBBE));
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("Rs. 10,000");
        b2.setBounds(580, 244, 180, 28);
        b2.setFont(new Font("Arial", Font.BOLD, 18));
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(0xB4CBBE));
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("Rs. 20,000");
        b3.setBounds(330, 286, 180, 28);
        b3.setFont(new Font("Arial", Font.BOLD, 18));
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(0xB4CBBE));
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("Rs. 30,000");
        b4.setBounds(580, 286, 180, 28);
        b4.setFont(new Font("Arial", Font.BOLD, 18));
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(0xB4CBBE));
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("Rs. 40,000");
        b5.setBounds(330, 330, 180, 28);
        b5.setFont(new Font("Arial", Font.BOLD, 18));
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(0xB4CBBE));
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("Rs. 50,000");
        b6.setBounds(580, 330, 180, 28);
        b6.setFont(new Font("Arial", Font.BOLD, 18));
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(0xB4CBBE));
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("BACK");
        b7.setBounds(330, 370, 180, 28);
        b7.setFont(new Font("Arial", Font.BOLD, 18));
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(0xB4CBBE));
        b7.addActionListener(this);
        l3.add(b7);

        setSize(1550, 800);
        setLocation(0,0);
        setVisible(true);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b7){
            setVisible(false);
            new main_class(pin);
        }
        else{
            JButton sourceButton = (JButton) e.getSource();
            String buttonText = sourceButton.getText();
            int amount = extractAmount(buttonText);

            Conn c = new Conn();
            Date date = new Date();
            try{
                ResultSet resultSet = c.statement.executeQuery("select * from bank where pin ='"+pin+"'");
                int balance = 0;
                while(resultSet.next()){
                    if(resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                if (balance < amount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                String query = "insert into bank values('" + pin + "', '" + date + "', 'Withdraw', '" + amount + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");


        }catch (Exception E){
            E.printStackTrace();
        }
            setVisible(false);
            new main_class(pin);
        }


    }
    private int extractAmount(String text) {
        // Regular expression to match the numerical part of the text
        String numericString = text.replaceAll("\\D", "");
        return Integer.parseInt(numericString);
    }

    public static void main(String[] args){
        new FastCash("");
    }
}
