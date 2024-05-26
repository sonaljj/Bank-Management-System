package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;

    JButton button1, button2, button3;
    Login(){
        super("Bank Management System");


        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde",Font.BOLD, 38 ));
        label1.setBounds(230,40,650,40);
        add(label1);

        label2 = new JLabel("CARD NO:");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Raleway",Font.BOLD, 28 ));
        label2.setBounds(200,150 , 650,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(350,150,250,30);
        textField2.setFont(new Font("Arial",Font.BOLD,20));
        add(textField2);


        label3 = new JLabel("PIN:");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Ralway",Font.BOLD, 28 ));
        label3.setBounds(200,210, 650,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(350,210,250,30);
        passwordField3.setFont(new Font("Arial",Font.BOLD,20));
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,10));
        button1.setBounds(350,280,130,30);
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,10));
        button2.setBounds(480,280,120,30);
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,10));
        button3.setBounds(350,320,250,30);
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.addActionListener(this);
        add(button3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 5, 200, 150);
        add(image);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/credit_card.png"));
        Image i22 = i11.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image1 = new JLabel(i33);
        image1.setBounds(640, 220, 140, 140);
        add(image1);

        setLayout(null);
        setSize(850, 450);
        setLocation(310, 100);
        setVisible(true);
        getContentPane().setBackground(new Color(0x4CA9F5));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource()==button1){
                Conn c = new Conn();
                String card_no = textField2.getText();
                String pin = new String(passwordField3.getPassword());
                String q = "select * from login where card_no = '"+card_no+"' and pin = '"+pin+"'";
                ResultSet result = c.statement.executeQuery(q);
                if(result.next()){
                    setVisible(false);
                    new main_class(pin);
                }else{s
                    JOptionPane.showMessageDialog(null,"Incorrect Credentials");
                }


            }
            else if (e.getSource()==button2){
                textField2.setText("");
                passwordField3.setText("");

            }
            else if (e.getSource()==button3){
                new Signup();
                setVisible(false);
            }
        }catch(Exception E)
        {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new Login();
    }
}
