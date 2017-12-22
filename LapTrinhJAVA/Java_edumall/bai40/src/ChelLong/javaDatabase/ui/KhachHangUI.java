package ChelLong.javaDatabase.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class KhachHangUI extends JFrame {
	DefaultTableModel dtmKhachHang;
	JTable tblKhachHang;

	JButton btnFirst, btnLast, btnNext, btnPrevious;
	JTextArea txtThongTin;

	Connection conn = null;
	Statement statement = null;
	ResultSet result = null;

	JTextField txtTen, txtNamSinh, txtMa;
	JButton btnLuu;
	public KhachHangUI(String title) {
		super(title);
		addControls();
		addEvents();
		ketNoiDatabase();
		hienThiToanBoKhachHang();
	}

	private void hienThiToanBoKhachHang() {
		// TODO Auto-generated method stub
		String sql = "select * from KhachHang";
		try {
			result = statement.executeQuery(sql);// thực hiện câu lênh sql là chọn dữ liệu từ bảng Khách hàng
			dtmKhachHang.setRowCount(0);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			while (result.next()) {// trong khi còn dữ liệu
				String ma = result.getString("MaKH");
				String ten = result.getString("TenKH");
				Date namSinh = result.getDate("namSinh");
				Vector<Object> vec = new Vector<Object>();
				vec.add(ma);
				vec.add(ten);
				vec.add(sdf.format(namSinh));
				dtmKhachHang.addRow(vec);// đưa lần lượt từng phần tử trong vector vào các cột, (ví dụ cột 0 ứng với
											// phần tử thứ 0)

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ketNoiDatabase() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// gán thư viện cho class này
			String connectUrl = "jdbc:sqlserver://" + "CHELLONGSCOMPUT\\SQLEXPRESS" + ":1433;databaseName="
					+ "dbKhachHang" + ";integratedSecurity=true;";
			conn = DriverManager.getConnection(connectUrl);
			// statement = conn.createStatement();//cchỉ đc di chuyển tới mà không đc quay
			// lui hay tới dòng bất kì
			statement = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, // có thể di chuyển con trỏ tham chiếu
					ResultSet.CONCUR_READ_ONLY);// có thể đọc
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("lỗi: " + e.toString());
		}
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnLast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					result.last();// tham chiếu đến phần tử cuối trong databse
					txtThongTin.setText(result.getString(2));// lấy thông tin ở cột 2 (cột tên)
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e.toString());
				}
			}
		});

		btnFirst.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					result.first();
					txtThongTin.setText(result.getNString(2));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});

		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					result.next();
					txtThongTin.setText(result.getNString(2));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});

		btnPrevious.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					result.previous();
					txtThongTin.setText(result.getNString(2));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyLuuKhachHang();
			}
		});
	}

	protected void xuLyLuuKhachHang() {
		// TODO Auto-generated method stub
		try {
			String sql="insert into KhachHang "
					+ "values('"+txtMa.getText()+"','"+txtTen.getText()+"','"+txtNamSinh.getText()+"','mn1')";
			int x = statement.executeUpdate(sql);
			if(x>0) {
				hienThiToanBoKhachHang();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		con.add(pnMain, BorderLayout.CENTER);

		dtmKhachHang = new DefaultTableModel();// khởi tạo 1 cái bảng
		dtmKhachHang.addColumn("Mã kh");
		dtmKhachHang.addColumn("Tên kh");
		dtmKhachHang.addColumn("năm sinh");
		tblKhachHang = new JTable(dtmKhachHang);
		JScrollPane scTable = new JScrollPane(tblKhachHang, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnMain.add(scTable, BorderLayout.CENTER);

		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BorderLayout());
		pnMain.add(pnNorth, BorderLayout.NORTH);
		btnFirst = new JButton("|<");
		btnLast = new JButton(">|");
		btnNext = new JButton(">>");
		btnPrevious = new JButton("<<");

		JPanel pnNorthOfNorth = new JPanel();

		pnNorthOfNorth.add(btnFirst);
		pnNorthOfNorth.add(btnPrevious);
		pnNorthOfNorth.add(btnNext);
		pnNorthOfNorth.add(btnLast);
		pnNorth.add(pnNorthOfNorth, BorderLayout.NORTH);

		txtThongTin = new JTextArea(5, 30);
		JScrollPane scThongTin = new JScrollPane(txtThongTin, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnNorth.add(scThongTin, BorderLayout.CENTER);
		
		JPanel pnThongTinChiTiet  = new JPanel();
		pnThongTinChiTiet.setLayout(new BoxLayout(pnThongTinChiTiet, BoxLayout.Y_AXIS));
		pnMain.add(pnThongTinChiTiet, BorderLayout.SOUTH);
		
		JPanel pnMa = new JPanel();
		pnMa.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMa = new JLabel("Mã: ");
		txtMa = new JTextField(20);
		pnMa.add(lblMa); 
		pnMa.add(txtMa);
		pnThongTinChiTiet.add(pnMa);
		
		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTen = new JLabel("Tên: ");
		txtTen = new JTextField(20);
		pnTen.add(lblTen); 
		pnTen.add(txtTen);
		pnThongTinChiTiet.add(pnTen);
		
		JPanel pnNamSinh = new JPanel();
		pnNamSinh.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNamSinh = new JLabel("Năm Sinh: ");
		txtNamSinh = new JTextField(20);
		pnNamSinh.add(lblNamSinh); 
		pnNamSinh.add(txtNamSinh);
		pnThongTinChiTiet.add(pnNamSinh);
		
		lblMa.setPreferredSize(lblNamSinh.getPreferredSize());
		lblTen.setPreferredSize(lblNamSinh.getPreferredSize());
		
		JPanel pnButtonChiTiet = new JPanel();
		pnButtonChiTiet.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnLuu = new JButton("Lưu");
		pnButtonChiTiet.add(btnLuu);
		pnThongTinChiTiet.add(pnButtonChiTiet);
	}

	public void showWindow() {
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
