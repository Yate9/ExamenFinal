package edu.lucas.examenfinal;

public class Tecnico extends Profesional{
    private String puesto;

    public Tecnico(String nombre, double salarioBase, String puesto) {
        super(nombre, salarioBase);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }


    @Override
    public double getPlusSalarial() {
        return 200;
    }
}
