package airline;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import java.awt.event.ActionListener;

public class air extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_model;
	private JTextField txt_cap;
	private JTextField txtmfd_by;
	private JTextField txtmfd_on;
	private JTable tble;

	static Statement stmn;
	static Database_Connector conn = new Database_Connector();
	ResultSet Rs = null;
	static Login_Panel log = new Login_Panel();
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model1 = new DefaultTableModel();
	DefaultTableModel model2 = new DefaultTableModel();
	DefaultTableModel model3 = new DefaultTableModel();
	DefaultTableModel model4 = new DefaultTableModel();
	DefaultTableModel model5 = new DefaultTableModel();
	private JTextField txt_leaving;
	private JTextField txt_flight;
	private JTextField txt_going;
	private JTextField txt_deptime;
	private JTextField txt_depdate;
	private JTextField txt_arrivaltime;
	private JTextField txt_arrivadate;
	private JTextField txt_flightacid;
	private JTable tble_flight;
	private JTextField txt_csname;
	private JTextField txt_csid;
	private JTextField txt_csadrs;
	private JTextField txt_csage;
	private JTextField txt_cscellno;
	private JTable tble_cs;
	private JTextField txt_psname;
	private JTextField txt_psid;
	private JTextField txt_psadrs;
	private JTextField txt_psage;
	private JTextField txt_pscellno;
	private JTextField txt_pscsid;
	private JTable tble_ps;
	private JTextField txt_affare;
	private JTextField txt_afid;
	private JTextField txt_afclstype;
	private JTextField txt_afflightno;
	private JTable tble_af;
	private JTextField txt_tseatno;
	private JTextField txt_ttid;
	private JTextField txt_tafid;
	private JTextField txt_tcsid;
	private JTextField txt_tflightno;
	private JTable tble_tick;

	public static void main(String[] args) {

		log.Login(conn);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					air frame = new air();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public air() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Airline Database System");
		setBounds(100, 100, 992, 645);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		tble_cs = new JTable(model2);
		tble_flight = new JTable(model1);
		tble = new JTable(model);
		tble_ps = new JTable(model3);
		tble_af = new JTable(model4);
		tble_tick = new JTable(model5);
		try {
			ResultSet rs = null;
			Statement stmt = conn.getConnection().createStatement();
			rs = stmt.executeQuery("select * from aircrafts");
			ResultSetMetaData rsmd = rs.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();
			for (int i = 1; i <= columnsNumber; i++) {
				model.addColumn(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			ResultSet rs = null;
			Statement stmt = conn.getConnection().createStatement();
			rs = stmt.executeQuery("select * from flight");
			ResultSetMetaData rsmd = rs.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();
			for (int i = 1; i <= columnsNumber; i++) {
				model1.addColumn(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		try {
			ResultSet rs = null;
			Statement stmt = conn.getConnection().createStatement();
			rs = stmt.executeQuery("select * from customers");
			ResultSetMetaData rsmd = rs.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();
			for (int i = 1; i <= columnsNumber; i++) {
				model2.addColumn(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		try {
			ResultSet rs = null;
			Statement stmt = conn.getConnection().createStatement();
			rs = stmt.executeQuery("select * from passengers");
			ResultSetMetaData rsmd = rs.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();
			for (int i = 1; i <= columnsNumber; i++) {
				model3.addColumn(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			ResultSet rs = null;
			Statement stmt = conn.getConnection().createStatement();
			rs = stmt.executeQuery("select * from airfare");
			ResultSetMetaData rsmd = rs.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();
			for (int i = 1; i <= columnsNumber; i++) {
				model4.addColumn(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		try {
			ResultSet rs = null;
			Statement stmt = conn.getConnection().createStatement();
			rs = stmt.executeQuery("select * from ticket");
			ResultSetMetaData rsmd = rs.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();
			for (int i = 1; i <= columnsNumber; i++) {
				model5.addColumn(rsmd.getColumnLabel(i));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}


		/*
		 * model.addColumn("AC_ID"); model.addColumn("MODEL_NO");
		 * model.addColumn("CAPACITY"); model.addColumn("MFD_BY");
		 * model.addColumn("MFD_ON");
		 */

		try {
			stmn = conn.getConnection().createStatement();
			ResultSet res = stmn.executeQuery("select * from aircrafts");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			stmn = conn.getConnection().createStatement();
			ResultSet res = stmn.executeQuery("select * from flight");
		} catch (Exception e) {
			e.printStackTrace();
		}

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Aircrafts", null, panel, null);

		JLabel lbl_Ac_id = new JLabel();
		lbl_Ac_id.setText("AC_ID ");
		lbl_Ac_id.setFont(new Font("Calibri", Font.BOLD, 14));

		txt_id = new JTextField();
		txt_id.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_id.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtidActionPerformed(evt);
			}
		});

		JLabel lbl_mod = new JLabel();
		lbl_mod.setText("MODEL_NO");
		lbl_mod.setFont(new Font("Calibri", Font.BOLD, 14));

		txt_model = new JTextField();
		txt_model.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lbl_cap = new JLabel();
		lbl_cap.setText("CAPACITY");
		lbl_cap.setFont(new Font("Calibri", Font.BOLD, 14));

		txt_cap = new JTextField();
		txt_cap.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lbl_mfd_by = new JLabel();
		lbl_mfd_by.setText("MFD_BY");
		lbl_mfd_by.setFont(new Font("Calibri", Font.BOLD, 14));

		txtmfd_by = new JTextField();

		JLabel lbl_mfd_on = new JLabel();
		lbl_mfd_on.setText("MFD_ON");
		lbl_mfd_on.setFont(new Font("Calibri", Font.BOLD, 14));

		txtmfd_on = new JTextField();
		txtmfd_on.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane jScrollPane1 = new JScrollPane(tble);

		JButton btn_add = new JButton();
		btn_add.setText("Add");
		btn_add.setFont(new Font("Calibri", Font.BOLD, 14));
		btn_add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnaddActionPerformed(evt);
			}
		});

		JButton btn_dlt = new JButton();
		btn_dlt.setText("Delete");
		btn_dlt.setFont(new Font("Calibri", Font.BOLD, 14));

		btn_dlt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btndltActionPerformed(evt);
			}

		});

		JButton btn_show = new JButton();
		btn_show.setText("Show");
		btn_show.setFont(new Font("Calibri", Font.BOLD, 14));
		btn_show.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnshowActionPerformed(evt);
			}

		});

		JButton btn_mod = new JButton();
		btn_mod.setText("Modify");
		btn_mod.setFont(new Font("Calibri", Font.BOLD, 14));

		btn_mod.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnmodActionPerformed(evt);
			}

		});

		tble.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null } }, new String[] { "Title 1",
				"Title 2", "Title 3", "Title 4", "Title 5" }));
		tble.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbleMouseClicked(evt);
			}

		});

		tble.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(56)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addGap(36)
																								.addComponent(
																										lbl_Ac_id,
																										GroupLayout.PREFERRED_SIZE,
																										38,
																										GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						gl_panel.createParallelGroup(
																								Alignment.TRAILING)
																								.addComponent(
																										txt_model,
																										GroupLayout.PREFERRED_SIZE,
																										108,
																										GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										txt_id,
																										GroupLayout.PREFERRED_SIZE,
																										108,
																										GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										txt_cap,
																										GroupLayout.PREFERRED_SIZE,
																										108,
																										GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										txtmfd_by,
																										GroupLayout.PREFERRED_SIZE,
																										108,
																										GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										txtmfd_on,
																										GroupLayout.PREFERRED_SIZE,
																										108,
																										GroupLayout.PREFERRED_SIZE))))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(76)
																.addComponent(
																		lbl_mod,
																		GroupLayout.PREFERRED_SIZE,
																		68,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(81)
																.addComponent(
																		lbl_cap,
																		GroupLayout.PREFERRED_SIZE,
																		55,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(84)
																.addComponent(
																		lbl_mfd_by,
																		GroupLayout.PREFERRED_SIZE,
																		49,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(82)
																.addComponent(
																		lbl_mfd_on,
																		GroupLayout.PREFERRED_SIZE,
																		52,
																		GroupLayout.PREFERRED_SIZE)))
								.addGap(102)
								.addComponent(jScrollPane1,
										GroupLayout.PREFERRED_SIZE, 1051,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(22, Short.MAX_VALUE))
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap(517, Short.MAX_VALUE)
								.addComponent(btn_add,
										GroupLayout.PREFERRED_SIZE, 84,
										GroupLayout.PREFERRED_SIZE)
								.addGap(35)
								.addComponent(btn_dlt,
										GroupLayout.PREFERRED_SIZE, 108,
										GroupLayout.PREFERRED_SIZE)
								.addGap(34)
								.addComponent(btn_show,
										GroupLayout.PREFERRED_SIZE, 84,
										GroupLayout.PREFERRED_SIZE)
								.addGap(34)
								.addComponent(btn_mod,
										GroupLayout.PREFERRED_SIZE, 108,
										GroupLayout.PREFERRED_SIZE).addGap(335)));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(35)
								.addComponent(lbl_Ac_id,
										GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(txt_id,
										GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lbl_mod,
										GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txt_model,
										GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addGap(11)
								.addComponent(lbl_cap,
										GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txt_cap,
										GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lbl_mfd_by,
										GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtmfd_by,
										GroupLayout.PREFERRED_SIZE, 24,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lbl_mfd_on,
										GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE)
								.addGap(13)
								.addComponent(txtmfd_on,
										GroupLayout.PREFERRED_SIZE, 23,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(317, Short.MAX_VALUE))
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane1,
										GroupLayout.PREFERRED_SIZE, 411,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED,
										165, Short.MAX_VALUE)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														btn_add,
														GroupLayout.PREFERRED_SIZE,
														25,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														btn_dlt,
														GroupLayout.PREFERRED_SIZE,
														25,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														btn_show,
														GroupLayout.PREFERRED_SIZE,
														25,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														btn_mod,
														GroupLayout.PREFERRED_SIZE,
														25,
														GroupLayout.PREFERRED_SIZE))
								.addGap(55)));

		jScrollPane1.setViewportView(tble);
		panel.setLayout(gl_panel);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		tabbedPane.addTab("Flight", panel1);
		tabbedPane.addTab("Customers", panel2);
		tabbedPane.addTab("Passengers", panel3);
		tabbedPane.addTab("Airfare", panel4);
		tabbedPane.addTab("Ticket", panel5);
		
		JPanel panel_5 = new JPanel();
		panel5.add(panel_5);
		
		JLabel lblTid = new JLabel();
		lblTid.setText("T_ID");
		lblTid.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblCsid_2 = new JLabel();
		lblCsid_2.setText("CS_ID");
		lblCsid_2.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblAfid_1 = new JLabel();
		lblAfid_1.setText("AF_ID");
		lblAfid_1.setFont(new Font("Calibri", Font.BOLD, 14));
		
		txt_tseatno = new JTextField();
		txt_tseatno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_ttid = new JTextField();
		txt_ttid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_tafid = new JTextField();
		txt_tafid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_tcsid = new JTextField();
		
		JLabel lblSeatno = new JLabel();
		lblSeatno.setText("SEAT_NO");
		lblSeatno.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JScrollPane jsrollpane6 = new JScrollPane((Component) null);
		
		JButton btn_tadd = new JButton();
		btn_tadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btntaddActionPerformed(evt);
			}
		});
		btn_tadd.setText("Add");
		btn_tadd.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btn_tdlt = new JButton();
		btn_tdlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btntdltActionPerformed(evt);
			}
		});
		btn_tdlt.setText("Delete");
		btn_tdlt.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btn_tshow = new JButton();
		btn_tshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btntshowActionPerformed(evt);
			}
		});
		btn_tshow.setText("Show");
		btn_tshow.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btn_tmod = new JButton();
		btn_tmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btntmodActionPerformed(evt);
			}
		});
		btn_tmod.setText("Modify");
		btn_tmod.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblFlightno_2 = new JLabel();
		lblFlightno_2.setText("FLIGHT_NO");
		lblFlightno_2.setFont(new Font("Calibri", Font.BOLD, 14));
		
		txt_tflightno = new JTextField();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap(112, Short.MAX_VALUE)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(80)
									.addComponent(lblTid))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(74)
									.addComponent(lblCsid_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(56)
									.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txt_tseatno, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
										.addComponent(txt_ttid, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
										.addComponent(txt_tafid, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
										.addComponent(txt_tcsid, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
										.addComponent(txt_tflightno, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(82)
									.addComponent(lblSeatno, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(78)
									.addComponent(lblAfid_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(72)
									.addComponent(lblFlightno_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
							.addGap(102)
							.addComponent(jsrollpane6, GroupLayout.PREFERRED_SIZE, 1051, GroupLayout.PREFERRED_SIZE)
							.addGap(46))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(btn_tadd, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(btn_tdlt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(btn_tshow, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(btn_tmod, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(335))))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jsrollpane6, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(34)
							.addComponent(lblTid, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txt_ttid, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblSeatno, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(txt_tseatno, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblAfid_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_tafid, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblCsid_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_tcsid, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblFlightno_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txt_tflightno, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(156)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_tadd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_tdlt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_tshow, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_tmod, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(55))
		);
		
		
		jsrollpane6.setViewportView(tble_tick);
		panel_5.setLayout(gl_panel_5);
		
		tble_tick.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null } }, new String[] { "Title 1",
				"Title 2", "Title 3", "Title 4", "Title 5" }));
		tble_tick.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt ) {
				try {
					int i = tble_tick.getSelectedRow();
					TAuto_Replace(i);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "" + e.getMessage());
					e.printStackTrace();
				}
			}

		});
		

		tble_tick.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JPanel panel_4 = new JPanel();
		panel4.add(panel_4);
		
		JLabel lblFare = new JLabel();
		lblFare.setText("FARE");
		lblFare.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblAfid = new JLabel();
		lblAfid.setText("AF_ID");
		lblAfid.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblFlightno_1 = new JLabel();
		lblFlightno_1.setText("FLIGHT_NO");
		lblFlightno_1.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblClstype = new JLabel();
		lblClstype.setText("CLS_TYPE");
		lblClstype.setFont(new Font("Calibri", Font.BOLD, 14));
		
		txt_affare = new JTextField();
		txt_affare.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_afid = new JTextField();
		txt_afid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_afclstype = new JTextField();
		txt_afclstype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_afflightno = new JTextField();
		
		JScrollPane jscrollpane5 = new JScrollPane((Component) null);
		
		JButton btn_afadd = new JButton();
		btn_afadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnafaddActionPerformed(evt);
			}
		});
		btn_afadd.setText("Add");
		btn_afadd.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btn_afdlt = new JButton();
		btn_afdlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnafdltActionPerformed(evt);
			}
		});
		btn_afdlt.setText("Delete");
		btn_afdlt.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btn_afshow = new JButton();
		btn_afshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnafshowActionPerformed(evt);
			}
		});
		btn_afshow.setText("Show");
		btn_afshow.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btn_afmod = new JButton();
		btn_afmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnafmodActionPerformed(evt);
			}
		});
		btn_afmod.setText("Modify");
		btn_afmod.setFont(new Font("Calibri", Font.BOLD, 14));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1419, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(112, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(80)
									.addComponent(lblAfid))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(74)
									.addComponent(lblFlightno_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(56)
									.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_4.createSequentialGroup()
											.addGap(10)
											.addComponent(lblClstype, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txt_affare, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
											.addComponent(txt_afid, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
											.addComponent(txt_afclstype, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
											.addComponent(txt_afflightno, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))))
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGap(82)
									.addComponent(lblFare, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
							.addGap(102)
							.addComponent(jscrollpane5, GroupLayout.PREFERRED_SIZE, 1051, GroupLayout.PREFERRED_SIZE)
							.addGap(46))
						.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
							.addComponent(btn_afadd, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(btn_afdlt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(btn_afshow, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(btn_afmod, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(335))))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 662, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jscrollpane5, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(34)
							.addComponent(lblAfid, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txt_afid, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblFare, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(txt_affare, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblClstype, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_afclstype, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblFlightno_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_afflightno, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(156)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_afadd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_afdlt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_afshow, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_afmod, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(55))
		);
		
		
		jscrollpane5.setViewportView(tble_af);
		panel_4.setLayout(gl_panel_4);
		
		tble_af.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null } }, new String[] { "Title 1",
				"Title 2", "Title 3", "Title 4", "Title 5" }));
		tble_af.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbleafMouseClicked(evt);
			}

		});

		tble.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JPanel panel_3 = new JPanel();
		panel3.add(panel_3);
		
		JLabel lblPsname = new JLabel();
		lblPsname.setText("PS_NAME");
		lblPsname.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblPsid = new JLabel();
		lblPsid.setText("PS_ID");
		lblPsid.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblPsage = new JLabel();
		lblPsage.setText("PS_AGE");
		lblPsage.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblPscellno = new JLabel();
		lblPscellno.setText("PS_CELLNO");
		lblPscellno.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblPsaddress = new JLabel();
		lblPsaddress.setText("PS_ADDRESS");
		lblPsaddress.setFont(new Font("Calibri", Font.BOLD, 14));
		
		txt_psname = new JTextField();
		txt_psname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_psid = new JTextField();
		txt_psid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_psadrs = new JTextField();
		txt_psadrs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_psage = new JTextField();
		
		txt_pscellno = new JTextField();
		txt_pscellno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane jsrollpane4 = new JScrollPane((Component) null);
		
		JButton btn_psadd = new JButton();
		btn_psadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnpsaddActionPerformed(evt);
			}
		});
		btn_psadd.setText("Add");
		btn_psadd.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btn_psdlt = new JButton();
		btn_psdlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnpsdltActionPerformed(evt);
			}
		});
		btn_psdlt.setText("Delete");
		btn_psdlt.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btn_psshow = new JButton();
		btn_psshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnpsshowActionPerformed(evt);
			}
		});
		btn_psshow.setText("Show");
		btn_psshow.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton btn_psmod = new JButton();
		btn_psmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnpsmodActionPerformed(evt);
			}
		});
		btn_psmod.setText("Modify");
		btn_psmod.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblCsid_1 = new JLabel();
		lblCsid_1.setText("CS_ID");
		lblCsid_1.setFont(new Font("Calibri", Font.BOLD, 14));
		
		txt_pscsid = new JTextField();
		txt_pscsid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(56)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(68)
									.addComponent(lblPsname, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(80)
									.addComponent(lblPsid))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(74)
									.addComponent(lblPsage, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(76)
									.addComponent(lblPscellno))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(56)
									.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_3.createSequentialGroup()
											.addGap(10)
											.addComponent(lblPsaddress, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txt_psname, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
											.addComponent(txt_psid, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
											.addComponent(txt_psadrs, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
											.addComponent(txt_psage, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
											.addComponent(txt_pscellno, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
											.addComponent(txt_pscsid, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))))
							.addGap(102))
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblCsid_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(121)))
					.addComponent(jsrollpane4, GroupLayout.PREFERRED_SIZE, 1051, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(597, Short.MAX_VALUE)
					.addComponent(btn_psadd, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(btn_psdlt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btn_psshow, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btn_psmod, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(335))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jsrollpane4, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(34)
							.addComponent(lblPsid, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txt_psid, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblPsname, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(txt_psname, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblPsaddress, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_psadrs, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblPsage, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_psage, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblPscellno, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(txt_pscellno, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblCsid_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txt_pscsid, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(156)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_psadd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_psdlt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_psshow, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_psmod, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(55))
		);
		
		
		jsrollpane4.setViewportView(tble_ps);
		panel_3.setLayout(gl_panel_3);
		
		tble_ps.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null } }, new String[] { "Title 1",
				"Title 2", "Title 3", "Title 4", "Title 5" }));
		tble_ps.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblepsMouseClicked(evt);
			}

		});

		tble.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		
		JPanel panel_2 = new JPanel();
		panel2.add(panel_2);
		
		JLabel lblCsname = new JLabel();
		lblCsname.setText("CS_NAME");
		lblCsname.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblCsid = new JLabel();
		lblCsid.setText("CS_ID");
		lblCsid.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblcsaddrs = new JLabel();
		lblcsaddrs.setText("CS_ADDRESS");
		lblcsaddrs.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblcsage = new JLabel();
		lblcsage.setText("CS_AGE");
		lblcsage.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JLabel lblCscellno = new JLabel();
		lblCscellno.setText("CS_CELLNO");
		lblCscellno.setFont(new Font("Calibri", Font.BOLD, 14));
		
		txt_csname = new JTextField();
		txt_csname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_csid = new JTextField();
		txt_csid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_csadrs = new JTextField();
		txt_csadrs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_csage = new JTextField();
		
		txt_cscellno = new JTextField();
		txt_cscellno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane jsrollpane3 = new JScrollPane((Component) null);
		
		JButton cs_add = new JButton();
		cs_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btncsaddActionPerformed(evt);
			}
		});
		cs_add.setText("Add");
		cs_add.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton cs_dlt = new JButton();
		cs_dlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btncsdltActionPerformed(evt);
			}
		});
		cs_dlt.setText("Delete");
		cs_dlt.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton cs_show = new JButton();
		cs_show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btncsshowActionPerformed(evt);
			}
		});
		cs_show.setText("Show");
		cs_show.setFont(new Font("Calibri", Font.BOLD, 14));
		
		JButton cs_mod = new JButton();
		cs_mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btncsmodActionPerformed(evt);
			}
		});
		cs_mod.setText("Modify");
		cs_mod.setFont(new Font("Calibri", Font.BOLD, 14));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1419, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(68)
							.addComponent(lblCsname, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(80)
							.addComponent(lblCsid))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(74)
							.addComponent(lblcsage, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(76)
							.addComponent(lblCscellno))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(56)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(10)
									.addComponent(lblcsaddrs, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
									.addComponent(txt_csname, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
									.addComponent(txt_csid, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
									.addComponent(txt_csadrs, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
									.addComponent(txt_csage, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
									.addComponent(txt_cscellno, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))))
					.addGap(102)
					.addComponent(jsrollpane3, GroupLayout.PREFERRED_SIZE, 1051, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(597, Short.MAX_VALUE)
					.addComponent(cs_add, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(cs_dlt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(cs_show, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(cs_mod, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(335))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 667, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jsrollpane3, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(34)
							.addComponent(lblCsid, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txt_csid, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblCsname, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(txt_csname, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblcsaddrs, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_csadrs, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblcsage, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_csage, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblCscellno, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(txt_cscellno, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(160)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(cs_add, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(cs_dlt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(cs_show, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(cs_mod, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(55))
		);
		
		jsrollpane3.setViewportView(tble_cs);
		panel_2.setLayout(gl_panel_2);
		JPanel panel_1 = new JPanel();
		panel1.add(panel_1);
		
		
		tble_cs.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null } }, new String[] { "Title 1",
				"Title 2", "Title 3", "Title 4", "Title 5" }));
		tble_cs.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblecsMouseClicked(evt);
			}

		});

		tble_cs.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


		JLabel lblFlightno = new JLabel();
		lblFlightno.setText("FLIGHT_NO");
		lblFlightno.setFont(new Font("Calibri", Font.BOLD, 14));

		txt_leaving = new JTextField();
		txt_leaving.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_flight = new JTextField();
		txt_flight.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_going = new JTextField();
		txt_going.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_deptime = new JTextField();

		txt_depdate = new JTextField();
		txt_depdate.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblLeavingfrom = new JLabel();
		lblLeavingfrom.setText("LEAVING_FROM");
		lblLeavingfrom.setFont(new Font("Calibri", Font.BOLD, 14));

		JLabel lblGoingto = new JLabel();
		lblGoingto.setText("GOING_TO");
		lblGoingto.setFont(new Font("Calibri", Font.BOLD, 14));

		JLabel lblDeptime = new JLabel();
		lblDeptime.setText("DEP_TIME");
		lblDeptime.setFont(new Font("Calibri", Font.BOLD, 14));

		JLabel lblDepdate = new JLabel();
		lblDepdate.setText("DEP_DATE");
		lblDepdate.setFont(new Font("Calibri", Font.BOLD, 14));

		JButton btn_flightadd = new JButton();
		btn_flightadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnflightaddActionPerformed(evt);
			}
		});
		btn_flightadd.setText("Add");
		btn_flightadd.setFont(new Font("Calibri", Font.BOLD, 14));

		JButton btn_flightdlt = new JButton();
		btn_flightdlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnflightdltActionPerformed(evt);
			}
		});
		btn_flightdlt.setText("Delete");
		btn_flightdlt.setFont(new Font("Calibri", Font.BOLD, 14));

		JButton btn_flightshow = new JButton();
		btn_flightshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnflightshowActionPerformed(evt);				
			}
		});
		btn_flightshow.setText("Show");
		btn_flightshow.setFont(new Font("Calibri", Font.BOLD, 14));

		JButton btn_flightmod = new JButton();
		btn_flightmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnflightmodActionPerformed(evt);
			}
		});
		btn_flightmod.setText("Modify");
		btn_flightmod.setFont(new Font("Calibri", Font.BOLD, 14));

		JLabel lblArrivaltime = new JLabel();
		lblArrivaltime.setText("ARRIVAL_TIME");
		lblArrivaltime.setFont(new Font("Calibri", Font.BOLD, 14));

		txt_arrivaltime = new JTextField();

		JLabel lblArrivaldate = new JLabel();
		lblArrivaldate.setText("ARRIVAL_DATE");
		lblArrivaldate.setFont(new Font("Calibri", Font.BOLD, 14));

		txt_arrivadate = new JTextField();
		txt_arrivadate.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lbl_flightAcid = new JLabel();
		lbl_flightAcid.setText("AC_ID");
		lbl_flightAcid.setFont(new Font("Calibri", Font.BOLD, 14));

		txt_flightacid = new JTextField();
		txt_flightacid.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane jscrollpane2 = new JScrollPane((Component) null);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(56)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addGroup(
																								gl_panel_1
																										.createSequentialGroup()
																										.addGap(68)
																										.addComponent(
																												lblLeavingfrom,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE))
																						.addGroup(
																								gl_panel_1
																										.createSequentialGroup()
																										.addGap(80)
																										.addComponent(
																												lblFlightno))
																						.addGroup(
																								gl_panel_1
																										.createSequentialGroup()
																										.addGap(81)
																										.addComponent(
																												lblGoingto,
																												GroupLayout.PREFERRED_SIZE,
																												72,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_panel_1
																										.createSequentialGroup()
																										.addGap(74)
																										.addComponent(
																												lblDeptime,
																												GroupLayout.PREFERRED_SIZE,
																												70,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_panel_1
																										.createSequentialGroup()
																										.addGap(76)
																										.addComponent(
																												lblDepdate))
																						.addGroup(
																								gl_panel_1
																										.createSequentialGroup()
																										.addGap(56)
																										.addGroup(
																												gl_panel_1
																														.createParallelGroup(
																																Alignment.LEADING,
																																false)
																														.addComponent(
																																txt_leaving,
																																Alignment.TRAILING,
																																GroupLayout.DEFAULT_SIZE,
																																108,
																																Short.MAX_VALUE)
																														.addComponent(
																																txt_flight,
																																Alignment.TRAILING,
																																GroupLayout.DEFAULT_SIZE,
																																108,
																																Short.MAX_VALUE)
																														.addComponent(
																																txt_going,
																																Alignment.TRAILING,
																																GroupLayout.DEFAULT_SIZE,
																																108,
																																Short.MAX_VALUE)
																														.addComponent(
																																txt_deptime,
																																Alignment.TRAILING,
																																GroupLayout.DEFAULT_SIZE,
																																108,
																																Short.MAX_VALUE)
																														.addComponent(
																																txt_depdate,
																																Alignment.TRAILING,
																																GroupLayout.DEFAULT_SIZE,
																																108,
																																Short.MAX_VALUE)
																														.addComponent(
																																txt_arrivaltime,
																																Alignment.TRAILING)
																														.addComponent(
																																txt_arrivadate,
																																GroupLayout.PREFERRED_SIZE,
																																108,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																txt_flightacid,
																																GroupLayout.PREFERRED_SIZE,
																																108,
																																GroupLayout.PREFERRED_SIZE))))
																		.addGap(102))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(122)
																		.addComponent(
																				lblArrivaltime,
																				GroupLayout.DEFAULT_SIZE,
																				108,
																				Short.MAX_VALUE)
																		.addGap(92)))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(jscrollpane2,
												GroupLayout.PREFERRED_SIZE,
												1051,
												GroupLayout.PREFERRED_SIZE)
										.addGap(46))
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addContainerGap(597, Short.MAX_VALUE)
										.addComponent(btn_flightadd,
												GroupLayout.PREFERRED_SIZE, 84,
												GroupLayout.PREFERRED_SIZE)
										.addGap(35)
										.addComponent(btn_flightdlt,
												GroupLayout.PREFERRED_SIZE,
												108, GroupLayout.PREFERRED_SIZE)
										.addGap(34)
										.addComponent(btn_flightshow,
												GroupLayout.PREFERRED_SIZE, 84,
												GroupLayout.PREFERRED_SIZE)
										.addGap(34)
										.addComponent(btn_flightmod,
												GroupLayout.PREFERRED_SIZE,
												108, GroupLayout.PREFERRED_SIZE)
										.addGap(335))
						.addGroup(
								gl_panel_1.createSequentialGroup().addGap(123)
										.addComponent(lblArrivaldate)
										.addContainerGap(1208, Short.MAX_VALUE))
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(143)
										.addComponent(lbl_flightAcid,
												GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(1223, Short.MAX_VALUE)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addContainerGap(
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jscrollpane2,
																				GroupLayout.PREFERRED_SIZE,
																				411,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(34)
																		.addComponent(
																				lblFlightno,
																				GroupLayout.PREFERRED_SIZE,
																				17,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				txt_flight,
																				GroupLayout.PREFERRED_SIZE,
																				24,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				lblLeavingfrom,
																				GroupLayout.PREFERRED_SIZE,
																				17,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(11)
																		.addComponent(
																				txt_leaving,
																				GroupLayout.PREFERRED_SIZE,
																				25,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(11)
																		.addComponent(
																				lblGoingto,
																				GroupLayout.PREFERRED_SIZE,
																				17,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				txt_going,
																				GroupLayout.PREFERRED_SIZE,
																				23,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				lblDeptime,
																				GroupLayout.PREFERRED_SIZE,
																				17,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				txt_deptime,
																				GroupLayout.PREFERRED_SIZE,
																				24,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				lblDepdate,
																				GroupLayout.PREFERRED_SIZE,
																				17,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(13)
																		.addComponent(
																				txt_depdate,
																				GroupLayout.PREFERRED_SIZE,
																				23,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				lblArrivaltime,
																				GroupLayout.PREFERRED_SIZE,
																				17,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				txt_arrivaltime,
																				GroupLayout.PREFERRED_SIZE,
																				24,
																				GroupLayout.PREFERRED_SIZE)))
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																Alignment.LEADING,
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(18)
																		.addComponent(
																				lblArrivaldate,
																				GroupLayout.PREFERRED_SIZE,
																				17,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(11)
																		.addComponent(
																				txt_arrivadate,
																				GroupLayout.PREFERRED_SIZE,
																				23,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				lbl_flightAcid,
																				GroupLayout.PREFERRED_SIZE,
																				17,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				txt_flightacid,
																				GroupLayout.PREFERRED_SIZE,
																				23,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap())
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGap(160)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								btn_flightadd,
																								GroupLayout.PREFERRED_SIZE,
																								25,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btn_flightdlt,
																								GroupLayout.PREFERRED_SIZE,
																								25,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btn_flightshow,
																								GroupLayout.PREFERRED_SIZE,
																								25,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btn_flightmod,
																								GroupLayout.PREFERRED_SIZE,
																								25,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(55)))));

		tble_flight = new JTable();
		tble_flight.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null } }, new String[] { "Title 1",
				"Title 2", "Title 3", "Title 4", "Title 5" }));
		tble_flight.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt ) {
				try {
					int i = tble_flight.getSelectedRow();
					flightAuto_Replace(i);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "" + e.getMessage());
					e.printStackTrace();
				}
			}

		});

		tble_flight.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);		
		
		jscrollpane2.setViewportView(tble_flight);
		panel_1.setLayout(gl_panel_1);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println("Tab: " + tabbedPane.getSelectedIndex());

			}
		});

	}
	
	protected void TAuto_Replace(int i) {
		// TODO Auto-generated method stub
		try {

			txt_ttid.setText(model5.getValueAt(i, 0).toString());
			txt_tseatno.setText(model5.getValueAt(i, 1).toString());
			txt_tafid.setText(model5.getValueAt(i, 2).toString());
			txt_tcsid.setText(model5.getValueAt(i, 3).toString());
			txt_tflightno.setText(model5.getValueAt(i, 4).toString());
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
	}

	protected void btntmodActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		try {
			if (JOptionPane.showConfirmDialog(null, "Are you sure?",
					"modification", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

				stmn.executeQuery("UPDATE ticket SET seat_no='"
						+ txt_tseatno.getText().toString() + "',af_id='"
						+ txt_tafid.getText().toString() + "',cs_id='"
						+ txt_tcsid.getText().toString() + "',flight_no='"
						+ txt_tflightno.getText().toString() + "' WHERE t_id= '"
						+ txt_ttid.getText().toString() + "'");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		btnshowActionPerformed(evt);
		
	}

	protected void btntshowActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		ResultSet res = null;
		Vector<String> cnames = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			model5.setRowCount(0);
			res = stmn.executeQuery("select * from ticket");
			ResultSetMetaData rsmd = res.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();

			while (res.next()) {
				Vector<String> row = new Vector<String>();
				for (int i = 1; i <= columnsNumber; i++) {
					row.addElement(res.getString(i));
				}
				model5.addRow(row);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		tble_tick.setModel(model5);
	}

	protected void btntdltActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		try {
			if (JOptionPane.showConfirmDialog(null,
					"Attention!!data maybe lost forever!!", "Are u sure?",
					JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)

				if (txt_ttid.getText().length() != 0) {
					stmn.executeQuery("Delete From ticket where t_id = '"
							+ txt_ttid.getText().toString() + "'");
					JOptionPane.showMessageDialog(null, "Deleted");
				} else {
					JOptionPane.showMessageDialog(null, "Empty field !");
				}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		btntshowActionPerformed(evt);
		// TODO add your handling code here:
	}
		
	

	protected void btntaddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String tt_id  = txt_ttid.getText();
		String seat_no = txt_tseatno.getText();
		String taf_id = txt_tafid.getText();
		String tcs_id = txt_tcsid.getText();
		String tflight_no = txt_tflightno.getText();

		String req = "INSERT INTO ticket VALUES('" + tt_id+ "','"
				+ seat_no + "','" + taf_id + "','" + tcs_id + "','" + tflight_no
				+ "')";
		try {
			// stmn = conn.getConnection().createStatement();
			// stm.executeQuery(req);
			stmn.executeUpdate(req);
			JOptionPane.showMessageDialog(null, "Added succesfully!");
			txt_ttid.setText("");
			txt_tseatno.setText("");
			txt_tafid.setText("");
			txt_tcsid.setText("");
			txt_tflightno.setText("");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
	}

	protected void btnafmodActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		try {
			if (JOptionPane.showConfirmDialog(null, "Are you sure?",
					"modification", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

				stmn.executeQuery("UPDATE airfare SET fare='"
						+ txt_affare.getText().toString() + "',cls_type='"
						+ txt_afclstype.getText().toString() + "',flight_no='"
						+ txt_afflightno.getText().toString() + "' WHERE af_id= '"
						+ txt_afid.getText().toString() + "'");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		btnshowActionPerformed(evt);
	}

	protected void btnafshowActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		ResultSet res = null;
		Vector<String> cnames = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			model4.setRowCount(0);
			res = stmn.executeQuery("select * from airfare");
			ResultSetMetaData rsmd = res.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();

			while (res.next()) {
				Vector<String> row = new Vector<String>();
				for (int i = 1; i <= columnsNumber; i++) {
					row.addElement(res.getString(i));
				}
				model4.addRow(row);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		tble_af.setModel(model4);
		
	}

	protected void btnafdltActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		try {
			if (JOptionPane.showConfirmDialog(null,
					"Attention!!data maybe lost forever!!", "Are u sure?",
					JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)

				if (txt_afid.getText().length() != 0) {
					stmn.executeQuery("Delete From aircrafts where af_id = '"
							+ txt_afid.getText().toString() + "'");
					JOptionPane.showMessageDialog(null, "Deleted");
				} else {
					JOptionPane.showMessageDialog(null, "Empty field !");
				}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		btnafshowActionPerformed(evt);
	}

	protected void btnafaddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String af_id = txt_afid.getText();
		String fare = txt_affare.getText();
		String cls_type = txt_afclstype.getText();
		String flight_no = txt_afflightno.getText();
		

		String req = "INSERT INTO airfare VALUES('" + af_id + "','"
				+ fare + "','" + cls_type + "','" + flight_no + "','" + "')";
		try {
			// stmn = conn.getConnection().createStatement();
			// stm.executeQuery(req);
			stmn.executeUpdate(req);
			JOptionPane.showMessageDialog(null, "Added succesfully!");
			txt_afid.setText("");
			txt_affare.setText("");
			txt_afclstype.setText("");
			txt_afflightno.setText("");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
	}

	protected void tbleafMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		try {
			int i = tble_af.getSelectedRow();
			AFAuto_Replace(i);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
	}
	private void AFAuto_Replace(int i) {
		try {

			txt_afid.setText(model4.getValueAt(i, 0).toString());
			txt_affare.setText(model4.getValueAt(i, 1).toString());
			txt_afclstype.setText(model4.getValueAt(i, 2).toString());
			txt_afflightno.setText(model4.getValueAt(i, 3).toString());
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
	}

	protected void btnpsmodActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		try {
			if (JOptionPane.showConfirmDialog(null, "Are you sure?",
					"modification", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

				stmn.executeQuery("UPDATE passengers SET ps_name='"
						+ txt_psname.getText().toString() + "',ps_adrs='"
						+ txt_psadrs.getText().toString() + "',ps_age='"
						+ txt_psage.getText().toString() + "',ps_cellno='"
						+ txt_pscellno.getText().toString() + "',cs_id='"
						+ txt_pscsid.getText().toString() + "' WHERE ps_id= '"
						+ txt_psid.getText().toString() + "'");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		btnshowActionPerformed(evt);
		
	}

	protected void btnpsshowActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		ResultSet res = null;
		Vector<String> cnames = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			model3.setRowCount(0);
			res = stmn.executeQuery("select * from passengers");
			ResultSetMetaData rsmd = res.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();

			while (res.next()) {
				Vector<String> row = new Vector<String>();
				for (int i = 1; i <= columnsNumber; i++) {
					row.addElement(res.getString(i));
				}
				model3.addRow(row);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		tble_ps.setModel(model3);
		
	}

	protected void btnpsdltActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		try {
			if (JOptionPane.showConfirmDialog(null,
					"Attention!!data maybe lost forever!!", "Are u sure?",
					JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)

				if (txt_id.getText().length() != 0) {
					stmn.executeQuery("Delete From passengers where ac_id = '"
							+ txt_psid.getText().toString() + "'");
					JOptionPane.showMessageDialog(null, "Deleted");
				} else {
					JOptionPane.showMessageDialog(null, "Empty field !");
				}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		btnpsshowActionPerformed(evt);
	}

	protected void btnpsaddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String ps_id = txt_psid.getText();
		String ps_name = txt_psname.getText();
		String ps_adrs = txt_psadrs.getText();
		String ps_age = txt_psage.getText();
		String ps_cellno = txt_pscellno.getText();
		String ps_csid = txt_pscsid.getText();

		String req = "INSERT INTO passengers VALUES('" + ps_id + "','"
				+ ps_name + "','" + ps_adrs + "','" + ps_age + "','" + ps_cellno + "','"+ ps_csid 
				+ "')";
		try {
			// stmn = conn.getConnection().createStatement();
			// stm.executeQuery(req);
			stmn.executeUpdate(req);
			JOptionPane.showMessageDialog(null, "Added succesfully!");
			txt_psid.setText("");
			txt_psname.setText("");
			txt_psadrs.setText("");
			txt_psage.setText("");
			txt_pscellno.setText("");
			txt_pscsid.setText("");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}

		
	}

	protected void tblepsMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		try {
			int i = tble_ps.getSelectedRow();
			PSAuto_Replace(i);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void PSAuto_Replace(int i) {
		try {

			txt_psid.setText(model3.getValueAt(i, 0).toString());
			txt_psname.setText(model3.getValueAt(i, 1).toString());
			txt_psadrs.setText(model3.getValueAt(i, 2).toString());
			txt_psage.setText(model3.getValueAt(i, 3).toString());
			txt_pscellno.setText(model3.getValueAt(i, 4).toString());
			txt_pscsid.setText(model3.getValueAt(i, 5).toString());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
	}


	protected void btncsmodActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		try {
			if (JOptionPane.showConfirmDialog(null, "Are you sure?",
					"modification", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

				stmn.executeQuery("UPDATE customers SET cs_name='"
						+ txt_csname.getText().toString() + "',cs_address='"
						+ txt_csadrs.getText().toString() + "',cs_age='"
						+ txt_csage.getText().toString() + "',cs_cellno='"
						+ txt_cscellno.getText().toString() + "' WHERE cs_id= '"
						+ txt_csid.getText().toString() + "'");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		btncsshowActionPerformed(evt);
		
	}

	protected void btncsshowActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		ResultSet res = null;
		Vector<String> cnames = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			model2.setRowCount(0);
			res = stmn.executeQuery("select * from customers");
			ResultSetMetaData rsmd = res.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();

			while (res.next()) {
				Vector<String> row = new Vector<String>();
				for (int i = 1; i <= columnsNumber; i++) {
					row.addElement(res.getString(i));
				}
				model2.addRow(row);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		tble_cs.setModel(model2);
		
	}

	protected void btncsdltActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		try {
			if (JOptionPane.showConfirmDialog(null,
					"Attention!!data maybe lost forever!!", "Are u sure?",
					JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)

				if (txt_id.getText().length() != 0) {
					stmn.executeQuery("Delete From customers where cs_id = '"
							+ txt_csid.getText().toString() + "'");
					JOptionPane.showMessageDialog(null, "Deleted");
				} else {
					JOptionPane.showMessageDialog(null, "Empty field !");
				}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		btncsshowActionPerformed(evt);
		
	}

	protected void tblecsMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		try {
			int i = tble_cs.getSelectedRow();
			CSAuto_Replace(i);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private void CSAuto_Replace(int i) {
		try {

			txt_csid.setText(model2.getValueAt(i, 0).toString());
			txt_csname.setText(model2.getValueAt(i, 1).toString());
			txt_csadrs.setText(model2.getValueAt(i, 2).toString());
			txt_csage.setText(model2.getValueAt(i, 3).toString());
			txt_cscellno.setText(model2.getValueAt(i, 4).toString());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
	}

	protected void btncsaddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String cs_id = txt_csid.getText();
		String cs_name = txt_csname.getText();
		String cs_adrs = txt_csadrs.getText();
		String cs_age = txt_csage.getText();
		String cs_cscellno = txt_cscellno.getText();
		

		String req = "INSERT INTO customers VALUES('" + cs_id + "','"
				+ cs_name + "','" + cs_adrs + "','" + cs_age + "','" + cs_cscellno
				+ "')";
		try {
			// stmn = conn.getConnection().createStatement();
			// stm.executeQuery(req);
			stmn.executeUpdate(req);
			JOptionPane.showMessageDialog(null, "Added succesfully!");
			txt_csid.setText("");
			txt_csname.setText("");
			txt_csadrs.setText("");
			txt_csage.setText("");
			txt_cscellno.setText("");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}

	}

	private void flightAuto_Replace(int i) {
		try {

			txt_flight.setText(model1.getValueAt(i, 0).toString());
			txt_leaving.setText(model1.getValueAt(i, 1).toString());
			txt_going.setText(model1.getValueAt(i, 2).toString());
			txt_deptime.setText(model1.getValueAt(i, 3).toString());
			txt_depdate.setText(model1.getValueAt(i, 4).toString());
			txt_arrivaltime.setText(model1.getValueAt(i, 5).toString());
			txt_arrivadate.setText(model1.getValueAt(i, 6).toString());
			txt_flightacid.setText(model1.getValueAt(i, 7).toString());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
	}

	
	private void btnflightshowActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		ResultSet res = null;
		Vector<String> cnames = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			model1.setRowCount(0);
			res = stmn.executeQuery("select * from flight");
			ResultSetMetaData rsmd = res.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();

			while (res.next()) {
				Vector<String> row = new Vector<String>();
				for (int i = 1; i <= columnsNumber; i++) {
					row.addElement(res.getString(i));
				}
				model1.addRow(row);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		tble_flight.setModel(model1);
		
	}

	private void btnflightdltActionPerformed(ActionEvent evt) {
		try {
			if (JOptionPane.showConfirmDialog(null,
					"Attention!!data maybe lost forever!!", "Are u sure?",
					JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)

				if (txt_flight.getText().length() != 0) {
					stmn.executeQuery("Delete From flight where flight_no = '"
							+ txt_flight.getText().toString() + "'");
					JOptionPane.showMessageDialog(null, "Deleted");
				} else {
					JOptionPane.showMessageDialog(null, "Empty field !");
				}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}

		btnflightshowActionPerformed(evt);
	}

	private void btnflightaddActionPerformed(ActionEvent arg0) {
		
		String flight_no = txt_flight.getText();
		String leaving_from = txt_leaving.getText();
		String going_to = txt_going.getText();
		String dep_time = txt_deptime.getText();
		String dep_date = txt_depdate.getText();
		String arrival_time = txt_arrivaltime.getText();
		String arrival_date = txt_arrivadate.getText();
		String flight_acid = txt_flightacid.getText();

		String req = "INSERT INTO flight VALUES('" + flight_no
				+ "','" + leaving_from + "','" + going_to + "','"
				+ dep_time + "','" + dep_date
				+ "','" + arrival_time + "','" + arrival_date + "','"
				+ flight_acid + "')";
		try {
			// stmn = conn.getConnection().createStatement();
			// stm.executeQuery(req);
			stmn.executeUpdate(req);
			JOptionPane.showMessageDialog(null, "Added succesfully!");
			txt_id.setText("");
			txt_model.setText("");
			txt_cap.setText("");
			txtmfd_on.setText("");
			txtmfd_by.setText("");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}

	}

	private void btnflightmodActionPerformed(ActionEvent evt) {
		
		try {
			if (JOptionPane.showConfirmDialog(null, "Are you sure?",
					"modification", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

				stmn.executeQuery("UPDATE flight SET leaving_from='"
						+ txt_leaving.getText().toString() + "',going_to='"
						+ txt_going.getText().toString() + "',dep_time='"
						+ txt_deptime.getText().toString() + "',dep_date='"
						+ txt_depdate.getText().toString() + "',arrival_time='"
						+ txt_arrivaltime.getText().toString() + "',arrival_date='"
						+ txt_arrivadate.getText().toString() + "',ac_id='"
						+ txt_flightacid.getText().toString() + "' WHERE flight_no= '"
						+ txt_flight.getText().toString() + "'");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		btnflightshowActionPerformed(evt);
		
	}

	private void Auto_Replace(int i) {
		try {

			txt_id.setText(model.getValueAt(i, 0).toString());
			txt_model.setText(model.getValueAt(i, 1).toString());
			txt_cap.setText(model.getValueAt(i, 2).toString());
			txtmfd_by.setText(model.getValueAt(i, 3).toString());
			txtmfd_on.setText(model.getValueAt(i, 4).toString());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
	}

	private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {
		String AC_ID = txt_id.getText();
		String MODEL_NO = txt_model.getText();
		String CAPACITY = txt_cap.getText();
		String MFD_BY = txtmfd_by.getText();
		String MFD_ON = txtmfd_on.getText();

		String req = "INSERT INTO aircrafts VALUES('" + AC_ID + "','"
				+ MODEL_NO + "','" + CAPACITY + "','" + MFD_BY + "','" + MFD_ON
				+ "')";
		try {
			// stmn = conn.getConnection().createStatement();
			// stm.executeQuery(req);
			stmn.executeUpdate(req);
			JOptionPane.showMessageDialog(null, "Added succesfully!");
			txt_id.setText("");
			txt_model.setText("");
			txt_cap.setText("");
			txtmfd_on.setText("");
			txtmfd_by.setText("");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
	}

	private void btnshowActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		ResultSet res = null;
		Vector<String> cnames = new Vector<String>();
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		try {
			model.setRowCount(0);
			res = stmn.executeQuery("select * from aircrafts");
			ResultSetMetaData rsmd = res.getMetaData();
			Integer columnsNumber = rsmd.getColumnCount();

			while (res.next()) {
				Vector<String> row = new Vector<String>();
				for (int i = 1; i <= columnsNumber; i++) {
					row.addElement(res.getString(i));
				}
				model.addRow(row);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		tble.setModel(model);
	}

	private void tbleMouseClicked(java.awt.event.MouseEvent evt) {
		try {
			int i = tble.getSelectedRow();
			Auto_Replace(i);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	

	private void btnmodActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		try {
			if (JOptionPane.showConfirmDialog(null, "Are you sure?",
					"modification", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

				stmn.executeQuery("UPDATE aircrafts SET MODEL_NO='"
						+ txt_model.getText().toString() + "',CAPACITY='"
						+ txt_cap.getText().toString() + "',MFD_BY='"
						+ txtmfd_by.getText().toString() + "',MFD_ON='"
						+ txtmfd_on.getText().toString() + "' WHERE AC_ID= '"
						+ txt_id.getText().toString() + "'");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		btnshowActionPerformed(evt);
	}

	private void txtidActionPerformed(java.awt.event.ActionEvent evt) {
		txt_id.setEnabled(false); // TODO add your handling code here:
	}

	private void btndltActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			if (JOptionPane.showConfirmDialog(null,
					"Attention!!data maybe lost forever!!", "Are u sure?",
					JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)

				if (txt_id.getText().length() != 0) {
					stmn.executeQuery("Delete From aircrafts where ac_id = '"
							+ txt_id.getText().toString() + "'");
					JOptionPane.showMessageDialog(null, "Deleted");
				} else {
					JOptionPane.showMessageDialog(null, "Empty field !");
				}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage());
			e.printStackTrace();
		}
		btnshowActionPerformed(evt);
		// TODO add your handling code here:
	}
}
