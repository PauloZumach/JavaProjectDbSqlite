

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Login_jFrame extends JFrame {
	
	//Connection conn = null;
	//ResultSet rs = null;
	//PreparedStatement pst = null;
	
	private JPanel frame;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					
					Login_jFrame frame = new Login_jFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	/**
	 * Create the frame.
	 */
	public Login_jFrame() {
		
		conn = javaconnect.ConnectrDB();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		frame = new JPanel();
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame);
		frame.setLayout(null);
		
		JLabel username = new JLabel("Username");
		username.setBounds(177, 93, 70, 14);
		username.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.add(username);
		
		JLabel password = new JLabel("Password");
		password.setBounds(177, 139, 70, 14);
		password.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.add(password);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(253, 133, 100, 20);
		frame.add(txt_password);
		
		
		TextField txt_username = new TextField();
		txt_username.setBounds(253, 85, 100, 22);
		txt_username.setBackground(new Color(255, 255, 255));
		frame.add(txt_username);
		
		JPanel panel = new JPanel();
		panel.setBounds(160, 50, 219, 160);
		panel.setForeground(Color.GRAY);
		panel.setBorder(new TitledBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Login:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)), "Login:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
	
		frame.add(panel);
		panel.setLayout(null);
		
		
		JButton cmdLogin = new JButton("Login");
		cmdLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String sql = "select * from bank_001 where AccountName=? and Password=?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, txt_username.getText());
					pst.setString(2, txt_password.getText());
					
					rs= pst.executeQuery();
					if(rs.next()) {
					
						JOptionPane.showMessageDialog(null, "Username and Password is correct!");
						Employee_info s = new Employee_info();
						s.setVisible(true);
					
						
					}else {
						JOptionPane.showMessageDialog(null, "Username or Password is Not correct!");
					}
			
				//rs.close();
				//pst.close();
				
				
				
				
				}catch(Exception e) {
					
					JOptionPane.showMessageDialog(null, e);
					
				}
				
			}
		});
		cmdLogin.setBounds(90, 126, 89, 23);
		panel.add(cmdLogin);
		
		JLabel icon = new JLabel("");
		icon.setBounds(40, 56, 90, 90);
		icon.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\DB SQLITE\\Project123\\img\\icon.jpg"));
		frame.add(icon);
		
	}
}
