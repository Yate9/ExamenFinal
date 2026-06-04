package edu.lucas.examenfinal;

import java.util.Scanner;

public class Main {
    static void main() {

        System.out.println("Comienzo del programa");
        Scanner sc=new Scanner(System.in);

        boolean bandera=true;
        while(bandera){
            System.out.println("Ingrese una opcion");
            System.out.println("1. Contratar Jugador");
            System.out.println("2. Contratar Cuerpo Tecnico");
            System.out.println("3. Despedir profesional");
            System.out.println("4. Ver nominas totales");
            System.out.println("5. Salir");
            int opcion=sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Contratatando jugador");
                    System.out.println("Ingrese el nombre del jugador");
                    String nombre=sc.next();
                    System.out.println("Ingrese el salario base del jugador");
                    double salario=sc.nextDouble();
                    System.out.println("Ingrese la posicion del jugador(PORTERO,DEFENSA,CENTROCAMPISTA,DELANTERO)");
                    Posicion posicion=Posicion.valueOf(sc.next());
                    Jugador jugador=new Jugador(nombre,salario,posicion);
                    GestorClub.contratarJugador(jugador);
                    break;

                case 2:
                    System.out.println("Contratar Cuerpo Tecnico");
                    break;
                case 3:
                    System.out.println("Despedir profesional");
                    break;
                case 4:
                    System.out.println("Ver nominas totales");
                    break;
                case 5:
                    System.out.println("Programa finalizado");
                    bandera=false;
                    break;
            }
        }
    }
}
