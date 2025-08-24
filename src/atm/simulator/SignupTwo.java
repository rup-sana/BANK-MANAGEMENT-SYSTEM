package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    
    JTextField panTF, aadharTF;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion, category, income, educational, occupation;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("PAGE 2: NEW ACCOUNT APLICATION FORM");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel vReligion = new JLabel("Religion:");
        vReligion.setFont(new Font("Raleway",Font.BOLD,20));
        vReligion.setBounds(100,140,100,30);
        add(vReligion);
        
        String valReligion[] = {"Hindu","Mislim","Christian","Sikh","Jain","Buddhism","Other"};
        religion = new JComboBox(valReligion);
        religion.setBackground(Color.WHITE);
        religion.setBounds(300,140,400,30);
        add(religion);
        
        JLabel vCategory = new JLabel("Category:");
        vCategory.setFont(new Font("Raleway",Font.BOLD,22));
        vCategory.setBounds(100,190,200,30);
        add(vCategory);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBackground(Color.WHITE);
        category.setBounds(300,190,400,30);
        add(category);
        
        JLabel vIncome = new JLabel("Income:");
        vIncome.setFont(new Font("Raleway",Font.BOLD,22));
        vIncome.setBounds(100,240,200,30);
        add(vIncome);
        
        String valIncome[] = {"Null","< 1,50,000","< 5,00,00","< 8,00,000","< 10,00,00","> 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBackground(Color.WHITE);
        income.setBounds(300,240,400,30);
        add(income);
        
        JLabel vEducational = new JLabel("Educational:");
        vEducational.setFont(new Font("Raleway",Font.BOLD,22));
        vEducational.setBounds(100,290,200,30);
        add(vEducational);
        
        JLabel vQuali = new JLabel("Qualification:");
        vQuali.setFont(new Font("Raleway",Font.BOLD,22));
        vQuali.setBounds(100,315,200,30);
        add(vQuali);
        
        String valEducational[] = {"Under-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        educational = new JComboBox(valEducational);
        educational.setBackground(Color.WHITE);
        educational.setBounds(300,315,400,30);
        add(educational);
        
        JLabel vOccu = new JLabel("Occupation:");
        vOccu.setFont(new Font("Raleway",Font.BOLD,22));
        vOccu.setBounds(100,390,200,30);
        add(vOccu);
        
        String valOccupation[] = {"Salaried","Freelancer","Business","Retired","Student","Other"};
        occupation = new JComboBox(valOccupation);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300,390,400,30);
        add(occupation);
        
        JLabel vPAN = new JLabel("PAN Number:");
        vPAN.setFont(new Font("Raleway",Font.BOLD,22));
        vPAN.setBounds(100,440,200,30);
        add(vPAN);
        
        panTF = new JTextField();
        panTF.setFont(new Font("Raleway",Font.BOLD,14));
        panTF.setBounds(300,440,400,30);
        add(panTF);
        
        JLabel vAadhar = new JLabel("Aadhar Number:");
        vAadhar.setFont(new Font("Raleway",Font.BOLD,22));
        vAadhar.setBounds(100,490,200,30);
        add(vAadhar);
        
        aadharTF = new JTextField();
        aadharTF.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTF.setBounds(300,490,400,30);
        add(aadharTF);
        
        JLabel vSeniorC = new JLabel("Senior Citizen:");
        vSeniorC.setFont(new Font("Raleway",Font.BOLD,22));
        vSeniorC.setBounds(100,540,200,30);
        add(vSeniorC);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup sgroup = new ButtonGroup();
        sgroup.add(syes);
        sgroup.add(sno);
        
        JLabel vExist = new JLabel("Existing Account:");
        vExist.setFont(new Font("Raleway",Font.BOLD,22));
        vExist.setBounds(100,590,200,30);
        add(vExist);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup egroup = new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,750);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducational = (String) educational.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String span = panTF.getText();
        String saadhar = aadharTF.getText();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        String existingacc = null;
        if(eyes.isSelected()){
            existingacc = "Yes";
        }else if(eno.isSelected()){
            existingacc = "No";
        }
        
        
        try{
           if(sreligion.equals("")){
               JOptionPane.showMessageDialog(null,"Religion is compulsory!");
           }else{
               Conn c = new Conn();
               String query = "insert into signupTwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducational+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingacc+"')";
               c.s.executeUpdate(query);
               
               //SignUp3 object
               setVisible(false);
               new SignupThree(formno).setVisible(true);
           }
        }catch(Exception e){
            System.out.println(e);
        }
    }
            
   public static void main(String args[]){
       new SignupTwo("");
   } 
}

