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

<table style="border-collapse: collapse; width: 100%; max-width: 800px; table-layout: fixed;">
    <tr>
        <td style="border: 1px solid transparent; padding: 5px; text-align: center;">
            <img src="https://github.com/user-attachments/assets/5bc2560d-3259-4cad-a524-ac475f81ff54" alt="Image 1" style="width: 100%; height: auto;">
        </td>
        <td style="border: 1px solid transparent; padding: 5px; text-align: center;">
            <img src="https://github.com/user-attachments/assets/73c4c80a-725a-4b09-a9ec-ce0b84b3fa25" alt="Image 2" style="width: 100%; height: auto;">
        </td>
        <td style="border: 1px solid transparent; padding: 5px; text-align: center;">
            <img src="https://github.com/user-attachments/assets/73ba445b-1e1d-4e24-b355-a26da6cdd5b1" alt="Image 3" style="width: 100%; height: auto;">
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid transparent; padding: 5px; text-align: center;">
            <img src="https://github.com/user-attachments/assets/9e91ab0b-8ca8-49b9-9a8f-eb55782dead4" alt="Image 4" style="width: 100%; height: auto;">
        </td>
        <td style="border: 1px solid transparent; padding: 5px; text-align: center;">
            <img src="https://github.com/user-attachments/assets/ab5d4dee-ef86-4b2d-86f7-d61de2939fc2" alt="Image 5" style="width: 100%; height: auto;">
        </td>
        <td style="border: 1px solid transparent; padding: 5px; text-align: center;">
            <img src="https://github.com/user-attachments/assets/7fbba838-f013-49ba-b132-db211eb3459c" alt="Image 6" style="width: 100%; height: auto;">
        </td>
    </tr>
</table>

Terinspirasi dari Aplikasi tix.id

### Diagram Class

1. CinemaTicketSystem

```
Fungsi:

Entry point aplikasi.

Metode Utama:

main(String[] args) memanggil kelas MainMenu.
```

2. MainMenu

```
Fungsi:

Tampilan awal aplikasi.

Atribut:

frame: JFrame untuk UI.

Metode:

Konstruktor MainMenu(): Membuat frame utama dengan tombol untuk melihat jadwal film atau keluar.
```

3. MovieSelection

```
Fungsi:

Menampilkan daftar film dengan jadwal tayang.

Atribut:

movies: Map untuk menyimpan daftar film dan jadwalnya.
movieImages: Map untuk menyimpan poster film.

Metode:

Konstruktor MovieSelection(): Menyediakan daftar film.
createScaledIcon(String, int, int): Membuat ikon poster berskala.
```

4. SeatSelection

```
Fungsi:

Memilih kursi berdasarkan jadwal tayang.

Atribut:

selectedMovie, selectedTime, ticketCount, selectedSeats: Informasi tentang pemesanan.
bookedSeats: Set kursi yang telah dipesan.

Metode:

SeatSelection(String, String[]): Mengelola pemilihan kursi.
generateSeatsPanel(): Membuat grid untuk kursi.
```

5. PaymentPage

```
Fungsi:

Menampilkan ringkasan pemesanan tiket.

Atribut:

movie, time, seats, totalPrice: Detail pemesanan.

Metode:

Konstruktor PaymentPage(String, String, String, int): Membuat halaman pembayaran.
```

6. BaseFrame

```
Fungsi:

Kelas dasar untuk semua frame aplikasi.

Metode:

Konstruktor BaseFrame(String, int, int): Mengatur properti dasar frame.
```

8. Hubungan Antar Kelas

```
CinemaTicketSystem: Titik awal program, memanggil MainMenu.

MainMenu: Mengarah ke MovieSelection.

MovieSelection: Memilih film dan waktu, lanjut ke SeatSelection.

SeatSelection: Memilih kursi, lanjut ke PaymentPage.

PaymentPage: Menampilkan ringkasan dan kembali ke MainMenu setelah konfirmasi.
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

Tombol "Lihat Jadwal Film" mengarah ke MovieSelection.
```

Movie Selection
```
Tampilan:

Poster film dalam grid.
Tombol "Kembali" untuk kembali ke MainMenu.

Navigasi:

Memilih film mengarah ke SeatSelection.
```

Seat Selection
```
Tampilan:

Dropdown waktu tayang.
Input jumlah tiket.
Grid kursi (10x20, warna hijau untuk kursi dipilih, abu-abu untuk kursi terpesan).

Navigasi:

Memilih jumlah kursi, lanjut ke PaymentPage.
```

Payment Page
```
Tampilan:

Ringkasan pembelian: film, waktu tayang, kursi, total harga.
Tombol "Konfirmasi dan Cetak Tiket".

Navigasi:

Setelah konfirmasi, kembali ke MainMenu.
```

### Coding Implementasi
Kode untuk menciptakan Absolute Cinema, meliputi:

```
CinemaTicketSystem.java: Entry point program, memulai aplikasi dan memanggil menu utama.

MainMenu.java: Menampilkan tampilan awal dengan opsi untuk melihat jadwal film atau keluar.

MovieSelection.java: Menampilkan daftar film, sinopsis, dan jadwal tayang untuk dipilih.

SeatSelection.java: Memungkinkan pemilihan kursi berdasarkan jadwal tayang dan jumlah tiket.

PaymentPage.java: Menampilkan ringkasan pembelian dan mengelola proses pembayaran.

BaseFrame.java: Kelas dasar untuk semua tampilan (frame) dalam aplikasi. Menyediakan pengaturan umum untuk frame seperti ukuran, pengaturan layout, dan tampilan dasar lainnya. Semua frame lainnya, seperti MovieSelection, SeatSelection, dan PaymentPage, akan mewarisi kelas ini.
```

Kode-kodenya mencakup fungsionalitas untuk memandu pengguna dari layar awal hingga konfirmasi tiket dengan antarmuka yang menarik.

![absolutecinema](https://github.com/user-attachments/assets/207dd647-3921-4522-b8f1-edb5e2eeb913)
