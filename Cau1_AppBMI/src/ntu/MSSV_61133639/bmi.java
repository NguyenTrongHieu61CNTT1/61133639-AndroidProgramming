package ntu.MSSV_61133639;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;

public class bmi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bmi frame = new bmi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bmi() {
		setTitle("Ứng dụng BMI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cân nặng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(48, 106, 77, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblChiuCao = new JLabel("Chiều cao:");
		lblChiuCao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChiuCao.setBounds(48, 158, 94, 28);
		contentPane.add(lblChiuCao);
		
		JLabel lblNewLabel_1 = new JLabel("ỨNG DỤNG THEO DÕI CHỈ SỐ BMI");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(169, 35, 313, 46);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(135, 100, 96, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(135, 152, 96, 46);
		contentPane.add(textField_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Kilogams");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(250, 112, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Centimets");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(250, 164, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setEditable(false);
		textField_2.setBounds(486, 100, 96, 98);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("KẾT QUẢ:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(399, 100, 77, 98);
		contentPane.add(lblNewLabel_2);
	}
}
