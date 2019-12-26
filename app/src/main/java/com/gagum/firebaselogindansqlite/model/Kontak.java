package com.gagum.firebaselogindansqlite.model;

public class Kontak {
    private int no_kontak;
    private String nama;
    private String nomor;
    private String alamat;

    public Kontak(int no_kontak, String nama, String nomor, String alamat) {
        this.no_kontak = no_kontak;
        this.nama = nama;
        this.nomor = nomor;
        this.alamat = alamat;
    }

    public Kontak() {
    }

    public int getNo_kontak() {
        return no_kontak;
    }

    public void setNo_kontak(int no_kontak) {
        this.no_kontak = no_kontak;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
