

public class VeiculoCarga extends Veiculo {

    private double capacidadeCarga;
    private int numeroEixos;
    private boolean unidadeAcoplada;

    public VeiculoCarga(String placa, String modelo, int fabricacao, double peso, 
        double capacidadeCarga, int numeroEixos, boolean unidadeAcoplada) {
        super(placa, modelo, fabricacao, peso);
        this.capacidadeCarga = capacidadeCarga;
        this.numeroEixos = numeroEixos;
        this.unidadeAcoplada = unidadeAcoplada;
    }

    public double getCapacidadeCarga() {
        return this.capacidadeCarga;
    }

    public int getNumeroEixos() {
        return this.numeroEixos;
    }

    public boolean hasUnidadeAcoplada() {
        return this.unidadeAcoplada;
    }

    @Override
    public CategoriaCnh getCategoriaMinimaNecessaria() {
        if (this.peso > 6000.0 && this.unidadeAcoplada) {
            return CategoriaCnh.E;
        }
        else if (this.peso > 3500.0) {
            return CategoriaCnh.C;
        }
        return CategoriaCnh.B;
    }

    @Override
    public String toString() {
        return "CARGA ["+super.toString()+", Capacidade carga: "+capacidadeCarga+"kg"
            +", Numero eixos: "+numeroEixos+", Unidade acoplada: "+unidadeAcoplada+"]";
    }
}
