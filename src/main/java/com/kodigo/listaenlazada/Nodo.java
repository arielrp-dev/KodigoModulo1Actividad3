package com.kodigo.listaenlazada;

/**
 * Clase Nodo que representa un elemento de la lista enlazada simple.
 * Cada nodo contiene un valor entero (dato) y una referencia al siguiente nodo en la lista.
 */
public class Nodo {

    // Atributos
    private int dato;
    private Nodo siguiente;

    /**
     * Constructor de la clase Nodo.
     *
     * @param dato El valor entero que contendrá el nodo.
     */
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;  // Inicialmente, el siguiente nodo es null.
    }

    // Métodos getters y setters

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}