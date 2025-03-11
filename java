
1.	Kelas Buku
public class Buku { private String idBuku; private String judul; private String penulis; private int tahunTerbit;
private boolean status; // true jika tersedia, false jika dipinjam
public Buku(String idBuku, String judul, String penulis, int tahunTerbit) { this.idBuku = idBuku;
this.judul = judul; this.penulis = penulis;
this.tahunTerbit = tahunTerbit; this.status = true; // Buku baru tersedia
}
 
public void tampilkanInfo() { System.out.println("ID Buku: " + idBuku); System.out.println("Judul: " + judul); System.out.println("Penulis: " + penulis);
System.out.println("Tahun Terbit: " + tahunTerbit); System.out.println("Status: " + (status ? "Tersedia" : "Dipinjam"));
}

public void ubahStatus(boolean status) { this.status = status;
}

public boolean isTersedia() { return status;
}
}

2.	Kelas Anggota
public class Anggota { private String idAnggota; private String nama; private String alamat;
public Anggota(String idAnggota, String nama, String alamat) { this.idAnggota = idAnggota;
this.nama = nama; this.alamat = alamat;
}

public void tampilkanInfo() { System.out.println("ID Anggota: " + idAnggota); System.out.println("Nama: " + nama); System.out.println("Alamat: " + alamat);
}
}

3.	Kelas Pinjaman
public class Peminjaman { private String idPeminjaman; private Anggota anggota; private Buku buku;
private String tanggalPinjam; private String tanggalKembali;

public Peminjaman(String idPeminjaman, Anggota anggota, Buku buku, String tanggalPinjam, String tanggalKembali) {
this.idPeminjaman = idPeminjaman; this.anggota = anggota;
this.buku = buku; this.tanggalPinjam = tanggalPinjam;
this.tanggalKembali = tanggalKembali;
}

public void tampilkanDetailPeminjaman() { System.out.println("ID Peminjaman: " + idPeminjaman);
 
anggota.tampilkanInfo(); buku.tampilkanInfo();
System.out.println("Tanggal Pinjam: " + tanggalPinjam); System.out.println("Tanggal Kembali: " + tanggalKembali);
}
public static boolean pinjamBuku(Anggota anggota, Buku buku, String tanggalPinjam, String tanggalKembali) {
if (buku.isTersedia()) {
buku.ubahStatus(false); // Ubah status buku menjadi dipinjam return true;
} else {
System.out.println("Buku tidak tersedia untuk dipinjam."); return false;
}
}

public static void kembalikanBuku(Buku buku) { buku.ubahStatus(true); // Ubah status buku menjadi tersedia
}
}

4.	Proram Utama
public class Main {
public static void main(String[] args) {
// Membuat beberapa objek Buku
Buku buku1 = new Buku("B001", "Belajar Java", "John Doe", 2020);
Buku buku2 = new Buku("B002", "Pemrograman Berorientasi Objek", "Jane Smith", 2021);

// Membuat beberapa objek Anggota
Anggota anggota1 = new Anggota("A001", "Ali", "Jakarta"); Anggota anggota2 = new Anggota("A002", "Budi", "Bandung");
// Simulasi peminjaman buku
String tanggalPinjam = "2023-10-01"; String tanggalKembali = "2023-10-15";
if (Peminjaman.pinjamBuku(anggota1, buku1, tanggalPinjam, tanggalKembali)) { Peminjaman peminjaman1 = new Peminjaman("P001", anggota1, buku1, tanggalPinjam,
tanggalKembali);
peminjaman1.tampilkanDetailPeminjaman();
}

