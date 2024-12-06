public class SapXep {
    public void sapXepTheoDamBay(HanhKhach[] ds) {
        for (int i = 0; i < ds.length - 1; i++) {
            for (int j = 0; j < ds.length - i - 1; j++) {
                if (ds[j].getSoDamBayTichLuy() < ds[j+1].getSoDamBayTichLuy()) {
                    // Hoán đổi
                    HanhKhach temp = ds[j];
                    ds[j] = ds[j+1];
                    ds[j+1] = temp;
                }
            }
        }
    }
}
