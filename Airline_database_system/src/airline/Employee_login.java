package airline;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Employee_login {
	
	
	/*public Employee_login() {

	}*/
	//static Login_Panel log = new Login_Panel();
	
	int SecondMenu(Database_Connector conn){ //function displaying table names
		JComboBox<String> cmb = new JComboBox<String>();
		cmb.addItem("Aircrafts");
		cmb.addItem("Flight");
		cmb.addItem("Customers");
		cmb.addItem("Passengers");
		cmb.addItem("Airfare");
		cmb.addItem("Ticket");
		cmb.addItem("Log Out");
		String query="";		
		int choice = 0;
		Object [] message = { "Enter your choice",cmb};
		int result = JOptionPane.showConfirmDialog(null, message, "Enter your choice ",JOptionPane.OK_CANCEL_OPTION);
		if(result==JOptionPane.CANCEL_OPTION){
			try {
				conn.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
		if(result==JOptionPane.OK_OPTION){
			choice = cmb.getSelectedIndex();
			if(choice==0)
				query = "select * from aircrafts";
			else if(choice==1)
				query = "select * from flight";
			else if (choice==2)
				query = "select * from customers";
			else if (choice==3)
				query = "select * from passengers";
			else if(choice==4)
				query = "select * from airfare";
			else if(choice==5)
				query = "select * from ticket";
			else if(choice==6)
				Login_Panel.Login(conn);
			ExecuteSQL(conn, query, choice); // function executing the query					
		}
		SecondMenu(conn);
		return choice;
	}
	

	public static void ExecuteSQL(Database_Connector conn, String s, Integer ch1){ // executing query for show records option
		// data structure required for JTable
		Vector<String> cnames = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		
		try {
			Statement stmt = conn.getConnection().createStatement() ;
			ResultSet rs = stmt.executeQuery(s);
			ResultSetMetaData rsmd = rs.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();
			for(int i=1; i<=columnsNumber; i++){
				cnames.addElement(rsmd.getColumnName(i));
			}
			while(rs.next()){
				Vector<String> row = new Vector<String>();
				for(int i=1; i<=columnsNumber; i++){
					row.addElement(rs.getString(i));
				}
				data.addElement(row);
			}
			DisplayTable(data,cnames,ch1); // function displaying result in a table format
			//GenerateReport(conn,s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(s.isEmpty())
				JOptionPane.showMessageDialog(null, "Empty Values");
			else
				JOptionPane.showMessageDialog(null, "Error in SQL");
			e.printStackTrace();
		}
	}
	
	public static void DisplayTable (Vector data, Vector cnames, Integer i){
		String caption = "";
		JPanel panel = new JPanel();
		JTable table = new JTable(data, cnames);
		JScrollPane scrollPane = new JScrollPane(table);
		
		panel.setLayout( new BorderLayout());
		//panel.setSize(2000,1700);
		panel.add(scrollPane, BorderLayout.CENTER);
		table.setPreferredSize(new Dimension(850,450));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		panel.setPreferredSize( new Dimension( 900, 500 ) );
		
		Object [] message = {panel};
		
		if(i==0)
			caption="Aircrafts Information";
		else if(i==1)
			caption="Flight Information";
		else if(i==2)
			caption="Customer Information";
		else if(i==3)
			caption="Passengers Information";
		else if(i==4)
			caption="Airfare Information";
		else if(i==5)
			caption="Ticket Information";
		else
			caption="Result Table";
		
		JOptionPane.showMessageDialog(null, message, caption, JOptionPane.INFORMATION_MESSAGE);
		
	}

	
}

