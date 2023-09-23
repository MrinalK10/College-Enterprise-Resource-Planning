import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ExaminationDetails extends JFrame implements ActionListener {

    JTextField search;
    JButton submit;
    JButton cancel;
    JTable table;
    public ExaminationDetails() {
        setSize(1000,475);
        setLocation(500,100);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Check Result");
        heading.setBounds(60,15,400,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        add(heading);

        search=new JTextField();
        search.setBounds(60,70,200,25);
        search.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(search);

        submit=new JButton("Result");
        submit.setBounds(300,70,120,25);
        submit.setFont(new Font("Tahoma",Font.BOLD,13));
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Back");
        cancel.setBounds(440,70,120,25);
        cancel.setFont(new Font("Tahoma",Font.BOLD,13));
        cancel.addActionListener(this);
        add(cancel);

        table=new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,150,1000,300);
        add(jsp);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int row=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        new ExaminationDetails();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==submit){
            setVisible(false);
            new Marks(search.getText());

        }
        else{
            setVisible(false);
        }
    }
}
