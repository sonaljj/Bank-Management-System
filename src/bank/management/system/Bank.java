package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
// Bank Statement Page
public class Bank extends JFrame implements ActionListener {
    String pin;
    JButton b1,b2,b3;
    JLabel label1, label2, label3, label4;
    List<String> transactions;
    int currentPage;
    int transactionsPerPage = 8;

    Bank(String pin){
        super("BankStament");
        this.pin = pin;
        this.transactions = new ArrayList<>();
        this.currentPage = 0;

        getContentPane().setBackground(new Color(0x9497DA));

        label1 = new JLabel(); // balances
        label1.setBounds(60,160,1000,380);
        label1.setFont(new Font("System", Font.TYPE1_FONT, 18));
        add(label1);

        label2 = new JLabel("Bank Statement");
        label2.setFont(new Font("System", Font.BOLD, 24));
        label2.setBounds(200,20,200,28);
        add(label2);

        label3 = new JLabel(); //card number
        label3.setBounds(100,60,1000,24);
        label3.setFont(new Font("System", Font.TYPE1_FONT, 20));
        add(label3);

        label4 = new JLabel(); // total balance
        label4.setFont(new Font("System", Font.TYPE1_FONT, 20));
        label4.setBounds(60,600,1000,24);
        add(label4);

        b1 = new JButton("Exit");
        b1.setFont(new Font("System", Font.BOLD, 20));
        b1.setBounds(450, 650, 80, 22);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Previous");
        b2.setFont(new Font("System", Font.BOLD, 20));
        b2.setBounds(60, 650, 120, 22);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Next");
        b3.setFont(new Font("System", Font.BOLD, 20));
        b3.setBounds(280, 650, 120, 22);
        b3.addActionListener(this);
        add(b3);

        loadBalance();
        displayCardNumber();
        displayTransactions(currentPage);

        setLayout(null);

        setSize(600, 720);
        setLocation(300, 0);
        setVisible(true);

    }
    private void loadBalance() {
        try{
            int balance = 0;
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin ='"+pin+"'");
            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String type = resultSet.getString("type");
                String amount = resultSet.getString("amount");
                transactions.add(date + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + type + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + amount);
                if (type.equals("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }label4.setText("Your Total Balance is Rs. "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private void displayCardNumber() {
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while(resultSet.next()){
                label3.setText("Card Number "+resultSet.getString("card_no").substring(0,4) + "XXXXXXXX" + resultSet.getString("card_no").substring(12));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void displayTransactions(int page) {
        StringBuilder transactionsPage = new StringBuilder("<html>");
        int start = page * transactionsPerPage;
        int end = Math.min(start + transactionsPerPage, transactions.size());

        for (int i = start; i < end; i++) {
            transactionsPage.append(transactions.get(i)).append("<br><br>");
        }
        transactionsPage.append("</html>");
        label1.setText(transactionsPage.toString());

        // Update the visibility of navigation buttons
        b2.setVisible(page > 0);
        b3.setVisible(end < transactions.size());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            setVisible(false);
        } else if (e.getSource() == b3) {
            currentPage++;
            displayTransactions(currentPage);
        } else if (e.getSource() == b2) {
            currentPage--;
            displayTransactions(currentPage);
        }
    }

    public static void main (String[] args){
        new Bank("");
    }
}
