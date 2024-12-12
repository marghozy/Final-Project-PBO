# Final-Project-PBO

Usulan Final Project PBO G 2024 (Kelompok 13)
| Name | NRP | Kelas |
| --- | --- | ----------|
| Rafif Thariq Dhiyaulhaqi | 5025231213 | PBO (G) |
| Ammar Ghozy Tanumijaya | 5025231203 | PBO (G) |
| Muhammad Daffa Rizky Sutrisno | 5025231207 | PBO (G) |

## Soal :
1. Tuliskan Judul dan Deskripsi Final Project yang akan dikerjakan
2. Buatlah Desain User Interface dan Diagram Class dari aplikasi Final Project

### ABSOLUTE CINEMA

Absolute Cinema adalah aplikasi berbasis online yang dirancang untuk mempermudah pengguna dalam memesan tiket film. Aplikasi ini memungkinkan pengguna untuk melihat daftar film yang tersedia, memilih jadwal film, menentukan kursi, dan menyelesaikan pembayaran. Fitur utama meliputi:

```
- Tampilan antarmuka pengguna yang ramah dan interaktif.
- Daftar film yang terorganisir berdasarkan studio dan waktu tayang.
- Pemilihan kursi dengan visualisasi tata letak kursi studio.
- Ringkasan dan konfirmasi tiket sebelum pembayaran.
```

Kegunaan aplikasi ini adalah untuk meningkatkan efisiensi dan kenyamanan pengguna dalam memesan tiket tanpa harus antre di lokasi bioskop.

### Desain User Interface

![image](https://github.com/user-attachments/assets/5bc2560d-3259-4cad-a524-ac475f81ff54)
![image](https://github.com/user-attachments/assets/73c4c80a-725a-4b09-a9ec-ce0b84b3fa25)
![image](https://github.com/user-attachments/assets/73ba445b-1e1d-4e24-b355-a26da6cdd5b1)
![image](https://github.com/user-attachments/assets/9e91ab0b-8ca8-49b9-9a8f-eb55782dead4)
![image](https://github.com/user-attachments/assets/ab5d4dee-ef86-4b2d-86f7-d61de2939fc2)

Terinspirasi dari Aplikasi tix.id

### Diagram Class

1. CinemaTicketSystem

```
Attributes: (none)
Methods:
+ main(String[]): void
```

2. MainMenu

```
Attributes:
- frame: JFrame
Methods:
+ MainMenu()
```

3. MovieSelection

```
Attributes:
- frame: JFrame
- movies: Map<String, String[]>
- movieImages: Map<String, String>
Methods:
+ MovieSelection()
```

4. SeatSelection

```
Attributes:
- frame: JFrame
- selectedMovie: String
- times: String[]
- selectedTime: String
- ticketCount: int
- selectedSeats: List<String>
- bookedSeats: Set<String>
Methods:
+ SeatSelection(String, String[])
- generateSeatsPanel(): JPanel
```

5. PaymentPage

```
Attributes:
- frame: JFrame
- movie: String
- time: String
- seats: String
- totalPrice: int
Methods:
+ PaymentPage(String, String, String, int)
```

6. Hubungan Antar Kelas

```
CinemaTicketSystem: Titik awal program, memanggil MainMenu.
MainMenu: Menyediakan akses ke menu utama dan navigasi ke MovieSelection.
MovieSelection: Menampilkan daftar film dan memungkinkan pengguna memilih film serta waktu tayang, lalu melanjutkan ke SeatSelection.
SeatSelection: Memungkinkan pengguna memilih kursi sesuai jumlah tiket, kemudian melanjutkan ke PaymentPage.
PaymentPage: Menampilkan ringkasan pembelian tiket dan menyelesaikan transaksi.
```

### Desain UI

Main Menu
```
Tampilan:
Judul: "Selamat Datang di Cinema Ticket System".
Tombol:
"Lihat Jadwal Film".
"Keluar".
Navigasi:
Tombol "Lihat Jadwal Film" membawa pengguna ke MovieSelection.
```

Movie Selection
```
Tampilan:
Grid poster film (dengan gambar jika tersedia).
Nama film di bawah poster.
Tombol "Kembali" untuk kembali ke MainMenu.
Navigasi:
Memilih film membawa pengguna ke SeatSelection.
```

Seat Selection
```
Tampilan:
Dropdown untuk memilih waktu tayang.
Input jumlah tiket.
Grid kursi (10x20, diwarnai hijau jika dipilih dan abu-abu jika sudah dipesan).
Tombol:
"Lanjut" untuk melanjutkan ke pemilihan kursi.
"Lanjut ke Pembayaran" untuk menuju PaymentPage.
"Kembali" untuk kembali ke MovieSelection.
Navigasi:
Memilih jumlah kursi sesuai tiket, lalu melanjutkan ke pembayaran.
```

Payment Page
```
Tampilan:
Ringkasan:
Nama film.
Waktu tayang.
Kursi yang dipilih.
Total harga dalam format lokal Indonesia.
Tombol:
"Konfirmasi dan Cetak Tiket".
Navigasi:
Setelah konfirmasi, kembali ke MainMenu.
```

### Coding Implementasi
Kode untuk menciptakan Absolute Cinema, meliputi:

```
CinemaTicketSystem.java sebagai entri utama program.
MainMenu.java untuk tampilan awal.
MovieSelection.java untuk memilih film dan waktu tayang.
SeatSelection.java untuk memilih kursi berdasarkan waktu tayang.
PaymentPage.java untuk konfirmasi dan pembayaran tiket.
```

Kode-kodenya mencakup fungsionalitas untuk memandu pengguna dari layar awal hingga konfirmasi tiket dengan antarmuka yang menarik.
