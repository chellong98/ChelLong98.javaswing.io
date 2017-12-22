package ChelLong.javaSwing.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhuongTrinhBac1UI extends JFrame {
	JTextField txtHeSoA, txtHeSoB;
	JButton btnGiai, btnThoat;
	JTextField txtKetQua;
	
	
	public PhuongTrinhBac1UI (String title) {
		super (title);
		this.addControls();
		this.addEvents();
	}
	
	ActionListener eventGiai = new ActionListener() { //tạo biến Giai sự kiện
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			XuLyGiaiPhuongTrinh(); //ctrl 1 tạo phương thức
		}
	};
	
	private void XuLyGiaiPhuongTrinh() {
		// TODO Auto-generated method stub
		String HeSoA = txtHeSoA.getText();
		String HeSoB = txtHeSoB.getText();
		double a = Double.parseDouble(HeSoA);
		double b = Double.parseDouble(HeSoB);
		if (a==0) {
			if (b==0) {
				JOptionPane.showMessageDialog(null, "Phương trình vô số nghiệm");
				txtKetQua.setText("vô số nghiệm");
			} else {
				JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm");
				txtKetQua.setText("vô nghiệm");
			}
		} else {
			String ketQua = String.valueOf(-b/a);
			txtKetQua.setText(ketQua);
		}
	}
	public void addEvents () {
		btnThoat.addActionListener(new ActionListener() { //tạo sự kiện nút thoát
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		btnGiai.addActionListener(eventGiai);//tạo sự kiện nút giải
	}
	
	public void addControls () {
		 Container con = getContentPane();
		 
		 JPanel pnMain = new JPanel();
		 pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		 
		 con.add(pnMain);
		 
		 JPanel pnTitle = new JPanel();
		 pnTitle.setLayout(new FlowLayout());
		 JLabel lblTieude = new JLabel("Giải phương trình bậc 1");
		 pnTitle.add(lblTieude);
		 
		 pnMain.add(pnTitle); //thêm layout title vào layout Main
		 
		 lblTieude.setForeground(Color.BLUE); //màu chữ
		 Font fontTieuDe = new Font("arial",Font.BOLD,20);//tạo font
		 lblTieude.setFont(fontTieuDe);//thêm font
		 
		 JPanel pnHeSoA = new JPanel();
		 pnHeSoA.setLayout(new FlowLayout());
		 JLabel lblHeSoA = new JLabel("Hệ số A: "); //nhãn hệ số A
		 txtHeSoA = new JTextField(15); //độ rộng 15
		 pnHeSoA.add(lblHeSoA);
		 pnHeSoA.add(txtHeSoA);
		 
		 pnMain.add(pnHeSoA); //thêm panel hệ số A
		 
		 JPanel pnHeSoB = new JPanel();
		 pnHeSoB.setLayout(new FlowLayout());
		 JLabel lblHeSoB = new JLabel("Hệ Số B: ");
		 txtHeSoB = new JTextField(15);
		 pnHeSoB.add(lblHeSoB);
		 pnHeSoB.add(txtHeSoB);
		 
		 pnMain.add(pnHeSoB); //thêm panel hệ số B
		 
		 JPanel pnButton = new JPanel();
		 pnButton.setLayout(new FlowLayout());
		 btnGiai = new JButton("Giải");
		 btnThoat = new JButton("Thoát");
		 btnThoat.setIcon(new ImageIcon("hinh/exit.png")); //tạo icon cho nút
		 pnButton.add(btnGiai);
		 pnButton.add(btnThoat);
		 
		 pnMain.add(pnButton); //thêm panel pnbutton
		 
		 JPanel pnKetQua = new JPanel();
		 pnKetQua.setLayout(new FlowLayout());
		 JLabel lblKetQua = new JLabel("Kết quả");
		 txtKetQua = new JTextField(15);
		 pnKetQua.add(lblKetQua);
		 pnKetQua.add(txtKetQua);
		 
		 pnMain.add(pnKetQua); //thêm panel kết quả
		 
	}
	
	public void showWindow () {
		this.setSize(400, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
