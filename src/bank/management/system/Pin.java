package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarFile;

public class Pin extends JFrame implements ActionListener {
    JButton b1, b2;
    JPasswordField  p1,p2;
    String pin;
    Pin(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1400, 700);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("SYSTEM", Font.BOLD, 16));
        label1.setBounds(380, 140, 500, 18);
        l3.add(label1);

        JLabel label2 = new JLabel("NEW PIN");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Arial", Font.BOLD, 14));
        label2.setBounds(380, 180, 200, 18);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBounds(550, 180, 200, 22);
        p1.setFont(new Font("Arial", Font.BOLD, 18));
        l3.add(p1);

        JLabel label3 = new JLabel("RE-ENTER NEW PIN");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Arial", Font.BOLD, 14));
        label3.setBounds(380, 220, 200, 18);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBounds(550, 220, 200, 22);
        p2.setFont(new Font("Arial", Font.BOLD, 18));
        l3.add(p2);

        b1 = new JButton("CHANGE");
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String pin1 = p1.getText();
            String pin2 = p2.getText();
            if (!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Re-entered Pin Doesn't Match");
                return;
            }
            if (e.getSource()==b1){
                if(pin1.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the new Pin");
                    return;
                }if(pin2.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter the new Pin");
                    return;
                }
                Conn c = new Conn();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signupthree set pin = '"+pin1+"' where pin = '"+pin+"'";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);
                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new Login();

            }else if(e.getSource()==b2){
                new main_class(pin);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args){
        new Pin("");

    }
}
