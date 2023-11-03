package controller;

public class DataUpdate {
    private String nim;
    private String alamat;
    private String tanggalLahir;
    private String angkatan;
    private String ipk;
    private String program;
    private String jenjang;
    private String kontak;
    private String semester;

    public DataUpdate(String nim, String alamat, String tanggalLahir, String angkatan, String ipk, String program, String jenjang, String kontak, String semester) {
        this.nim = nim;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.angkatan = angkatan;
        this.ipk = ipk;
        this.program = program;
        this.jenjang = jenjang;
        this.kontak = kontak;
        this.semester = semester;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getIpk() {
        return ipk;
    }

    public void setIpk(String ipk) {
        this.ipk = ipk;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
