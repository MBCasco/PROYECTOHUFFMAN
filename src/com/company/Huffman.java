package com.company;

public class Huffman {


    private static char Arreglo_Chars[]; //the string coverted to characters.
    private static int Tabla[] = new int[0x7f]; //holds the frequency of the item
    private static Nodo Mi_Nodo[]; //the main Priority Queue, the Final Tree generated is stored in spot 0.
    private static int Tamaño_Tabla = 0;//The true length of the table that holds the characters.
    private static Arbol Mi_Arbol; //A variable that holds the Tree
    private static int Tamaño_Nodo = 0;//all increments or decrements are made to this value
    public static HuffmanTransversor hC; //The Class Responsible for Decoding the Huffman Tree


    public Huffman(String Valor)
    {
        Tabla_Frequencia(Valor);
        Arreglo_Nodos();
        Nodo Aux = Crear_Arbol();
        hC = new HuffmanTransversor(Aux,Arreglo_Chars,Valor);
    }
    public static void Tabla_Frequencia(String Valor)
    {
        Arreglo_Chars = Valor.toCharArray();
        for(int i = 0; i < Arreglo_Chars.length; i++)
        {
            Tabla[Obtener_Ascii(Arreglo_Chars[i])] += 1;
        }

    }



    public static int Obtener_Ascii(char substringValue)
    {
        return substringValue&0x7f;
    }

    public static void Arreglo_Nodos()
    {
        int Contador = 0;
        for(int i = 0; i < Tabla.length; i++)
        {
            if(Tabla[i]>0)
            {
                Contador++;
            }

        }

        Tamaño_Tabla =  Contador;
        Contador = 0;
        Mi_Nodo = new Nodo[Tamaño_Tabla];

        for(int i = 0; i < 127; i++)
        {
            if(Tabla[i] != 0)
            {
                Mi_Nodo[Contador]= new Nodo(Tabla[i], (char)i, null, null);
                Contador++;
            }
        }
        Tamaño_Nodo = Mi_Nodo.length;
        Ordenar();

    }

    public static Nodo Crear_Arbol()
    {
        for(int i = 1; i < Tamaño_Nodo; i++)
        {
            try
            {
                if(Mi_Nodo[1].Frecuencia >= Mi_Nodo[0].Frecuencia)
                {
                    Mi_Arbol = new Arbol(Mi_Nodo[0],Mi_Nodo[i]);
                    Mi_Nodo[0] = Mi_Arbol;
                    Mover_Items(i, Tamaño_Nodo);
                    Tamaño_Nodo -= 1;
                    i -= 1;
                    Ordenar();
                }
                else
                {
                    if(i+1 < Tamaño_Nodo)
                    {
                        Mi_Arbol = new Arbol(Mi_Nodo[i], Mi_Nodo[i+1]);
                        Mi_Nodo[1] = Mi_Arbol;
                        Mover_Items(i+1, Tamaño_Nodo);
                        Ordenar();
                        Tamaño_Nodo -= 1;
                        i -= 1;
                    }
                       else
                    {
                        Mi_Nodo[1] = Mi_Nodo[i];
                        Mi_Nodo[0] = new Arbol(Mi_Nodo[0], Mi_Nodo[1]);
                    }
                }
            }
            catch(Exception e)
            {
                //I dare this program to crash...hahaha
            }
        }
        return Mi_Nodo[0];
    }

    private static void Mover_Items(int Indice, int Tamaño)
    {
        try
        {
            for(int i = Indice; i < Tamaño; i++)
            {
                Mi_Nodo[i] = Mi_Nodo[i+1];
            }
        }
        catch(Exception e)
        {
        }
    }

    private static void Ordenar()
    {
        Nodo Temp;
        for(int i = Tamaño_Nodo-1; i > 1; i--)
        {
            for(int j = 0; j < i; j++)
            {
                if(Mi_Nodo[j].Frecuencia > Mi_Nodo[j+1].Frecuencia)
                {
                    Temp = Mi_Nodo[j+1];
                    Mi_Nodo[j+1] = Mi_Nodo[j];
                    Mi_Nodo[j] = Temp;
                }

                if(Mi_Nodo[j].Frecuencia == Mi_Nodo[j+1].Frecuencia && Mi_Nodo[j].Hijo_Izquierdo != null)
                {
                    Temp = Mi_Nodo[j+1];
                    Mi_Nodo[j+1] = Mi_Nodo[j];
                    Mi_Nodo[j] = Temp;
                }
            }
        }
    }


}
