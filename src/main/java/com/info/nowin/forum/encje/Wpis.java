package com.info.nowin.forum.encje;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * @author Michlu
 * @sience 2017-01-28
 */
@Entity
@Table(name = "wpis")
public class Wpis implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private Timestamp data;

    @Lob()
    private String tresc;

    @ManyToOne
    @JoinColumn(name = "uzytkownik")
    private Uzytkownik uzytkownik;

    @ManyToOne
    @JoinColumn(name = "temat")
    private Temat temat;

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

    public Temat getTemat() {
        return temat;
    }

    public void setTemat(Temat temat) {
        this.temat = temat;
    }
}
