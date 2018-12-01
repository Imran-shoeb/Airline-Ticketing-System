package airline;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login_Panel {
	
	static Employee_login emp = new Employee_login();
	public static int Login(Database_Connector conn){
		String id = "";
		
	    Statement stmn = null;
		JTextField user = new JTextField(10);
		int setPassBit = 0;
		int typeCheck = 0;
		JPasswordField password = new JPasswordField(10);
		ResultSet rs = null;
		Object [] message = { "User Name: " , user, "\n", "Password:", password};
		int result = JOptionPane.showConfirmDialog(null, message, "Enter User name and Password",JOptionPane.OK_CANCEL_OPTION);
		if(result==JOptionPane.OK_OPTION){
			try {
				stmn = conn.getConnection().createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			try {
				rs = stmn.executeQuery("SELECT * from desc_login");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("user: " + user.getText() + " Password: " + password.getText());
			try {
				while(rs.next()){
					System.out.println("rs user: " + rs.getString(1) + " rs Password: " + rs.getString(2));
					if (user.getText().length()>0 && password.getText().length()>0) {
						
					if(user.getText().equals(rs.getString(1)) && password.getText().equals(rs.getString(2))){		
					    setPassBit = 1; 
					    typeCheck=rs.getInt(3);
					    break;
					}
					else {
						//System.out.println("ID or PASSWORD doesn't match");
						setPassBit = 2;						
					}
				}
					else {
						//System.out.println("Empty field.Write something.");
						setPassBit = 3;
				}
				
				
			}
				if (setPassBit == 1) {
					if (typeCheck == 1) {
						return 1;
					}
					else if (typeCheck == 2) {
						emp.SecondMenu(conn);
					}
				}
				
				else if (setPassBit == 2) {
					JOptionPane.showMessageDialog(null,"ID or PASSWORD doesn't match");
					Login(conn);
				}
				else if (setPassBit == 3) {
					JOptionPane.showMessageDialog(null, "Empty field.Write something.");
					Login(conn);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (result==JOptionPane.CANCEL_OPTION) {
			
			try {
				conn.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
			
		}
		return 0;
	}

}
