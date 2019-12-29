package gpa;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
public class GPA implements ActionListener
{
        
    JButton i,m,v;
    JFrame frame;
    JPanel panel;
    JLabel namel,regl,CS1l,CS2l,MA1l,EC1l,EC2l,LC1l,LC2l,LM1l,l,l2;
    JTextField namet,regt,CS1t,CS2t,MA1t,EC1t,EC2t,LC1t,LC2t,LM1t;
    GPA()
    {   
        frame=new JFrame("Find Your GPA");
        panel=new JPanel();
        Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
        int h=size.height;
        int w=size.width;
        frame.setSize(w,h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Font font=new Font("Verdana",Font.BOLD,16);
        UIManager.put("Label.font",font);
        UIManager.put("Button.font",font);
        panel.setLayout(null);
        panel.setSize(w,h);
	frame.setContentPane(panel);
        
        i=new JButton("Insert");
        i.setBounds(200, 280,150, 25);
        m=new JButton("Clear");
        m.setBounds(200,330,150,25);
        v=new JButton("View");
        v.setBounds(200,380,150,25); 
       
        l=new JLabel();
        l.setBounds(380,380,300,25);
        namel=new JLabel("Name: ");
        namel.setBounds(970,200,100, 20);
        namel.setForeground(Color.yellow);
        regl=new JLabel("Reg.n no.: ");
        regl.setBounds(970,230,100, 20);
        regl.setForeground(Color.yellow);
        CS1l=new JLabel("CS401: ");
        CS1l.setBounds(970,260, 100, 20);
        CS1l.setForeground(Color.yellow);
        CS2l=new JLabel("CS402: ");
        CS2l.setBounds(970,290, 100, 20);
        CS2l.setForeground(Color.yellow);
        MA1l=new JLabel("MA401: ");
        MA1l.setBounds(970,320, 100, 20);
        MA1l.setForeground(Color.yellow);
        EC1l=new JLabel("EC401: ");
        EC1l.setBounds(970,350, 100, 20);
        EC1l.setForeground(Color.yellow);
        EC2l=new JLabel("EC402: ");
        EC2l.setBounds(970,380, 100, 20);
        EC2l.setForeground(Color.yellow);
        LC1l=new JLabel("CS411: ");
        LC1l.setBounds(970,410, 100, 20);
        LC1l.setForeground(Color.yellow);
        LC2l=new JLabel("CS412: ");
        LC2l.setBounds(970,440, 100, 20);
        LC2l.setForeground(Color.yellow);
        LM1l=new JLabel("MA411: ");
        LM1l.setBounds(970,470, 100, 20);
        LM1l.setForeground(Color.yellow);
        namet=new JTextField();
        namet.setBounds(1070,200,200, 20);
        regt=new JTextField();
        regt.setBounds(1070,230, 40, 20);
        CS1t=new JTextField();
        CS1t.setBounds(1070,260, 40, 20);
        CS2t=new JTextField();
        CS2t.setBounds(1070,290, 40, 20);
        MA1t=new JTextField();
        MA1t.setBounds(1070,320, 40, 20);
        EC1t=new JTextField();
        EC1t.setBounds(1070,350, 40, 20);
        EC2t=new JTextField();
        EC2t.setBounds(1070,380, 40, 20);
        LC1t=new JTextField();
        LC1t.setBounds(1070,410, 40, 20);
        LC2t=new JTextField();
        LC2t.setBounds(1070,440, 40, 20);
        LM1t=new JTextField();
        LM1t.setBounds(1070,470, 40, 20);
        
        try
        {
            l2=new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\HarshaVenkat\\Desktop\\CS402\\Project\\resize1.jpg"))));//.getScaledInstance(3, 3, Image.SCALE_SMOOTH)));
            l2.setBounds(0,-25,1366,770);
        }
        catch(Exception e)
        {
            System.out.println("Image doesn't exist");
        }
        l2.add(namel);l2.add(regl);l2.add(CS1l);l2.add(CS2l);l2.add(MA1l);
        l2.add(EC1l);l2.add(EC2l);l2.add(LC1l);l2.add(LC2l);l2.add(LM1l);
        
        panel.add(l2);
        l2.add(namet);l2.add(regt);l2.add(CS1t);l2.add(CS2t);l2.add(MA1t);
        l2.add(EC1t);l2.add(EC2t);l2.add(LC1t);l2.add(LC2t);l2.add(LM1t);
        
        frame.setVisible(true);
        l2.add(i);l2.add(m);l2.add(v);
        i.addActionListener(this);
        m.addActionListener(this);
        v.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        char ch;
        if(e.getSource()==i)
        {   
            ch='i';
            l.setText("");
            int[] num=new int[9];
            String n=namet.getText();
            num[0]=Integer.parseInt(regt.getText());
            num[1]=Integer.parseInt(CS1t.getText());
            num[2]=Integer.parseInt(CS2t.getText());
            num[3]=Integer.parseInt(MA1t.getText());
            num[4]=Integer.parseInt(EC1t.getText());
            num[5]=Integer.parseInt(EC2t.getText());
            num[6]=Integer.parseInt(LC1t.getText());
            num[7]=Integer.parseInt(LC2t.getText());
            num[8]=Integer.parseInt(LM1t.getText());
            try
            {
            Database db=new Database(ch,n,num);
            db.openConnection();
            }
            catch(SQLException s)
            {System.out.println(s);}
        }
        else if(e.getSource()==m)
        {   
            namet.setText("");
            regt.setText("");
            CS1t.setText("");
            CS2t.setText("");
            MA1t.setText("");
            EC1t.setText("");
            EC2t.setText("");
            LC1t.setText("");
            LC2t.setText("");
            LM1t.setText("");
            l.setText("");
        }
        else if(e.getSource()==v)
        {
            ch='v';
            int n=Integer.parseInt(regt.getText());
            Database db=new Database(ch,n,"sg");
            try {
                db.openConnection();
            } catch (SQLException ex) {
                System.out.println("SQL exception");
            }
            frame.dispose();
        } 
    }
    void viewer(String a,double b)
    {
        l.setForeground(Color.WHITE);
        l.setText("Name: "+a+"    GPA:"+b);
        l2.add(l);
    }
    public static void main(String[] args) throws SQLException 
    {
        Login l=new Login();
    }
}