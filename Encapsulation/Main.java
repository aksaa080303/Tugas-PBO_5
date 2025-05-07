package Encapsulation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Input Data Mahasiswa ===");
        System.out.print("Nama mahasiswa: ");
        String namaMhs = input.nextLine();
        System.out.print("Alamat mahasiswa: ");
        String alamatMhs = input.nextLine();
        Student student = new Student(namaMhs, alamatMhs);

        System.out.print("Jumlah mata kuliah: ");
        int jumlahMatkul = input.nextInt();
        input.nextLine();
        for (int i = 0; i < jumlahMatkul; i++) {
            System.out.print("Mata kuliah ke-" + (i + 1) + ": ");
            String matkul = input.nextLine();
            System.out.print("Nilai: ");
            int nilai = input.nextInt();
            input.nextLine();
            student.addCourseGrade(matkul, nilai);
        }

        System.out.println("\n" + student);
        student.printGrades();
        System.out.println("Rata-rata nilai: " + student.getAverageGrade());

        System.out.println("\n=== Input Data Dosen ===");
        System.out.print("Nama dosen: ");
        String namaDosen = input.nextLine();
        System.out.print("Alamat dosen: ");
        String alamatDosen = input.nextLine();
        Teacher teacher = new Teacher(namaDosen, alamatDosen);

        System.out.print("Jumlah mata kuliah yang diajar: ");
        int jumlahAjar = input.nextInt();
        input.nextLine(); 
        for (int i = 0; i < jumlahAjar; ) {
            System.out.print("Mata kuliah ke-" + (i + 1) + ": ");
            String matkul = input.nextLine();
            boolean berhasil = teacher.addCourse(matkul);
            if (!berhasil) {
                System.out.println("Mata kuliah \"" + matkul + "\" sudah ditambahkan sebelumnya, silakan input yang berbeda.");
            } else {
                i++; 
            }
        }


        System.out.print("\nIngin menghapus mata kuliah dari dosen? (y/n): ");
        String hapus = input.nextLine();
        if (hapus.equalsIgnoreCase("y")) {
            System.out.print("Masukkan nama mata kuliah yang ingin dihapus: ");
            String matkulHapus = input.nextLine();
            boolean removed = teacher.removeCourse(matkulHapus);
            if (removed) {
                System.out.println(" Mata kuliah berhasil dihapus.");
            } else {
                System.out.println(" Mata kuliah tidak ditemukan, tidak bisa dihapus.");
            }
        }

        System.out.println("\n" + teacher);


        input.close();
    }
}


