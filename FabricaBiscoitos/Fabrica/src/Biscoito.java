
public class Biscoito {
    private double materiaPrima;

    public Biscoito(double materiaPrima) {

        this.materiaPrima = materiaPrima;
    }

    public double getMateriaPrima() {

        return materiaPrima;
    }

    public void usarMateriaPrima() {
        double novaMateriaPrima = materiaPrima - 25;
        this.materiaPrima = novaMateriaPrima;
    }
}