package r99.developer.id.kowlegesharing2.Model;

public class MLaporan {

    String name;
    String judul;
    String tanggal;
    int image;

    public MLaporan(String name, String judul, String tanggal, int image) {
        this.name = name;
        this.judul = judul;
        this.tanggal = tanggal;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
