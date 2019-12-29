package gpa;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login implements ActionListener {

    JFrame f;
    JPanel p;
    JLabel title;
    JButton b1, b2;
    Font fontt =new Font("Verdana",Font.BOLD,50);
    Font fontl =new Font("Sans Serif",Font.PLAIN,20);
    Login() {
        f = new JFrame();
        p = new JPanel();
        p.setBackground(new Color(0,0,255,150));
        f.setSize(600, 350);
        f.setLocation(400, 200);
        title = new JLabel("Login As");
        b1=new JButton("Admin");
        b2=new JButton("User");
        title.setFont(fontt);
        title.setBounds(180,0,500,60);
        b1.setFont(fontl);b2.setFont(fontl);
        b1.setBounds(80, 200,115,50);
        b2.setBounds(400,200,115,50);
        p.add(title);
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
            f.dispose();
            ALogin al=new ALogin();
        }
        if(e.getSource()==b2)
        {
            f.dispose();
            ULogin ul=new ULogin();
        }    
    }
}
   
