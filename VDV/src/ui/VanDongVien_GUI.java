package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.Database;
import dao.CLB_DAO;
import dao.VDV_DAO;
import entity.CLB;
import entity.VDV;
import java.awt.Component;

public class VanDongVien_GUI extends JFrame  implements ActionListener, MouseListener {

	private static final long serialVersionUID = -1554680235689968471L;

	private JButton btnThem;
	private JButton btnsua;
	private JButton btnXoa;
	private JButton btnKetThuc;

	private DefaultTableModel dataModel;
	private JTable table;

	private JScrollPane scroll;

	private JComboBox<String> cboCauLB;
	private JTextField txtMaVDV;
	private JTextField txtTenVDV;
	private JTextField txtTuoi;

	private JButton btnLoc;

	private JButton btntim;

	public VanDongVien_GUI() {
		
		setSize(900, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Box b, b1, b2, b3, b4, b5, b6, b7, b8;
		getContentPane().add(b = Box.createVerticalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b8 = Box.createHorizontalBox());

		b.add(Box.createVerticalStrut(10));
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b8 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		JLabel lblTieuDe, lblMaVDV, lblTenVDV, lblTuoi, lblCLB;
		b1.add(lblTieuDe = new JLabel("-THÔNG TIN VẬN ĐỘNG VIÊN- ", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTieuDe.setForeground(Color.BLUE);

		b2.add(lblMaVDV = new JLabel("  Mã số vận động viên:  ", JLabel.RIGHT));
		b2.add(txtMaVDV = new JTextField());
		b2.add(Box.createHorizontalStrut(50));
		b3.add(lblTenVDV = new JLabel("Tên Vận động viên:  ", JLabel.RIGHT));
		b3.add(txtTenVDV = new JTextField());
		b3.add(Box.createHorizontalStrut(50));
		b4.add(lblTuoi = new JLabel("Câu lạc bộ:  ", JLabel.RIGHT));
		b4.add(cboCauLB = new JComboBox<String>());
		b4.add(Box.createHorizontalStrut(300));

		b5.add(lblCLB = new JLabel("Tuổi:  ", JLabel.RIGHT));
		b5.add(txtTuoi = new JTextField());
		b5.add(Box.createHorizontalStrut(50));

		DefaultComboBoxModel<String> dataModelLop = new DefaultComboBoxModel<String>();

		cboCauLB.setModel(dataModelLop);

		lblTuoi.setPreferredSize(lblMaVDV.getPreferredSize());
		lblTenVDV.setPreferredSize(lblMaVDV.getPreferredSize());
		lblCLB.setPreferredSize(lblMaVDV.getPreferredSize());

		b6.add(Box.createHorizontalStrut(40));
		b6.add(btnThem = new JButton("Thêm Mới "));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(btnsua = new JButton("sữa"));
		b6.add(Box.createHorizontalStrut(10));
		b6.add(btnXoa = new JButton("Xóa"));
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		b6.add(horizontalStrut);
		
		btntim = new JButton("tìm");
		b6.add(btntim);
		b6.add(Box.createHorizontalStrut(50));
		b6.add(btnKetThuc = new JButton("Kết Thúc"));

		String[] tieuDe = { "Mã Số", "Tên vận động viên", "Tuổi", "Câu Lạc Bộ" };
		b7.add(scroll = new JScrollPane(table = new JTable(dataModel = new DefaultTableModel(tieuDe, 0))));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách vận động viên:"));

		JLabel lblName;
		b8.add(lblName = new JLabel("Họ tên sv: Trần Chí Bảo..massv:..21080741"));
		lblName.setFont(new Font("Times", Font.ITALIC, 12));
		lblName.setForeground(Color.RED);
		b8.add(Box.createHorizontalStrut(50));
		b8.add(btnLoc= new JButton("   Lọc danh sách VĐV theo câu lạc bộ "));
		btnLoc.setFont(new Font("Times New Roman", Font.ITALIC,14 ));
		btnLoc.setForeground(Color.BLUE);
		table.addMouseListener(this);
		btnKetThuc.addActionListener(this);
		btnLoc.addActionListener(this);
		btnsua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btntim.addActionListener(this);
		
		Database.getIntance().connect();
		updatacbo();
		updatatable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			actionThem();
		}
		if(o.equals(btnsua)) {
			actionSua();
		}
		if(o.equals(btnXoa)) {
			actionXoa();
		}if(o.equals(btntim)) {
			actiontimtheoma(txtMaVDV.getText());
		}if(o.equals(btnLoc)) {
			actionLoc(cboCauLB.getSelectedItem().toString());
		}if(o.equals(btnKetThuc)) {
			System.exit(0);
		}
	}
	private void actionLoc(String ma) {
		VDV_DAO ds = new VDV_DAO();
		loc(ma);
	}
	private void actiontimtheoma(String ma) {
		VDV_DAO ds = new VDV_DAO();
		updatatablema(ma);
	}
	private void actionThem() {
		VDV_DAO ds = new VDV_DAO();
		if(ds.create(obj_vdv())) {
			updatatable();
			xoarong();
		}else {
			JOptionPane.showMessageDialog(null, "khong the them vi trung khoa chin");
		}
	}
	private void actionXoa() {
		int hoi = JOptionPane.showConfirmDialog(this, "ban co chac khong", "chu y",JOptionPane.YES_NO_OPTION);
		if(hoi == JOptionPane.YES_OPTION) {
			VDV_DAO ds = new VDV_DAO();
			if(ds.delete(obj_vdv().getMavdv())) {
				updatatable();
			}else {
				JOptionPane.showMessageDialog(null, "khong the xoa vi khong the tim thay ma");
			}
		}
	}
	private void actionSua() {
		VDV_DAO  ds = new VDV_DAO();
		if(ds.update(obj_vdv())) {
			updatatable();
			xoarong();
		}else {
			JOptionPane.showMessageDialog(null, "khong the update");
		}
		txtMaVDV.getSelectedText();
		txtMaVDV.requestFocus();

	}
	private VDV obj_vdv() {
		String ma = txtMaVDV.getText().trim();
		String ten = txtTenVDV.getText().trim();
		int tuoi = Integer.parseInt(txtTuoi.getText());
		String maclb = cboCauLB.getSelectedItem().toString();
		return new VDV(ma, ten, tuoi, new CLB(maclb));
	}
	private void updatacbo() {
		CLB_DAO  list = new CLB_DAO();
		for(CLB clb : list.doctubang()) {
			cboCauLB.addItem(clb.getMaclb());
		}
	}
	private void deletetable() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}
	private void updatatable() {
		deletetable();
		VDV_DAO list = new VDV_DAO();
		for(VDV s : list.doclentubang()) {
			String[] dataRow = {s.getMavdv(), s.getTenvdv(),s.getTuoi()+"",s.getClb().getMaclb()};
			dataModel.addRow(dataRow);
		}
		table.setModel(dataModel);
	}
	private void updatatablema(String ma) {
		deletetable();
		VDV_DAO list = new VDV_DAO();
		for(VDV s : list.timtheoma(ma)) {
			String[] dataRow = {s.getMavdv(), s.getTenvdv(),s.getTuoi()+"",s.getClb().getMaclb()};
			dataModel.addRow(dataRow);
		}
		table.setModel(dataModel);
	}
	private void loc(String ma) {
		deletetable();
		VDV_DAO list = new VDV_DAO();
		for(VDV s : list.locMaCLB(ma)) {
			String[] dataRow = {s.getMavdv(), s.getTenvdv(),s.getTuoi()+"",s.getClb()+""};
			dataModel.addRow(dataRow);
		}
		table.setModel(dataModel);
	}
	private void xoarong() {
		String s ="";
		txtMaVDV.setText(s);
		txtTenVDV.setText(s);
		txtTuoi.setText(s);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaVDV.setText(table.getValueAt(row, 0).toString());
		txtTenVDV.setText(table.getValueAt(row, 1).toString());
		txtTuoi.setText(table.getValueAt(row, 2).toString());
		cboCauLB.setSelectedItem(table.getValueAt(row, 3));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
