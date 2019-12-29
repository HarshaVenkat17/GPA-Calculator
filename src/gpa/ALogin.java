package gpa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ALogin implements ActionListener {

    JFrame f,alert1,alert2;
    JPanel p;
    JLabel l1, l2, title;
    JButton b1, b2;
    JTextField f1;JPasswordField f2;
    String us,pw;
    int ch=0;
    String[] users={"Harsha245","Sarath266","Ratul264"};
    String[] pass={"Surya@123","Rayala073","Ratul_99"};
    Font fontt =new Font("Verdana",Font.BOLD,50);
    Font fontl =new Font("Sans Serif",Font.PLAIN,20);
    ALogin() {
        f = new JFrame();
        p = new JPanel();
        p.setBackground(Color.PINK);
        f.setSize(600, 350);
        f.setLocation(400, 200);
        title = new JLabel("Admin Login");
        b1=new JButton("Submit");
        b2=new JButton("Reset");
        l1 = new JLabel("Username: ");
        l2 = new JLabel("Password: ");
        title.setFont(fontt);
        title.setBounds(120,0,500,60);
        l1.setFont(fontl);l2.setFont(fontl);
         b1.setFont(fontl);b2.setFont(fontl);
        l1.setBounds(30,100,115,30);
        l2.setBounds(30,150,115,30);
        b1.setBounds(80, 230,115,30);
        b2.setBounds(400,230,115,30);
        f1=new JTextField();        
        f2=new JPasswordField();
        f1.setBounds(160,102,300,30);
        f2.setBounds(160,150,300,30);
        f1.setFont(fontl);
        f2.setEchoChar('*');         
        
        p.add(title);
        p.add(l1);p.add(l2);
        p.add(f1);p.add(f2);
        p.add(b1);p.add(b2);
        
        f.setContentPane(p);
        p.setLayout(null);
        p.setVisible(true);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         b1.addActionListener(this);b2.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            int i=0;
            us=f1.getText();
            
            pw=String.valueOf(f2.getPassword());
            try
            {
                for(i=0;i<users.length;i++)
                {
                    if(us.equals(users[i]))
                    {
                        break;
                    } 
                }
                if(pw.equals(pass[i]))
                {
                    ch=1;
                }
                else
                {
                    alert2=new JFrame();  
                    JOptionPane.showMessageDialog(alert2,"Password incorrect. Please verify!","Alert",JOptionPane.WARNING_MESSAGE);
                    f2.setText("");
                }
                if(ch==1)
                {
                    f.dispose();
                    GPA g=new GPA();
                }
            }
            catch(Exception ex)
            {
                if(i==3)
                {   
                    alert1=new JFrame();  
                    JOptionPane.showMessageDialog(alert1,"UserName incorrect. Please verify!","Alert",JOptionPane.WARNING_MESSAGE);   
                    f1.setText("");
                    f2.setText("");
                }
            }            
        }
        if(e.getSource()==b2)
        {
            f1.setText("");
            f2.setText("");
        }    
    }
}
   
