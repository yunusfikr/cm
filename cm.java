import java.util.Scanner;

public class cm {

    static Scanner input = new Scanner(System.in);

    static String[][] data = new String[100][6];
    static int jumlahData = 0;

    public static void main(String[] args) {
        int pilihan;

        do {
            tampilMenu();
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> tambahData();
                case 2 -> tampilkanData();
                case 3 -> cariProdi();
                case 4 -> hitungStatus();
                case 5 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 5);
    }

    static void tampilMenu() {
        System.out.println("\n---- Sistem Pendaftaran Magang Mahasiswa ----");
        System.out.println("1. Tambah Data Magang");
        System.out.println("2. Tampilkan Semua Pendaftar Magang");
        System.out.println("3. Cari Pendaftar Berdasarkan Program Studi");
        System.out.println("4. Hitung Jumlah Pendaftar untuk Setiap Status");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1-5): ");
    }

    static void tambahData(){

    }

    static void tampilkanData(){

    }

    static void cariProdi(){

    }

    static void hitungStatus(){
        
    }
}