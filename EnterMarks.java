import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {
     Choice crollno;
     JComboBox cbsemester;

     JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5;
     JTextField tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;

     JButton cancel, submit;

    EnterMarks(){
        setSize(900,500);
        setLocation(500,150);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Img/Exam.png"));
        Image i2 = i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,70,400,300);
        add(image);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel srollno =new JLabel("Select Roll No. :");
        srollno.setBounds(50,70,150,20);
        srollno.setFont(new Font("serif",Font.BOLD,20));
        add(srollno);

        crollno=new Choice();
        crollno.setBounds(200,70,150,20);
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

        JLabel semester =new JLabel("Select Semester:");
        semester.setBounds(50,100,150,20);
        semester.setFont(new Font("serif",Font.BOLD,20));
        add(semester);

        String semesterarr[]={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};

        cbsemester=new JComboBox(semesterarr);
        cbsemester.setBounds(200,100,150,20);
        cbsemester.setBackground(Color.white);
        add(cbsemester);

        JLabel subject =new JLabel("Enter Subject");
        subject.setBounds(100,150,200,40);
        subject.setFont(new Font("serif",Font.BOLD,20));
        add(subject);

        JLabel marks =new JLabel("Enter Marks");
        marks.setBounds(320,150,200,40);
        marks.setFont(new Font("serif",Font.BOLD,20));
        add(marks);

        tfsub1=new JTextField();
        tfsub1.setBounds(70,200,200,20);
        add(tfsub1);

        tfsub2=new JTextField();
        tfsub2.setBounds(70,230,200,20);
        add(tfsub2);

        tfsub3=new JTextField();
        tfsub3.setBounds(70,260,200,20);
        add(tfsub3);

        tfsub4=new JTextField();
        tfsub4.setBounds(70,290,200,20);
        add(tfsub4);

        tfsub5=new JTextField();
        tfsub5.setBounds(70,320,200,20);
        add(tfsub5);

        tfmarks1=new JTextField();
        tfmarks1.setBounds(320,200,100,20);
        add(tfmarks1);

        tfmarks2=new JTextField();
        tfmarks2.setBounds(320,230,100,20);
        add(tfmarks2);

        tfmarks3=new JTextField();
        tfmarks3.setBounds(320,260,100,20);
        add(tfmarks3);

        tfmarks4=new JTextField();
        tfmarks4.setBounds(320,290,100,20);
        add(tfmarks4);

        tfmarks5=new JTextField();
        tfmarks5.setBounds(320,320,100,20);
        add(tfmarks5);

        submit=new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setFont(new Font("Tahoma",Font.BOLD,13));
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(280,360,150,25);
        cancel.setFont(new Font("Tahoma",Font.BOLD,13));
        cancel.addActionListener(this);
        add(cancel);




        setVisible(true);
    }

    public static void main(String[] args) {
        new EnterMarks();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
            try {
               Conn c=new Conn();

               String query1="insert into subject values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"', '"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";

               String query2="insert into marks values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"', '"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"')";

               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);

               JOptionPane.showMessageDialog(null,"Marks Inserted Succesfully");
               setVisible(false);
            }catch (Exception ae){
                ae.printStackTrace();
            }


        }else{
            setVisible(false);
        }
    }
}
