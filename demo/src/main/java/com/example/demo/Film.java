package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="Filmy")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tytul;
    private String gatunek;
    private String rezyser;
    private String scenarzysta;
    private String opis;
    @Transient
    boolean  nowy;

    public Film(String tytul, String gatunek, String rezyser, String scenarzysta, String opis, boolean nowy) {
        this.tytul = tytul;
        this.gatunek = gatunek;
        this.rezyser = rezyser;
        this.scenarzysta = scenarzysta;
        this.opis = opis;
        this.nowy = nowy;
    }

    public Film(Integer id, String tytul, String gatunek, String rezyser, String scenarzysta, String opis, boolean nowy) {
        this.id = id;
        this.tytul = tytul;
        this.gatunek = gatunek;
        this.rezyser = rezyser;
        this.scenarzysta = scenarzysta;
        this.opis = opis;
        this.nowy = nowy;
    }

    public Film() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String imie) {
        this.tytul = tytul;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getRezyser() {
        return rezyser;
    }

    public void setRezyser(String rezyser) {
        this.rezyser = rezyser;
    }

    public String getScenarzysta() {
        return scenarzysta;
    }

    public void setScenarzysta(String scenarzysta) {
        this.scenarzysta = scenarzysta;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isNowy() {
        return nowy;
    }

    public void setNowy(boolean nowy) {
        this.nowy = nowy;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", tytul='" + tytul + '\'' +
                ", gatunek='" + gatunek + '\'' +
                ", rezyser='" + rezyser + '\'' +
                ", scenarzysta='" + scenarzysta + '\'' +
                ", opis='" + opis + '\'' +
                ", nowy=" + nowy +
                '}';
    }
}