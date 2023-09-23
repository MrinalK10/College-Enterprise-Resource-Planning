import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {

    public Project() {
        setSize(1920, 1080);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Img/background.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1900, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar menubar = new JMenuBar();


        setJMenuBar(menubar);


        // New Information

        JMenu newInformation = new JMenu("Add Information     ");
        newInformation.setForeground(Color.BLACK);

        menubar.add(newInformation);


        JMenuItem facultyInfo = new JMenuItem("Add Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("Add Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        // View Details

        JMenu viewInformation = new JMenu("View Information     ");

        menubar.add(viewInformation);

        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.white);
        facultyDetails.addActionListener(this);
        viewInformation.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.white);
        studentDetails.addActionListener(this);
        viewInformation.add(studentDetails);

        //Examination

        JMenu examinationDetails = new JMenu("Examination     ");

        menubar.add(examinationDetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.white);
        entermarks.addActionListener(this);
        examinationDetails.add(entermarks);

        JMenuItem results = new JMenuItem("Examination Results");
        results.setBackground(Color.white);
        results.addActionListener(this);
        examinationDetails.add(results);

        // Update Details

        JMenu updateInformation = new JMenu("Update Information     ");

        menubar.add(updateInformation);

        JMenuItem updatefacultyInfo = new JMenuItem("Update Faculty Information");
        updatefacultyInfo.setBackground(Color.white);
        updatefacultyInfo.addActionListener(this);
        updateInformation.add(updatefacultyInfo);

        JMenuItem updatestudentInfo = new JMenuItem("Update Student Information");
        updatestudentInfo.setBackground(Color.white);
        updatestudentInfo.addActionListener(this);
        updateInformation.add(updatestudentInfo);

        // Fees

        JMenu feeStructure = new JMenu("Student Fees     ");

        menubar.add(feeStructure);

        JMenuItem feeDetails = new JMenuItem("Student Fee Details");
        feeDetails.setBackground(Color.white);
        feeDetails.addActionListener(this);
        feeStructure.add(feeDetails);

        JMenuItem onlineFeePayment = new JMenuItem("Online Fee Payment");
        onlineFeePayment.setBackground(Color.white);
        onlineFeePayment.addActionListener(this);
        feeStructure.add(onlineFeePayment);

        //Tools

        JMenu tools = new JMenu("Tools     ");
        tools.setForeground(Color.BLACK);

        menubar.add(tools);


        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        tools.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.white);
        calc.addActionListener(this);
        tools.add(calc);

//        JMenuItem browser = new JMenuItem("Browser");
//        browser.setBackground(Color.white);
//        browser.addActionListener(this);
//        tools.add(browser);

        //Exit

        JMenu exit = new JMenu("Exit");

        menubar.add(exit);

        JMenuItem ex = new JMenuItem("Close");
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Project();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();

        if (msg.equals("Close")) {
            setVisible(false);
        } else if (msg.equals("Add Faculty Information")) {

            new AddTeacherInfo();
        } else if (msg.equals("Add Student Information")) {

            new AddStudentInfo();

        } else if (msg.equals("View Faculty Details")) {

            new TeacherInformation();
        } else if (msg.equals("View Student Details")) {

            new StudentInformation();
        } else if (msg.equals("Update Faculty Information")) {

            new UpdateTeacher();
        } else if (msg.equals("Update Student Information")) {

            new UpdateStudents();

        }else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }

        else if(msg.equals("Examination Results")){
            new ExaminationDetails();
        }

        else if(msg.equals("Student Fee Details")){
            new FeeStructure();
        }

        else if(msg.equals("Online Fee Payment")){
            new StudentFees();
        }

        else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception ae){

            }

        }
        else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception ae){

            }

        }
//        else if (msg.equals("Browser")) {
//            try {
//
//            }catch (Exception ae){
//
//            }

        }

    }



