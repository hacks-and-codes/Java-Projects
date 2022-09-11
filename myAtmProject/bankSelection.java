package myAtmProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bankSelection {

	private JFrame frame;
	private JTextField txtAccNum;
	private JButton btnCancel;
	private JButton btnOk;
	private JButton btnBack;
	private JTextField txtAmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bankSelection window = new bankSelection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bankSelection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setResizable(false);
		frame.setBounds(100, 100, 806, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Money Transfer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(10, 11, 770, 439);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] 
				{"select a destination", "1. Zenith Bank", "2. ADB", "3. Standard Chartered", 
						"4. EcoBank", "5. Cal Bank", "6. GCB", "7. Prudential Bank"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.setBounds(522, 89, 199, 44);
		panel.add(comboBox);
		
		txtAccNum = new JTextField();
		txtAccNum.setBounds(198, 97, 160, 32);
		panel.add(txtAccNum);
		txtAccNum.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(257, 362, 101, 34);
		panel.add(btnCancel);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				try {
				int accNum = (int) Double.parseDouble(txtAccNum.getText());
					double cash = (long) Double.parseDouble(txtAmt.getText());
					
					if(accNum < 10) {
						JOptionPane.showMessageDialog(btnOk, "Invalid account number");
						comboBox.getSelectedItem();
					}else if (cash > 3000 || accNum == cash ) {
						JOptionPane.showMessageDialog(comboBox, "Please try again");
					}
//				}catch (Exception error) {
//					JOptionPane.showMessageDialog(comboBox, "");
//				}
//				
				
		}
		});
		btnOk.setBackground(new Color(50, 205, 50));
		btnOk.setBounds(422, 362, 101, 34);
		panel.add(btnOk);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBackground(Color.BLUE);
		btnBack.setBounds(620, 284, 101, 34);
		panel.add(btnBack);
		
		JLabel lblAccountN = new JLabel("Account No.");
		lblAccountN.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAccountN.setBounds(44, 110, 102, 23);
		panel.add(lblAccountN);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAmount.setBounds(44, 157, 102, 23);
		panel.add(lblAmount);
		
		txtAmt = new JTextField();
		txtAmt.setColumns(10);
		txtAmt.setBounds(198, 148, 160, 32);
		panel.add(txtAmt);
	}
}
