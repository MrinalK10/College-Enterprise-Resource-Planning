import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;



public class AddTeacherInfo extends JFrame implements ActionListener {

    JTextField nameinput,fatherinput,addressinput,phinput,emailinput,aadharinput,xinput,xiiInput;
    JLabel setempID;
    JDateChooser dc ;
    JComboBox courseinput,branchinput;
    JButton submit,cancel;

    Random ran=new Random();
    long digit = Math.abs((ran.nextLong()% 9000L)+1000L);
    public AddTeacherInfo() {

        setSize(900,800);
        setLocation(500,150);

        setLayout(null);

        JLabel heading = new JLabel("Faculty Details");
        heading.setBounds(330,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);


        JLabel name = new JLabel("Name :");
        name.setBounds(70,130,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);


        nameinput = new JTextField();
        nameinput.setBounds(160,130,250,30);
        add(nameinput);

        JLabel fathername = new JLabel("Father's Name :");
        fathername.setBounds(420,130,150,30);
        fathername.setFont(new Font("serif",Font.BOLD,20));
        add(fathername);


        fatherinput = new JTextField();
        fatherinput.setBounds(570,130,250,30);
        add(fatherinput);

        JLabel empID = new JLabel("Employee ID :");
        empID.setBounds(70,200,150,30);
        empID.setFont(new Font("serif",Font.BOLD,20));
        add(empID);

        setempID = new JLabel("101"+digit);
        setempID.setBounds(220,200,150,30);
        setempID.setFont(new Font("serif",Font.BOLD,20));
        add(setempID);

        JLabel dob = new JLabel("Date of Birth :");
        dob.setBounds(420,200,150,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

            dc=new JDateChooser();
            dc.setBounds(570,200,250,30);
            add(dc);

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


        aadharinput = new JTextField();
        aadharinput.setBounds(570,340,250,30);
        add(aadharinput);

        JLabel classx = new JLabel("Class X (%) :");
        classx.setBounds(70,410,150,30);
        classx.setFont(new Font("serif",Font.BOLD,20));
        add(classx);

        xinput = new JTextField();
        xinput.setBounds(210,410,100,30);
        add(xinput);

        JLabel classxii = new JLabel("Class XII (%) :");
        classxii.setBounds(70,480,150,30);
        classxii.setFont(new Font("serif",Font.BOLD,20));
        add(classxii);

        xiiInput = new JTextField();
        xiiInput.setBounds(210,480,100,30);
        add(xiiInput);

        JLabel course = new JLabel("Degree :");
        course.setBounds(70,550,100,30);
        course.setFont(new Font("serif",Font.BOLD,20));
        add(course);

        String coursename[]={"B.Tech","BBA","BCA","MBA"};

        courseinput=new JComboBox(coursename);
        courseinput.setBounds(210,550,100,30);
        courseinput.setBackground(Color.white);
        add(courseinput);

        JLabel branch = new JLabel("Department :");
        branch.setBounds(420,550,150,30);
        branch.setFont(new Font("serif",Font.BOLD,20));
        add(branch);

        String branchname[]={"CSE","EEE","ECE","Civil","Mechanical","IT","BCA","BBA","MBA"};

        branchinput=new JComboBox(branchname);
        branchinput.setBounds(570,550,100,30);
        branchinput.setBackground(Color.white);
        add(branchinput);

        submit=new JButton("Submit");
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
        new AddTeacherInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==submit){

            String getname=nameinput.getText();
            String getfname=fatherinput.getText();
            String getempID= setempID.getText();
            String getdob= ((JTextField) dc.getDateEditor().getUiComponent()).getText();
            String getaddress=addressinput.getText();
            String getphnum=phinput.getText();
            String getemail=emailinput.getText();
            String getaadhar=aadharinput.getText();
            String getx=xinput.getText();
            String getxii=xiiInput.getText();
            String getcourse=(String) courseinput.getSelectedItem();
            String getbranch=(String) branchinput.getSelectedItem();

            try{
                    String query ="insert into teacher values('"+getname+"','"+getfname+"','"+getempID+"','"+getdob+"','"+getaddress+"','"+getphnum+"','"+getemail+"','"+getaadhar+"','"+getx+"','"+getxii+"','"+getcourse+"','"+getbranch+"')";

                Conn con=new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Teacher Information Inserted Successfully");


            }catch (Exception ae){
                ae.printStackTrace();
            }



        }
        else {
            setVisible(false);
        }

    }
}

