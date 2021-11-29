

public class VeiculoPasseio extends Veiculo {
    
    public VeiculoPasseio(String placa, String modelo, int fabricacao, double peso) {
        super(placa, modelo, fabricacao, peso);
    }

    @Override
    public CategoriaCnh getCategoriaMinimaNecessaria() {
        return CategoriaCnh.B;
    }

    @Override
    public String toString() {
        return "PASSEIO ["+super.toString()+"]";
    }

}
