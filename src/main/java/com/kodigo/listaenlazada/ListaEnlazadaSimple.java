package com.kodigo.listaenlazada;

/**
 * Clase que implementa una lista enlazada simple.
 * Permite realizar operaciones básicas como insertar y eliminar nodos al inicio de la lista.
 */
public class ListaEnlazadaSimple {

    // Atributo que representa la cabeza de la lista
    private Nodo cabeza;

    /**
     * Constructor de la clase ListaEnlazadaSimple.
     * Inicialmente, la lista está vacía, por lo que cabeza es null.
     */
    public ListaEnlazadaSimple() {
        this.cabeza = null;
    }

    /**
     * Inserta un nuevo nodo con el dato proporcionado al inicio de la lista.
     *
     * @param dato El valor entero que contendrá el nuevo nodo.
     */
    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.setSiguiente(cabeza);  // El nuevo nodo apunta al antiguo primer nodo.
        cabeza = nuevoNodo;  // La cabeza ahora es el nuevo nodo.
    }

    /**
     * Elimina el nodo que está al inicio de la lista, si existe.
     * Si la lista está vacía, no realiza ninguna acción.
     */
    public void eliminarAlInicio() {
        if (cabeza != null) {
            cabeza = cabeza.getSiguiente();  // La cabeza pasa a ser el siguiente nodo.
        }
    }

    /**
     * Inserta un nuevo nodo con el dato dado en la posición especificada.
     *
     * @param dato El valor entero que contendrá el nuevo nodo.
     * @param posicion La posición en la que se debe insertar el nuevo nodo.
     *                La posición 0 es el inicio de la lista.
     */
    public void insertarEnPosicion(int dato, int posicion) {
        if (posicion < 0) {
            throw new IllegalArgumentException("La posición no puede ser negativa.");
        }

        Nodo nuevoNodo = new Nodo(dato);

        if (posicion == 0) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
            return;
        }

        Nodo actual = cabeza;
        for (int i = 0; i < posicion - 1 && actual != null; i++) {
            actual = actual.getSiguiente();
        }

        if (actual == null) {
            throw new IndexOutOfBoundsException("La posición es mayor que el tamaño de la lista.");
        }

        nuevoNodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevoNodo);
    }

    /**
     * Muestra los elementos de la lista enlazada en consola.
     * Imprime cada nodo con su respectivo valor.
     */
    public void imprimirLista() {
        Nodo actual = cabeza;
        System.out.print("Lista enlazada: ");
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();  // Avanza al siguiente nodo.
        }
        System.out.println("null");  // Marca el final de la lista.
    }

    /**
     * Devuelve el nodo que está en la cabeza de la lista.
     *
     * @return El nodo que está en la cabeza de la lista.
     */
    public Nodo getCabeza() {
        return cabeza;
    }
}
