# LAPORAN PRAKTIKUM PBO E-SURAT
### Oleh Kelompok 13 SI A 22:
### Ayu Cahyarani (2209116008)
### Abdul Rahman (2209116045)
#
### Deskripsi Project
Proyek E-Surat adalah aplikasi manajemen surat berbasis pemrograman berorientasi objek yang bertujuan untuk mengotomatisasi dan meningkatkan efisiensi dalam proses pembuatan surat di Fakultas Teknik Universitas Mulawarman. Aplikasi ini dirancang untuk menggantikan proses manual dalam penanganan surat dan membawa manfaat signifikan seperti peningkatan efisiensi, pengurangan penggunaan kertas, penghematan biaya pengiriman surat fisik, dan peningkatan kemampuan dalam mengelola surat elektronik. Aplikasi ini memberikan solusi modern dan berkelanjutan untuk manajemen surat.
### Flowchart
Berikut adalah diagram yang menggambarkan alur proses sistem E-Surat:

![image](https://github.com/PA-E-Surat/PBO_Project_E-Surat/assets/126738691/848f6c5d-d068-4e06-a9fc-da42f8d27c06)

### ERD

Berikut adalah diagram yang digunakan untuk perancangan database yang menunjukan relasi antar objek beserta atribut-atribut dalam sistem E-Surat secara detail:
![erd esurat19](https://github.com/PA-E-Surat/PBO_Project_E-Surat/assets/126738691/6d1c52fb-874f-49a4-99e8-0d911dc57b52)


### Hierarki Kelas
Berikut adalah kelas yang digunakan dalam sistem E-Surat:

![image](https://github.com/PA-E-Surat/PBO_Project_E-Surat/assets/126738691/fabea52a-155c-457f-adb6-1e4857fab174)


### Source Code
Berikut adalah screenshot source code dari program E-Surat:
##### ActionButton - Tombol Kustom
![image](https://github.com/PA-E-Surat/PBO_Project_E-Surat/assets/126738691/2bb529c3-aeac-4de4-a71d-ee2e1beda4f7)
`ActionButton` adalah kelas yang mewarisi dari `JButton` dan digunakan untuk membuat tombol kustom dengan efek visual saat mouse ditekan. Fitur utama dari kelas ini adalah:
- Ketika mouse ditekan, tombol akan berubah warna menjadi abu-abu tua.
- Ketika mouse dilepaskan, tombol akan kembali ke warna asalnya.

##### PanelAction - Panel Tombol
`PanelAction` adalah kelas JPanel yang berisi sebuah tombol kustom `actionButton` yang digunakan untuk memicu tindakan tertentu ketika diklik. Fitur utama dari kelas ini adalah:
- Tombol `actionButton` dengan latar belakang biru dan teks "DETAIL" yang akan melakukan tindakan ketika diklik.
![image](https://github.com/PA-E-Surat/PBO_Project_E-Surat/assets/126738691/1c8b7db2-43da-41a1-81e4-c2d156812b7d)

##### TableActionCellRender - Pengatur Tampilan Tombol Kustome Tabel
![image](https://github.com/PA-E-Surat/PBO_Project_E-Surat/assets/126738691/fd608b6e-9000-45e8-9377-d2603b196ca5)
`TableActionCellRender` adalah kelas yang memungkinkan kita mengatur tampilan sel dalam `JTable` dengan aksi kustom. Dengan kelas ini, Anda dapat menampilkan panel aksi kustom (`PanelAction`) sebagai konten sel dalam tabel.

##### Tester - Untuk Mencoba Aplikasi
![image](https://github.com/PA-E-Surat/PBO_Project_E-Surat/assets/126738691/dad65653-6730-4ef9-92f2-f2e56b61f681)
`Test` adalah kelas utama dalam _package_ action. Ini adalah aplikasi GUI sederhana yang menggunakan `JTable` dengan sel kustom yang berisi panel aksi (`PanelAction`) untuk menampilkan kostum tabel yang telah dibuat.

#####
#####
#####
#####
#####




### Output
Berikut adalah screenshoot output dari program E-Surat:
# Tampilan menu awal
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
