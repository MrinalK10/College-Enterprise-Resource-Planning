import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame implements ActionListener {

    String rollno;

    JButton cancel;
    public Marks(String rollno) {
        this.rollno=rollno;

        setSize(500,600);
        setLocation(700,100);

        setLayout(null);

        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Birla Institute of Technology");
        heading.setBounds(100,10,500,25);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel subheading = new JLabel("Results of Examination 2023");
        subheading.setBounds(110,50,500,20);
        subheading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(subheading);

        JLabel lblrollno = new JLabel("Roll Number:"+rollno);
        lblrollno.setBounds(60,100,500,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblrollno);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60,130,500,20);
        lblsemester.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblsemester);

        JLabel sub1 = new JLabel();
        sub1.setBounds(100,200,520,20);
        sub1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100,230,520,20);
        sub2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(100,260,520,20);
        sub3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(100,290,520,20);
        sub4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(100,320,520,20);
        sub5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(sub5);

        try{
            Conn c=new Conn();

            ResultSet rs1=c.s.executeQuery("select * from subject where rollno ='"+rollno+"'");
            while (rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }

            ResultSet rs2=c.s.executeQuery("select * from marks where rollno ='"+rollno+"'");

            while (rs2.next()){
                sub1.setText(sub1.getText()+"-------------"+rs2.getString("marks1"));
                sub2.setText(sub2.getText()+"-------------"+rs2.getString("marks2"));
                sub3.setText(sub3.getText()+"-------------"+rs2.getString("marks3"));
                sub4.setText(sub4.getText()+"-------------"+rs2.getString("marks4"));
                sub5.setText(sub5.getText()+"-------------"+rs2.getString("marks5"));
                lblsemester.setText("Semester:"+rs2.getString("semester"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        cancel=new JButton("Back");
        cancel.setBounds(150,360,150,25);
        cancel.setFont(new Font("Tahoma",Font.BOLD,13));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Marks("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
}
