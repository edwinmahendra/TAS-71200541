package com.uas.prakrplbo;

/**
 * Hello world!
 *
 */
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Monster> monster_toko;
    static ArrayList<Monster> monster_namaKamu;
    public static void main( String[] args ) {
        Scanner input = new Scanner(System.in);
        final Monster cerberus1 = new Cerberus("Mike");
        final Monster cerberus2 = new Cerberus("Clay");
        final Monster manticore1 = new Manticore("Ron");
        final Monster manticore2 = new Manticore("Pay");
        final Monster cyclops1 = new Cyclops("Chuck");
        final Monster cyclops2 = new Cyclops("Jey");
        monster_toko = new ArrayList<Monster>() {
            {
                add(cerberus1);
                add(cerberus2);
                add(manticore1);
                add(manticore2);
                add(cyclops1);
                add(cyclops2);
            }
        };
        monster_namaKamu = new ArrayList<>();
        System.out.println("Selamat datang di monster shop UKDW");
        System.out.println("Siapakah namamu?");
        System.out.print("Nama: ");
        String nama = input.nextLine();
        System.out.println("Halo " + nama + "! Silakan pilih menu di bawah ini");
        int pilihan = 0;
        while(pilihan != 5) {
            System.out.println("" +
                    "1. Beli monster\n" +
                    "2. Gabungkan monster\n" +
                    "3. Lihat data monster\n" +
                    "4. Lihat daftar monster\n" +
                    "5. Tutup program");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    if (monster_toko.size() > 0) {
                        System.out.println("Daftar monster yang ada di toko");
                        tampilkanMonsterToko();
                        System.out.println("Monster nomor berapa yang akan kamu beli?");
                        System.out.print("Nomor monster: ");
                        int beli = input.nextInt();
                        beliMonster(beli);
                    }else{
                        tampilkanMonsterToko();
                        break;
                    }
                    break;
                case 2:
                    tampilkanMonsterSaya();
                    System.out.println("Monster nomor berapa saja yang akan kamu gabungkan?");
                    System.out.print("Nomor monster 1: ");
                    int monster1 = input.nextInt();
                    System.out.print("Nomor monster 2: ");
                    int monster2 = input.nextInt();
                    gabungkanMonster(monster1, monster2);
                    break;
                case 3:

                    if (monster_namaKamu.size() <= 0 && monster_namaKamu.size() <= monster_toko.size()){
                        tampilkanMonsterSaya();
                        break;
                    }else{
                        tampilkanMonsterSaya();
                        System.out.println("Monster nomor berapa yang akan kamu lihat?");
                        System.out.print("Nomor monster: ");
                        int monster = input.nextInt();
                        if(monster<monster_namaKamu.size()){
                            getMonsterSaya(monster).getInfo();
                        }else{
                            System.out.println("Monster anda tidak sampai "+monster );
                        }

                    }
                    break;
                case 4:
                    tampilkanMonsterSaya();
                    break;
                default:
                    System.out.println("Terima kasih, " + nama + ", semoga harimu menyenangkan!");
                    break;
            }
            System.out.println("\n===========================\n");
        }
    }
    public static void tampilkanMonsterToko() {
        if (monster_toko.size() > 0) {
            int i = 1;
            for (Monster monster : monster_toko) {
                System.out.println(i + ". " + monster.getNama());
                i++;
            }
        } else {
            System.out.println("Ups! Monster di toko sudah habis");

        }
    }
    public static void tampilkanMonsterSaya() {
        if (monster_namaKamu.size() > 0) {
            int i = 1;
            for (Monster monster : monster_namaKamu) {
                System.out.println(i + ". " + monster.getNama());
                i++;
            }
        } else {
            System.out.println("Ups! Kamu belum memiliki monster");
        }
    }
    public static void beliMonster(int monster) {
        if (monster <= 0 || monster > monster_toko.size()) {
            System.out.println("Ups! Monster di toko sudah habis");
        } else {
            Monster beliMonster = monster_toko.get(monster-1);
            monster_toko.remove(monster-1);
            monster_namaKamu.add(beliMonster);
            System.out.println("Berhasil membeli monster " + beliMonster.getNama() + "!");
        }
    }
    public static Monster getMonsterSaya(int monster) {
        return monster_namaKamu.get(monster-1);
    }
    public static void gabungkanMonster(int monster1, int monster2) {
        Evolusi monster = new Evolusi(getMonsterSaya(monster1),getMonsterSaya(monster2));
        System.out.println("Monster baru berhasil terlahir");
        System.out.println("Data monster: ");
        monster.getInfo();
    }
}