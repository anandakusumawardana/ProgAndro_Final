package com.example.progandro_final;

public class Valid {
    protected   boolean isValid(String username, String pwd){
        return username.equals("kimJisoo@gmail.com") && pwd.equals("blackpink") ||
                username.equals("ananda@gmail.com") && pwd.equals("123");
    }
}
