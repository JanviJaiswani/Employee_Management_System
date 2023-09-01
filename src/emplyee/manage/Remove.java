
package emplyee.manage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Remove extends JFrame implements ActionListener, ItemListener {
    Choice empId;
    JLabel nameTf, phnTf, emailTf;
    JButton b1,b2;

    Remove() {
        getContentPane().setBackground( Color.WHITE);
        setLayout(null);

        JLabel employeeId = new JLabel("Employee Id");
        employeeId.setBounds(50, 50, 160, 35);
        employeeId.setFont(new Font("serif", Font.BOLD, 25));
        add(employeeId);

        empId = new Choice();
        empId.setBounds(240, 56, 150, 45);
        add(empId);
        empId.addItemListener(this);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 100, 150, 35);
        name.setFont(new Font("serif", Font.PLAIN, 20));
        add(name);

        nameTf = new JLabel();
        nameTf.setBounds(120, 102, 150, 30);
        nameTf.setFont(new Font("serif", Font.PLAIN, 20));
        add(nameTf);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(50, 150, 150, 35);
        phone.setFont(new Font("serif", Font.PLAIN, 20));
        add(phone);

        phnTf = new JLabel();
        phnTf.setBounds(120, 152, 150, 30);
        phnTf.setFont(new Font("serif", Font.PLAIN, 20));
        add(phnTf);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 200, 50, 35);
        email.setFont(new Font("serif", Font.PLAIN, 20));
        add(email);

        emailTf = new JLabel();
        emailTf.setBounds(120, 202, 250, 30);
        emailTf.setFont(new Font("serif", Font.PLAIN, 20));
        add(emailTf);

        try {
            Connect con = new Connect();
            ResultSet rs = con.s.executeQuery("Select * from emplyee_add");
            while (rs.next()) {
                empId.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        b1 = new JButton("Delete");
        b1.setBounds(160, 290, 100, 40);
        b1.setFont(new Font("serif", Font.BOLD, 25));
        b1.addActionListener(this);
        add(b1);
        
       b2 = new JButton("Back");
        b2.setBounds(300, 290, 100, 40);
        b2.setFont(new Font("serif", Font.BOLD, 25));
        b2.addActionListener(this);
        add(b2);
        
         
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = il.getImage().getScaledInstance(800, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(430, 0, 600, 400);
        add(image);
        
        setSize(1000, 450);
        setLocation(200, 50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void itemStateChanged(ItemEvent e) {
        try {
            Connect con = new Connect();
            ResultSet rs = con.s.executeQuery("Select * from emplyee_add Where id = '" + empId.getSelectedItem() + "'");
            while (rs.next()) {
                nameTf.setText(rs.getString("name"));
                phnTf.setText(rs.getString("phone"));
                emailTf.setText(rs.getString("email"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent a) {
        if(a.getSource()==b1){
        try{
            Connect con = new Connect();
            String query = "delete from emplyee_add where id= '"+empId.getSelectedItem()+"'";
            con.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Employee details deleted successfully");
                setVisible(false);
             new Home();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        else{ setVisible(false);
        new Home();}
        
    }

    public static void main(String[] args) {
        new Remove();
    }
}

