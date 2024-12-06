import java.util.ArrayList;
import java.util.List;

public class ChuyenBay {
    private String maChuyenBay;
    private String sanBayDi;
    private String sanBayDen;
    private String ngayBay;
    private String gioBay;
    private int soGheEconomy;
    private int soGheBusiness;
    private int soGheFirst;
    private List<Ghe> danhSachGhe;
    private char trangThai;
    private List<Ticket> danhSachVe;
    private double khoangCachBay;

    public ChuyenBay(String maChuyenBay, String sanBayDi, String sanBayDen, String ngayBay, String gioBay, int soGheEconomy, int soGheBusiness, int soGheFirst, Ghe[] danhSachGhe, char trangThai, Ticket[] danhSachVe, double khoangCachBay ) {
        this.maChuyenBay = maChuyenBay;
        this.sanBayDi = sanBayDi;
        this.sanBayDen = sanBayDen;
        this.ngayBay = ngayBay;
        this.gioBay = gioBay;
        this.soGheEconomy = soGheEconomy;
        this.soGheBusiness = soGheBusiness;
        this.soGheFirst = soGheFirst;
        this.danhSachGhe = new ArrayList<>();
        this.trangThai = trangThai;
        this.danhSachVe = new ArrayList<>();
        this.khoangCachBay =khoangCachBay;
        taoDanhSachGhe();
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public String getSanBayDi() {
        return sanBayDi;
    }

    public String getSanBayDen() {
        return sanBayDen;
    }

    public String getNgayBay() {
        return ngayBay;
    }

    public String getGioBay() {
        return gioBay;
    }

    public int getSoGheEconomy() {
        return soGheEconomy;
    }

    public int getSoGheBusiness() {
        return soGheBusiness;
    }

    public int getSoGheFirst() {
        return soGheFirst;
    }

    public List<Ghe> getDanhSachGhe() {
        return danhSachGhe;
    }


    public char getTrangThai() {
        return trangThai;
    }

    public List<Ticket> getDanhSachVe() {
        return danhSachVe;
    }

    public double getKhoangCachBay() {
        return khoangCachBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public void setSanBayDi(String sanBayDi) {
        this.sanBayDi = sanBayDi;
    }

    public void setSanBayDen(String sanBayDen) {
        this.sanBayDen = sanBayDen;
    }

    public void setNgayBay(String ngayBay) {
        this.ngayBay = ngayBay;
    }

    public void setGioBay(String gioBay) {
        this.gioBay = gioBay;
    }

    public void setSoGheEconomy(int soGheEconomy) {
        this.soGheEconomy = soGheEconomy;
    }

    public void setSoGheBusiness(int soGheBusiness) {
        this.soGheBusiness = soGheBusiness;
    }

    public void setSoGheFirst(int soGheFirst) {
        this.soGheFirst = soGheFirst;
    }

    public void setDanhSachGhe(List<Ghe> danhSachGhe) {
        this.danhSachGhe = danhSachGhe;
    }

    public void setTrangThai(char trangThai) {
        this.trangThai = trangThai;
    }

    public void setDanhSachVe(List<Ticket> danhSachVe) {
        this.danhSachVe = danhSachVe;
    }

    public void setKhoangCachBay(double khoangCachBay) {
        this.khoangCachBay = khoangCachBay;
    }

        // Tạo danh sách ghế
        private void taoDanhSachGhe() {
            // Tạo ghế Economy: 20 hàng × 6 ghế
            for (int hang = 1; hang <= 20; hang++) {
                for (char ghe = 'A'; ghe <= 'F'; ghe++) {
                    String maGhe = String.format("Y%02d%c", hang, ghe);
                    danhSachGhe.add(new Ghe(maGhe, 'Y', false, 0));
                }
            }

            // Tạo ghế Business: 10 hàng × 4 ghế
            for (int hang = 1; hang <= 10; hang++) {
                for (char ghe = 'A'; ghe <= 'D'; ghe++) {
                    String maGhe = String.format("B%02d%c", hang, ghe);
                    danhSachGhe.add(new Ghe(maGhe, 'B', false, 0));
                }
            }

            // Tạo ghế First: 5 hàng × 2 ghế
            for (int hang = 1; hang <= 5; hang++) {
                for (char ghe = 'A'; ghe <= 'B'; ghe++) {
                    String maGhe = String.format("F%02d%c", hang, ghe);
                    danhSachGhe.add(new Ghe(maGhe, 'F', false, 0));
                }
            }
        }


    // Kiểm tra ghế trống
        public boolean kiemTraGheTrong(char hangGhe) {
            if (danhSachGhe == null || danhSachGhe.isEmpty()) {
                return false;
            }
            for (Ghe ghe : danhSachGhe) {
                if (ghe.getHangGhe() == hangGhe && !ghe.getDaDat()) {
                    return true;
                }
            }
            return false;
        }

        // Đặt ghế
        public boolean datGhe(String maGhe) {
            for (Ghe ghe : danhSachGhe) {
                if (ghe.getMaGhe().equals(maGhe) && !ghe.getDaDat()) {
                    ghe.setDaDat(true);
                    System.out.println("Đặt ghế thành công: " + maGhe + " trên chuyến bay " + maChuyenBay);
                    return true;
                }
            }
            System.out.println("Ghế không tồn tại hoặc đã được đặt: " + maGhe);
            return false;
        }

    // Hủy ghế
    public boolean huyGhe(String maGhe) {
        for (Ghe ghe : danhSachGhe) {
            if (ghe.getMaGhe().equals(maGhe) && ghe.getDaDat()) {
                ghe.setDaDat(false);
                System.out.println("Hủy ghế thành công: " + maGhe + " trên chuyến bay " + maChuyenBay);
                return true;
            }
        }
        System.out.println("Ghế không tồn tại hoặc chưa được đặt: " + maGhe);
        return false;
    }

    // toString
    @Override
    public String toString() {
        return "ChuyenBay{" +
                "maChuyenBay='" + maChuyenBay + '\'' +
                ", sanBayDi='" + sanBayDi + '\'' +
                ", sanBayDen='" + sanBayDen + '\'' +
                ", ngayBay='" + ngayBay + '\'' +
                ", gioBay='" + gioBay + '\'' +
                ", trangThai=" + trangThai +
                ", khoangCachBay=" + khoangCachBay +
                ", danhSachGhe=" + danhSachGhe +
                '}';
    }
}