import java.util.Arrays;

public class TimKiem {
    private ChuyenBay[] danhSachChuyenBay; // Danh sách chuyến bay

    // Constructor
    public TimKiem(ChuyenBay[] danhSachChuyenBay) {
        this.danhSachChuyenBay = danhSachChuyenBay;
    }

    // Tìm chuyến bay theo nhiều tiêu chí
    public ChuyenBay[] timChuyenBay(String ngayBay, String sanBayDi, String sanBayDen) {
        ChuyenBay[] ketQua = new ChuyenBay[100];
        int count = 0;

        for (ChuyenBay cb : danhSachChuyenBay) {
            if (cb != null &&
                    cb.getNgayBay().equals(ngayBay) &&
                    cb.getSanBayDi().equals(sanBayDi) &&
                    cb.getSanBayDen().equals(sanBayDen)) {
                ketQua[count++] = cb;
            }
        }

        return Arrays.copyOf(ketQua, count);
    }
}
