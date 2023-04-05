package view_model;

public class QLCuaHang {
    private String ma;
    private String ten;
    private String diachi;
    private String thanhpho;
    private String quocgia;

    public QLCuaHang() {
    }

    public QLCuaHang(String ma, String ten, String diachi, String thanhpho, String quocgia) {
        this.ma = ma;
        this.ten = ten;
        this.diachi = diachi;
        this.thanhpho = thanhpho;
        this.quocgia = quocgia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getThanhpho() {
        return thanhpho;
    }

    public void setThanhpho(String thanhpho) {
        this.thanhpho = thanhpho;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }
}
