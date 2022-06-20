package com.uas.prakrplbo;

import java.util.Arrays;

public abstract class Monster implements MonsterInterface {
    String nama;

    public Monster(String nama) {
        this.nama = nama;
    }

    public abstract String bersuara();

    public void getInfo() {
        for (String s : Arrays.asList("Nama: " + nama, "Suara: " + bersuara(), "Gerak: " + getNama() + ' ' + bergerak() + "...")) {
            System.out.println(s);
        }
    }

    public String getNama() {
        return nama;
    }

    public abstract String bergerak();
}
