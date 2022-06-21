/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barang.model;

/**
 *
 * @author Gian
 */
public class Barang {

    private Long id;
    private String nama;
    private String deskripsi;
    private String kategori;
    private int stok;
    private int harga;

    public Barang() {
    }

    public Barang(Long id, String nama, String deskripsi, String kategori, int stok, int harga) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;
    }

    public Barang(String nama, String deskripsi, String kategori, int stok, int harga) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Barang{" + "id=" + id + ", nama=" + nama + ", deskripsi=" + deskripsi + ", kategori=" + kategori + ", stok=" + stok + ", harga=" + harga + '}';
    }

}
