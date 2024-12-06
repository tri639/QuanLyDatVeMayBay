import java.util.ArrayList;
import java.util.List;

public class HanhKhach implements IHanhKhach {
    private String id;
    private String name;
    private int namSinh;
    private String soHoChieu;
    private String idHangBay;
    private String maTheThanhVien;
    private double soDamBayTichLuy;
    private char hangTheThanhVien;
    private List<Ticket> danhSachVe;
    private String diaChi;

    public HanhKhach(String id, String name, int namSinh, String soHoChieu, String idHangBay, String maTheThanhVien, double soDamBayTichLuy, char hangTheThanhVien, String diaChi) {
        this.id = id;
        this.name = name;
        this.namSinh = namSinh;
        this.soHoChieu = soHoChieu;
        this.maTheThanhVien = maTheThanhVien;
        this.soDamBayTichLuy = soDamBayTichLuy;
        this.hangTheThanhVien = hangTheThanhVien;
        this.danhSachVe = new ArrayList<>();
        this.diaChi = diaChi;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public String getSoHoChieu() {
        return soHoChieu;
    }

    public String getIdHangBay() {
        return idHangBay;
    }

    public String getMaTheThanhVien() {
        return maTheThanhVien;
    }

    public double getSoDamBayTichLuy() {
        return soDamBayTichLuy;
    }

    public char getHangTheThanhVien() {
        return hangTheThanhVien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public List<Ticket> getDanhSachVe() {
        return danhSachVe;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public void setSoHoChieu(String soHoChieu) {
        this.soHoChieu = soHoChieu;
    }

    public void setIdHangBay(String idHangBay) {
        this.idHangBay = idHangBay;
    }

    public void setMaTheThanhVien(String maTheThanhVien) {
        this.maTheThanhVien = maTheThanhVien;
    }

    public void setSoDamBayTichLuy(double soDamBayTichLuy) {
        this.soDamBayTichLuy = soDamBayTichLuy;
    }

    public void setHangTheThanhVien(char hangTheThanhVien) {
        this.hangTheThanhVien = hangTheThanhVien;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setDanhSachVe(List<Ticket> danhSachVe) {
        this.danhSachVe = danhSachVe;
    }

    // đặt vé
    @Override
    public boolean datVe(String maChuyenBay, char hangGhe) {
        if (danhSachVe.size() >= 5) {
            System.out.println("Bạn không thể đặt thêm vé (tối đa 5 vé).");
            return false;
        }

        HanhKhach hanhKhach = this;

        Ticket veMoi = new Ticket("V" + (danhSachVe.size() + 1), maChuyenBay, "GHE001", hangGhe, 'B', hanhKhach, "");

        double giaVe = veMoi.tinhGiaVe();
        veMoi.setGiaVe(giaVe);
        danhSachVe.add(veMoi);
        System.out.println("Đặt vé thành công: " + veMoi);
        return true;
    }

    @Override
    public boolean huyVe(String maVe) {
        for (int i = 0; i < danhSachVe.size(); i++) {
            Ticket ve = danhSachVe.get(i);
            if (ve.getMaVe().equals(maVe)) {
                danhSachVe.remove(i);  // Xóa vé nếu tìm thấy
                System.out.println("Hủy vé thành công: " + ve);
                return true;
            }
        }
        System.out.println("Không tìm thấy vé với mã: " + maVe);
        return false;
    }


    @Override
    public boolean doiVe(String maVeCu, String maChuyenBayMoi) {
        for (Ticket ve : danhSachVe) {
            if (ve.getMaVe().equals(maVeCu)) {
                ve.setMaChuyenBay(maChuyenBayMoi);
                System.out.println("Đổi vé thành công. Vé mới: " + ve);
                return true;
            }
        }
        System.out.println("Không tìm thấy vé với mã: " + maVeCu);
        return false;
    }

    @Override
    public void kiemTraTrangThaiVe(String maVe) {
        for (Ticket ve : danhSachVe) {
            if (ve.getMaVe().equals(maVe)) {
                System.out.println("Thông tin vé: " + ve);
                return;
            }
        }
        System.out.println("Không tìm thấy vé với mã: " + maVe);
    }


    @Override
    public void tichLuyDamBay(double khoangCach, char hangGhe) {
        double heSo = switch (hangTheThanhVien) {
            case 'Y' -> 1.0;
            case 'B' -> 1.5;
            case 'F' -> 2.0;
            default -> 0.0;
        };
        soDamBayTichLuy += khoangCach * heSo;
        System.out.println("Điểm tích lũy hiện tại của bạn: " + soDamBayTichLuy);
    }

    public void nangHangTheThanhVien() {
        if (soDamBayTichLuy >= 50000) {
            hangTheThanhVien = 'G';
            maTheThanhVien = "Gold";
        } else if (soDamBayTichLuy >= 10000) {
            hangTheThanhVien = 'S';
            maTheThanhVien = "Silver";
        } else {
            hangTheThanhVien = 'B';
            maTheThanhVien = "Basic";
        }
        System.out.println("Hạng thẻ thành viên hiện tại: " + maTheThanhVien);
    }

    @Override
    public String toString() {
        return "HanhKhach{" +
                "id='" + id + '\'' +
                ", ten='" + name + '\'' +
                ", namSinh=" + namSinh +
                ", soHoChieu='" + soHoChieu + '\'' +
                ", idHangBay='" + idHangBay + '\'' +
                ", maTheThanhVien='" + maTheThanhVien + '\'' +
                ", soDamBayTichLuy=" + soDamBayTichLuy +
                ", hangTheThanhVien=" + hangTheThanhVien +
                ", diaChi='" + diaChi + '\'' +
                ", danhSachVe=" + danhSachVe +
                '}';
    }
}