import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ThongKe {
    private List<Ticket> danhSachVe;


    public ThongKe(List<Ticket> danhSachVe) {
        this.danhSachVe = danhSachVe;
    }

    public double thongKeDoanhThu(String ngayBatDau, String ngayKetThuc) {
        double tongDoanhThu = 0;

        LocalDate batDau = LocalDate.parse(ngayBatDau, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate ketThuc = LocalDate.parse(ngayKetThuc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        for (Ticket ve : danhSachVe) {
            if (ve != null &&
                    ve.getTrangThaiVe() == 'B' &&
                    namTrongKhoang(ve.getNgayDatVe(), batDau, ketThuc)) {
                tongDoanhThu += ve.getGiaVe();
            }
        }

        return tongDoanhThu;
    }

    private boolean namTrongKhoang(String ngay, LocalDate batDau, LocalDate ketThuc) {

        LocalDate ngayDat = LocalDate.parse(ngay, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // Kiểm tra xem ngày có nằm trong khoảng từ batDau đến ketThuc hay không
        return !ngayDat.isBefore(batDau) && !ngayDat.isAfter(ketThuc);
    }

}
