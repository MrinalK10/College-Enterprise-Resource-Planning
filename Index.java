import javax.swing.*;
import java.awt.*;

public class Index extends JFrame implements Runnable {

    Thread t;
    Index() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Img/Main.png"));
        Image i2 = i1.getImage().getScaledInstance(1300,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t=new Thread(this);
        t.start();


        setVisible(true);
        setLocation(350, 50);
        setSize(1300, 900);




    }
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
//            setVisible(false);
            new Login();


        }
        catch (Exception e){

        }

    }

    public static void main(String[] args) {
        new Index();

    }


}
