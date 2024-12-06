import java.util.ArrayList;
import java.util.List;

public class HangBay {
    private String id;
    private String tenHangBay;
    private List<ChuyenBay> danhSachChuyenBay;
    private List<HanhKhach> danhSachHanhKhach;
    private double[] bangGiaCoBan;

    public HangBay(String id, String tenHangBay, List<ChuyenBay> danhSachChuyenBay, List<HanhKhach> danhSachHanhKhach, double[] bangGiaCoBan) {
        this.id = id;
        this. tenHangBay = tenHangBay;
        this.danhSachChuyenBay = new ArrayList<>();
        this.danhSachHanhKhach = new ArrayList<>();
        this.bangGiaCoBan = bangGiaCoBan;
    }

    public String getId() {
        return id;
    }

    public String getTenHangBay() {
        return tenHangBay;
    }

    public List<ChuyenBay> getDanhSachChuyenBay() {
        return danhSachChuyenBay;
    }

    public List<HanhKhach> getDanhSachHanhKhach() {
        return danhSachHanhKhach;
    }

    public double[] getBangGiaCoBan() {
        return bangGiaCoBan;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTenHangBay(String tenHangBay) {
        this.tenHangBay = tenHangBay;
    }

    public void setDanhSachChuyenBay(List<ChuyenBay> danhSachChuyenBay) {
        this.danhSachChuyenBay = danhSachChuyenBay;
    }

    public void setDanhSachHanhKhach(List<HanhKhach> danhSachHanhKhach) {
        this.danhSachHanhKhach = danhSachHanhKhach;
    }

    public void setBangGiaCoBan(double[] bangGiaCoBan) {
        this.bangGiaCoBan = bangGiaCoBan;
    }

    public void themChuyenBay(ChuyenBay chuyenBay) {
        danhSachChuyenBay.add(chuyenBay);
        System.out.println("Thêm chuyến bay thành công: " + chuyenBay.getMaChuyenBay());
    }

    // Xóa chuyến bay
    public boolean xoaChuyenBay(String maChuyenBay) {
        for (ChuyenBay cb : danhSachChuyenBay) {
            if (cb.getMaChuyenBay().equals(maChuyenBay)) {
                danhSachChuyenBay.remove(cb);
                System.out.println("Đã xóa chuyến bay: " + maChuyenBay);
                return true;
            }
        }
        System.out.println("Không tìm thấy chuyến bay: " + maChuyenBay);
        return false;
    }

    // Tìm chuyến bay
    public ChuyenBay timChuyenBay(String maChuyenBay) {
        for (ChuyenBay cb : danhSachChuyenBay) {
            if (cb.getMaChuyenBay().equals(maChuyenBay)) {
                return cb;
            }
        }
        return null;
    }

    // Thêm hành khách
    public void themHanhKhach(HanhKhach hanhKhach) {
        danhSachHanhKhach.add(hanhKhach);
        System.out.println("Đã thêm hành khách: " + hanhKhach.getId());
    }

    // Xóa hành khách
    public boolean xoaHanhKhach(String idHanhKhach) {
        for (HanhKhach hk : danhSachHanhKhach) {
            if (hk.getId().equals(idHanhKhach)) {
                danhSachHanhKhach.remove(hk);
                System.out.println("Đã xóa hành khách: " + idHanhKhach);
                return true;
            }
        }
        System.out.println("Không tìm thấy hành khách: " + idHanhKhach);
        return false;
    }

    // Tìm hành khách
    public HanhKhach timHanhKhach(String idHanhKhach) {
        for (HanhKhach hk : danhSachHanhKhach) {
            if (hk.getId().equals(idHanhKhach)) {
                return hk;
            }
        }
        return null;
    }

    // Tính tổng doanh thu
    public double tinhTongDoanhThu() {
        double tongDoanhThu = 0;
        for (ChuyenBay cb : danhSachChuyenBay) {
            for (Ticket ve : cb.getDanhSachVe()) {
                tongDoanhThu += ve.getGiaVe();
            }
        }
        return tongDoanhThu;
    }

    // toString
    @Override
    public String toString() {
        return "HangBay{" +
                "id='" + id + '\'' +
                ", tenHangBay='" + tenHangBay + '\'' +
                ", so luong chuyen bay=" + danhSachChuyenBay.size() +
                ", so luong hanh khach=" + danhSachHanhKhach.size() +
                '}';
    }
}
