import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;                 // procurar na net o significado desta classe.




public class Employee_info extends JFrame {

	
	
	private JPanel contentPane;
	private JTable table = new JTable();

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_info frame = new Employee_info();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null;
	//ResultSet rs = null;
	//PreparedStatement pst = null;             // para se conectar a db preciso destes componentes.
	
	/**
	 * Create the frame.
	 */
public Employee_info() {
		
	   
		conn = javaconnect.ConnectrDB();
		Update_Table();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 11, 389, 230);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
	}
	
	
	private void Update_Table() {
		try {
			
		String sql = "select * from Bank_001";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
	
		table.setModel(DbUtils.resultSetToTableModel(rs));
		conn.close();
		
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
}
