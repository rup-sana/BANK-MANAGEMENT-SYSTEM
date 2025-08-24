package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit, withdrawal, fastcash,ministate,pinchange,balanceen,exit;
    String pinnumber;
            
    FastCash(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(215,250,650,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(170,370,150,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal = new JButton("Rs 500");
        withdrawal.setBounds(355,370,150,25);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,400,150,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministate = new JButton("Rs 2000");
        ministate.setBounds(355,400,150,25);
        ministate.addActionListener(this);
        image.add(ministate);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,430,150,25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceen = new JButton("Rs 10000");
        balanceen.setBounds(355,430,150,25);
        balanceen.addActionListener(this);
        image.add(balanceen);
        
        exit = new JButton("BACK");
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+ amount +" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
            
    public static void main(String args[]){
        new FastCash("");
    }
}
