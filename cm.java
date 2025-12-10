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

    static void tambahData() {

        System.out.print("Nama Mahasiswa : ");
        data[jumlahData][0] = input.nextLine();

        System.out.print("NIM : ");
        data[jumlahData][1] = input.nextLine();

        System.out.print("Program Studi : ");
        data[jumlahData][2] = input.nextLine();

        System.out.print("Perusahaan Tujuan Magang : ");
        data[jumlahData][3] = input.nextLine();

        String semester;
        while (true) {
            System.out.print("Semester pengambilan magang (6 atau 7): ");
            semester = input.nextLine();
            if (semester.equals("6") || semester.equals("7")) break;
            System.out.println("Input tidak valid! Semester hanya 6 atau 7.");
        }
        data[jumlahData][4] = semester;

        String status;
        while (true) {
            System.out.print("Status magang (Diterima/Menunggu/Ditolak): ");
            status = input.nextLine();
            if (status.equalsIgnoreCase("Diterima") ||
                status.equalsIgnoreCase("Menunggu") ||
                status.equalsIgnoreCase("Ditolak")) break;
            System.out.println("Status tidak valid!");
        }
        data[jumlahData][5] = status;

        jumlahData++;
        System.out.println("Data berhasil ditambahkan! Total pendaftar: " + jumlahData);
    }

    static void tampilkanData() {
        if (jumlahData == 0) {
            System.out.println("Belum ada pendaftar.");
            return;
        }

        System.out.printf("%-4s %-35s %-15s %-20s %-20s %-25s %-10s\n",
                        "No", "Nama", "NIM", "Prodi", "Perusahaan", "Semester", "Status");


        for (int i = 0; i < jumlahData; i++) {
            System.out.printf("%-4s %-35s %-15s %-20s %-20s %-25s %-10s\n",
                    (i + 1), data[i][0],data[i][1], data[i][2], data[i][3], data[i][4], data[i][5]);
        }
    }

    static void cariProdi() {
        System.out.print("Masukkan Program Studi: ");
        String cari = input.nextLine();

        boolean ditemukan = false;
        System.out.println("\nHasil Pencarian: ");

        for (int i = 0; i < jumlahData; i++) {
            if (data[i][2].equalsIgnoreCase(cari)) {
                ditemukan = true;
                System.out.printf("%d. %s | %s | %s | %s | Semester %s | %s\n",
                        (i + 1),
                        data[i][0], data[i][1], data[i][2],
                        data[i][3], data[i][4], data[i][5]);
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ditemukan pendaftar dengan prodi tersebut.");
        }
    }

    static void hitungStatus()   {

   int diterima = 0, menunggu = 0, ditolak = 0;

        for (int i = 0; i < jumlahData; i++) {
            if (data[i][5].equalsIgnoreCase("Diterima")) diterima++;
            else if (data[i][5].equalsIgnoreCase("Menunggu")) menunggu++;
            else if (data[i][5].equalsIgnoreCase("Ditolak")) ditolak++;
        }

        System.out.println("Diterima : " + diterima);
        System.out.println("Menunggu : " + menunggu);
        System.out.println("Ditolak  : " + ditolak);
        System.out.println("Total pendaftar : " + jumlahData);

    }
}