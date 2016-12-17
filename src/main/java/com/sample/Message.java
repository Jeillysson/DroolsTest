package com.sample;

public class Message {

    public static int INICIO = 0;
    public static int SALGADOS = 1;
    public static int DOCES = 2;
    public static int BEBIDAS = 3;
    public static int REFRIGERANTES = 5;
    public static int CAFE = 6;
    public static int SUCOS = 7;
    public static int RETORNO = 8;
    public static int FIM = 4;
    		

    private String message;

    private int status;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}