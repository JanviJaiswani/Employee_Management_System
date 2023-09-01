
package emplyee.manage;


import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
     JButton b1 ,b2,b3,b4;
Home(){
    
        
        setLayout(null);
        
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/home1.jpg"));
        Image i2 = il.getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 650);
        add(image);
        
        
         JLabel l3 = new JLabel("Employee Management System");
        l3.setBounds(520, 30, 440, 50);
        l3.setFont(new Font("serif", Font.BOLD, 32));
        l3.setForeground(Color.GREEN);
        image.add(l3);
        
        b1 = new JButton("Add Employee");
        b1.setBounds(640, 150, 250, 40);
        b1.setFont(new Font("serif", Font.BOLD, 25));
        b1.addActionListener(this);
        image.add(b1);
        
          b2 = new JButton("Remove Employee");
        b2.setBounds(640, 250,250, 40);
        b2.setFont(new Font("serif", Font.BOLD, 25));
        b2.addActionListener(this);
        image.add(b2);
        
            b3 = new JButton("Update Employee");
        b3.setBounds(640, 350, 250, 40);
        b3.setFont(new Font("serif", Font.BOLD, 25));
        b3.addActionListener(this);
        image.add(b3);
        
          b4 = new JButton("View Employee");
        b4.setBounds(640, 450, 250, 40);
        b4.setFont(new Font("serif", Font.BOLD, 25));
        b4.addActionListener(this);
        image.add(b4);
        
          setSize(1000, 650);
        setLocation(250, 100);
        setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

     public void actionPerformed(ActionEvent e){
       if(e.getSource() == b1){
            setVisible(false);
           new Add();
       }
       else if(e.getSource() == b2){
           setVisible(false);
           new Remove();
       }
        else if(e.getSource() == b3){
            setVisible(false);
            new View();
           
        }
        else   if(e.getSource() == b4){
           setVisible(false);
            new View();
        }
           
    }
    public static void main(String Str[]){
        new Home();
    }
}
