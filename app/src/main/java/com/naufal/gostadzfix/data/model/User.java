package com.naufal.gostadzfix.data.model;

public class User {
    String firstname, lastname, tanggallahir, provinsi, kabupaten_kota, kecamatan, nophone;
    public User(String firstname, String lastname, String tanggallahir, String provinsi, String kabupaten_kota, String kecamatan, String nophone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.tanggallahir = tanggallahir;
        this.provinsi = provinsi;
        this.kabupaten_kota = kabupaten_kota;
        this.kecamatan = kecamatan;
        this.nophone = nophone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTanggallahir() {
        return tanggallahir;
    }

    public void setTanggallahir(String tanggallahir) {
        this.tanggallahir = tanggallahir;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKabupaten_kota() {
        return kabupaten_kota;
    }

    public void setKabupaten_kota(String kabupaten_kota) {
        this.kabupaten_kota = kabupaten_kota;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getNophone() {
        return nophone;
    }

    public void setNophone(String nophone) {
        this.nophone = nophone;
    }
}