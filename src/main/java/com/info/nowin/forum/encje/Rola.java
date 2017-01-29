package com.info.nowin.forum.encje;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Michlu
 * @sience 2017-01-28
 */
@Entity
@Table(name="rola")
public class Rola implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String login;
    private String rola;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }
}
