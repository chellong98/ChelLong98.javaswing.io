package pccc.quanlytailieu.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class TimKiemUI extends JFrame{
	JTextField txtNhap;
	JButton btnTimKiem;
	public TimKiemUI (String title) {
		super(title);
		addControls();
		addEvents();
		
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ThongTinUI ui = new ThongTinUI("Tài liệu cần tìm kiếm");
				ui.showWindow();
			}
		});
	}

	private void addControls() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //tạo giao diện giống window
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.setBackground(Color.white);
		
//		tạo layout ảnh
		JPanel pnImagePCCC = new JPanel();
		
		pnImagePCCC.setLayout(new BorderLayout());
		pnImagePCCC.add(new ImageBackground("images//pccc.jpg"), BorderLayout.CENTER);
		con.add(pnImagePCCC);

//		tạo txt nhập
		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnTimKiem.setBackground(Color.white);
		JLabel lblTieuDe = new JLabel("Nhập từ khóa bạn muốn tìm kiếm?");
		lblTieuDe.setFont(new Font("arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.red);
		txtNhap = new JTextField(50);
		ImageIcon imgTimKiem = new ImageIcon("images//search.png");
		btnTimKiem = new JButton("", imgTimKiem);
		btnTimKiem.setBackground(Color.white);
		pnTimKiem.add(lblTieuDe);
		pnTimKiem.add(txtNhap);
		pnTimKiem.add(btnTimKiem);
		con.add(pnTimKiem);
		pnTimKiem.setPreferredSize(new Dimension(0, 70));
	}
	
	public void showWidow() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		
	}
}
