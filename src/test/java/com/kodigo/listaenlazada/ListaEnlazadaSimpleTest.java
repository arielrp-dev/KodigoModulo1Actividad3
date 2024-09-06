package com.kodigo.listaenlazada;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * Clase de pruebas unitarias para verificar el funcionamiento de la clase ListaEnlazadaSimple.
 */
public class ListaEnlazadaSimpleTest {

    private ListaEnlazadaSimple lista;

    @BeforeEach
    public void setUp() {
        // Crear una nueva lista enlazada antes de cada prueba
        lista = new ListaEnlazadaSimple();
    }

    @Test
    public void testInsertarEnPosicionInicio() {
        System.out.println("\n***********************************************************************\n");
        System.out.println("Prueba de inserción en la posición 0:");

        lista.insertarAlInicio(10);
        lista.insertarAlInicio(20);

        // Insertar en la posición 0
        lista.insertarEnPosicion(30, 0);

        // Mostrar la lista después de la inserción
        System.out.println("Lista después de insertar 30 en la posición 0:");
        lista.imprimirLista(); // Esperado: 30 -> 20 -> 10 -> null

        // Comprobar el primer nodo
        assertEquals(30, lista.getCabeza().getDato(), "El primer nodo debería contener 30");
        assertEquals(20, lista.getCabeza().getSiguiente().getDato(), "El segundo nodo debería contener 20");
        assertEquals(10, lista.getCabeza().getSiguiente().getSiguiente().getDato(), "El tercer nodo debería contener 10");
    }

    @Test
    public void testInsertarEnPosicionIntermedia() {
        System.out.println("\n***********************************************************************\n");
        System.out.println("Prueba de inserción en una posición intermedia:");

        lista.insertarAlInicio(10);
        lista.insertarAlInicio(20);
        lista.insertarAlInicio(30);

        // Mostrar la lista antes de la inserción
        System.out.println("Lista antes de insertar 25 en la posición 1:");
        lista.imprimirLista(); // Esperado: 30 -> 20 -> 10 -> null

        // Insertar en la posición 1
        lista.insertarEnPosicion(25, 1);

        // Mostrar la lista después de la inserción
        System.out.println("Lista después de insertar 25 en la posición 1:");
        lista.imprimirLista(); // Esperado: 30 -> 25 -> 20 -> 10 -> null

        // Comprobar que los nodos están en el orden correcto
        assertEquals(30, lista.getCabeza().getDato(), "El primer nodo debería contener 30");
        assertEquals(25, lista.getCabeza().getSiguiente().getDato(), "El segundo nodo debería contener 25");
        assertEquals(20, lista.getCabeza().getSiguiente().getSiguiente().getDato(), "El tercer nodo debería contener 20");
        assertEquals(10, lista.getCabeza().getSiguiente().getSiguiente().getSiguiente().getDato(), "El cuarto nodo debería contener 10");
    }

    @Test
    public void testInsertarEnPosicionFinal() {
        System.out.println("\n***********************************************************************\n");
        System.out.println("Prueba de inserción en la última posición:");

        lista.insertarAlInicio(10);
        lista.insertarAlInicio(20);
        lista.insertarAlInicio(30);

        // Insertar en la última posición (posición 3)
        lista.insertarEnPosicion(40, 3);

        // Mostrar la lista después de la inserción
        System.out.println("Lista después de insertar 40 en la posición 3:");
        lista.imprimirLista(); // Esperado: 30 -> 20 -> 10 -> 40 -> null

        // Comprobar que el último nodo contiene 40
        Nodo nodo = lista.getCabeza();
        while (nodo.getSiguiente() != null) {
            nodo = nodo.getSiguiente();
        }
        assertEquals(40, nodo.getDato(), "El último nodo debería contener 40");
    }

    @Test
    public void testInsertarEnPosicionFueraDeRango() {
        System.out.println("\n***********************************************************************\n");
        System.out.println("Prueba de inserción en una posición fuera del rango:");

        lista.insertarAlInicio(10);
        lista.insertarAlInicio(20);

        // Intentar insertar en una posición mayor que el tamaño de la lista (posición 3)
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> lista.insertarEnPosicion(30, 3));

        String expectedMessage = "La posición es mayor que el tamaño de la lista.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), "El mensaje de excepción debería indicar que la posición está fuera del rango.");
    }

    @Test
    public void testInsertarEnPosicionNegativa() {
        System.out.println("\n***********************************************************************\n");
        System.out.println("Prueba de inserción en una posición negativa:");

        // Intentar insertar en una posición negativa
        Exception exception = assertThrows(IllegalArgumentException.class, () -> lista.insertarEnPosicion(10, -1));

        String expectedMessage = "La posición no puede ser negativa.";
        String actualMessage = exception.getMessage();
        if (Objects.equals(actualMessage, expectedMessage)) System.out.println(actualMessage);
        assertTrue(actualMessage.contains(expectedMessage), "El mensaje de excepción debería indicar que la posición no puede ser negativa.");
    }

    @Test
    public void testEliminarEnListaVacia() {
        System.out.println("\n***********************************************************************\n");
        System.out.println("Prueba de eliminar en lista vacía:");

        // Intentar eliminar de una lista vacía
        lista.eliminarAlInicio();

        // Mostrar la lista vacía
        System.out.println("Lista después de intentar eliminar en una lista vacía:");
        lista.imprimirLista();

        // Comprobar que la cabeza sigue siendo null
        assertNull(lista.getCabeza(), "La lista debería estar vacía (cabeza == null)");
    }
    @Test
    public void testInsercionAlternada() {
        System.out.println("\n***********************************************************************\n");
        System.out.println("Prueba de inserción y eliminación alternadas:");

        lista.insertarAlInicio(10);
        lista.insertarAlInicio(20);
        lista.insertarAlInicio(30);
        lista.imprimirLista(); // Esperado: 30 -> 20 -> 10 -> null

        lista.eliminarAlInicio();
        lista.imprimirLista(); // Esperado: 20 -> 10 -> null

        lista.insertarAlInicio(40);
        lista.imprimirLista(); // Esperado: 40 -> 20 -> 10 -> null
    }

    @Test
    public void testInsercionMultiple() {
        System.out.println("\n***********************************************************************\n");
        System.out.println("Prueba de inserción múltiple:");

        lista.insertarAlInicio(50);
        lista.insertarAlInicio(60);
        lista.insertarAlInicio(70);
        lista.insertarAlInicio(80);
        lista.imprimirLista(); // Esperado: 80 -> 70 -> 60 -> 50 -> null

        assertEquals(80, lista.getCabeza().getDato(), "El primer nodo debería contener 80");
        assertEquals(70, lista.getCabeza().getSiguiente().getDato(), "El segundo nodo debería contener 70");
        assertEquals(60, lista.getCabeza().getSiguiente().getSiguiente().getDato(), "El tercer nodo debería contener 60");
        assertEquals(50, lista.getCabeza().getSiguiente().getSiguiente().getSiguiente().getDato(), "El cuarto nodo debería contener 50");
    }

    @Test
    public void testEliminarUnSoloNodo() {
        System.out.println("\n***********************************************************************\n");
        System.out.println("Prueba de eliminación de un solo nodo:");

        lista.insertarAlInicio(90);
        lista.imprimirLista(); // Esperado: 90 -> null

        lista.eliminarAlInicio();
        lista.imprimirLista(); // Esperado: null (lista vacía)

        assertNull(lista.getCabeza(), "La lista debería estar vacía después de eliminar el único nodo");
    }

    @Test
    public void testInsercionEnListaVacia() {
        System.out.println("\n***********************************************************************\n");
        System.out.println("Prueba de inserción en lista vacía:");

        lista.insertarAlInicio(100);
        lista.imprimirLista(); // Esperado: 100 -> null

        assertEquals(100, lista.getCabeza().getDato(), "El primer nodo debería contener 100");
    }

    @Test
    public void testImpresionLista() {
        System.out.println("\n***********************************************************************\n");
        System.out.println("Prueba de impresión de la lista:");

        lista.insertarAlInicio(200);
        lista.insertarAlInicio(300);
        lista.insertarAlInicio(400);
        lista.imprimirLista(); // Esperado: 400 -> 300 -> 200 -> null
    }
}
