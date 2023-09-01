
package emplyee.manage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;



public class Add extends JFrame implements ActionListener {
    
    Random rN = new Random();
    int number = rN.nextInt(9999999);
    JButton add,back;
    JTextField nameText,fnameText, emailText,addTx,salarytx,phonetx,aadhartx,desigtx;
    JDateChooser dcdob;
    JComboBox edutx ;
    JLabel idtx;
    Add(){
          getContentPane().setBackground(new Color(255, 255, 204));
        setLayout(null);
        
        JLabel l3 = new JLabel("Add Employee Detail");
        l3.setBounds(300, 30, 400, 45);
        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 35));
        l3.setForeground(Color.RED);
        add(l3);
        
        JLabel name =new JLabel("Name");
        name.setBounds(50, 150, 150, 45);
        name.setFont(new Font("serif", Font.BOLD, 25));
        add(name);
        
         nameText = new JTextField();
        nameText.setBounds(150,152,200,40);
        add(nameText);
        
         JLabel fname =new JLabel("Father's Name");
        fname.setBounds(400, 150, 250, 45);
        fname.setFont(new Font("serif", Font.BOLD, 25));
        add(fname);
         
           fnameText = new JTextField();
        fnameText.setBounds(630,152,200,40);
        add(fnameText);
       
        JLabel email =new JLabel("Email");
        email.setBounds(50, 220, 150, 45);
        email.setFont(new Font("serif", Font.BOLD, 25));
        add(email);
        
        emailText = new JTextField();
        emailText.setBounds(150,222,200,40);
        add(emailText);
        
         JLabel address =new JLabel("Current Address");
        address.setBounds(400, 220, 250, 45);
        address.setFont(new Font("serif", Font.BOLD, 25));
        add(address);
         
          addTx = new JTextField();
        addTx.setBounds(630,222,200,40);
        add(addTx);
        
        
        JLabel dob =new JLabel("DOB");
        dob.setBounds(50, 290, 150, 45);
        dob.setFont(new Font("serif", Font.BOLD, 25));
        add(dob);
        
          dcdob = new JDateChooser();
         dcdob.setBounds(150,292,200,35);
         add(dcdob);
         
         
          JLabel salary =new JLabel("Salary");
        salary.setBounds(50, 430, 200, 45);
        salary.setFont(new Font("serif", Font.BOLD, 25));
        add(salary); 
        
           salarytx = new JTextField();
        salarytx.setBounds(150,430,200,40);
        add(salarytx);
       
       JLabel phone=new JLabel("Mobile");
        phone.setBounds(50, 360, 150, 45);
        phone.setFont(new Font("serif", Font.BOLD, 25));
        add(phone);
         
          phonetx = new JTextField();
        phonetx.setBounds(150,360,200,40);
        add(phonetx);
        
         JLabel aadhar =new JLabel("Aadhar No");
        aadhar.setBounds(400, 360, 250, 45);
        aadhar.setFont(new Font("serif", Font.BOLD, 25));
        add(aadhar); 
        
           aadhartx = new JTextField();
        aadhartx.setBounds(630,360,200,40);
        add(aadhartx);
        
             JLabel desig=new JLabel("Designation");
        desig.setBounds(400,290, 250, 45);
        desig.setFont(new Font("serif", Font.BOLD, 25));
        add(desig);
         
          desigtx = new JTextField();
        desigtx.setBounds(630,292,200,40);
        add(desigtx);
       
        JLabel edu =new JLabel("Education");
        edu.setBounds(400, 430, 250, 45);
        edu.setFont(new Font("serif", Font.BOLD, 25));
        add(edu);
        
        String courses[] = {"B.Tech" ,"M.Tech" ,"BBA" ,"BSE","BCA","MCA","PG","B.COM","BA","MA","MSE","M.COM"};
        edutx = new JComboBox(courses);
        edutx.setBackground(Color.WHITE);
        edutx.setBounds(630,430,200,45);
         edutx.setFont(new Font("serif", Font.PLAIN, 25));
        add(edutx);
        
         JLabel id=new JLabel("Employee Id");
        id.setBounds(50, 500, 200, 45);
        id.setFont(new Font("serif", Font.BOLD, 25));
        add(id);
        
         idtx=new JLabel(""+ number);
        idtx.setBounds(200, 500, 200, 45);
        idtx.setFont(new Font("serif", Font.PLAIN, 25));
        add(idtx);
        
         add = new JButton("Add Details");
        add.setBounds(200, 600, 250, 40);
        add.setFont(new Font("serif", Font.BOLD, 25));
        add.addActionListener(this);
        add(add);
        
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
              String name = nameText.getText();
        String fatherName = fnameText.getText();
        String email = emailText.getText();
        String address = addTx.getText();
        String dob =((JTextField)dcdob.getDateEditor()).getText();
        String salary = salarytx.getText();
        String phone = phonetx.getText();
        String aadhar = aadhartx.getText();
        String designation = desigtx.getText();
        String education = edutx.getSelectedItem().toString();
        String employeeId = idtx.getText();
          try{
              Connect con = new Connect();
              String query = "INSERT INTO emplyee_add (name, fname, dob, email, address, phone, salary, desig, aadhar, education, id) VALUES ('"
                      + name + "', '" + fatherName + "', '" + dob + "', '" + email + "', '" + address + "', '"
                      + phone + "', '" + salary + "', '" + designation + "', '" + aadhar + "', '" + education + "', '" + employeeId + "')";
              con.s.executeUpdate(query); 
               JOptionPane.showMessageDialog(null, "Employee details added successfully");
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
        new Add();
    }
}
