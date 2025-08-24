package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdrawal, fastcash,ministate,pinchange,balanceen,exit;
    String pinnumber;
            
    Transactions(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(215,250,650,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,370,150,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(355,370,150,25);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,400,150,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministate = new JButton("Mini-Statement");
        ministate.setBounds(355,400,150,25);
        ministate.addActionListener(this);
        image.add(ministate);
        
        pinchange = new JButton("Change PIN");
        pinchange.setBounds(170,430,150,25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceen = new JButton("Balance Enquiry");
        balanceen.setBounds(355,430,150,25);
        balanceen.addActionListener(this);
        image.add(balanceen);
        
        exit = new JButton("Exit");
        exit.setBounds(355,460,150,25);
        exit.addActionListener(this);
        image.add(exit);
       
        setSize(900,800);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource() == withdrawal){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource() == balanceen){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource() == ministate){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
            
    public static void main(String args[]){
        new Transactions("");
    }
}
