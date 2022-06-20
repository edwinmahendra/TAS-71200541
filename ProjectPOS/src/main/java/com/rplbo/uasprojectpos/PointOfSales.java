package com.rplbo.uasprojectpos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PointOfSales {
    private ArrayList<Barang> arrBarang;

    public PointOfSales() {
        arrBarang = new ArrayList<>();
    }

    public void inputBarang(Barang barang) {
        arrBarang.add(barang);
    }

    public void tampilDaftarBarang() {
        System.out.println("Kode Barang\t\tNama Barang\t\t\t\tStok\tHarga");
        for (Barang barang : arrBarang) {
            System.out.print(barang.getKode() + "\t\t\t" + barang.getNama() + "\t" + barang.getStok() + "\t\tRp " + barang.getHarga());
            System.out.println();
        }
    }

    public void checkout(HashMap<Barang, Integer> keranjang, long nominal) {
        int tagihan = 0;
        int kembalian = 0;
        int a = 0;

        HashMap<Barang, Integer> keranjang1 = new HashMap<Barang, Integer>();
        Iterator<Map.Entry<Barang, Integer>> iterator = keranjang.entrySet().iterator();
        if (iterator.hasNext()) {
            do {
                Map.Entry<Barang, Integer> j = iterator.next();
                tagihan += j.getKey().getHarga() * j.getValue();
                a += j.getKey().getStok() - j.getValue();
                for (Barang barang : arrBarang) {
                    if (!j.getKey().getNama().equals(barang.getNama())) {
                        continue;
                    }
                    a = barang.getStok() - j.getValue();
                    barang.setStok(a);
                }
            } while (iterator.hasNext());
        }

        System.out.println("-----Transaksi sukses!-----");
        System.out.println("Total Tagihan: Rp " + tagihan);
        System.out.println("Total Bayar: Rp " + nominal);
        kembalian += nominal - tagihan;
        System.out.println("Total kembalian: Rp " + kembalian);
    }
}