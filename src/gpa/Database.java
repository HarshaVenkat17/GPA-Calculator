package gpa;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private Connection conn;
    private Statement si,si1,si2;
   
    char c;String name,sendn,sc,ch; 
    int[] val=new int[9];
    int[] credits=new int[9];
    int[] s1=new int[15];
    int[] s2=new int[15];
    int[] s3=new int[15];
    int[] s4=new int[15];
    int[] s5=new int[15];
    int[] s6=new int[15];
    int[] s7=new int[15];
    int[] s8=new int[15];
    int[] roll=new int[15];
    public static String[] users=new String[15];
    public static String[] pass=new String[15];
    int r,i=0;double[] gpa=new double[15];double sendg;
    Database(char ch,int no,String source)
    {
        this.c=ch;this.r=no;
        this.sc=source;
    }
    Database(char ch,String n,int[] num)
    {
        this.c=ch; this.name=n;
        this.val=num;
    }
    Database(char ch,String a)
    {
        this.c=ch;this.ch=a;
    }
    public Connection openConnection() throws SQLException
    {
        if(conn==null)
        {
            String url="jdbc:mysql://localhost/";
            String dbName="info";
            String driver="com.mysql.jdbc.Driver";
            String userName="root";
            String password="";
            try
            {
                Class.forName(driver);
                this.conn=(Connection)DriverManager.getConnection(url+dbName,userName,password);
                System.out.println("Connection Successful");
                if(c=='p')
                {
                    if("check".equals(ch))
                    {
                        String q="SELECT * FROM persons";
                    
                        si=(Statement)conn.createStatement();
                        ResultSet rs=si.executeQuery(q);
                        i=0;
                        while(rs.next())
                        {
                            users[i]=rs.getString("Name");
                            pass[i]=rs.getString("PASS");
                            i++;
                        }  
                    }
                    else
                    {
                        String q1="UPDATE persons SET PASS='"+sc+"' WHERE Reg="+r;                        
                        si1=(Statement)conn.createStatement();
                        si1.executeUpdate(q1);
                    }
                }
                else if(c=='v')
                {
                    String q="SELECT * FROM persons";
                    si=(Statement)conn.createStatement();
                    ResultSet rs=si.executeQuery(q);
                       while(rs.next())
                    {
                        if(rs.getInt("Reg")==r) 
                        {
                            sendn=rs.getString("Name");
                            sendg=rs.getDouble("GPA");
                            int send1=rs.getInt("CS401");
                        int send2=rs.getInt("CS402");
                        int send3=rs.getInt("MA401");
                        int send4=rs.getInt("EC401");
                        int send5=rs.getInt("EC402");
                        int send6=rs.getInt("CS411");
                        int send7=rs.getInt("CS412");
                        int send8=rs.getInt("MA411");
                            if("sl".equals(sc))
                            {ULogin ul=new ULogin();
                            ul.viewer(sendg,send1,send2,send3,send4,send5,send6,send7,send8);}
                            else if("sg".equals(sc))
                            {GPA g=new GPA();
                            g.viewer(sendn,sendg);}
                        }
                    }
                }
                else if(c=='i')
                {
                    si1=(Statement)conn.createStatement();
                    credits[0]= 3;credits[1]=3;credits[2]=4;credits[3]=3;credits[4]=3;credits[5]=3;
                    credits[6]=1;credits[7]=1;credits[8]=1;
                    String query1 = " insert into persons (Name,Reg,CS401,CS402,MA401,EC401,EC402,CS411,CS412,MA411,GPA,PASS)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement preparedStmt = conn.prepareStatement(query1);
                    preparedStmt.setString(1, name);preparedStmt.setInt(2, val[0]);
                    preparedStmt.setInt(3,val[1]);preparedStmt.setInt(4,val[2]);
                    preparedStmt.setInt(5,val[3]);preparedStmt.setInt(6, val[4]);preparedStmt.setInt(7,val[5]);
                    preparedStmt.setInt(8,val[6]);preparedStmt.setInt(9,val[7]);preparedStmt.setInt (10,val[8]);
                    preparedStmt.setDouble (11,0.0);preparedStmt.setString(12,name+Integer.toString(val[0]));
                    preparedStmt.execute();
                    String query2="SELECT * FROM persons";
                    si=(Statement)conn.createStatement();
                    ResultSet rs=si.executeQuery(query2);
                    
                    while(rs.next())
                    {
                        roll[i]=rs.getInt("Reg");
                        s1[i]=rs.getInt("CS401");
                        s2[i]=rs.getInt("CS402");
                        s3[i]=rs.getInt("MA401");
                        s4[i]=rs.getInt("EC401");
                        s5[i]=rs.getInt("EC402");
                        s6[i]=rs.getInt("CS411");
                        s7[i]=rs.getInt("CS412");
                        s8[i]=rs.getInt("MA411");
                        i++;
                    }
                    Find f=new Find();
                    gpa=f.calculate(s1,s2,s3,s4,s5,s6,s7,s8,credits);
                    int cout=0;
                    for(int ro:roll)
                    {
                        String q="UPDATE persons SET GPA="+gpa[cout++]+" WHERE Reg="+ro;
                        si2=(Statement)conn.createStatement();
                        si2.executeUpdate(q);
                    }
                }
                conn.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        return conn;
    }
}
