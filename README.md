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
###### Controller - Kontroller Aplikasi
##### DataUpdate 

### Database Package
##### Database

### Entitas Package

### GUI Package
##### ChooseLogin
##### MahasiswaForm
##### MahasiswaInterface
##### StaffForm

- Metode showDta
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

- Metode showDta
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

- Metode showDta
### Penjelasan Kode

- Metode showDta
### Penjelasan Kode

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
