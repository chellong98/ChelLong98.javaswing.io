package pccc.quanlytailieu.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import pccc.detaikhoahoc.model.ThuatNgu;

public class ThongTinUI extends JFrame {
	JList<ThuatNgu> listThuatNgu;
	DefaultTableModel dtmThuatNgu;
	JTable tblThuatNgu;
	JTextArea txtThuatNgu;
	JComboBox<ThuatNgu>cboThuatNgu;
	JButton btnNew, btnCopy;
	public ThongTinUI(String title) {
		super(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
//		tạo ra 2 panel chính
		JPanel pnLeft= new JPanel();
		pnLeft.setPreferredSize(new Dimension(250, 0));
		JPanel pnRight = new JPanel();
		JSplitPane spMain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
		spMain.setOneTouchExpandable(true);
		con.add(spMain, BorderLayout.CENTER);
		
//		tạo 2 panel trên phải và dưới phải
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		JPanel pnTopOfRight = new JPanel();
		pnTopOfRight.setPreferredSize(new Dimension(0, 300));
		JPanel pnBottomOfRight = new JPanel();
		JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnTopOfRight, pnBottomOfRight);
		spRight.setOneTouchExpandable(true);
		pnRight.add(spRight);
		
//		tạo các nội dung chính
//		tạo list
		pnLeft.setLayout(new BorderLayout());
		listThuatNgu = new JList<ThuatNgu>();
		JScrollPane scList = new JScrollPane(listThuatNgu, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.add(scList);
		
//		tạo bảng
		pnTopOfRight.setLayout(new BorderLayout());
		dtmThuatNgu = new DefaultTableModel();
		dtmThuatNgu.addColumn("Mã");
		dtmThuatNgu.addColumn("Tên Thuật Ngữ");
		dtmThuatNgu.addColumn("Định Nghĩa");
		dtmThuatNgu.addColumn("Tài Liệu");
		tblThuatNgu = new JTable(dtmThuatNgu);
		JScrollPane scTable = new JScrollPane(tblThuatNgu, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTopOfRight.add(scTable, BorderLayout.CENTER);
		
//		tạo text area
		pnBottomOfRight.setLayout(new BorderLayout());
		txtThuatNgu = new JTextArea();
		txtThuatNgu.setWrapStyleWord(true);
		txtThuatNgu.setLineWrap(true);
		JScrollPane scArea = new JScrollPane(txtThuatNgu, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnBottomOfRight.add(scArea, BorderLayout.CENTER);
//		tạo cbobox
		JPanel pnCboThuatNgu = new JPanel();
		pnCboThuatNgu.setLayout(new FlowLayout(FlowLayout.CENTER));
		cboThuatNgu = new JComboBox<ThuatNgu>();
		cboThuatNgu.setPreferredSize(new Dimension(200, 20));
		pnCboThuatNgu.add(cboThuatNgu);
		pnBottomOfRight.add(pnCboThuatNgu, BorderLayout.NORTH);
		btnNew = new JButton("Làm mới");
		btnCopy = new JButton("Sao Chép");
		pnCboThuatNgu.add(btnNew);
		pnCboThuatNgu.add(btnCopy);
		
		
	}
	
	public void showWindow() {
		this.setSize(1100, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
