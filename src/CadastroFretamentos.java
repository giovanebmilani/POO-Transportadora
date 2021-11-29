import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;


public class CadastroFretamentos {
    
    private ArrayList<Fretamento> fretamentos;

    public CadastroFretamentos() {
        this.fretamentos = new ArrayList<Fretamento>();
    }

    public boolean cadastra(Fretamento frete) {
        if (frete != null) {
            fretamentos.add(frete);
            return true;
        }
        return false;
    }

    public ArrayList<Fretamento> getFretamentos() {
        return this.fretamentos;
    }

    public void atualizarStatusVeiculo() {
        fretamentos.forEach(frete -> frete.setStatusVeiculo());
    }

    public void atualizarStatusMotorista() {
        fretamentos.forEach(frete -> frete.setStatusMotorista());
    }

    public ArrayList<Entry<Veiculo, Double>> getVeiculosMaisLucrativos() {
        HashMap<Veiculo, Double> veiculos = new HashMap<Veiculo, Double>();

        fretamentos.forEach((frete) -> {
            if (veiculos.containsKey(frete.getVeiculo())) {
                double temp = veiculos.get(frete.getVeiculo());
                veiculos.put(frete.getVeiculo(), temp+frete.getValorCobrado());
            }
            else {
                veiculos.put(frete.getVeiculo(), frete.getValorCobrado());
            }
        });
        ArrayList<Entry<Veiculo, Double>> res = new ArrayList<Entry<Veiculo, Double>>(veiculos.entrySet());
        Collections.sort(res, (v1,v2) -> v2.getValue().compareTo(v1.getValue()));
        return res;
    }

}
