package com.company;

import java.util.Scanner;

public class Main {

    static Huffman huffman;
    private static Scanner Scan = new Scanner(System.in);
    private static String Valor;

    public static void main(String[] args) {
        System.out.print("INGRESA TU MENSAJE AQUI-->>");
        Valor = Scan.nextLine();
        System.out.println("CADENA DE DATOS INGRESADA: "+Valor);
        huffman = new Huffman(Valor);
        System.out.printf("LA REPRESENTACION EN BITS DE SU MENSAJE ES    :"+huffman.hC.Patron_De_Bits); System.out.println("Mensaje Compreso: "+huffman.hC.Mensaje_Compreso);
        System.out.println("Tamaño en Bites del mensaje compreso: "+huffman.hC.Mensaje_Compreso.length);
        System.out.println("Tamaño en Bites del mensaje normal: "+Valor.length());

    }
}
