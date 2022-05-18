/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Jonny
 */
@Entity

public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String laitud;
    private String altitud;
    private char estado;
    @ManyToOne
    @JoinColumn(nullable = true)
    private Cliente cliente;

    public Pedido() {
        super();
    }

    public Pedido(int codigo, String laitud, String altitud, char estado, Cliente cliente) {
        super();
        this.codigo = codigo;
        this.laitud = laitud;
        this.altitud = altitud;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Pedido(int codigo, String laitud, String altitud, char estado) {
        super();
        this.codigo = codigo;
        this.laitud = laitud;
        this.altitud = altitud;
        this.estado = estado;

    }

    @Override
    public int hashCode() {
        return codigo;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        return other.hashCode() == this.hashCode();
    }

}
