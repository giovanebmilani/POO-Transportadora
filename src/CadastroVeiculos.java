import java.util.ArrayList;
import java.util.Collections;


public class CadastroVeiculos {
    
    private ArrayList<Veiculo> veiculos;

    public CadastroVeiculos() {
        this.veiculos = new ArrayList<Veiculo>();
    }

    public boolean cadastra(Veiculo veiculo) {
        if (veiculo != null) {
            veiculos.add(veiculo);
            return true;
        }
        return false;
    }

    public Veiculo getVeiculo(String placa) {
        return veiculos.stream()
                .filter(v -> v.getPlaca().equals(placa))
                .findAny().orElse(null);
    }
    
    public VeiculoPasseio getVeiculoPasseio(int id) {
        return (VeiculoPasseio)veiculos.stream()
                                .filter(v -> v instanceof VeiculoPasseio)
                                .filter(v -> v.getId() == id)
                                .findAny().orElse(null);
    }
    
    public VeiculoCarga getVeiculoCarga(int id) {
        return (VeiculoCarga)veiculos.stream()
                                .filter(v -> v instanceof VeiculoCarga)
                                .filter(v -> v.getId() == id)
                                .findAny().orElse(null);
    }

    public VeiculoPassageiros getVeiculoPassageiros(int id) {
        return (VeiculoPassageiros)veiculos.stream()
                                .filter(v -> v instanceof VeiculoPassageiros)
                                .filter(v -> v.getId() == id)
                                .findAny().orElse(null);
    }

    public ArrayList<Veiculo> getEmOrdemFabricacao() {
        Collections.sort(veiculos);
        return veiculos;
    }

}
