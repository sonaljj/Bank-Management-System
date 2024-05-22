package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    String formno ;
    JComboBox comboBox, comboBox2, comboBox3,comboBox4,comboBox5;
    JTextField textPan,textaadhar;
    JRadioButton r1,r2,e1,e2;
    JButton next;

    Signup2(String first){
        super("Application Form");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        this.formno = first;
        JLabel l1 = new JLabel("PAGE:2");
        l1.setFont(new Font("Raleway",Font.BOLD,20));
        l1.setBounds(150,20,600,40);
        add(l1);

        JLabel l2 = new JLabel("Additional Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(150,80,600,30);
        add(l2);

        JLabel l3 = new JLabel("Religion");
        l3.setFont(new Font("Raleway",Font.BOLD,20));
        l3.setBounds(160,160,600,22);
        add(l3);

        String religion[]= {"Hindu","Muslim","Sikh","Christian","Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(0xB4CBBE));
        comboBox.setFont(new Font("Ralway",Font.BOLD,20));
        comboBox.setBounds(320,160,400,22);
        add(comboBox);

        JLabel l4 = new JLabel("Category");
        l4.setFont(new Font("Raleway",Font.BOLD,20));
        l4.setBounds(160,200,600,22);
        add(l4);

        String category[]= {"General","OBC","SC","ST","Other"};
        comboBox2 = new JComboBox(category);
        comboBox2.setBackground(new Color(0xB4CBBE));
        comboBox2.setFont(new Font("Ralway",Font.BOLD,20));
        comboBox2.setBounds(320,200,400,22);
        add(comboBox2);

        JLabel l5 = new JLabel("Income");
        l5.setFont(new Font("Raleway",Font.BOLD,20));
        l5.setBounds(160,240,600,22);
        add(l5);

        String income[]= {"Null","Below 1,50,000","Below 2,50,000","5,00,000","About 10,00,000","Above 10,00,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(0xB4CBBE));
        comboBox3.setFont(new Font("Ralway",Font.BOLD,20));
        comboBox3.setBounds(320,240,400,22);
        add(comboBox3);

        JLabel l6 = new JLabel("Educational");
        l6.setFont(new Font("Ralway",Font.BOLD,20));
        l6.setBounds(160,280,400,22);
        add(l6);

        String educational[]={"Non-Graduate","Graduate","Post-Graduate","Doctorate","Other"};
        comboBox4 = new JComboBox(educational);
        comboBox4.setBackground(new Color(0xB4CBBE));
        comboBox4.setFont(new Font("Ralway",Font.BOLD,20));
        comboBox4.setBounds(320,280,400,22);
        add(comboBox4);

        JLabel l7 = new JLabel("Occupation");
        l7.setFont(new Font("Ralway",Font.BOLD,20));
        l7.setBounds(160,320,400,22);
        add(l7);

        String occupation[]={"Salaried","Self-employed","Business", "Student","Other"};
        comboBox5 = new JComboBox(occupation);
        comboBox5.setBackground(new Color(0xB4CBBE));
        comboBox5.setFont(new Font("Ralway",Font.BOLD,20));
        comboBox5.setBounds(320,320,400,22);
        add(comboBox5);

        JLabel l8 = new JLabel("PAN Number");
        l8.setFont(new Font("Ralway",Font.BOLD,20));
        l8.setBounds(160,360,400,22);
        add(l8);

        textPan = new JTextField();
        textPan.setFont(new Font("Ralway",Font.BOLD,22));
        textPan.setBounds(320,360,400,22);
        add(textPan);

        JLabel l9 = new JLabel("Aadhar Number");
        l9.setFont(new Font("Ralway",Font.BOLD,20));
        l9.setBounds(160,400,400,22);
        add(l9);

        textaadhar = new JTextField();
        textaadhar.setFont(new Font("Ralway",Font.BOLD,22));
        textaadhar.setBounds(320,400,400,22);
        add(textaadhar);

        JLabel l10 = new JLabel("Senior Citizen");
        l10.setFont(new Font("Ralway",Font.BOLD,20));
        l10.setBounds(160,440,400,22);
        add(l10);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Ralway",Font.BOLD,20));
        r1.setBackground(new Color(0x4FA0D2));
        r1.setBounds(360,440,60,22);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setFont(new Font("Ralway",Font.BOLD,20));
        r2.setBackground(new Color(0x4FA0D2));
        r2.setBounds(480,440,60,22);
        add(r2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);

        JLabel l11 = new JLabel("Existing Account");
        l11.setFont(new Font("Ralway",Font.BOLD,20));
        l11.setBounds(160,480,400,22);
        add(l11);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Ralway",Font.BOLD,20));
        e1.setBackground(new Color(0x4FA0D2));
        e1.setBounds(360,480,60,22);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setFont(new Font("Ralway",Font.BOLD,20));
        e2.setBackground(new Color(0x4FA0D2));
        e2.setBounds(480,480,60,22);
        add(e2);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(e1);
        buttonGroup2.add(e2);

        JLabel l12 = new JLabel("Form No :");
        l12.setFont(new Font("Ralway",Font.BOLD,20));
        l12.setBounds(650,20,100,22);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Ralway",Font.BOLD,18));
        l13.setBounds(760,20,400,22);
        add(l13);

        next = new JButton("Next");
        next.setFont(new Font("Ralway",Font.BOLD,20));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(600,550,100,22);
        next.addActionListener(this);
        add(next);



        setLayout(null);
        setSize(850,650);
        setLocation(350,30);
        getContentPane().setBackground(new Color(0x4FA0D2));
        setVisible(true);
    }
    @Override
    public void  actionPerformed(ActionEvent e){
        String rel = (String) comboBox.getSelectedItem();
        String cate = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occu = (String) comboBox5.getSelectedItem();

        String pan = textPan.getText();
        String aadhar = textaadhar.getText();
        String scitizen = " ";
        if (r1.isSelected()) {
            scitizen = "Yes";
        }
        else if(r2.isSelected()){
            scitizen = "No";
        }
        String eaccount = " ";
        if (e1.isSelected()) {
            eaccount = "Yes";
        }
        else if(e2.isSelected()){
            eaccount = "No";
        }

        try{
            if(textPan.getText().equals("") || textaadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q = "insert into signuptwo values('"+formno+"','"+rel+"','"+cate+"','"+inc+"','"+edu+"','"+occu+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c1.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            }

        }
        catch (Exception E){
            E.printStackTrace();
        }


    }
    public static void main(String[] args){
        new Signup2("");
    }

}
