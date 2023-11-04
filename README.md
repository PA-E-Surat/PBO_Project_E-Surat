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
