import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.net.*;

class Experiment extends Frame
{
    Discuss fd;
    SignIn fd1;
    SignUp fd2;
    TextField t1 = new TextField();
    TextField pass = new TextField();
    public Experiment(Frame f)
    {
        setTitle("Gmail");
        setSize(500,250);
        setLayout(new FlowLayout());
        addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    System.exit(0);
                }
            });
        Panel p = new Panel();
        p.setLayout(new GridLayout(5,2));
        Button s1 = new Button("SignIN"),s2 = new Button("Clear");
        Button s3 = new Button("SignUp"),s4 = new Button("Forgotten Password");
        Button s5 = new Button("Next"),s6 = new Button("Quit");
        p.add(new Label("UserName/Mobile no/Email  "));
        p.add(t1);
        p.add(new Label("Password"));
        pass.setEchoChar('*');
        p.add(pass);
        p.add(s1);p.add(s2);p.add(s3);p.add(s4);p.add(s5);p.add(s6);
        add(p);
        s3.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    fd2.setVisible(true);
                    setVisible(false);
                }
            });
        s2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    t1.setText("");
                    pass.setText("");
                }
            });
        s6.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    fd.setVisible(true);
                }
            });
        fd = new Discuss(this);
        fd2 = new SignUp(this);
        setVisible(true);
    }

    public static void main(String args[])throws Exception
    {
        Frame f = new Frame();
        new Experiment(f);
    }
}

class Discuss extends Frame
{
    Discuss(Frame f)
    {
        setSize(200,150);
        setLayout(new FlowLayout());
        add(new Label("Confirm to CLOSE"));
        Panel p1 = new Panel();
        Button b1 = new Button("Confirm"),b2 = new Button("Cancel");
        p1.setLayout(new GridLayout(1,2));
        p1.add(b1);p1.add(b2);
        add(p1);
        b1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    setVisible(false);
                    System.exit(0);
                }
            });
        b2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    setVisible(false);
                }
            });
    }
}

class SignUp extends Frame
{
    Experiment ed;
    static String fname1,lname1,day1,month1,year1;
    SignUp(Frame f)
    {
        setSize(700,450);
        setLayout(new FlowLayout());
        addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    System.exit(0);
                }
            });
        add(new Label("Create New Account..."));
        TextField fname = new TextField();
        TextField lname = new TextField();
        Panel p3 = new Panel();
        p3.setLayout(new GridLayout(2,2));
        p3.add(new Label("First Name : "));
        p3.add(fname);
        p3.add(new Label("Last Name : "));
        p3.add(lname);
        add(p3);
        Choice day = new Choice();
        day.add("1");day.add("2");day.add("3");day.add("4");day.add("5");day.add("6");day.add("7");day.add("8");day.add("9");day.add("10");day.add("11");day.add("12");day.add("13");day.add("14");day.add("15");day.add("16");day.add("17");day.add("18");day.add("19");day.add("20");day.add("7");day.add("21");day.add("22");day.add("23");day.add("24");day.add("25");day.add("26");day.add("27");day.add("28");day.add("29");day.add("30");day.add("31");
        Choice month = new Choice();
        month.add("January");month.add("February");month.add("March");month.add("April");month.add("May");month.add("June");month.add("July");month.add("August");month.add("September");month.add("October");month.add("November");month.add("Dcember");
        Choice year = new Choice();
        year.add("2000");year.add("2001");year.add("2002");
        Panel p4 = new Panel();
        p4.setLayout(new GridLayout(1,6));
        p4.add(new Label("Day :  "));
        p4.add(day);
        p4.add(new Label("          Month  :   "));
        p4.add(month);
        p4.add(new Label("          Year   :    "));
        p4.add(year);
        add(p4);
        Button back = new Button("Back"),cre = new Button("Create");
        fname1 = fname.getText();
        lname1 = lname.getText();
        day1 = day.getSelectedItem();
        month1 = month.getSelectedItem();
        year1 = year.getSelectedItem();
        back.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    ed.setVisible(true);
                    setVisible(false);
                }
            });
        cre.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                }
            });
        setVisible(true);
    }
}

class SignIn
{
    SignIn()
    {
    }
}

class WriteData
{
    SignUp da;
    public void CollectData()
    {

        String name = SignUp.fname1+" "+da.lname1;
        String dob = da.day1+"-"+da.month1+"-"+da.year1;
    }

    public void ModifyData()
    {
    }

    public void createfile(String name)throws Exception
    {
        File file = new File(name);
        if(file.createNewFile())
            System.out.println("Successfully! created the file...");
        else
            System.out.println("Error , File is not created successfully");

    }
}

class ReadData
{
    ReadData()
    {
    }
}

