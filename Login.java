import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel;
    JTextField usernameinput,passwordinput;

    Login(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(40,40,170,20);
        add(username);

        usernameinput = new JTextField();
        usernameinput.setBounds(150,40,170,20);
        add(usernameinput);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,170,20);
        add(password);

        passwordinput = new JPasswordField();
        passwordinput.setBounds(150,70,170,20);
        add(passwordinput);

        login=new JButton("Login");
        login.setBounds(60,120,110,30);
        login.setFont(new Font("Tahoma",Font.BOLD,13));
        login.addActionListener(this);
        add(login);

        cancel=new JButton("Cancel");
        cancel.setBounds(180,120,110,30);
        cancel.setFont(new Font("Tahoma",Font.BOLD,13));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Img/profile1.png"));
        Image i2 = i1.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,30,100,80);
        add(image);



        setSize(500,200);
        setLocation(750,350);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Login();
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==login){
            String username=usernameinput.getText();
            String password=passwordinput.getText();

            String query="select * from login where username = '" +username+"' and password='"+password+"'";

            try{
                Conn c =new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()){
                    setVisible(false);
                    new Project();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }

                c.s.close();
            }catch (Exception e){
                e.printStackTrace();
            }



        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }
    }
}
