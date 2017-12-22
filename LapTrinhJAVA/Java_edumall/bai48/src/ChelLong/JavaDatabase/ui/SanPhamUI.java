package ChelLong.JavaDatabase.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ChelLong.JavaDatabase.model.DanhMuc;
import ChelLong.JavaDatabase.model.SanPham;
import ChelLong.JavaDatabase.service.DanhMucService;
import ChelLong.JavaDatabase.service.SanPhamService;

public class SanPhamUI extends JFrame {
	JList<DanhMuc>listDanhMuc;
	
	JButton btnThemMoiDM, btnChinhSuaDM, btnXoaDM;
	
	DefaultTableModel dtmSanPham;
	JTable tblSanPham;
	
	JComboBox<DanhMuc>cboDanhMuc;
	
	JButton btnTaoMoiSp, btnLuuSp, btnXoaSp;
	JTextField txtMa, txtTen, txtSoLuong, txtDonGia;
	
	ArrayList<SanPham> dssp;
	public SanPhamUI (String title) {
		super(title);
		addControls();
		addEvents();
		hienThiDanhMucLenList();
	}

	private void hienThiDanhMucLenList() {
		// TODO Auto-generated method stub
		DanhMucService service = new DanhMucService();
		Vector<DanhMuc>vec = service.docToanBoDanhMuc();
		listDanhMuc.setListData(vec);
		cboDanhMuc.removeAllItems();
		for (DanhMuc dm : vec) {
			cboDanhMuc.addItem(dm);
		}
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		listDanhMuc.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(listDanhMuc.getSelectedValue()==null) return;
				SanPhamService service = new SanPhamService();
				 dssp = service.docSanPhamTheoDanhMuc(
						listDanhMuc.getSelectedValue().getMaDM());
				dtmSanPham.setRowCount(0);
				for(SanPham sp : dssp) {
					Vector<Object> vec = new Vector<>();
					vec.add(sp.getMaSp());
					vec.add(sp.getTenSp());
					vec.add(sp.getSoLuong());
					vec.add(sp.getDonGia());
					dtmSanPham.addRow(vec);
				}
				
			}
		});
		tblSanPham.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = tblSanPham.getSelectedRow();
				if(row == -1) return;
				SanPham sp = dssp.get(row);
				txtMa.setText(sp.getMaSp());
				txtTen.setText(sp.getTenSp());
				txtSoLuong.setText(sp.getSoLuong()+"");
				txtDonGia.setText(sp.getDonGia()+"");
			}
		});
		
		btnTaoMoiSp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtDonGia.setText("");
				txtMa.setText("");
				txtTen.setText("");
				txtSoLuong.setText("");
			}
		});
		
		btnLuuSp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
//		thiết kế 2 panel chính
		JPanel pnLeft = new JPanel();
		pnLeft.setPreferredSize(new Dimension(250, 0));;
		JPanel pnRight = new JPanel();
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
		sp.setOneTouchExpandable(true);
		con.add(sp, BorderLayout.CENTER);
		
//		thiết kế Jlist của panel trái
		pnLeft.setLayout(new BorderLayout());
		listDanhMuc = new JList<DanhMuc>();
		JScrollPane scListDanhMuc = new JScrollPane(listDanhMuc, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.add(scListDanhMuc, BorderLayout.CENTER);
		TitledBorder borderListDanhMuc = new TitledBorder(BorderFactory.createLineBorder(Color.red), 
														"Danh mục sản phẩm");
		listDanhMuc.setBorder(borderListDanhMuc);
		
//		tạo các button
		btnThemMoiDM = new JButton("Thêm DM");
		btnChinhSuaDM = new JButton("Cập nhật DM");
		btnXoaDM = new JButton("Xóa DM");
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnButton.add(btnThemMoiDM);
		pnButton.add(btnChinhSuaDM);
		pnButton.add(btnXoaDM);
		pnLeft.add(pnButton, BorderLayout.SOUTH);
		
//		thiết kế giao diện phải
//		thiết kế giao diện trên phải
		pnRight.setLayout(new BorderLayout());
		JPanel pnTopOfRight = new JPanel();
		pnTopOfRight.setLayout(new BorderLayout());
		pnRight.add(pnTopOfRight, BorderLayout.NORTH);
		pnTopOfRight.setPreferredSize(new Dimension(0, 250));
		
		dtmSanPham = new DefaultTableModel();
		dtmSanPham.addColumn("Mã SP");
		dtmSanPham.addColumn("Tên SP");
		dtmSanPham.addColumn("Số lượng");
		dtmSanPham.addColumn("Đơn Giá");
		tblSanPham = new JTable(dtmSanPham);
		JScrollPane scTable = new JScrollPane(tblSanPham, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTopOfRight.add(scTable, BorderLayout.CENTER);
		

//		thiết kế giao diện dưới phải
		
		JPanel pnBottomOfRight = new JPanel();
		pnBottomOfRight.setLayout(new BoxLayout(pnBottomOfRight, BoxLayout.Y_AXIS));
		pnRight.add(pnBottomOfRight, BorderLayout.CENTER);
		
		JPanel pnDanhMuc = new JPanel();
		pnDanhMuc.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblDanhMuc = new JLabel("Danh Mục");
		cboDanhMuc = new JComboBox<DanhMuc>();
		cboDanhMuc.setPreferredSize(new Dimension(250, 20));
		pnDanhMuc.add(lblDanhMuc);
		pnDanhMuc.add(cboDanhMuc);
		pnBottomOfRight.add(pnDanhMuc);
		
		JPanel pnMa = new JPanel();
		pnMa.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblMa = new JLabel("Mã sản phẩm ");
		txtMa = new JTextField(20);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		pnBottomOfRight.add(pnMa);
		
		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblTen = new JLabel("Tên sản phẩm ");
		txtTen = new JTextField(20);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnBottomOfRight.add(pnTen);
		
		JPanel pnSoLuong = new JPanel();
		pnSoLuong.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblSoLuong = new JLabel("Số lượng ");
		txtSoLuong = new JTextField(20);
		pnSoLuong.add(lblSoLuong);
		pnSoLuong.add(txtSoLuong);
		pnBottomOfRight.add(pnSoLuong);
		
		JPanel pnDonGia = new JPanel();
		pnDonGia.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblDonGia = new JLabel("Mã sản phẩm");
		txtDonGia = new JTextField(20);
		pnDonGia.add(lblDonGia);
		pnDonGia.add(txtDonGia);
		pnBottomOfRight.add(pnDonGia);
		
		lblMa.setPreferredSize(lblTen.getPreferredSize());
		lblSoLuong.setPreferredSize(lblTen.getPreferredSize());
		lblDonGia.setPreferredSize(lblTen.getPreferredSize());
		
		JPanel pnButtonSanPham = new JPanel();
		pnButtonSanPham.setLayout(new FlowLayout());
		btnTaoMoiSp = new JButton("tạo mới");
		btnLuuSp = new JButton("Lưu sản phẩm");
		btnXoaSp = new JButton("Xóa Sản Phẩm");
		pnButtonSanPham.add(btnTaoMoiSp);
		pnButtonSanPham.add(btnLuuSp);
		pnButtonSanPham.add(btnXoaSp);
		pnBottomOfRight.add(pnButtonSanPham);
	}
	
	public void showWindow() {
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
