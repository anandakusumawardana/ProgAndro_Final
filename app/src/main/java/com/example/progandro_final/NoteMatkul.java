package com.example.progandro_final;

public class NoteMatkul {
    private String matakuliah, dosen, sks;

    public NoteMatkul(){
        //empty constructor
    }

    public NoteMatkul(String matakuliah, String dosen, String sks){
        this.matakuliah = matakuliah;
        this.dosen = dosen;
        this.sks = sks;
    }

    public String getMataKuliah() {
        return matakuliah;
    }

    public String getDosen() {
        return dosen;
    }

    public String getSks() {
        return sks;
    }

}
