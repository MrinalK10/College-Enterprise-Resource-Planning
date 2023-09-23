import com.sun.source.tree.WhileLoopTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFees extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox courseinput,branchinput,cbsemester;

    JLabel labeltotal;

    JButton update,pay,back;

    StudentFees(){
        setSize(900,500);
        setLocation(500,100);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Img/Fees.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);

        JLabel srollno =new JLabel("Select Roll No. :");
        srollno.setBounds(40,60,150,20);
        srollno.setFont(new Font("Tahoma",Font.BOLD,16));
        add(srollno);

        crollno=new Choice();
        crollno.setBounds(200,60,150,20);
        add(crollno);

        try{
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("Select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        JLabel name = new JLabel("Name :");
        name.setBounds(40,100,150,20);
        name.setFont(new Font("Tahoma",Font.BOLD,16));
        add(name);


        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelname);

        JLabel fathername = new JLabel("Father's Name :");
        fathername.setBounds(40,140,150,20);
        fathername.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fathername);


        JLabel labelfname = new JLabel();
        labelfname.setBounds(200,140,150,20);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelfname);

        try {
            Conn c=new Conn();
            String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);

            while (rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c=new Conn();
                    String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);

                    while (rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        JLabel course = new JLabel("Course :");
        course.setBounds(40,180,150,20);
        course.setFont(new Font("Tahoma",Font.BOLD,16));
        add(course);

        String coursename[]={"BTech","Bsc","BCA","BBA","MBA","MCA"};

        courseinput=new JComboBox(coursename);
        courseinput.setBounds(200,180,150,16);
        courseinput.setBackground(Color.white);
        add(courseinput);

        JLabel branch = new JLabel("Branch :");
        branch.setBounds(40,220,150,20);
        branch.setFont(new Font("Tahoma",Font.BOLD,16));
        add(branch);

        String branchname[]={"CSE","EEE","ECE","Civil","Mechanical","IT","BCA","BBA","MBA"};

        branchinput=new JComboBox(branchname);
        branchinput.setBounds(200,220,150,20);
        branchinput.setBackground(Color.white);
        add(branchinput);

        JLabel semester =new JLabel("Semester:");
        semester.setBounds(40,260,150,20);
        semester.setFont(new Font("Tahoma",Font.BOLD,16));
        add(semester);

        String semesterarr[]={"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};

        cbsemester=new JComboBox(semesterarr);
        cbsemester.setBounds(200,260,150,20);
        cbsemester.setBackground(Color.white);
        add(cbsemester);

        JLabel total =new JLabel("Total Payable:");
        total.setBounds(40,300,150,20);
        total.setFont(new Font("Tahoma",Font.BOLD,16));
        add(total);

         labeltotal =new JLabel();
        labeltotal.setBounds(200,300,150,20);
        labeltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labeltotal);

        update=new JButton("Upddate");
        update.setBounds(30,380,100,25);
        update.setFont(new Font("Tahoma",Font.BOLD,13));
        update.addActionListener(this);
        add(update);

        pay=new JButton("Pay Fees");
        pay.setBounds(150,380,100,25);
        pay.setFont(new Font("Tahoma",Font.BOLD,13));
        pay.addActionListener(this);
        add(pay);

        back=new JButton("Back");
        back.setBounds(270,380,100,25);
        back.setFont(new Font("Tahoma",Font.BOLD,13));
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentFees();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==update){

        String course=(String) courseinput.getSelectedItem();
        String semester=(String) cbsemester.getSelectedItem();

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from fee where course='"+course+"'");

            while (rs.next()){
                labeltotal.setText(rs.getString(semester));
            }


        }catch (Exception ae){
            ae.printStackTrace();
        }

    } else if (e.getSource()==pay) {
        String rollno=crollno.getSelectedItem();
        String course=(String) courseinput.getSelectedItem();
        String semester=(String) cbsemester.getSelectedItem();
        String branch= (String) branchinput.getSelectedItem();
        String total=labeltotal.getText();

        try{
            Conn c=new Conn();
            String query="insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
            c.s.executeUpdate(query);

           JOptionPane.showMessageDialog(null,"College fee submitted successfully");

           setVisible(false);


        }catch (Exception ae){
            ae.printStackTrace();
        }


    }
    else{
        setVisible(false);
    }
    }
}
