package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JRadioButton r1,r2, m1, m2, m3;
    JButton next;
    JTextField textName,textfName, textEmail, textState, textAdd, textCity, textPin;
    JDateChooser dateChooser;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);
    Signup(){

        super("Application Form");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO." + first);
        label1.setBounds(500,20,600,20);
        label1.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label1);

        JLabel label2 = new JLabel("PAGE:1");
        label2.setBounds(150,20,100,24);
        label2.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(150,100,600,24);
        label3.setFont(new Font("Ralway", Font.BOLD,22));
        add(label3);

        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Ralway", Font.BOLD, 20));
        labelName.setBounds(150, 150, 200, 20);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Ralway", Font.BOLD, 20));
        textName.setBounds(320, 150, 300, 30 );
        add(textName);

        JLabel labelfName = new JLabel("Father's Name :");
        labelfName.setFont(new Font("Ralway", Font.BOLD, 20));
        labelfName.setBounds(150, 200, 200, 20);
        add(labelfName);

        textfName = new JTextField();
        textfName.setFont(new Font("Ralway", Font.BOLD, 20));
        textfName.setBounds(320, 200, 300, 30 );
        add(textfName);

        JLabel DOB = new JLabel("Date of Birth :");
        DOB.setFont(new Font("Ralway", Font.BOLD, 20));
        DOB.setBounds(150, 250, 200, 20);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(320,250,300,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel labelG = new JLabel("Gender :");
        labelG.setBounds(150, 300, 300, 20);
        labelG.setFont(new Font("Ralway", Font.BOLD, 20));
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setBackground((new Color(0x4FA0D2)));
        r1.setFont(new Font("Ralway",Font.BOLD, 18));
        r1.setBounds(320, 300, 100,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD, 18));
        r2.setBounds(450, 300, 100,30);
        r2.setBackground((new Color(0x4FA0D2)));
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add (r1);
        buttonGroup.add(r2);

        JLabel labelEmail = new JLabel("Email Address :");
        labelEmail.setBounds(150, 350, 200, 20);
        labelEmail.setFont(new Font("Ralway", Font.BOLD, 20));
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Ralway", Font.BOLD, 20));
        textEmail.setBounds(320, 350, 300, 30 );
        add(textEmail);

        JLabel labelMs = new JLabel("Maritial Status :");
        labelMs.setBounds(150, 400, 200, 20);
        labelMs.setFont(new Font("Ralway", Font.BOLD, 20));
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setBounds(320, 400, 100, 30);
        m1.setBackground((new Color(0x4FA0D2)));
        m1.setFont(new Font("Ralway", Font.BOLD, 18));
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBounds(420, 400, 130, 30);
        m2.setBackground((new Color(0x4FA0D2)));
        m2.setFont(new Font("Ralway", Font.BOLD, 18));
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBounds(550, 400, 100, 30);
        m3.setBackground((new Color(0x4FA0D2)));
        m3.setFont(new Font("Ralway", Font.BOLD, 18));
        add(m3);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);


        JLabel labeladd = new JLabel("Address :");
        labeladd.setBounds(150, 450, 200, 20);
        labeladd.setFont(new Font("Ralway", Font.BOLD, 20));
        add(labeladd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Ralway", Font.BOLD, 20));
        textAdd.setBounds(320, 450, 300, 30 );
        add(textAdd);

        JLabel labelcity = new JLabel("City :");
        labelcity.setBounds(150, 500, 200, 20);
        labelcity.setFont(new Font("Ralway", Font.BOLD, 20));
        add(labelcity);

        textCity = new JTextField();
        textCity.setFont(new Font("Ralway", Font.BOLD, 20));
        textCity.setBounds(320, 500, 300, 30 );
        add(textCity);

        JLabel labelstate = new JLabel("State :");
        labelstate.setBounds(150, 550, 200, 20);
        labelstate.setFont(new Font("Ralway", Font.BOLD, 20));
        add(labelstate);

        textState = new JTextField();
        textState.setFont(new Font("Ralway", Font.BOLD, 20));
        textState.setBounds(320, 550, 300, 30 );
        add(textState);

        JLabel labelpin = new JLabel("Pincode :");
        labelpin.setBounds(150, 600, 200, 20);
        labelpin.setFont(new Font("Ralway", Font.BOLD, 20));
        add(labelpin);

        textPin = new JTextField();
        textPin.setFont(new Font("Ralway", Font.BOLD, 20));
        textPin.setBounds(320, 600, 300, 30 );
        add(textPin);

        next = new JButton("Next");
        next.setFont(new Font("Ralway", Font.BOLD, 20));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,650,80,40);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(0x4FA0D2));
        setLayout(null);
        setSize(850, 750);
        setLocation(360, 0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = textName.getText();
        String fname = textfName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()) {
            gender = "Female";
        }
        String email = textEmail.getText();
        String marital = null;
        if(m1.isSelected()){
            marital = "Married";
        }
        else if(m2.isSelected()){
            marital = "Unmarried";
        }
        else if(m3.isSelected()){
            marital = "Other";
        }
        String address = textAdd.getText();
        String city = textCity.getText();
        String state = textState.getText();
        String pin = textPin.getText();

        try {
            if(textName.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }else {
                Conn con1 = new Conn();
                String q = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                con1.statement.executeUpdate(q);
                new Signup2(first);
                setVisible(false);

            }
        }catch (Exception E)
        {E.printStackTrace();;}


    }

    public static void main(String[] args){
        new Signup();
    }
}



