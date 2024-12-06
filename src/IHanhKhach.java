public interface IHanhKhach {
    boolean datVe(String maChuyenBay, char hangGhe);
    boolean huyVe(String maVe);
    boolean doiVe(String maVeCu, String maChuyenBayMoi);
    void kiemTraTrangThaiVe(String maVe);
    void tichLuyDamBay(double khoangCach, char hangGhe);
}
