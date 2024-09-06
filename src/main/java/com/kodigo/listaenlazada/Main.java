package com.kodigo.listaenlazada;

/**
 * Clase principal para interactuar con la lista enlazada simple.
 * Permite insertar, eliminar y mostrar los elementos de la lista.
 */
public class Main {

    public static void main(String[] args) {
        // Crear una instancia de la lista enlazada simple
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        // Inserciones al inicio de la lista
        System.out.println("Insertando nodos al inicio:");
        lista.insertarAlInicio(10);
        lista.imprimirLista();
        lista.insertarAlInicio(20);
        lista.imprimirLista();
        lista.insertarAlInicio(30);
        lista.imprimirLista();

        // Eliminación del nodo al inicio de la lista
        System.out.println("\nEliminando nodo al inicio:");
        lista.eliminarAlInicio();
        lista.imprimirLista();

        // Interacciones adicionales
        System.out.println("\nInsertando y eliminando más nodos:");
        lista.insertarAlInicio(40);
        lista.imprimirLista();
        lista.eliminarAlInicio();
        lista.imprimirLista();
    }
}