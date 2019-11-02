package com.example.progandro_final;

public class NoteMatkul {
    private String mataKuliah, dosen,sks;

    public NoteMatkul(String mataKuliah, String dosen, String sks){
        this.mataKuliah = mataKuliah;
        this.dosen = dosen;
        this.sks = sks;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public String getDosen() {
        return dosen;
    }

    public String getSks() {
        return sks;
    }

}
