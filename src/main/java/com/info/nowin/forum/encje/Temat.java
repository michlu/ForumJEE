package com.info.nowin.forum.encje;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.Timestamp;
import java.util.Set;

/**
 * @author Michlu
 * @sience 2017-01-28
 */
@Entity
@Table(name = "temat")
public class Temat implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private Timestamp data;
    private String tytul;
    @Lob()
    private String tresc;

    @ManyToOne
    @JoinColumn(name = "uzytkownik")
    private Uzytkownik uzytkownik;

    @OneToMany(mappedBy = "temat", fetch = FetchType.EAGER)
    @OrderBy("data ASC")
    private Set<Wpis> wpisy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public Set<Wpis> getWpisy() {
        return wpisy;
    }

    public void setWpisy(Set<Wpis> wpisy) {
        this.wpisy = wpisy;
    }
}
