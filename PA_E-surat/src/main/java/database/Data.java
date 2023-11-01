package database;

public class Data {
    private final String nim;
    private final String namaMahasiswa;
    private final String prodi;
    private final String jenjangStudi;
    private final String ipk;
    private final String kontak;
    private final String angkatan;
    private final String semester;
    private final String alamat;
    private final String ttl;

    public Data(String nim, String namaMahasiswa, String prodi, String jenjangStudi, String ipk, String kontak, String angkatan, String semester, String alamat, String ttl) {
        this.nim = nim;
        this.namaMahasiswa = namaMahasiswa;
        this.prodi = prodi;
        this.jenjangStudi = jenjangStudi;
        this.ipk = ipk;
        this.kontak = kontak;
        this.angkatan = angkatan;
        this.semester = semester;
        this.alamat = alamat;
        this.ttl = ttl;
    }

    // Getters and setters...
}
