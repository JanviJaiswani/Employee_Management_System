
package emplyee.manage;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class index extends JFrame implements ActionListener{
    index(){
        getContentPane().setBackground(new Color(255, 255, 204));
        setLayout(null);
        
        JLabel l3 = new JLabel("Employee Management System");
        l3.setBounds(220, 30, 1200, 75);
        l3.setFont(new Font("serif", Font.PLAIN, 60));
        l3.setForeground(Color.RED);
        add(l3);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/bg1.jpg"));
        Image i2 = il.getImage().getScaledInstance(800, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(70, 100, 1050, 500);
        add(image);
        
          JButton b1 = new JButton("Click here");
        b1.setBounds(460, 560, 200, 50);
        b1.setFont(new Font("serif", Font.BOLD, 25));
        b1.setBackground(new Color(255, 255, 204));
        b1.setForeground(Color.BLUE);
        b1.addActionListener(this);
        add(b1);
         
        
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        while(true){
            l3.setVisible(false);
            try{
                Thread.sleep(400);
            }
            catch (Exception e){
                
            }
            l3.setVisible(true);
             try{
                Thread.sleep(400);
            }
            catch (Exception e){
                
            }
             
        }
    
    }
    public void actionPerformed(ActionEvent a){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args){
        new index();
    }
}
