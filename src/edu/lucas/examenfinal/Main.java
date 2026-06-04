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
            System.out.println("6. Ver profesionales");
            int opcion=sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Contratatando jugador");
                    System.out.println("Ingrese el nombre del jugador");
                    String nombreJugador=sc.next();
                    System.out.println("Ingrese el salario base del jugador");
                    double salarioBaseJugador=sc.nextDouble();
                    System.out.println("Ingrese la posicion del jugador(PORTERO,DEFENSA,CENTROCAMPISTA,DELANTERO)");
                    Posicion posicionJugador=Posicion.valueOf(sc.next());
                    Jugador jugador=new Jugador(nombreJugador,salarioBaseJugador,posicionJugador);
                    try{
                        GestorClub.contratarJugador(jugador);
                    }catch(PresupuestoExcedidoException e){
                        System.err.println("Presupuesto excedido");
                        System.err.println("Fichaje del jugador cancelado");
                    }
                    break;

                case 2:
                    System.out.println("Contratando Cuerpo Tecnico");
                    System.out.println("Ingrese el nombre del cuerpo tecnico");
                    String nombreTecnico=sc.next();
                    System.out.println("Ingrese el salario base del cuerpo tecnico");
                    double salarioBaseTecnico=sc.nextDouble();
                    System.out.println("Ingrese el puesto del cuerpo tecnico");
                    String puestoTecnico=sc.next();
                    Tecnico tecnico=new Tecnico(nombreTecnico,salarioBaseTecnico,puestoTecnico);
                    try{
                        GestorClub.contratarTecnico(tecnico);
                    }catch(PresupuestoExcedidoException e){
                        System.err.println("Presupuesto excedido");
                        System.err.println("Fichaje del cuerpo tecnico cancelado");
                    }
                    break;
                case 3:
                    System.out.println("Despedir profesional");
                    System.out.println("Ingrese el nombre del profesional: ");
                    String nombreProfesional=sc.next();
                    try{
                        GestorClub.despedirProfesional(nombreProfesional);
                    }catch(ProfesionalNoEncontradoException e){
                        System.err.println("Profesional no encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Viendo nominas totales");

                    break;
                case 5:
                    System.out.println("Programa finalizado");
                    bandera=false;
                    break;
                case 6:
                    GestorClub.mostrarProfesionales();
            }
        }
    }
}
