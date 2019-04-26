package com.company;

public class Arbol extends Nodo {

    private Nodo Raiz;

    public Arbol()
    {
        Raiz = null;
    }

    public Arbol(Nodo Nodo_1, Nodo Nodo_2)
    {
        Raiz = super.Add_Nodo(Nodo_1, Nodo_2);
    }

    public void Insert_Nodo(int Frecuencia, char Caracter)
    {
        Raiz.Frecuencia =  Frecuencia;
        Raiz.Caracter = Caracter;
        Raiz.Hijo_Izquierdo = null;
        Raiz.Hijo_Derecho = null;
    }

    public void Insert_Nodo(int Frecuencia, char Caracter, Nodo Hijo_Izquierdo, Nodo Hijo_Derecho)
    {
        Raiz.Frecuencia =  Frecuencia;
        Raiz.Caracter = Caracter;
        this.Raiz.Hijo_Izquierdo = Hijo_Izquierdo;
        this.Raiz.Hijo_Derecho = Hijo_Derecho;
    }

    public void Insert_Nodo(Nodo Nodo)
    {
        this.Raiz.Frecuencia = Nodo.Frecuencia;
        this.Raiz.Caracter = Nodo.Caracter;
        this.Raiz.Hijo_Izquierdo = Nodo.Hijo_Izquierdo;
        this.Raiz.Hijo_Derecho = Nodo.Hijo_Derecho;
    }

    public void Insert_Nodo(Nodo Nodo_1, Nodo Nodo_2)
    {
        Raiz = super.Add_Nodo(Nodo_1, Nodo_2);
    }

}
