public class Ghe {
    private String maGhe;
    private char hangGhe;
    private boolean daDat;
    private double giaCoBan;

    public Ghe(String maGhe, char hangGhe, boolean daDat, double giaCoBan) {
        this.maGhe = maGhe;
        this.hangGhe = hangGhe;
        this.daDat = daDat;
        this.giaCoBan = giaCoBan;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public char getHangGhe() {
        return hangGhe;
    }

    public boolean getDaDat() {
        return daDat;
    }

    public double getGiaCoBan() {
        return giaCoBan;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public void setHangGhe(char hangGhe) {
        this.hangGhe = hangGhe;
    }

    public void setDaDat(boolean daDat) {
        this.daDat = daDat;
    }

    public void setGiaCoBan(double giaCoBan) {
        this.giaCoBan = giaCoBan;
    }

    @Override
    public String toString() {
        return "Ghe{" +
                "maGhe='" + maGhe + '\'' +
                ", hangGhe=" + hangGhe +
                ", daDat=" + daDat +
                ", giaCoBan=" + giaCoBan +
                '}';
    }
}
