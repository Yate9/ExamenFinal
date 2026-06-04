package edu.lucas.examenfinal;

import java.util.ArrayList;

public class GestorClub {
    static final double PRESUPUESTO_MAXIMO=100000;
    static ArrayList<Profesional> profesionales=new ArrayList<>();

    public static ArrayList<Profesional> getProfesionales() {
        return profesionales;
    }

    public static void setProfesionales(ArrayList<Profesional> profesionales) {
        GestorClub.profesionales = profesionales;
    }

    public static void contratarJugador(Jugador jugador)throws PresupuestoExcedidoException{
        double salarioTotal=0;
        for(Profesional profesional:profesionales){
            salarioTotal+=profesional.getSalarioBase();
        }
        if(salarioTotal+jugador.getSalarioBase()>PRESUPUESTO_MAXIMO){
            throw new PresupuestoExcedidoException("Presupuesto excedido");
        }
        salarioTotal+=jugador.getSalarioBase();
        profesionales.add(jugador);
    }
}
