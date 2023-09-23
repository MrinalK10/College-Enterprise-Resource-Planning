import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class StudentInformation extends JFrame implements ActionListener {

    Choice rollno;
    JTable table;
    JButton search,print,update,add,cancel;
    public StudentInformation() {
        setLayout(null);
        setSize(900,800);
        getContentPane().setBackground(Color.white);
        setLocation(500,150);

        JLabel heading =new JLabel("Roll No. :");
        heading.setBounds(20,40,100,50);
        heading.setFont(new Font("serif",Font.BOLD,20));

        add(heading);

        rollno=new Choice();
        rollno.setBounds(120,55,150,50);
        add(rollno);

        try{
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("Select * from student");
            while(rs.next()){
                rollno.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();



        try{
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("Select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,150,900,700);
        add(jsp);

        search =new JButton("Search");
        search.setBounds(20,100,80,20);
        search.addActionListener(this);
        add(search);

        add =new JButton("Add");
        add.setBounds(120,100,80,20);
        add.addActionListener(this);
        add(add);

        update =new JButton("Update");
        update.setBounds(220,100,80,20);
        update.addActionListener(this);
        add(update);

        print =new JButton("Print");
        print.setBounds(320,100,80,20);
        print.addActionListener(this);
        add(print);

        cancel =new JButton("Cancel");
        cancel.setBounds(420,100,80,20);
        cancel.addActionListener(this);
        add(cancel);


        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentInformation();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==search){

            String query = "select * from student where rollno = '"+rollno.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }


        } else if (ae.getSource()==add) {
            setVisible(false);
            new AddStudentInfo();
        }else if (ae.getSource()==update) {
            setVisible(false);

        } else if (ae.getSource()==print) {
            try {
                table.print();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            setVisible(false);

        }

    }
}
