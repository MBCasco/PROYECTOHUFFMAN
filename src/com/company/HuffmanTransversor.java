package com.company;

import java.util.BitSet;

public class HuffmanTransversor {

    private Nodo Nodo_Raiz;
    private char Caracter;
    private char[] Arreglo_Chars;
    public String Patron_De_Bits = "";
    static byte[] Mensaje_Compreso;
    private String[] Arreglo_Codigo = new String[1000];


    public HuffmanTransversor(Nodo Mi_Nodo, char[] Arreglo_Chars,String Mensaje)
    {
        String Temp;
        this.Arreglo_Chars = Arreglo_Chars;
        Nodo_Raiz = Mi_Nodo;
        for(int i = 0; i < Arreglo_Chars.length; i++)
        {
            Temp = Busqueda(Nodo_Raiz, "", Arreglo_Chars[i]);
            Patron_De_Bits += Temp+" ";
            Arreglo_Codigo[i]=Temp;
            System.out.println("Código huffman "+Arreglo_Chars[i]+" "+Temp);
        }

        //Comprimir el Mensaje
        BitSet Arreglo_De_Bits = new BitSet();
        int k = 0;
        int j;
        for (int i = 0; i < Mensaje.length(); i++)
        {
            char Caracter = Mensaje.charAt(i);
            for(j = 0; j < Arreglo_Chars.length; j++)
            {
                if(Arreglo_Chars[j] == Caracter)
                {
                    break;
                }
            }
            String Codigo = Arreglo_Codigo[j];
            for(j = 0; j < Codigo.length(); j++)
            {
                boolean bit = Codigo.charAt(j) == '1';
                Arreglo_De_Bits.set(k++, bit);
            }
        }

        Mensaje_Compreso = Arreglo_De_Bits.toByteArray();

    }

    public String Busqueda(Nodo Nodo_Raiz, String Valor,char Mi_Caracter)
    {
        String Valor_Binario ="";
        if(Nodo_Raiz != null)
        {
            if(Nodo_Raiz.Hijo_Izquierdo != null)
                Valor_Binario = Busqueda(Nodo_Raiz.Hijo_Izquierdo, Valor+"0", Mi_Caracter);
            if(Nodo_Raiz.Caracter == Mi_Caracter)
                return Valor;

            else
            {
                if(Valor_Binario == "")
                {
                    return Busqueda(Nodo_Raiz.Hijo_Derecho, Valor+"1",Mi_Caracter);
                }
                else
                {
                    return Valor_Binario;
                }
            }
        }
        else
        {
            return "";
        }
    }

}
