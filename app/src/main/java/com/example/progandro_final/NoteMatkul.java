package com.example.progandro_final;

import com.google.firebase.firestore.PropertyName;

public class NoteMatkul {
    private String matakuliah, dosen, sks;

    public NoteMatkul(){
        //empty constructor
    }

    public NoteMatkul(String matakuliah, String dosen, String sks){
        this.matakuliah = matakuliah;
        this.dosen = dosen;
        this.sks = sks;
        System.out.println("tes");
    }
    @PropertyName("matakuliah")
    public String getMataKuliah() {
        return matakuliah;
    }
    @PropertyName("dosen")
    public String getDosen() {
        return dosen;
    }
    @PropertyName("sks")
    public String getSks() {
        return sks;
    }

}
