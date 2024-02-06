package com.leila.HibernatePR.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table (name = "associati")
public class Associati {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonIgnoreProperties({"associatiList"})
    @ManyToOne
    @JoinColumn(name = "id_clienti", referencedColumnName = "id")
    private Clienti idCliente;

    @JsonIgnoreProperties({"associatiList"})
    @ManyToOne
    @JoinColumn(name = "id_fornitori", referencedColumnName = "id")
    private Fornitori idFornitore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clienti getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clienti idCliente) {
        this.idCliente = idCliente;
    }

    public Fornitori getIdFornitore() {
        return idFornitore;
    }

    public void setIdFornitore(Fornitori idFornitore) {
        this.idFornitore = idFornitore;
    }

    @Override
    public String toString() {
        return "Associati{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idFornitore=" + idFornitore +
                '}';
    }
}
