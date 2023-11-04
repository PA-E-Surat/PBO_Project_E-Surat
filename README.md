# LAPORAN PRAKTIKUM PBO E-SURAT
### Oleh Kelompok 13 SI A 22:
### Ayu Cahyarani (2209116008)
### Abdul Rahman (2209116045)
#
### Deskripsi Project
Proyek E-Surat adalah aplikasi manajemen surat berbasis pemrograman berorientasi objek yang bertujuan untuk mengotomatisasi dan meningkatkan efisiensi dalam proses pembuatan surat di Fakultas Teknik Universitas Mulawarman. Aplikasi ini dirancang untuk menggantikan proses manual dalam penanganan surat dan membawa manfaat signifikan seperti peningkatan efisiensi, pengurangan penggunaan kertas, penghematan biaya pengiriman surat fisik, dan peningkatan kemampuan dalam mengelola surat elektronik. Aplikasi ini memberikan solusi modern dan berkelanjutan untuk manajemen surat.
### Flowchart
Berikut adalah diagram yang menggambarkan alur proses sistem E-Surat:


### ERD

``Berikut adalah diagram yang digunakan untuk perancangan database yang menunjukan relasi antar objek beserta atribut-atribut dalam sistem E-Surat secara detail:``


### Hierarki Kelas
Berikut adalah kelas yang digunakan dalam sistem E-Surat:



### Source Code
### Action Package
##### ActionButton - Tombol 
##### PanelAction - Panel Tombolndakan ketika diklik.
##### TableActionCellRender - Pengatur Tampilan Tombol Kustome Tabel
##### Tester - Untuk Mencoba Aplikasi

### Controller Package
##### Controller
- Metode insertData
### Penjelasan Kode

- Metode insertData
### Penjelasan Kode


- Metode insertData
### Penjelasan Kode


- Metode insertData
### Penjelasan Kode


##### DataUpdate 
- Metode insertData
### Penjelasan Kode


- Metode insertData
### Penjelasan Kode


- Metode insertData
### Penjelasan Kode


- Metode insertData
### Penjelasan Kode


- Metode insertData
### Penjelasan Kode


### Database Package
##### Database
- Melakukan _Import__ paket
 ```
  package database;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.SQLException;
```
### Penjelasan Kode
Kelas `Database` adalah kelas yang digunakan untuk mengelola koneksi dengan basis data. Ini memungkinkan aplikasi Anda untuk berinteraksi dengan basis data, dalam hal ini, mengakses data yang diperlukan. Di bawah ini adalah ringkasan singkat tentang kelas `Database`:
- `Connection`: Kelas ini digunakan untuk membuka dan menutup koneksi ke basis data. Fungsinya adalah mengelola koneksi ke database yang digunakan oleh aplikasi.
- `DriverManager`: Kelas ini memungkinkan Anda untuk mendaftar driver JDBC yang diperlukan untuk berkomunikasi dengan database tertentu.
- `SQLException`: Kelas ini menangani pengecualian yang terkait dengan kesalahan yang mungkin terjadi selama berinteraksi dengan database, seperti kesalahan koneksi atau pernyataan SQL.
Kelas `Database` adalah bagian kunci dalam mengelola koneksi ke database, dan memungkinkan aplikasi Anda untuk melakukan operasi basis data yang diperlukan, seperti membaca dan menulis data.

- Melakukan pengelolaan koneksi antar aplikasi dan database
```
public class Database {
    public final Connection connection;

    public Database() {
        this.connection = openConnection();
    }

    public Connection openConnection() {
        Connection conn = null;
        try {
            String dbHost = "localhost";
            String dbName = "database_e_surat";
            String dbUser = "root";
            String dbPass = "";

            String url = "jdbc:mysql://" + dbHost + "/" + dbName;
            conn = DriverManager.getConnection(url, dbUser, dbPass);
            System.out.println("Database Connected!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
        }
        return conn;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database Closed");
            }
        } catch (SQLException ex) {
            System.out.println("Failed to close the database.");
        }
    }
}
```
### Penjelasan Kode
Kelas `Database` adalah kelas yang digunakan untuk mengelola koneksi dengan basis data MySQL. Ini memungkinkan aplikasi Anda untuk berinteraksi dengan basis data, dalam hal ini, mengakses data yang diperlukan. Di bawah ini adalah ringkasan singkat tentang kelas `Database`:
- `Connection`: Kelas ini digunakan untuk membuka dan menutup koneksi ke basis data MySQL. Fungsinya adalah mengelola koneksi ke database yang digunakan oleh aplikasi.
- `DriverManager`: Kelas ini memungkinkan Anda untuk mendaftar driver JDBC yang diperlukan untuk berkomunikasi dengan database MySQL.
- `SQLException`: Kelas ini menangani pengecualian yang terkait dengan kesalahan yang mungkin terjadi selama berinteraksi dengan database, seperti kesalahan koneksi atau pernyataan SQL.
Kelas `Database` digunakan untuk menginisialisasi dan membuka koneksi ke basis data MySQL dengan host "localhost", nama database "database_e_surat", pengguna "root", dan kata sandi kosong. Setelah koneksi berhasil dibuka, pesan "Database Connected!" akan ditampilkan di konsol.
Kelas `Database` adalah bagian kunci dalam mengelola koneksi ke database MySQL, dan memungkinkan aplikasi Anda untuk melakukan operasi basis data yang diperlukan, seperti membaca dan menulis data.


### Entitas Package
##### Admin
- Melakukan  _import_ paket
  ```
  package entitas;
  import database.Database;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.util.logging.Level;
  import java.util.logging.Logger;'
  ```
### Penjelasan Kode
Paket `entitas` berisi kelas-kelas yang digunakan untuk merepresentasikan entitas atau objek-objek dalam aplikasi. Objek-objek ini mewakili data dan informasi yang diperlukan untuk operasi aplikasi. Di bawah ini adalah ringkasan singkat tentang paket `entitas`:
- `Database`: Kelas ini bertanggung jawab untuk berinteraksi dengan basis data. Ini mencakup operasi seperti menjalankan pernyataan SQL dan mengambil data dari database. Kelas ini adalah penghubung penting antara aplikasi dan basis data.
- `PreparedStatement`: Kelas ini digunakan untuk mempersiapkan dan mengeksekusi pernyataan SQL. Ini membantu dalam menghindari serangan SQL injeksi dan memungkinkan aplikasi untuk memasukkan parameter ke dalam pernyataan SQL.
- `ResultSet`: Kelas ini digunakan untuk menyimpan hasil dari pernyataan SQL yang dijalankan di database. Data hasil query dapat diekstrak dan digunakan oleh aplikasi.
Paket `entitas` berperan penting dalam merepresentasikan data yang diperlukan oleh aplikasi, dan kelas-kelas di dalamnya berfungsi sebagai model data yang digunakan dalam aplikasi Anda.

- Metode readData
```
      public final boolean readData() {
        boolean loginSuccessful = false;

        try {
            openConnection();

            String sql = "SELECT * FROM admin WHERE Email = ? AND Password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            loginSuccessful = resultSet.next();
        } catch (SQLException e) {
            Logger.getLogger(Pengguna.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }
```
### Penjelasan Kode
Metode `readData` digunakan untuk mengautentikasi pengguna dengan mencocokkan email dan kata sandi yang dimasukkan dengan catatan dalam basis data. Di bawah ini adalah penjelasan singkat tentang bagaimana metode ini bekerja:
- `boolean loginSuccessful`: Variabel ini digunakan untuk menunjukkan apakah proses login berhasil. Awalnya diatur sebagai `false`.
- Metode `openConnection()`: Metode ini digunakan untuk membuka koneksi ke database sebelum mengambil data.
- `String sql`: Ini adalah pernyataan SQL yang digunakan untuk mencari pengguna dengan email dan kata sandi tertentu dalam tabel `admin`. Tanda tanya (`?`) digunakan sebagai tanda tanya yang akan diisi dengan nilai yang sesuai.
- `PreparedStatement preparedStatement`: Objek ini mempersiapkan pernyataan SQL dengan memasukkan email dan kata sandi ke dalam pernyataan.
- `ResultSet resultSet`: Objek ini digunakan untuk menyimpan hasil dari eksekusi pernyataan SQL. Jika ada hasil yang sesuai, maka login dianggap berhasil.
- Jika ada kesalahan SQL selama proses, misalnya terjadi kesalahan dalam eksekusi pernyataan SQL, maka kesalahan tersebut akan ditangkap dan dicatat.
- Terakhir, metode `closeConnection()` dipanggil untuk menutup koneksi database setelah selesai mengambil data.
Metode ini memainkan peran penting dalam mengelola proses otentikasi pengguna dan menentukan apakah pengguna berhasil masuk atau tidak.

- Melakukan findData
```
    public String findData(String suratID) {
        String nim = null;
        try {
            String sql = "SELECT Mahasiswa_NIM1 FROM pengajuan WHERE ID_Pengajuan = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, suratID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                nim = resultSet.getString("Mahasiswa_NIM1");
            }
        } catch (SQLException e) {
        }
        return nim;
    }
```
### Penjelasan Kode
Metode `findData` digunakan untuk mencari NIM (Nomor Induk Mahasiswa) berdasarkan ID surat yang diberikan. Berikut penjelasan singkat tentang bagaimana metode ini bekerja:
- `String nim`: Variabel ini digunakan untuk menyimpan NIM (Nomor Induk Mahasiswa) yang akan ditemukan. Awalnya diatur sebagai `null`.
- Metode ini mengambil ID surat sebagai argumen dan menggabungkannya ke dalam pernyataan SQL untuk mencari NIM yang terkait dalam tabel `pengajuan`.
- `String sql`: Ini adalah pernyataan SQL yang digunakan untuk mencari NIM dengan menggunakan ID surat yang diberikan.
- `PreparedStatement preparedStatement`: Objek ini digunakan untuk mempersiapkan pernyataan SQL dengan memasukkan ID surat ke dalam pernyataan.
- `ResultSet resultSet`: Objek ini digunakan untuk menyimpan hasil dari eksekusi pernyataan SQL. Jika ada hasil yang sesuai, maka NIM akan diambil dari hasil tersebut.
- Jika ada kesalahan SQL selama proses, misalnya terjadi kesalahan dalam eksekusi pernyataan SQL, maka kesalahan tersebut akan ditangkap dan diabaikan.
Metode `findData` berfungsi sebagai alat untuk menemukan NIM berdasarkan ID surat yang diberikan dalam konteks aplikasi Anda. Hal ini berguna ketika Anda perlu menghubungkan ID surat dengan NIM mahasiswa yang sesuai dalam basis data.

##### DataDiri
- Melakukan Inisialisasi komponen
```
public class DataDiri extends Database {
    private String nim;
    private String alamat;
    private String tempatLahir;
    private String angkatan;
    private String ipk;
    private String program;
    private String jenjang;
    private String kontak;

    public DataDiri() {
        this.nim = nim;
    }

     public final String[] readData(String nim) {
        try {
            openConnection();

            String[] data = new String[10];
            String sql = "SELECT * FROM data_diri WHERE NIM = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nim);
            ResultSet resultSet = preparedStatement.executeQuery();


        if (resultSet.next()) {
            data[0] = resultSet.getString("NIM");
            data[1] = resultSet.getString("Nama_Mahasiswa");
            data[2] = resultSet.getString("Prodi");
            data[3] = resultSet.getString("Jenjang_Studi");
            data[4] = resultSet.getString("IPK");
            data[5] = resultSet.getString("Kontak");
            data[6] = resultSet.getString("Angkatan");
            data[7] = resultSet.getString("Semester");
            data[8] = resultSet.getString("Alamat");
            data[9] = resultSet.getString("TTL");
            return data;
        }
    } catch (SQLException ex) {
        Logger.getLogger(DataDiri.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}
```
### Penjelasan Kode=
- `String nim`: Variabel ini digunakan untuk menyimpan NIM mahasiswa yang akan digunakan sebagai kunci pencarian.
- Metode ini membuka koneksi ke database yang digunakan dalam aplikasi Anda.
- Sebuah array `data` dengan ukuran 10 dibuat untuk menyimpan data pribadi mahasiswa, seperti Nama, Program Studi, IPK, dan sebagainya.
- Pernyataan SQL digunakan untuk mencari data pribadi berdasarkan NIM yang diberikan dalam tabel `data_diri`.
- Hasil dari pernyataan SQL disimpan dalam `ResultSet` untuk dianalisis.
- Jika ada hasil yang sesuai, data pribadi seperti NIM, Nama Mahasiswa, Program Studi, dan lainnya akan dimasukkan ke dalam array `data`. Kemudian, array ini dikembalikan sebagai hasil dari metode.
- Jika tidak ada hasil yang sesuai atau terjadi kesalahan SQL, metode akan mengembalikan `null`.
Metode `readData` berfungsi sebagai alat untuk mengambil data pribadi seorang mahasiswa berdasarkan NIM dalam konteks aplikasi Anda. Ini memungkinkan aplikasi Anda untuk menampilkan dan mengelola data pribadi mahasiswa dengan mudah.

- Melakukan updateData
```
 public final boolean updateData(DataUpdate dataUpdate) {
        boolean updateSuccessful = false;

        try {
            openConnection();

            String sql = "UPDATE data_diri SET Alamat = ?, Prodi = ?, Jenjang_Studi = ?, IPK = ?, Kontak = ?, Angkatan = ?, Semester = ?, TTL = ? WHERE NIM = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dataUpdate.getAlamat());
            preparedStatement.setString(2, dataUpdate.getProgram());
            preparedStatement.setString(3, dataUpdate.getJenjang());
            preparedStatement.setString(4, dataUpdate.getIpk());
            preparedStatement.setString(5, dataUpdate.getKontak());
            preparedStatement.setString(6, dataUpdate.getAngkatan());
            preparedStatement.setString(7, dataUpdate.getSemester());
            preparedStatement.setString(8, dataUpdate.getTanggalLahir());
            preparedStatement.setString(9, dataUpdate.getNim());

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                updateSuccessful = true;
            }
        } catch (SQLException e) {
        } finally {
            closeConnection();
        }

        return updateSuccessful;
    }
```
### Penjelasan Kode
- `DataUpdate dataUpdate`: Metode ini menerima objek `DataUpdate` yang berisi informasi terbaru yang akan diperbarui dalam database.
- Metode ini membuka koneksi ke database yang digunakan dalam aplikasi Anda.
- Pernyataan SQL digunakan untuk mengupdate data pribadi mahasiswa dalam tabel `data_diri` berdasarkan NIM.
- Parameter yang akan diperbarui, seperti Alamat, Program Studi, IPK, dan lainnya, diambil dari objek `dataUpdate` dan dimasukkan ke dalam pernyataan SQL.
- Jika pembaruan berhasil dilakukan dan satu atau lebih baris dalam database telah diperbarui, variabel `updateSuccessful` akan diatur ke `true`.
- Jika pembaruan gagal atau terjadi kesalahan SQL, variabel `updateSuccessful` akan tetap `false`.
- Terakhir, metode ini akan menutup koneksi ke database sebelum mengembalikan nilai `updateSuccessful`.
Metode `updateData` adalah alat yang memungkinkan aplikasi Anda untuk memperbarui data pribadi seorang mahasiswa dalam database, yang bisa digunakan untuk memastikan bahwa informasi mahasiswa tetap akurat dan mutakhir.

##### Pengajuan
- Metode inserData
```
public Pengajuan(String peruntukanValue, String mahasiswaNIM, String roleChecker) {
        this.peruntukanValue = peruntukanValue;
        this.mahasiswaNIM = mahasiswaNIM;
        this.roleChecker = roleChecker;
    }

    public String insertData() {
        String generatedId = null;

        try {
            openConnection();

            String sql = "INSERT INTO pengajuan (Peruntukan, Lampiran, Mahasiswa_NIM1, Aktivitas_ID_Aktivitas) VALUES (?, 'Null', ?, 'null')";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, peruntukanValue);
            preparedStatement.setString(2, roleChecker);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getString(1);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Pengajuan.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }

        return generatedId;
    }
```
### Penjelasan Kode
- `String generatedId`: Variabel ini digunakan untuk menyimpan ID yang dihasilkan setelah pengajuan disimpan ke dalam database.
- Metode ini membuka koneksi ke database yang digunakan dalam aplikasi Anda.
- Pernyataan SQL digunakan untuk menyimpan data pengajuan ke dalam tabel `pengajuan` di database. Informasi yang disimpan meliputi peruntukan surat, lampiran (dalam contoh ini diatur sebagai "Null"), NIM mahasiswa, dan ID aktivitas (dalam contoh ini diatur sebagai "null").
- Parameter yang akan disimpan dalam pernyataan SQL diambil dari variabel `peruntukanValue` dan `roleChecker`.
- Setelah data pengajuan disimpan dalam database, metode ini akan mengambil ID yang dihasilkan. Jika penyimpanan berhasil (lebih dari 0 baris dimasukkan), ID yang dihasilkan akan disimpan dalam variabel `generatedId`.
- Jika terjadi kesalahan SQL selama penyimpanan, metode ini akan menangani kesalahan tersebut dan memprosesnya.
- Terakhir, metode ini akan menutup koneksi ke database sebelum mengembalikan nilai `generatedId`.
Metode `insertData` adalah alat yang memungkinkan aplikasi Anda untuk menyimpan pengajuan surat mahasiswa ke dalam database dengan parameter seperti peruntukan surat, NIM mahasiswa, dan ID aktivitas yang relevan.

- Metode readData
```
public String[] readData() {
        try {
            openConnection();

            String[] data = new String[6];
            String sql = "SELECT * FROM pengajuan";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                data[0] = resultSet.getString("ID_Pengajuan");
                data[1] = resultSet.getString("Peruntukan");
                data[2] = resultSet.getString("Lampiran");
                data[3] = resultSet.getString("Mahasiswa_NIM");
                data[4] = resultSet.getString("Aktivitas_ID_Aktivitas");
                data[5] = resultSet.getString("Tanggal");

                return data;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pengajuan.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
```
### Penjelasan Kode
- `String[] data`: Variabel ini adalah array string dengan panjang 6 yang digunakan untuk menyimpan data pengajuan yang akan diambil dari database.
- Metode ini membuka koneksi ke database yang digunakan dalam aplikasi Anda.
- Pernyataan SQL digunakan untuk mengambil data dari tabel `pengajuan`. Data yang diambil termasuk ID pengajuan, peruntukan surat, lampiran, NIM mahasiswa, ID aktivitas, dan tanggal pengajuan.
- Hasil eksekusi pernyataan SQL diambil dalam variabel `resultSet`.
- Jika data pengajuan tersedia dalam tabel (ada hasil dalam `resultSet`), metode ini akan mengambil data tersebut dan menyimpannya dalam array `data`. Setiap elemen array sesuai dengan kolom yang sesuai dalam tabel.
- Jika tidak ada data yang ditemukan atau terjadi kesalahan SQL selama pengambilan data, metode ini akan menangani kesalahan tersebut dan mengembalikan nilai `null`.
Metode `readData` adalah alat yang memungkinkan aplikasi Anda untuk mengambil data pengajuan surat dari database, yang kemudian dapat digunakan untuk ditampilkan atau diproses sesuai kebutuhan.

##### Pengguna
- Metode readData
```
public final boolean readData() {
        boolean loginSuccessful = false;

        try {
            openConnection();

            String sql = "SELECT * FROM pengguna WHERE ID_Pengguna = ? AND Password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id_pengguna);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            loginSuccessful = resultSet.next();
        } catch (SQLException e) {
            Logger.getLogger(Pengguna.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }

        return loginSuccessful;
    }
}
```
### Penjelasan Kode
- `boolean loginSuccessful`: Variabel ini adalah boolean yang menunjukkan apakah proses login berhasil. Nilai ini akan mengindikasikan apakah pengguna dengan ID_Pengguna dan kata sandi yang diberikan berhasil diotentikasi atau tidak.
- Metode ini membuka koneksi ke database yang digunakan dalam aplikasi Anda.
- Pernyataan SQL digunakan untuk mengambil data dari tabel `pengguna` berdasarkan ID_Pengguna dan kata sandi yang diberikan. Data ini digunakan untuk mencocokkan informasi yang diinputkan oleh pengguna dengan data yang ada di database.
- Hasil eksekusi pernyataan SQL diambil dalam variabel `resultSet`.
- Jika data pengguna dengan ID_Pengguna dan kata sandi yang sesuai ditemukan dalam tabel (ada hasil dalam `resultSet`), maka `loginSuccessful` akan diatur sebagai `true`, mengindikasikan bahwa proses login berhasil.
- Jika tidak ada data yang ditemukan atau terjadi kesalahan SQL selama proses login, metode ini akan menangani kesalahan tersebut dan mengembalikan `false`, yang menunjukkan bahwa proses login gagal.
Metode `readData` adalah alat yang memungkinkan aplikasi Anda untuk mengotentikasi pengguna berdasarkan ID_Pengguna dan kata sandi yang mereka berikan, yang merupakan langkah penting dalam pengamanan aplikasi.

##### RiwayatSurat
- Metode insertData
```
public boolean insertData(String jenisSurat, String posisiSurat, String action, String idPengajuan) {
        boolean insertSuccessful = false;
        
        try {
            openConnection();

            String sql = "INSERT INTO riwayat_surat (Jenis_Surat, Status, Posisi_Surat, Action, Pengajuan_ID_Pengajuan) VALUES (?, 'Pending', ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, jenisSurat);
            preparedStatement.setString(2, posisiSurat);
            preparedStatement.setString(3, action);
            preparedStatement.setString(4, idPengajuan);

            int rowsInserted = preparedStatement.executeUpdate();

            insertSuccessful = rowsInserted > 0;
        } catch (SQLException e) {
            Logger.getLogger(RiwayatSurat.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection();
        }

        return insertSuccessful;
    }
```
### Penjelasan Kode
- `boolean insertSuccessful`: Variabel ini adalah boolean yang mengindikasikan apakah proses penambahan data riwayat surat berhasil. Nilai `true` menunjukkan bahwa data berhasil dimasukkan, sedangkan nilai `false` menunjukkan bahwa proses penambahan data gagal.
- Metode ini membuka koneksi ke database yang digunakan dalam aplikasi Anda.
- Pernyataan SQL digunakan untuk menyisipkan data baru ke dalam tabel `riwayat_surat`. Data yang dimasukkan meliputi jenis surat, status, posisi surat, action, dan ID_Pengajuan.
- Nilai-nilai yang ingin dimasukkan ke dalam pernyataan SQL diambil dari parameter yang dilewatkan ke metode ini.
- Jika proses penyisipan data berhasil (tidak ada kesalahan SQL), maka `insertSuccessful` akan diatur sebagai `true`, mengindikasikan bahwa data riwayat surat berhasil dimasukkan.
- Jika terjadi kesalahan SQL selama proses penyisipan data atau proses tersebut gagal, metode ini akan menangani kesalahan tersebut dan mengembalikan `false`.
Metode `insertData` merupakan komponen penting dalam aplikasi Anda yang memungkinkan Anda untuk mencatat riwayat surat yang terkait dengan berbagai tindakan dan posisi dalam alur kerja aplikasi Anda.


- Metode readData
```
public List<String[]> readData() {
        List<String[]> data = new ArrayList<>();

        try {
            openConnection();

            String sql = "SELECT * FROM riwayat_surat"; 
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idSurat = resultSet.getString("ID_Surat");
                String jenisSurat = resultSet.getString("Jenis_Surat");
                String status = resultSet.getString("Status");
                String posisiSurat = resultSet.getString("Posisi_Surat");
                String action = resultSet.getString("Action");
                String pengajuanID = resultSet.getString("Pengajuan_ID_Pengajuan");

                String[] row = {idSurat, jenisSurat, status, posisiSurat, action, pengajuanID};
                data.add(row);
            }
        } catch (SQLException e) {
            Logger.getLogger(RiwayatSurat.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            openConnection();
        }
        return data;
    }
```
### Penjelasan Kode
- `List<String[]> data`: Variabel ini adalah daftar yang berisi array string. Setiap elemen dalam daftar adalah array yang berisi informasi riwayat surat, seperti ID Surat, Jenis Surat, Status, Posisi Surat, Action, dan ID Pengajuan.
- Metode ini membuka koneksi ke database yang digunakan dalam aplikasi Anda.
- Pernyataan SQL digunakan untuk mengambil data dari tabel `riwayat_surat`.
- Hasil dari pernyataan SQL diambil dalam bentuk objek `ResultSet`, dan setiap baris data riwayat surat diekstrak dari hasil ini.
- Setiap baris data riwayat surat disimpan dalam bentuk array string, dan array tersebut ditambahkan ke dalam daftar `data`.
- Setelah semua data riwayat surat telah dibaca dan dimasukkan ke dalam daftar, daftar `data` dikembalikan sebagai hasil dari metode.
- Jika terjadi kesalahan SQL selama proses pembacaan data, metode ini akan menangani kesalahan tersebut dan mengembalikan daftar kosong.
Metode `readData` merupakan komponen penting dalam aplikasi Anda yang memungkinkan Anda untuk mengakses dan menampilkan riwayat surat dalam berbagai konteks aplikasi Anda.

- Metode updateData
```
public final boolean updateData(DataUpdate dataUpdate) {
      boolean updateSuccessful = false;

      try {
          openConnection();

          String sql = "UPDATE riwayat_surat SET Status = ? WHERE ID_Surat = ?";
          PreparedStatement preparedStatement = connection.prepareStatement(sql);
          preparedStatement.setString(1, dataUpdate.getStatus()); 
          preparedStatement.setString(2, dataUpdate.getNim());

          int rowsUpdated = preparedStatement.executeUpdate();

          if (rowsUpdated > 0) {
              updateSuccessful = true;
          }
      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
          closeConnection();
      }

      return updateSuccessful;
  }
}
```
### Penjelasan Kode
- `DataUpdate dataUpdate`: Metode ini menerima objek `DataUpdate` yang berisi informasi yang diperlukan untuk melakukan pembaruan, seperti ID Surat yang akan diperbarui dan status yang akan diatur.
- Metode ini membuka koneksi ke database yang digunakan dalam aplikasi Anda.
- Pernyataan SQL digunakan untuk mengupdate status suatu surat berdasarkan ID Surat yang diberikan.
- Status yang akan diupdate diambil dari objek `dataUpdate`.
- Hasil dari pernyataan SQL menunjukkan berapa banyak baris yang berhasil diupdate.
- Jika baris berhasil diupdate (jumlah baris yang diupdate lebih dari 0), maka metode mengembalikan `true`, yang menunjukkan bahwa pembaruan berhasil. Jika tidak ada baris yang diupdate, maka metode mengembalikan `false`.
- Jika terjadi kesalahan SQL selama proses pembaruan, metode ini akan menangani kesalahan tersebut.
Metode `updateData` adalah komponen penting dalam aplikasi Anda yang memungkinkan Anda untuk mengubah status suatu surat dalam riwayat surat, seperti mengubahnya menjadi "Diterima" atau "Ditolak". Hal ini sangat berguna dalam mengelola riwayat surat dalam aplikasi Anda.

### GUI Package
##### ChooseLogin
- Kelas ChoosLogin
  ```
  public class ChooseLogin extends javax.swing.JFrame {
    private MahasiswaForm mahasiswaForm;
    private StaffForm staffForm;
    public ChooseLogin() {
        initComponents();
        mahasiswaForm = new MahasiswaForm();
        staffForm = new StaffForm();
        this.setPreferredSize(new Dimension(800, 600));
    }
  ```
### Penjelasan Kode
Kelas `ChooseLogin` digunakan dalam aplikasi untuk memberikan pilihan login kepada pengguna. Pengguna dapat memilih untuk login sebagai mahasiswa atau staff dengan mengeklik tombol yang sesuai. Berikut adalah penjelasan dari kelas ini:
- Kelas ini memiliki dua atribut, yaitu `mahasiswaForm` dan `staffForm`, yang masing-masing merupakan objek dari kelas `MahasiswaForm` dan `StaffForm`. Kedua objek ini digunakan untuk mengakses antarmuka login mahasiswa dan staff.
- Dalam konstruktor kelas `ChooseLogin`, objek `mahasiswaForm` dan `staffForm` diciptakan. Ini memungkinkan aplikasi untuk menampilkan antarmuka login mahasiswa dan staff saat pengguna memilihnya.
- Selain itu, kelas ini juga mengatur preferensi dimensi jendela aplikasi menjadi 800x600 piksel.
Kelas `ChooseLogin` bertindak sebagai jendela awal yang memberikan pilihan login kepada pengguna. Dengan memilih login sebagai mahasiswa atau staff, pengguna dapat mengakses fungsi yang sesuai dalam aplikasi.


- Metode untuk memilih jendela login
  ```
   private void loginNonMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginNonMahasiswaActionPerformed
        // TODO add your handling code here:
        staffForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginNonMahasiswaActionPerformed

    private void loginMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMahasiswaActionPerformed
        // TODO add your handling code here:
        mahasiswaForm.setVisible(true);
        this.dispose();
    }
  ```
### Penjelasan Kode
Metode `loginNonMahasiswaActionPerformed` dan `loginMahasiswaActionPerformed` digunakan dalam kelas `ChooseLogin` untuk menangani tindakan yang terjadi saat pengguna memilih login sebagai mahasiswa atau staff. Berikut adalah penjelasan dari kedua metode ini:
- Metode `loginNonMahasiswaActionPerformed`:
  - Metode ini dipanggil ketika pengguna memilih untuk login sebagai staff.
  - Saat metode ini dipanggil, jendela antarmuka staff (`staffForm`) akan ditampilkan dengan memanggil metode `setVisible(true)`.
  - Jendela antarmuka `ChooseLogin` akan ditutup (`this.dispose()`) sehingga hanya antarmuka staff yang ditampilkan.
- Metode `loginMahasiswaActionPerformed`:
  - Metode ini dipanggil ketika pengguna memilih untuk login sebagai mahasiswa.
  - Saat metode ini dipanggil, jendela antarmuka mahasiswa (`mahasiswaForm`) akan ditampilkan dengan memanggil metode `setVisible(true)`.
  - Jendela antarmuka `ChooseLogin` akan ditutup (`this.dispose()`) sehingga hanya antarmuka mahasiswa yang ditampilkan.
Metode-metode ini memungkinkan pengguna untuk memilih jenis login yang sesuai, yaitu sebagai mahasiswa atau staff, dan mengarahkan mereka ke antarmuka yang sesuai untuk melakukan proses login.

##### MahasiswaForm
- Melakukan Inisialisasi pada komponen
  ```
  public class MahasiswaForm extends javax.swing.JFrame {
    final Database database;
    private  DataDiri dataMahasiswa;
 
    public MahasiswaForm() {
        initComponents();
        database = new Database();
        passTextField.setEchoChar((char) 0);
        passTextField.setText("Password");
        popError.setVisible(false);
    }
  ```
### Penjelasan Kode
### Kelas MahasiswaForm
Kelas `MahasiswaForm` merupakan salah satu kelas dalam proyek ini dan digunakan untuk mengelola antarmuka pengguna untuk mahasiswa. Ini termasuk pengelolaan masuk dan tampilan data diri mahasiswa.
- `database`: Variabel `database` adalah objek dari kelas `Database` yang digunakan untuk berinteraksi dengan basis data.
- `dataMahasiswa`: Variabel `dataMahasiswa` adalah objek dari kelas `DataDiri` yang digunakan untuk mengelola dan menampilkan data diri mahasiswa.
Metode konstruktor ini akan dijalankan saat objek kelas `MahasiswaForm` dibuat.
- `initComponents()`: Metode ini adalah metode yang digenerate secara otomatis oleh IDE dan digunakan untuk menginisialisasi komponen-komponen dalam antarmuka pengguna.
- `passTextField.setEchoChar((char) 0)`: Baris ini mengatur `passTextField` (kotak teks untuk kata sandi) untuk menampilkan karakter tanpa menyembunyikannya. Ini berguna untuk menampilkan kata sandi secara jelas.
- `passTextField.setText("Password")`: Baris ini mengatur teks default "Password" dalam `passTextField` yang akan diganti saat pengguna memasukkan kata sandi mereka.
- `popError.setVisible(false)`: Baris ini mengatur komponen `popError` (mungkin sebuah popup kesalahan) agar tidak terlihat pada awalnya.
Kelas `MahasiswaForm` digunakan untuk mengatur antarmuka pengguna dan melakukan inisialisasi komponen-komponen dalam antarmuka pengguna yang berkaitan dengan mahasiswa.


- Metode Focus gained and Focus lost pada TextField
  ```
      private void nimTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nimTextFieldFocusGained
        // TODO add your handling code here:
        if (nimTextField.getText().equals("Nim")) {
        nimTextField.setText("");
        nimTextField.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_nimTextFieldFocusGained

    private void nimTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nimTextFieldFocusLost
        // TODO add your handling code here:
        if (nimTextField.getText().isEmpty()) {
        nimTextField.setText("Nim");
        nimTextField.setForeground(Color.GRAY);
        }
    }
  ```
### Penjelasan Kode
Kelas `MahasiswaForm` mengandung dua metode, yaitu `nimTextFieldFocusGained` dan `nimTextFieldFocusLost`, yang digunakan untuk mengatur perilaku dan tampilan `nimTextField` saat fokus masuk dan keluar.
- `nimTextFieldFocusGained`: Metode ini akan dipanggil saat fokus masuk ke komponen `nimTextField`. Jika teks dalam `nimTextField` sama dengan "Nim", maka teks tersebut akan dihapus dan warna teks akan diatur kembali menjadi hitam.
- `nimTextFieldFocusLost`: Metode ini akan dipanggil saat fokus keluar dari komponen `nimTextField`. Jika teks dalam `nimTextField` kosong, maka teksnya akan diatur kembali menjadi "Nim" dan warna teks akan diatur menjadi abu-abu.
Dua metode ini digunakan untuk memberikan interaktivitas yang lebih baik dengan pengguna, memudahkan pengguna dalam memasukkan NIM, dan memberikan umpan balik visual saat mengisi NIM di dalam `nimTextField`.

- Metode signIn Button untuk login
```
private void signButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signButtonActionPerformed
        // TODO add your handling code here:
        String nim = nimTextField.getText();
        String password = new String(passTextField.getPassword());

        if (nim.equals("Nim") || password.isEmpty()) {
            popError.setText("• Nim tidak boleh kosong\n• Password tidak boleh kosong");
            popError.setVisible(true);
        } else {
            Pengguna data = new Pengguna(nim, password);

            data.openConnection();

            if (data.readData()) {
                MahasiswaInterface mahasiswaInterface = new MahasiswaInterface(nim);
                mahasiswaInterface.setVisible(true);
                popError.setVisible(false);
                this.dispose();
            } else {
                popError.setText("• Login gagal, silahkan cek kembali nim dan password");
                popError.setVisible(true);
            }

            data.closeConnection();
        }
```
### Penjelasan Kode
Dalam kelas `MahasiswaForm`, terdapat metode `signButtonActionPerformed` yang digunakan untuk mengatur tindakan saat tombol "Sign In" ditekan. Berikut adalah penjelasan dari metode ini:
- Saat tombol "Sign In" ditekan, metode ini akan dipanggil.
- Metode ini mengambil teks yang dimasukkan oleh pengguna dalam komponen `nimTextField` sebagai NIM dan teks dalam komponen `passTextField` sebagai kata sandi.
- Kemudian, metode ini memeriksa apakah NIM sama dengan "Nim" atau kata sandi kosong. Jika salah satu dari kondisi tersebut terpenuhi, maka akan ditampilkan pesan kesalahan yang menyatakan bahwa NIM dan kata sandi tidak boleh kosong.
- Jika NIM dan kata sandi tidak kosong, metode ini menciptakan objek `Pengguna` dengan NIM dan kata sandi yang dimasukkan.
- Objek `Pengguna` membuka koneksi ke basis data dan mencoba untuk membaca data pengguna.
- Jika data pengguna ditemukan, maka pengguna akan diarahkan ke antarmuka MahasiswaInterface dengan NIM yang sesuai, dan pesan kesalahan (jika ada) akan disembunyikan.
- Jika login gagal atau data pengguna tidak ditemukan, maka akan ditampilkan pesan kesalahan yang menyatakan bahwa login gagal dan pengguna diminta untuk memeriksa kembali NIM dan kata sandi.
- Terakhir, objek `Pengguna` menutup koneksi ke basis data.
Metode ini bertanggung jawab untuk mengelola proses otentikasi pengguna saat mereka mencoba masuk ke aplikasi. Jika otentikasi berhasil, pengguna akan diarahkan ke antarmuka MahasiswaInterface, dan jika gagal, pesan kesalahan akan ditampilkan.

##### MahasiswaInterface
- Melakukan Inisialisasi MahasiswaInterface
```
public class MahasiswaInterface extends javax.swing.JFrame {
    final Database database;
    private final String roleChecker;
    RiwayatSurat riwayatSurat = new RiwayatSurat();
    CardLayout cardLayout;
    private String mahasiswaNIM;
    private String peruntukan;
    private String mahasiswaNim;
    private String checkNim;
    private JPanel suratButtonPanel;
```
### Penjelasan Kode
- `database`: Variabel `database` adalah objek dari kelas Database yang digunakan untuk berinteraksi dengan basis data.
- `roleChecker`: Variabel `roleChecker` adalah string yang digunakan untuk menyimpan peran pengguna yang saat ini digunakan dalam aplikasi.
- `riwayatSurat`: Variabel `riwayatSurat` adalah objek dari kelas RiwayatSurat yang digunakan untuk mengakses dan mengelola data riwayat surat.
- `cardLayout`: Variabel `cardLayout` adalah objek dari kelas CardLayout yang digunakan untuk mengelola tampilan panel (kartu) dalam antarmuka pengguna.
- `mahasiswaNIM`: Variabel `mahasiswaNIM` adalah string yang digunakan untuk menyimpan NIM (Nomor Induk Mahasiswa) mahasiswa yang saat ini digunakan dalam aplikasi.
- `peruntukan`: Variabel `peruntukan` adalah string yang digunakan untuk menyimpan peruntukan yang saat ini digunakan dalam aplikasi.
- `mahasiswaNim`: Variabel `mahasiswaNim` adalah string yang digunakan untuk menyimpan NIM (Nomor Induk Mahasiswa) yang saat ini digunakan dalam aplikasi.
- `checkNim`: Variabel `checkNim` adalah string yang digunakan untuk memeriksa dan menyimpan NIM (Nomor Induk Mahasiswa) saat memeriksa operasi aplikasi.
- `suratButtonPanel`: Variabel `suratButtonPanel` adalah objek dari kelas JPanel yang digunakan untuk menampilkan tombol-tombol aksi terkait surat pada antarmuka pengguna.


- Melakukan Inisialisasi pada komponen konstruktor JFrame MahasiswaInterface
```
 public MahasiswaInterface(String roleChecker) {
        initComponents();
        database = new Database();
        this.roleChecker = roleChecker;
        pnlCards.add(welcomePanel, "pnlCard4");
        pnlCards.add(suratPanel, "pnlCard2");
        pnlCards.add(profilPanel, "pnlCard1");
        pnlCards.add(changeProfil, "pnlCard3");
        pnlCards.add(buatPanel, "pnlCard4");
        Navigation.setPreferredSize(new Dimension(50, 520)); 
        Navigation.setVisible(true);
        cardLayout = (CardLayout) (pnlCards.getLayout());
        suratButtonPanel = new JPanel();
    }
```
### Penjelasan 
Konstruktor `MahasiswaInterface` adalah metode khusus yang digunakan untuk menginisialisasi objek dari kelas `MahasiswaInterface` ketika kelas ini dibuat (diinstansiasi).
- `roleChecker`: Parameter `roleChecker` adalah sebuah string yang digunakan untuk menerima peran pengguna yang akan digunakan dalam aplikasi.
- `database`: Variabel `database` adalah objek dari kelas `Database` yang digunakan untuk berinteraksi dengan basis data.
- `pnlCards`: Objek `pnlCards` adalah panel yang digunakan untuk menampilkan berbagai kartu (panel) dalam antarmuka pengguna.
- `welcomePanel`, `suratPanel`, `profilPanel`, `changeProfil`, `buatPanel`: Objek-objek ini adalah panel-panel yang akan ditampilkan dalam kartu-kartu antarmuka pengguna.
- `Navigation`: Objek `Navigation` adalah komponen yang digunakan untuk navigasi dalam antarmuka pengguna.
- `cardLayout`: Variabel `cardLayout` adalah objek dari kelas `CardLayout` yang digunakan untuk mengelola tampilan panel (kartu) dalam antarmuka pengguna.
- `suratButtonPanel`: Variabel `suratButtonPanel` adalah objek dari kelas `JPanel` yang digunakan untuk menampilkan tombol-tombol aksi terkait surat pada antarmuka pengguna.

- Metode showData
```
  private void showData() {
        String nimToCheck = roleChecker;
        DataDiri dataMahasiswa = new DataDiri();
        String[] data = dataMahasiswa.readData(nimToCheck);
        
        if (data != null) {
            System.out.println("NIM: " + Arrays.toString(data));
            namaLengkap.setText((String) data[0]);
            nimNomor.setText((String) data[1]);
            programStudi.setText((String) data[2]);
            jenjangStudi.setText((String) data[3]);
            ipkMahasiswa.setText((String) data[4]);
            kontakNomor.setText((String) data[5]);
            angkatanTahun.setText((String) data[6]);
            semesterTahun.setText((String) data[7]);
            alamatRumah.setText((String) data[8]);
            tempatTanggalLahir.setText((String) data[9]);
        } else {
            System.out.println("Data tidak ditemukan");
        }
```
### Penjelasan Kode
Metode `showData()` digunakan untuk menampilkan dan mengisi data dari seorang mahasiswa pada antarmuka pengguna.
- `nimToCheck`: Variabel `nimToCheck` digunakan untuk menyimpan Nomor Induk Mahasiswa (NIM) yang akan dicek atau ditampilkan datanya. Nilainya diambil dari variabel `roleChecker`.
- `dataMahasiswa`: Objek `dataMahasiswa` adalah objek dari kelas `DataDiri` yang digunakan untuk mengakses data mahasiswa.
- `data`: Variabel `data` digunakan untuk menyimpan data mahasiswa yang diambil dari metode `readData(nimToCheck)` dari objek `dataMahasiswa`.

Jika data ditemukan:
- Data mahasiswa diambil dan disimpan dalam bentuk array `data`.
- Data ini kemudian digunakan untuk mengisi berbagai komponen pada antarmuka pengguna, seperti `namaLengkap`, `nimNomor`, `programStudi`, dan lainnya.
- Jika data mahasiswa tidak ditemukan, maka pesan "Data tidak ditemukan" akan dicetak di konsol.
Metode `showData()` digunakan untuk menampilkan informasi dan data mahasiswa pada antarmuka pengguna sesuai dengan NIM yang saat ini sedang digunakan.

- Metode inputData
```
private void inputDataShow() {
        String nimToCheck = roleChecker;
        DataDiri dataMahasiswa = new DataDiri();
        String[] data = dataMahasiswa.readData(nimToCheck);
        
        if (data != null) {
            System.out.println("NIM: " + Arrays.toString(data));
            inputAlamat.setText((String) data[8]);
            inputTempat.setText((String) data[9]);
            inputTanggal.setText((String) data[9]);
            inputAngkatan.setText((String) data[6]);
            inputIPK.setText((String) data[4]);
            inputProgram.setText((String) data[2]);
            inputJenjang.setText((String) data[3]);
            inputKontak.setText((String) data[5]);
            inputSemester.setText((String) data[7]);
        } else {
            System.out.println("Data tidak ditemukan"); 
        }
    }
```
### Penjelasan Kode
Metode `inputDataShow()` digunakan untuk menampilkan dan mengisi data mahasiswa pada antarmuka pengguna dengan tujuan pengisian ulang data.
- `nimToCheck`: Variabel `nimToCheck` digunakan untuk menyimpan Nomor Induk Mahasiswa (NIM) yang akan dicek atau ditampilkan datanya. Nilainya diambil dari variabel `roleChecker`.
- `dataMahasiswa`: Objek `dataMahasiswa` adalah objek dari kelas `DataDiri` yang digunakan untuk mengakses data mahasiswa.
- `data`: Variabel `data` digunakan untuk menyimpan data mahasiswa yang diambil dari metode `readData(nimToCheck)` dari objek `dataMahasiswa`.
Jika data ditemukan:
- Data mahasiswa diambil dan disimpan dalam bentuk array `data`.
- Data ini kemudian digunakan untuk mengisi ulang berbagai komponen pada antarmuka pengguna, seperti `inputAlamat`, `inputTempat`, `inputTanggal`, dan lainnya.
- Jika data mahasiswa tidak ditemukan, maka pesan "Data tidak ditemukan" akan dicetak di konsol.

Metode `inputDataShow()` digunakan untuk mengisi ulang data mahasiswa pada antarmuka pengguna sesuai dengan NIM yang saat ini sedang digunakan.


- Metode signOut
```
private void navigateToLoginScreen() {
        ChooseLogin loginScreen = new ChooseLogin();
        loginScreen.setVisible(true); 
        this.dispose();
    }
private void signOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutActionPerformed
        // TODO add your handling code here:
        navigateToLoginScreen();
    }//GEN-LAST:event_signOutActionPerformed
```
### Penjelasan Kode
Metode `navigateToLoginScreen()` digunakan untuk menavigasi pengguna dari antarmuka saat ini ke layar login ketika mereka memilih untuk keluar (sign out) dari aplikasi.
- Metode ini menciptakan objek `ChooseLogin` yang merupakan antarmuka untuk masuk ke sistem.
- Selanjutnya, ia mengatur antarmuka `ChooseLogin` sebagai terlihat (visible).
- Akhirnya, metode ini menutup antarmuka saat ini dengan memanggil `this.dispose()`.
Metode `navigateToLoginScreen()` memungkinkan pengguna untuk keluar dari aplikasi dan kembali ke halaman login dengan cara yang mudah dan efisien.
Metode `signOutActionPerformed()` digunakan untuk menangani peristiwa saat tombol "Sign Out" ditekan oleh pengguna dalam antarmuka.
- Ketika tombol "Sign Out" ditekan, metode ini memanggil `navigateToLoginScreen()` untuk menavigasi pengguna ke layar login.
Metode ini memberikan kemudahan bagi pengguna untuk keluar dari aplikasi dan kembali ke halaman login dengan cara yang sederhana.


- Metode navigationBar
  ```
  private void navButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navButtonActionPerformed
        // TODO add your handling code here:
        Dimension currentSize = Navigation.getSize();

        if (currentSize.equals(new Dimension(50, 520))) {
            Navigation.setPreferredSize(new Dimension(110, 520));
        } else {
            Navigation.setPreferredSize(new Dimension(50, 520));
        }

        Navigation.revalidate();
        Navigation.repaint();
    }
  ```
### Penjelasan Kode
Metode `navButtonActionPerformed()` digunakan untuk mengelola peristiwa saat tombol navigasi pada antarmuka pengguna ditekan. Tombol ini bertujuan untuk menyembunyikan atau menampilkan panel navigasi.
- Pertama, metode ini mendapatkan dimensi (ukuran) saat ini dari komponen Navigation (panel navigasi).
- Selanjutnya, metode ini memeriksa apakah dimensi saat ini sama dengan `new Dimension(50, 520)`. Jika ya, itu berarti panel navigasi sedang disembunyikan, dan metode akan mengubah ukurannya menjadi `new Dimension(110, 520)`, sehingga panel navigasi akan terlihat.
- Jika dimensi saat ini tidak sama dengan `new Dimension(50, 520)`, itu berarti panel navigasi sedang terlihat, dan metode akan mengubah ukurannya kembali menjadi `new Dimension(50, 520)`, sehingga panel navigasi akan disembunyikan.
- Akhirnya, metode memastikan bahwa perubahan ukuran diterapkan dengan memanggil `Navigation.revalidate()` dan `Navigation.repaint()`.
Metode ini memberikan pengguna kontrol sederhana untuk menyembunyikan atau menampilkan panel navigasi sesuai dengan preferensi mereka, sehingga antarmuka menjadi lebih fleksibel dan mudah digunakan.

- Melakukan updateData dengan changeButton
  ```
  private void changeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButton1ActionPerformed
        // TODO add your handling code here:
        String newAlamat = inputAlamat.getText();
        String newTanggalLahir = inputTanggal.getText();
        String newAngkatan = inputAngkatan.getText();
        String newIpk = inputIPK.getText()  ;
        String newProgram = inputProgram.getText();
        String newJenjang = inputJenjang.getText();
        String newKontak = inputKontak.getText();
        String newSemester = inputSemester.getText();
        String nim = roleChecker;
        
        DataUpdate dataUpdate = new DataUpdate(nim, newAlamat, newTanggalLahir, newAngkatan, newIpk, newProgram, newJenjang, newKontak, newSemester);
    
        DataDiri dataMahasiswa = new DataDiri();
        boolean updateSuccessful = dataMahasiswa.updateData(dataUpdate);

        if (updateSuccessful) {
            System.out.println("Data updated successfully.");
        } else {
            System.out.println("Data update failed.");
        }
    }
  ```
### Penjelasan Kode
Metode `changeButton1ActionPerformed()` digunakan untuk mengelola peristiwa saat tombol "Simpan Perubahan" pada antarmuka pengguna ditekan. Tombol ini bertujuan untuk menyimpan perubahan yang dilakukan oleh pengguna pada data diri mereka.
- Metode ini pertama-tama mengambil semua input pengguna, seperti alamat baru, tanggal lahir baru, angkatan baru, IPK baru, program studi baru, jenjang studi baru, kontak baru, dan semester baru.
- Selanjutnya, metode mengambil NIM (Nomor Induk Mahasiswa) saat ini dari variabel `roleChecker`, yang digunakan untuk mengidentifikasi mahasiswa yang sedang mengakses antarmuka.
- Kemudian, metode membuat objek `DataUpdate` dengan menggunakan data yang telah diambil, yang akan digunakan untuk menyimpan perubahan data.
- Selanjutnya, metode membuat objek `DataDiri` dan mencoba untuk memperbarui data dengan menggunakan objek `DataUpdate`. Jika perubahan data berhasil disimpan, metode mencetak pesan "Data updated successfully." ke konsol.
- Jika perubahan data gagal disimpan, metode mencetak pesan "Data update failed." ke konsol.
Metode ini memungkinkan pengguna untuk menyimpan perubahan pada data diri mereka, seperti alamat, tanggal lahir, dan lainnya, yang akan digunakan dalam aplikasi.

##### StaffForm
- Melakukan Inisialisasi pada komponen
```
package gui;

import database.Database;
import java.awt.Color;
import entitas.Admin;

public class StaffForm extends javax.swing.JFrame {
    final Database database;
    
    public StaffForm() {
        initComponents();
        database = new Database();
        passTextField.setEchoChar((char) 0);
        passTextField.setText("Password");
        popError.setVisible(false);
```
### Penjelasan Kode
Kode ini menciptakan antarmuka untuk staf pada aplikasi dan menginisialisasi komponen pentingnya.
- `database`: Variabel datbase adalah objek dari kelas Database yang digunakan untuk berinteraksi dengan basis data.
- `StaffForm()`: Konstruktor ini digunakan untuk menginisialisasi form staf.
  - Metode `initComponents()` digunakan untuk menginisialisasi komponen antarmuka.
  - Objek `database` diinisialisasi untuk berinteraksi dengan database.
  - Teks pada komponen `passTextField` diatur ke "Password" dan tampilan karakter acak (echo char) diaktifkan. Ini membantu dalam input kata sandi yang aman.
  - Komponen `popError` (pop-up error) awalnya diatur menjadi tidak terlihat (false), yang berarti tidak ada pesan error yang ditampilkan secara default.
Kode ini menciptakan form staf dengan inisialisasi komponen dan persiapan awal untuk antarmuka pengguna.

- Metode Action (Tombol Login/Sign in button)
  ```
  private void signButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signButtonActionPerformed
        // TODO add your handling code here:
        String email = emailTextField.getText();
        String password = new String(passTextField.getPassword());

        if (email.equals("Email") || password.isEmpty()) {
            popError.setText("• Email tidak boleh kosong\n• Password tidak boleh kosong");
            popError.setVisible(true);
        } else {
            Admin data = new Admin (email,password);
            data.openConnection();

            if (data.readData()) {
                StaffInterface staffInterface = new StaffInterface(email);
                staffInterface.setVisible(true);
                popError.setVisible(false);
                this.dispose();
            } else {
                popError.setText("• Login gagal, silahkan cek kembali nim dan password");
                popError.setVisible(true);
            }

            data.closeConnection();
  ```
### Penjelasan Kode
- `email`: Variabel `email` mengambil teks yang dimasukkan ke dalam `emailTextField`, yaitu alamat email yang digunakan untuk login.
- `password`: Variabel `password` mengambil kata sandi (password) yang dimasukkan ke dalam `passTextField`, yang disamarkan.
- Kode berikutnya melakukan validasi. Jika `email` sama dengan "Email" atau `password` kosong, maka pesan error akan ditampilkan pada komponen `popError`, memberikan informasi bahwa alamat email dan kata sandi tidak boleh kosong.
- Jika tidak ada pesan error yang ditampilkan, maka program akan mencoba melakukan login dengan memeriksa informasi yang dimasukkan melalui objek `Admin`. Jika informasi login sesuai (ditemukan dalam database), maka antarmuka `StaffInterface`
- akan ditampilkan dan antarmuka login saat ini akan ditutup (`dispose`).
- Jika informasi login tidak sesuai atau tidak ditemukan dalam database, pesan error akan ditampilkan pada komponen `popError`, memberikan informasi bahwa login gagal.
- Terakhir, koneksi ke database ditutup.

#### Staff Interface
- Imported Package
```
package gui;
import action.PanelAction;
import action.TableActionCellRender;
import controller.DataUpdate;
import database.Database;
import entitas.Admin;
import entitas.DataDiri;
import entitas.Pengajuan;
import entitas.RiwayatSurat;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
````
### Penjelasan Kode
- `database`: Objek database yang digunakan dalam kelas ini.
- `roleChecker`: String yang menyimpan peran pengguna.
- `riwayatSurat`: Objek RiwayatSurat yang digunakan untuk mengakses data riwayat surat.
- `cardLayout`: Objek CardLayout yang digunakan untuk mengelola tampilan panel.
- `email`: String yang menyimpan alamat email.
- `password`: String yang menyimpan kata sandi.
- `mahasiswaNIM`: String yang menyimpan NIM mahasiswa.
- `peruntukan`: String yang menyimpan peruntukan.
- `mahasiswaNim`: String yang menyimpan NIM mahasiswa.
- `checkNim`: String yang digunakan untuk memeriksa NIM.
- `currentNim`: String yang menyimpan NIM saat ini.
- `idSuratToAccept`: String yang menyimpan ID surat yang akan diterima.

- Created Constrcutor
```
 public StaffInterface(String roleChecker) {
        initComponents();
        database = new Database();
        this.roleChecker = roleChecker;
        pnlCards.add(welcomePanel, "pnlCard5");
        pnlCards.add(suratPanel, "pnlCard2");
        pnlCards.add(profilPanel, "pnlCard1");
        pnlCards.add(buatPanel, "pnlCard4");
        Navigation.setPreferredSize(new Dimension(50, 520)); 
        Navigation.setVisible(true);
        cardLayout = (CardLayout) (pnlCards.getLayout());
        suratTabel.setDefaultEditor(Object.class, null);
        suratTabel.setCellSelectionEnabled(false);
    }
```
### Penjelasan Kode
- `database`: Variabel database adalah objek dari kelas Database yang digunakan untuk berinteraksi dengan basis data.
- `roleChecker`: Variabel roleChecker adalah string yang digunakan untuk menyimpan peran pengguna yang saat ini digunakan dalam aplikasi.
- `riwayatSurat`: Variabel riwayatSurat adalah objek dari kelas RiwayatSurat yang digunakan untuk mengakses dan mengelola data riwayat surat.
- `cardLayout`: Variabel cardLayout adalah objek dari kelas CardLayout yang digunakan untuk mengelola tampilan panel (kartu) dalam antarmuka pengguna.
- `email`: Variabel email adalah string yang digunakan untuk menyimpan alamat email yang digunakan dalam aplikasi.
- `password`: Variabel password adalah string yang digunakan untuk menyimpan kata sandi yang digunakan dalam aplikasi.
- `mahasiswaNIM`: Variabel mahasiswaNIM adalah string yang digunakan untuk menyimpan NIM (Nomor Induk Mahasiswa) mahasiswa yang saat ini terkait dengan operasi yang dilakukan.
- `peruntukan`: Variabel peruntukan adalah string yang digunakan untuk menyimpan peruntukan yang terkait dengan operasi yang dilakukan dalam aplikasi.
- `mahasiswaNim`: Variabel mahasiswaNim adalah string yang digunakan untuk menyimpan NIM (Nomor Induk Mahasiswa) mahasiswa yang terkait dalam operasi aplikasi.
- `checkNim`: Variabel checkNim adalah string yang digunakan untuk memeriksa dan menyimpan NIM (Nomor Induk Mahasiswa) saat memeriksa operasi aplikasi.
- `currentNim`: Variabel currentNim adalah string yang digunakan untuk menyimpan NIM (Nomor Induk Mahasiswa) saat ini dalam aplikasi.
- `idSuratToAccept`: Variabel idSuratToAccept adalah string yang digunakan untuk menyimpan ID surat yang akan diterima atau terkait dalam operasi aplikasi.

- Metode showTabel
```
  private void showTable() {
        DefaultTableModel model = new DefaultTableModel();
        Admin admin = new Admin(email, password);

        model.addColumn("ID Surat");
        model.addColumn("Jenis Surat");
        model.addColumn("Status");
        model.addColumn("Posisi Surat");
        model.addColumn("Action");

        List<String[]> riwayatSuratData = riwayatSurat.readData();

        for (String[] row : riwayatSuratData) {
            model.addRow(row);
        }

        suratTabel.setModel(model);

        TableColumn column = suratTabel.getColumnModel().getColumn(4);
        column.setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return new PanelAction();
            }
        });
```
### Penjelasan Kode
- Metode `showTable()` digunakan untuk mengisi dan menampilkan data pada sebuah tabel di antarmuka pengguna.
- Sebuah model tabel (DefaultTableModel) dibuat untuk menampung data yang akan ditampilkan.
- Objek Admin diciptakan dengan menggunakan alamat email dan kata sandi yang ada.
- Kemudian, kolom-kolom (kolom "ID Surat", "Jenis Surat", "Status", "Posisi Surat", dan "Action") ditambahkan ke model tabel.
- Data riwayat surat dibaca dan dimasukkan ke dalam model tabel sebagai baris-baris data.
- Model tabel ditetapkan ke komponen JTable dengan nama suratTabel.
- Kolom "Action" (kolom ke-4) dalam tabel diperoleh dan diubah penampilannya agar dapat menampilkan komponen PanelAction di dalam sel "Action". Ini memungkinkan kita untuk menampilkan komponen khusus di dalam sel ini.

- Metode showData
```
 private void showData(String nimToCheck, String idSurat) {
        DataDiri dataMahasiswa = new DataDiri();
        String[] data = dataMahasiswa.readData(nimToCheck);

        if (data != null) {
            System.out.println("NIM: " + Arrays.toString(data));
            namaLengkap.setText((String) data[0]);
            nimNomor.setText((String) data[1]);
            programStudi.setText((String) data[2]);
            jenjangStudi.setText((String) data[3]);
            ipkMahasiswa.setText((String) data[4]);
            kontakNomor.setText((String) data[5]);
            angkatanTahun.setText((String) data[6]);
            semesterTahun.setText((String) data[7]);
            alamatRumah.setText((String) data[8]);
            tempatTanggalLahir.setText((String) data[9]);
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    private void navigateToLoginScreen() {
            ChooseLogin loginScreen = new ChooseLogin();
            loginScreen.setVisible(true); 
            this.dispose();
        }
```

### Penjelasan Kode
### Menampilkan Data Mahasiswa dan Navigasi ke Layar Login
Kode ini terdiri dari dua metode yang digunakan dalam antarmuka pengguna:

1. `showData(String nimToCheck, String idSurat)`:
   - Metode ini digunakan untuk menampilkan data mahasiswa berdasarkan NIM (Nomor Induk Mahasiswa) yang diberikan dan ID surat yang terkait.
   - Pertama, metode membuat objek `DataDiri` dengan nama `dataMahasiswa`.
   - Selanjutnya, metode memanggil metode `readData(nimToCheck)` dari objek `dataMahasiswa` untuk mengambil data mahasiswa berdasarkan NIM yang diberikan.
   - Jika data ditemukan (bernilai tidak `null`), metode akan menampilkan data tersebut di antarmuka pengguna. Data tersebut mencakup informasi seperti nama lengkap, NIM, program studi, jenjang studi, IPK, nomor kontak, tahun angkatan,
   - semester tahun, alamat rumah, dan tempat/tanggal lahir.
   - Jika data tidak ditemukan (bernilai `null`), metode akan mencetak pesan "Data tidak ditemukan."

2. `navigateToLoginScreen()`:
   - Metode ini digunakan untuk mengganti tampilan antarmuka pengguna ke layar login (`ChooseLogin`).
   - Metode menciptakan objek `ChooseLogin` dengan nama `loginScreen`.
   - Selanjutnya, metode menjadikan layar login `loginScreen` terlihat dengan memanggil `setVisible(true)`.
   - Terakhir, metode ini menutup layar saat ini dengan memanggil `this.dispose()`.
Metode-metode ini memungkinkan pengguna untuk menampilkan data mahasiswa terkait dan berpindah ke layar login ketika diperlukan.

- Metode actionButton (Tombol / Buttom)
```
 private void suratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suratActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "pnlCard5");
        showTable();
    }//GEN-LAST:event_suratActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        // TODO add your handling code here:
        DataUpdate dataUpdate = new DataUpdate(idSuratToAccept, "Accept");
        RiwayatSurat riwayatSurat = new RiwayatSurat();
        boolean updateSuccessful = riwayatSurat.updateData(dataUpdate);

        if (updateSuccessful) {
            System.out.println("Status updated to 'accept'");
        } else {
            System.out.println("Status update failed");
        }
    }
```

### Penjelasan Kode
Kode ini berisi dua metode yang menangani aksi pengguna pada antarmuka:
1. `suratActionPerformed(java.awt.event.ActionEvent evt)`:
   - Metode ini menangani aksi yang terjadi ketika tombol "surat" pada antarmuka ditekan.
   - Pertama, metode mengganti tampilan antarmuka ke "pnlCard5" menggunakan objek `cardLayout`. Ini mengubah tampilan ke panel yang menampilkan data surat.
   - Selanjutnya, metode memanggil metode `showTable()` untuk menampilkan data surat di dalam tabel.
2. `acceptButtonActionPerformed(java.awt.event.ActionEvent evt)`:
   - Metode ini menangani aksi yang terjadi ketika tombol "acceptButton" pada antarmuka ditekan.
   - Pertama, metode menciptakan objek `DataUpdate` dengan informasi ID surat yang akan diterima dan status "Accept".
   - Kemudian, metode menciptakan objek `RiwayatSurat` untuk mengakses dan mengelola data riwayat surat.
   - Metode berusaha untuk memperbarui status surat menjadi "Accept" dengan memanggil metode `updateData(dataUpdate)` pada objek `riwayatSurat`.
   - Jika pembaruan berhasil, metode mencetak pesan "Status updated to 'accept'".
   - Jika pembaruan gagal, metode mencetak pesan "Status update failed".
Metode-metode ini memungkinkan pengguna untuk melihat data surat dan mengubah status surat menjadi "Accept" saat diperlukan.















### Metode AddMouseListener
### Penjelasan Kode
Kode ini digunakan untuk mengendalikan tindakan ketika pengguna mengklik sel dalam kolom "Action" di tabel `suratTabel`.
- `suratTabel.addMouseListener(new MouseAdapter())` menambahkan sebuah mouse listener ke tabel `suratTabel`, sehingga mengizinkan kita untuk menangani peristiwa ketika pengguna mengklik sel dalam tabel.
- `int column = suratTabel.getColumnModel().getColumnIndex("Action")` digunakan untuk mendapatkan indeks kolom yang bernama "Action". Ini memungkinkan kita untuk memeriksa apakah pengguna mengklik sel di kolom "Action".
- `int row = suratTabel.rowAtPoint(e.getPoint())` mengembalikan indeks baris yang sesuai dengan titik yang diklik oleh pengguna.
- Berdasarkan kolom yang di-klik ("Action") dan indeks baris yang ditemukan, kode ini memeriksa apakah pengguna mengklik sel di kolom "Action" dan juga memeriksa apakah indeks baris valid (lebih besar atau sama dengan nol).
- Jika pengguna mengklik sel di kolom "Action" dan indeks baris valid, maka program akan mengambil ID surat yang terkait dengan baris yang diklik, mencari data berdasarkan ID surat tersebut, dan menampilkan data tersebut di "pnlCard1" dalam antarmuka pengguna.
- Hasil dari kode ini adalah mengubah tampilan antarmuka pengguna ke kartu "pnlCard1" dan menampilkan data yang sesuai dengan surat yang diklik oleh pengguna.






### Penjelasan
Kode ini adalah bagian dari kelas `StaffInterface`, yang digunakan untuk mengelola antarmuka pengguna dalam aplikasi Java. Kelas ini memiliki berbagai variabel yang digunakan untuk mengakses data, mengelola tampilan, dan menyimpan informasi pengguna.

Kelas ini digunakan dalam aplikasi untuk berinteraksi dengan pengguna, mengelola data surat, dan mengelola pengajuan. Variabel-variabelnya digunakan untuk menyimpan data seperti alamat email, kata sandi, NIM mahasiswa, peruntukan, dan ID surat yang sedang diterima.

Kelas ini memiliki banyak fungsi dan fitur yang tidak ditampilkan di potongan kode ini, tetapi kode ini adalah bagian penting dari aplikasi untuk memulai antarmuka pengguna dan mengakses data.

### Penggunaan
Kode ini digunakan sebagai dasar untuk mengembangkan fungsi lebih lanjut dalam aplikasi dan dapat diintegrasikan dengan komponen antarmuka pengguna lainnya.


### Catatan
Pastikan kode ini terhubung dengan bagian lain dari aplikasi untuk menjalankan fungsi yang diinginkan.

Di kelas, ini akan melakuknimo _import___ package dari java, salah, satunya dalam contoh diatas adalah ArrayList.

- ![image](https://github.com/PA-E-Surat/PBO_Project_E-Surat/assets/126738691/04cb50f8-c49d-4ea7-bed0-2440e7c76768)
![image](https://github.com/PA-E-Surat/PBO_Project_E-Surat/assets/126738691/ccda7616-44af-4639-899e-9cf47290800c)
Dibagian ini, user dapat memilih menu berdasarkan _role_ akun yang dimiliki, dalam kasus ini, kita akan menggunakan akun mahasiswa.
![image](https://github.com/PA-E-Surat/PBO_Project_E-Surat/assets/126738691/ddf5644c-4e36-4558-ad2e-8624e2acaa55)
User dapat login menggunakan akun resmi yang telah terdafatar, dalam kasus ini kita akan mencoba login menggunakan akun SIAUNMUL.
![image](https://github.com/PA-E-Surat/PBO_Project_E-Surat/assets/126738691/1190142d-ed15-4d45-8ecb-f3f490c15357)
Setelah login, user akan masuk ke menu utama, didalam aplikasi ini sendiri, terdapat 2 menu, yaitu menu Profil dan E-Surat.
Profil terdiri dari data diri mahasiswa, sedangkan E-Surat, user akan dapat meminta pengajuan surat, yang dimana nantinya akan di _review_ oleh admin atau staff universitas.
![image](https://github.com/PA-E-Surat/PBO_Project_E-Surat/assets/126738691/a99adab9-dc67-406f-adc0-768e9c4840af)
Dalam menu profil, terdapat data pribadi mahasiswa. Dalam menu ini pula, mahasiswa dapat mengubah data diri, dengan cara menekan tombol "Ubah Data"
![image](https://github.com/PA-E-Surat/PBO_Project_E-Surat/assets/126738691/2a9e60b8-1848-4e07-9ebc-bbf71986464d)
Selanjutnya adalah menu E-Surat, yaitu menu dimana mahasiswa dapat melakukan pengajuan surat, dalam menu ini, jika mahasiswa melakukan pengajuan surat, maka mahasiswa diharuskan menunggu kurang lebih 1-3 hari kerja.
Setelah itu, surat akan ditampilkan, apakah di _Accept__ atau _Denied._
