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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bmi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField canNangValues;
	private JTextField chieuCaoValues;
	private JTextField kQ;

	
	public bmi() {
		setTitle("Ứng dụng BMI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel canNang = new JLabel("Cân nặng:");
		canNang.setFont(new Font("Tahoma", Font.BOLD, 15));
		canNang.setBounds(48, 106, 77, 28);
		contentPane.add(canNang);
		
		JLabel chieuCao = new JLabel("Chiều cao:");
		chieuCao.setFont(new Font("Tahoma", Font.BOLD, 15));
		chieuCao.setBounds(48, 158, 94, 28);
		contentPane.add(chieuCao);
		
		JLabel lblNewLabel_1 = new JLabel("ỨNG DỤNG THEO DÕI CHỈ SỐ BMI");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(169, 35, 313, 46);
		contentPane.add(lblNewLabel_1);
		
		canNangValues = new JTextField();
		canNangValues.setBounds(135, 100, 96, 46);
		contentPane.add(canNangValues);
		canNangValues.setColumns(10);
		
		JTextField chieuCaoValues = new JTextField();
		chieuCaoValues.setColumns(10);
		chieuCaoValues.setBounds(135, 152, 96, 46);
		contentPane.add(chieuCaoValues);
		
		JRadioButton rdKg = new JRadioButton("Kilogams");
		rdKg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdKg.setBounds(250, 112, 103, 21);
		contentPane.add(rdKg);
		
		JRadioButton rdCm = new JRadioButton("Centimets");
		rdCm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdCm.setBounds(250, 164, 103, 21);
		contentPane.add(rdCm);
		
		kQ = new JTextField();
		kQ.setBackground(new Color(255, 255, 255));
		kQ.setEditable(false);
		kQ.setBounds(486, 100, 96, 98);
		contentPane.add(kQ);
		kQ.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("KẾT QUẢ:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(399, 100, 77, 98);
		contentPane.add(lblNewLabel_2);
		
		JButton btnKT = new JButton("KIỂM TRA");
		btnKT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Lấy dữ liệu:
				String str_canNang = canNangValues.getText();
				String str_chieuCao = chieuCaoValues.getText();
				
				//Chuyển kiểu:
				Double canNang = Double.parseDouble(str_canNang);
				Double chieuCao = Double.parseDouble(str_chieuCao);
				
				//Tính toán:
				if (rdCm.isSelected()) {
					chieuCao = chieuCao/100;
				}
				
				double kq = canNang/(chieuCao*chieuCao);
				
				//Hiển thị:
				kQ.setText(String.valueOf(kq));
				
			}
		});
		btnKT.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnKT.setBounds(48, 211, 183, 46);
		contentPane.add(btnKT);
	}
}
