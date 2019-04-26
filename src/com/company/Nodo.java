package com.company;

public class Nodo {

    public int Frecuencia;
    public char Caracter;
    public Nodo Hijo_Izquierdo;
    public Nodo Hijo_Derecho;

    public Nodo(int Frecuencia, char Caracter, Nodo Hijo_Izquierdo, Nodo Hijo_Derecho)
    {
        this.Frecuencia = Frecuencia;
        this.Caracter = Caracter;
        this.Hijo_Izquierdo = Hijo_Izquierdo;
        this.Hijo_Derecho = Hijo_Derecho;
    }

    public Nodo()
    {

    }

    public Nodo Add_Nodo(Nodo Nodo_1, Nodo Nodo_2)
    {
        if(Nodo_1.Frecuencia < Nodo_2.Frecuencia)
        {
            Hijo_Izquierdo = Nodo_1;
            Hijo_Derecho = Nodo_2;
        }
        else
        {
            Hijo_Derecho = Nodo_1;
            Hijo_Izquierdo = Nodo_2;
        }
        Frecuencia = Nodo_1.Frecuencia + Nodo_2.Frecuencia;

        return this;
    }
}
