package ChelLong.JavaDatabase.model;

public class SanPham {
	private String maSp;
	private String tenSp;
	private int soLuong;
	private int donGia;
	private int isDelete;
	private String maDanhMuc;
	public String getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public String getMaSp() {
		return maSp;
	}
	public void setMaSp(String maSp) {
		this.maSp = maSp;
	}
	public String getTenSp() {
		return tenSp;
	}
	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public SanPham(String maSp, String tenSp, int soLuong, int donGia, int isDelete) {
		super();
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.isDelete = isDelete;
	}
	public SanPham() {
		super();
	}
	@Override
	public String toString() {
		return this.tenSp;
	}
	
	
}
