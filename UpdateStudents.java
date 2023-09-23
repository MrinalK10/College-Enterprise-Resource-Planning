import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;



public class UpdateStudents extends JFrame implements ActionListener {

    JTextField tfcourse,addressinput,phinput,emailinput,tfbranch;
    JLabel setrollno;

    JButton submit,cancel;
    Choice crollno;



    public UpdateStudents() {

        setSize(900,800);
        setLocation(500,150);


        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(300,20,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel srollno =new JLabel("Select Roll No. :");
        srollno.setBounds(20,60,150,50);
        srollno.setFont(new Font("serif",Font.BOLD,20));
        add(srollno);

        crollno=new Choice();
        crollno.setBounds(170,75,220,50);
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
        name.setBounds(70,130,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);


        JLabel labelname = new JLabel();
        labelname.setBounds(160,130,250,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);

        JLabel fathername = new JLabel("Father's Name :");
        fathername.setBounds(420,130,150,30);
        fathername.setFont(new Font("serif",Font.BOLD,20));
        add(fathername);


        JLabel labelfname = new JLabel();
        labelfname.setBounds(570,130,250,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);

        JLabel rollno = new JLabel("Roll Number :");
        rollno.setBounds(70,200,150,30);
        rollno.setFont(new Font("serif",Font.BOLD,20));
        add(rollno);

        setrollno = new JLabel();
        setrollno.setBounds(220,200,150,30);
        setrollno.setFont(new Font("serif",Font.PLAIN,20));
        add(setrollno);

        JLabel dob = new JLabel("Date of Birth :");
        dob.setBounds(420,200,150,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        JLabel labeldob=new JLabel();
        labeldob.setBounds(570,200,250,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);

        JLabel address = new JLabel("Address :");
        address.setBounds(70,270,100,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);


        addressinput = new JTextField();
        addressinput.setBounds(160,270,250,30);

        add(addressinput);

        JLabel phonenumber = new JLabel("Phone Number :");
        phonenumber.setBounds(420,270,150,30);
        phonenumber.setFont(new Font("serif",Font.BOLD,20));
        add(phonenumber);


        phinput = new JTextField();
        phinput.setBounds(570,270,250,30);

        add(phinput);

        JLabel email = new JLabel("Email ID :");
        email.setBounds(70,340,150,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        emailinput = new JTextField();
        emailinput.setBounds(160,340,250,30);

        add(emailinput);

        JLabel aadhar = new JLabel("Aadhar Number :");
        aadhar.setBounds(420,340,150,30);
        aadhar.setFont(new Font("serif",Font.BOLD,20));
        add(aadhar);


        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(570,340,250,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadhar);

        JLabel classx = new JLabel("Class X (%) :");
        classx.setBounds(70,410,150,30);
        classx.setFont(new Font("serif",Font.BOLD,20));
        add(classx);

        JLabel labelx = new JLabel();
        labelx.setBounds(210,410,100,30);
        labelx.setFont(new Font("serif",Font.PLAIN,20));
        add(labelx);

        JLabel classxii = new JLabel("Class XII (%) :");
        classxii.setBounds(70,480,150,30);
        classxii.setFont(new Font("serif",Font.BOLD,20));
        add(classxii);

        JLabel labelxii = new JLabel();
        labelxii.setBounds(210,480,100,30);
        labelxii.setFont(new Font("serif",Font.PLAIN,20));
        add(labelxii);

        JLabel course = new JLabel("Course :");
        course.setBounds(70,550,100,30);
        course.setFont(new Font("serif",Font.BOLD,20));
        add(course);



        tfcourse=new JTextField();
        tfcourse.setBounds(210,550,100,30);

        add(tfcourse);

        JLabel branch = new JLabel("Branch :");
        branch.setBounds(420,550,150,30);
        branch.setFont(new Font("serif",Font.BOLD,20));
        add(branch);



        tfbranch=new JTextField();
        tfbranch.setBounds(570,550,100,30);

        add(tfbranch);



        try {
            Conn c=new Conn();
            String query="select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);

            while (rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                setrollno.setText(rs.getString("rollno"));
                labeldob.setText(rs.getString("dob"));
                addressinput.setText(rs.getString("address"));
                phinput.setText(rs.getString("ph_no"));
                emailinput.setText(rs.getString("email"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelx.setText(rs.getString("classx"));
                labelxii.setText(rs.getString("classxii"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
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
                        setrollno.setText(rs.getString("rollno"));
                        labeldob.setText(rs.getString("dob"));
                        addressinput.setText(rs.getString("address"));
                        phinput.setText(rs.getString("ph_no"));
                        emailinput.setText(rs.getString("email"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        labelx.setText(rs.getString("classx"));
                        labelxii.setText(rs.getString("classxii"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


        submit=new JButton("Update");
        submit.setBounds(250,650,110,30);
        submit.setFont(new Font("Tahoma",Font.BOLD,13));
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(450,650,110,30);
        cancel.setFont(new Font("Tahoma",Font.BOLD,13));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }


    public static void main(String[] args) {
        new UpdateStudents();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){

            String getrollno= setrollno.getText();
            String getaddress=addressinput.getText();
            String getphnum=phinput.getText();
            String getemail=emailinput.getText();
            String getcourse= tfcourse.getText();
            String getbranch= tfbranch.getText();

            try{
                String query ="update student set address='"+getaddress+"',ph_no='"+getphnum+"',email='"+getemail+"',course='"+getcourse+"',branch='"+getbranch+"'where rollno='"+getrollno+"'";

                Conn con=new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Information Updated Successfully");


            }catch (Exception ae){
                ae.printStackTrace();
            }



        }
        else {
            setVisible(false);
        }
    }
}

