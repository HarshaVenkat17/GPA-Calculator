package gpa;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class ChangeP implements ActionListener {

    JFrame f;
    JPanel p;
    JLabel l1, l2;
    JButton b1,b2;
    String us,pw;
    JTextField f2;JPasswordField f1;
    int roll,i=0;
    Font fontl =new Font("Sans Serif",Font.PLAIN,20);
   
    ChangeP(int roll) 
    {    
        f = new JFrame();
        p = new JPanel();       
        p.setBackground(Color.GREEN);
        f.setSize(610,350);
        f.setLocation(400, 200);
        b1=new JButton("Save");
        b2=new JButton("Clear");
        l1 = new JLabel("New Password: ");
        l2 = new JLabel("Re-enter: ");
        l1.setFont(fontl);l2.setFont(fontl);
        b1.setFont(fontl);b2.setFont(fontl);
        l1.setBounds(30,100,150,30);
        l2.setBounds(30,150,150,30);
        b1.setBounds(100,230,115,30);
        b2.setBounds(400,230,115,30);
        
        f2=new JTextField();        
        f1=new JPasswordField();
        f1.setBounds(200,102,300,30);
        f2.setBounds(200,150,300,30);
        f2.setFont(fontl);
        f1.setEchoChar('*');         
        p.add(l1);p.add(l2);
        p.add(f1);p.add(f2);
        p.add(b1);p.add(b2);
        
        f.setContentPane(p);
        p.setLayout(null);
        p.setVisible(true);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.roll=roll;
         b1.addActionListener(this);b2.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            us=f2.getText();
            pw=String.valueOf(f1.getPassword());
            try
            {
                if(pw.equals(us))
                {
                    Database db=new Database('p',roll,us);
                    try {
                        db.openConnection();
                        } 
                    catch (SQLException ex) {
                        System.out.println("SQL exception");
                        }
                    f.dispose();   
                }
                else
                {
                    JFrame alert2=new JFrame();  
                    JOptionPane.showMessageDialog(alert2,"Password incorrect. Please verify!","Alert",JOptionPane.WARNING_MESSAGE);
                    f1.setText("");f2.setText("");
                }
            }
            catch(Exception ex)
            {
                System.out.println("Hi");
                    f1.setText("");
                    f2.setText("");
                }
            }            
        
        if(e.getSource()==b2)
        {
            f1.setText("");
            f2.setText("");
        }      
    }    
}
   
