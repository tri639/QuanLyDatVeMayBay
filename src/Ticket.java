import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
    private String maVe;
    private String maChuyenBay;
    private String maGhe;
    private char hangGhe;
    private double giaVe;
    private char trangThaiVe;
    private HanhKhach hanhKhach;
    private String ngayDatVe;

    public Ticket(String maVe, String maChuyenBay, String maGhe, char hangGhe, char trangThaiVe, HanhKhach hanhKhach, String ngayDatVe) {
        this.maVe = maVe;
        this.maChuyenBay = maChuyenBay;
        this.maGhe = maGhe;
        this.hangGhe = hangGhe;
        this.trangThaiVe = trangThaiVe;
        this.hanhKhach = hanhKhach;
        this.ngayDatVe = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
        this.giaVe = tinhGiaVe();
    }


    public String getMaVe() {
        return maVe;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public char getHangGhe() {
        return hangGhe;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public char getTrangThaiVe() {
        return trangThaiVe;
    }

    public HanhKhach getHanhKhach() {
        return hanhKhach;
    }

    public String getNgayDatVe() {
        return ngayDatVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public void setHangGhe(char hangGhe) {
        this.hangGhe = hangGhe;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }

    public void setTrangThaiVe(char trangThaiVe) {
        this.trangThaiVe = trangThaiVe;
    }

    public void setHanhKhach(HanhKhach hanhKhach) {
        this.hanhKhach = hanhKhach;
    }

    public void setNgayDatVe(String ngayDatVe) {
        this.ngayDatVe = ngayDatVe;
    }

    public double tinhGiaVe() {
        double gia = 0;
        switch (hangGhe) {
            case 'Y': // Economy
                gia = 1000000;
                break;
            case 'B': // Business
                gia = 3000000;
                break;
            case 'F': // First
                gia = 5000000;
                break;
            default:
                System.out.println("Hạng ghế không hợp lệ.");
        }
        return gia;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "maVe='" + maVe + '\'' +
                ", maChuyenBay='" + maChuyenBay + '\'' +
                ", hangGhe=" + hangGhe +
                ", giaVe=" + giaVe +
                '}';
    }
}
