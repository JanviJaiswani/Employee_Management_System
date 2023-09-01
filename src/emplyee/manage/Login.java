
package emplyee.manage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
   
    JTextField t1,t2;
    
    Login(){
      getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);
          
        JLabel l3 = new JLabel("User Name");
        l3.setBounds(80, 30, 100, 20);
        l3.setFont(new Font("serif", Font.PLAIN, 20));
        l3.setForeground(Color.BLACK);
        add(l3);
        
           t1 = new JTextField();
        t1.setBounds(200,30,150,20);
        add(t1);
        
         JLabel l2 = new JLabel("Password");
        l2.setBounds(80, 70, 100, 20);
        l2.setFont(new Font("serif", Font.PLAIN, 20));
        l2.setForeground(Color.BLACK);
        add(l2);
//     

        t2 = new JTextField();
        t2.setBounds(200,70,150,20);
        add(t2);
//     

         JButton b1 = new JButton("login");
        b1.setBounds(160, 140, 150, 40);
        b1.setFont(new Font("serif", Font.BOLD, 25));
        b1.setBackground(new Color(255, 255, 204));
        b1.setForeground(Color.BLUE);
        b1.addActionListener(this);
        add(b1);
        
        
         ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/log.jpg"));
        Image i2 = il.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 20, 200, 200);
        add(image);
        
         setSize(600, 280);
        setLocation(420, 300);
        setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
     public void actionPerformed(ActionEvent a){
        setVisible(false);
         try{
                String user = t1.getText();
                 String pass = t2.getText();
                 Connect c = new Connect();
                String query = "select * from employee_login where user = '" + user + "' and password = '" + pass + "'";
                 ResultSet rs = c.s.executeQuery(query);
                 if(rs.next()){
                    
                   setVisible(false);  
                   new Home();
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"Invalid Password");
                     setVisible(false);
                 }
            }
            catch (Exception e){
                 e.printStackTrace();
            }
          
           

    }
    
    public static void main(String[] args){
        new Login();
    } 
}
