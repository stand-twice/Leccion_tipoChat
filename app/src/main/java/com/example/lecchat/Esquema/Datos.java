package com.example.lecchat.Esquema;

public class Datos {

    private String dialogo;
    private String Naudio;
    private int id;
    private int lecciones_id;
    private int persona;

    public Datos(int i, int lec_id, int p, String d, String a) {
        this.id = i;
        this.lecciones_id = lec_id;
        this.persona = p;
        this.dialogo = d;
        this.Naudio = a;
    }

    public Datos(){}

    public String getDialogo() {
        return dialogo;
    }

    public void setDialogo(String dialogo) {
        this.dialogo = dialogo;
    }

    public String getNaudio() {
        return Naudio;
    }

    public void setNaudio(String naudio) {
        Naudio = naudio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLecciones_id() {
        return lecciones_id;
    }

    public void setLecciones_id(int lecciones_id) {
        this.lecciones_id = lecciones_id;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }
}
