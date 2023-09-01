
package emplyee.manage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class View extends JFrame implements ActionListener{

    JTable table;
    Choice empId;
    JButton Search,b2,b4,b3;
    View(){
      getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel search = new JLabel("Search By Employee Id");
        search.setBounds(20, 30, 150, 20);
        add(search);
        
        empId = new Choice();
        empId.setBounds(180,30,150,20);
        add(empId); 
        
        Search = new JButton("Search Employee");
        Search.setBounds(370, 30, 170, 20);
        Search.addActionListener(this);
        add(Search);
        
        b2 = new JButton("Print");
        b2.setBounds(40, 80, 120, 30);
        b2.addActionListener(this);
        add(b2);
        
         b3= new JButton("Update");
        b3.setBounds(170, 80, 120, 30);
        b3.addActionListener(this);
        add(b3);
        
        b4= new JButton("Back");
        b4.setBounds(300, 80, 120, 30);
        b4.addActionListener(this);
        add(b4);
        
        try {
            Connect con = new Connect();
            ResultSet rs = con.s.executeQuery("Select * from emplyee_add");

            while (rs.next()) {
                empId.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table = new JTable();
       
        try{
            Connect con = new Connect();
            ResultSet rs = con.s.executeQuery("Select * from emplyee_add");
             table.setModel(DbUtils.resultSetToTableModel(rs));
      
           
        }
         catch (Exception e){
                 e.printStackTrace();
            }
       JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 140, 900, 600);
        add(jsp);
        
          setSize(900, 700);
        setLocation(200, 50);
        setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        public void actionPerformed(ActionEvent a){
        if(a.getSource()==Search){
            String query = "Select * from emplyee_add where id ='"+empId.getSelectedItem()+"'";
            try{
               Connect con = new Connect(); 
               ResultSet rs = con.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(a.getSource()==b2){
             try{
                 table.print();
             }
             catch(Exception e){
                 e.printStackTrace(); 
             }
         }
        else if(a.getSource()==b3){
            setVisible(false);
             new Update(empId.getSelectedItem());
        }
         else if(a.getSource()==b4){
             setVisible(false);
             new Home();
         }
    } 
         public static void main(String[] args){
        new View();
    }
}
