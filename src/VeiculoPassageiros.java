

public class VeiculoPassageiros extends Veiculo {
    
    private int maxPassageiros;

    public VeiculoPassageiros(String placa, String modelo, int fabricacao, double peso, int maxPassageiros) {
        super(placa, modelo, fabricacao, peso);
        this.maxPassageiros = maxPassageiros;
    }

    public int getMaxPassageiros() {
        return this.maxPassageiros;
    }

    @Override
    public CategoriaCnh getCategoriaMinimaNecessaria() {
        if (this.maxPassageiros > 8) {
            return CategoriaCnh.D;
        }
        else if (this.peso > 3500.0) {
            return CategoriaCnh.C;
        }
        return CategoriaCnh.B;
    }

    @Override
    public String toString() {
        return "PASSAGEIROS ["+super.toString()+", Máximo passageiros: "+maxPassageiros+"]";
    }

}
