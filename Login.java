
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField t1,t3;
    JPasswordField t2;
    JButton b1;
    public Login()
    {
        l1 = new JLabel("Enter Username:");
        add(l1);
        t1 = new JTextField(10);
        add(t1);
        l2 = new JLabel("Enter Password");
        add(l2);
        t2 = new JPasswordField(10);
        add(t2);
        b1 = new JButton("LOGIN");
        add(b1);
        b1.addActionListener(this);
        
        t3 = new JTextField(10);
        add(t3);
        setSize(500, 500);
        setLocation(50, 50);
        setVisible(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getActionCommand()=="LOGIN")
       {
           String username = t1.getText();
           char[] password = t2.getPassword();
           String p = String.valueOf(password);
           try
           {
               Class.forName("com.mysql.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost/swing","root","root1");
               java.sql.Statement st = con.createStatement();
               String str = "Insert into User(username, password) values('"+username+"','"+p+"')";
               if(st.executeUpdate(str)!=0)
               {
                    t3.setText("Success");
               }
               else
               {
                   t3.setText("Invalid");
               }
           }
           catch(Exception e)
           {
               System.out.println(e);
           }
       }
    }
    public static void main(String[] args) {
        Login obj = new Login();
    }
}
