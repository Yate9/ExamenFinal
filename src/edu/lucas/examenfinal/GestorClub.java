package edu.lucas.examenfinal;

import java.util.ArrayList;

public class GestorClub {
    static final double PRESUPUESTO_MAXIMO = 10000;
    static ArrayList<Profesional> profesionales = new ArrayList<>();

    public static ArrayList<Profesional> getProfesionales() {
        return profesionales;
    }

    public static void setProfesionales(ArrayList<Profesional> profesionales) {
        GestorClub.profesionales = profesionales;
    }

    public static void contratarJugador(Jugador jugador) throws PresupuestoExcedidoException {
        double salarioTotal = 0;
        for (Profesional profesional : profesionales) {
            salarioTotal += profesional.getSalarioBase();
        }
        if (salarioTotal + jugador.getSalarioBase() > PRESUPUESTO_MAXIMO) {
            throw new PresupuestoExcedidoException("Presupuesto excedido");
        }
        profesionales.add(jugador);
    }

    public static void contratarTecnico(Tecnico tecnico) throws PresupuestoExcedidoException {
        double salarioTotal = 0;
        for (Profesional profesional : profesionales) {
            salarioTotal += profesional.getSalarioBase();
        }
        if (salarioTotal + tecnico.getSalarioBase() > PRESUPUESTO_MAXIMO) {
            throw new PresupuestoExcedidoException("Presupuesto excedido");
        }
        profesionales.add(tecnico);
    }

    public static void despedirProfesional(String nombreProfesional) throws ProfesionalNoEncontradoException {
        for (Profesional profesional : profesionales) {
            if (profesional.getNombre().equalsIgnoreCase(nombreProfesional)) {
                profesionales.remove(profesional);
            } else {
                throw new ProfesionalNoEncontradoException("Profesional no encontrado");
            }
        }
    }

    public static void mostrarNominas() {
        for (Profesional profesional : profesionales) {
            double salarioTotal =0;
            if (profesional instanceof Jugador) {
                System.out.println("Jugador: " + profesional.getNombre() + " con la posicion " + ((Jugador) profesional).getPosicion() + " y un salario de " + profesional.getSalarioBase() + profesional.getPlusSalarial());
                salarioTotal += (profesional.getSalarioBase()+(profesional.getPlusSalarial()));
            } else {
                System.out.println("Tecnico: " + profesional.getNombre() + " con el puesto " + ((Tecnico) profesional).getPuesto() + " y un salario de " + profesional.getSalarioBase() + profesional.getPlusSalarial());
                salarioTotal += (profesional.getSalarioBase()+(profesional.getPlusSalarial()));
            }
        }
    }
    public static void mostrarProfesionales(){
        for(Profesional profesional:profesionales){
            System.out.println(profesional.getNombre());
        }
    }
}
