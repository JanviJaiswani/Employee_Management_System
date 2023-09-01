

package emplyee.manage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.sql.*;



public class Update extends JFrame implements ActionListener {
    
   
    JButton add,back;
    JTextField edutf,fnameText, emailText,addTx,salarytx,phonetx,aadhartx,desigtx;
    JLabel idtx;
    String empId;
    Update(String empId){
        this.empId = empId;
          getContentPane().setBackground(new Color(255, 255, 204));
        setLayout(null);
        
        JLabel l3 = new JLabel("Update Employee Detail");
        l3.setBounds(300, 30, 400, 45);
        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 35));
        l3.setForeground(Color.RED);
        add(l3);
        
        JLabel name =new JLabel("Name");
        name.setBounds(50, 150, 150, 45);
        name.setFont(new Font("serif", Font.BOLD, 25));
        add(name);
        
         JLabel nameTf = new JLabel();
        nameTf.setBounds(150,152,200,40);
        nameTf.setFont(new Font("serif", Font.BOLD, 25));
        add(nameTf); 
        
         JLabel fname =new JLabel("Father's Name");
        fname.setBounds(400, 150, 250, 45);
        fname.setFont(new Font("serif", Font.BOLD, 25));
        add(fname);
         
           fnameText = new JTextField();
        fnameText.setBounds(630,152,200,40);
          fnameText.setFont(new Font("serif", Font.BOLD, 25));
        add(fnameText);
       
        JLabel email =new JLabel("Email");
        email.setBounds(50, 220, 150, 45);
        email.setFont(new Font("serif", Font.BOLD, 25));
        add(email);
        
        emailText = new JTextField();
        emailText.setBounds(150,222,200,40);
        emailText.setFont(new Font("serif", Font.BOLD, 25));
        add(emailText);
        
         JLabel address =new JLabel("Current Address");
        address.setBounds(400, 220, 250, 45);
        address.setFont(new Font("serif", Font.BOLD, 25));
        add(address);
         
          addTx = new JTextField();
        addTx.setBounds(630,222,200,40);
        addTx.setFont(new Font("serif", Font.BOLD, 25));
        add(addTx);
        
        
        JLabel dob =new JLabel("DOB");
        dob.setBounds(50, 290, 150, 45);
        dob.setFont(new Font("serif", Font.BOLD, 25));
        add(dob);
        
         JLabel dobtf = new JLabel();
         dobtf.setBounds(150,292,200,35);
         dobtf.setFont(new Font("serif", Font.BOLD, 25));
         add(dobtf);
         
         
          JLabel salary =new JLabel("Salary");
        salary.setBounds(400, 290, 250, 45);
        salary.setFont(new Font("serif", Font.BOLD, 25));
        add(salary); 
        
           salarytx = new JTextField();
        salarytx.setBounds(630,292,200,40);
        salarytx.setFont(new Font("serif", Font.BOLD, 25));
        add(salarytx);
       
       JLabel phone=new JLabel("Mobile");
        phone.setBounds(50, 360, 150, 45);
        phone.setFont(new Font("serif", Font.BOLD, 25));
        add(phone);
         
          phonetx = new JTextField();
        phonetx.setBounds(150,360,200,40);
         phonetx.setFont(new Font("serif", Font.BOLD, 25));
        add(phonetx);
        
         JLabel aadhar =new JLabel("Aadhar No");
        aadhar.setBounds(400, 360, 250, 45);
        aadhar.setFont(new Font("serif", Font.BOLD, 25));
        add(aadhar); 
        
          JLabel aadhartf = new JLabel();
        aadhartf.setBounds(630,360,200,40);
         aadhartf.setFont(new Font("serif", Font.BOLD, 25));
        add(aadhartf);
        
             JLabel desig=new JLabel("Designation");
        desig.setBounds(50, 430, 200, 45);
        desig.setFont(new Font("serif", Font.BOLD, 25));
        add(desig);
         
          desigtx = new JTextField();
        desigtx.setBounds(180,430,180,40);
           desigtx.setFont(new Font("serif", Font.BOLD, 25));
        add(desigtx);
       
        JLabel edu =new JLabel("Education");
        edu.setBounds(400, 430, 250, 45);
        edu.setFont(new Font("serif", Font.BOLD, 25));
        add(edu);
        
         edutf = new JTextField();
    
        edutf.setBackground(Color.WHITE);
        edutf.setBounds(630,430,200,45);
         edutf.setFont(new Font("serif", Font.PLAIN, 25));
        add(edutf);
        
         JLabel id=new JLabel("Employee Id");
        id.setBounds(50, 500, 200, 45);
        id.setFont(new Font("serif", Font.BOLD, 25));
        add(id);
        
         idtx=new JLabel();
        idtx.setBounds(200, 500, 200, 45);
        idtx.setFont(new Font("serif", Font.PLAIN, 25));
        add(idtx);
        
         add = new JButton("Update Details");
        add.setBounds(200, 600, 250, 40);
        add.setFont(new Font("serif", Font.BOLD, 25));
        add.addActionListener(this);
        add(add);
        
        try{
            Connect con = new Connect();
            String query ="select * from emplyee_add where id = '"+empId+"'";
            ResultSet rs = con.s.executeQuery(query);
            while(rs.next()){
                  nameTf.setText(rs.getString("name"));
                  fnameText.setText(rs.getString("fname"));
                  dobtf.setText(rs.getString("dob"));
                  emailText.setText(rs.getString("email"));
                  addTx.setText(rs.getString("address"));
                  phonetx.setText(rs.getString("phone"));
                  aadhartf.setText(rs.getString("aadhar"));
                  desigtx.setText(rs.getString("desig"));
                  edutf.setText(rs.getString("education"));
                  idtx.setText(rs.getString("id"));
                  salarytx.setText(rs.getString("salary"));
                  
                  
                  
            }
        }
        catch(Exception a){
        a.printStackTrace();
        }
        
          back = new JButton("Back");
        back.setBounds(470, 600,250, 40);
        back.setFont(new Font("serif", Font.BOLD, 25));
       back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
    
     public void actionPerformed(ActionEvent a){
         if(a.getSource() == add){
             
        String fatherName = fnameText.getText();
        String email = emailText.getText();
        String address = addTx.getText();
        String salary = salarytx.getText();
        String phone = phonetx.getText();
        String designation = desigtx.getText();
        String education =edutf.getText();
     
          try{
              Connect con = new Connect();
              String query = "UPDATE emplyee_add SET fname = '" + fatherName + "', salary = '" + salary + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "', education = '" + education + "', desig = '" + designation + "' WHERE id = '" + empId + "'";
              con.s.executeUpdate(query); 
               JOptionPane.showMessageDialog(null, "Employee details updated successfully");
                setVisible(false);
             new Home();
          }
          
         catch(Exception e){
             e.printStackTrace();
         }
          
         }
         else if(a.getSource() == back){
             setVisible(false);
             new Home();
         }
       
    }
    public static void main(String[] args){
        new Update("");
    }
}
