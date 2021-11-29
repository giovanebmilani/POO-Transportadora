import java.util.ArrayList;
import java.util.Collections;


public class CadastroFuncionarios {
    
    private ArrayList<Funcionario> funcionarios;

    public CadastroFuncionarios() {
        this.funcionarios = new ArrayList<Funcionario>();
    }

    public boolean cadastra(Funcionario func) {
        if (func != null) {
            funcionarios.add(func);
            return true;
        }
        return false;
    }

    public Funcionario getFuncionario(String cpf) {
        return funcionarios.stream()
                            .filter(f -> f.getCpf().equals(cpf))
                            .findAny().orElse(null);
    }

    public Administrativo getAdministrativo(int id) {
        return (Administrativo)funcionarios.stream()
                                .filter(f -> f instanceof Administrativo)
                                .filter(f -> f.getId() == id)
                                .findAny().orElse(null);
    }

    public Motorista getMotorista(int id) {
        return (Motorista)funcionarios.stream()
                                .filter(f -> f instanceof Motorista)
                                .filter(f -> f.getId() == id)
                                .findAny().orElse(null);
    }

    public Manobrista getManobrista(int id) {
        return (Manobrista)funcionarios.stream()
                                .filter(f -> f instanceof Manobrista)
                                .filter(f -> f.getId() == id)
                                .findAny().orElse(null);
    }

    public ArrayList<Funcionario> getEmOrdemAlfabetica() {
        Collections.sort(funcionarios);
        return funcionarios;
    }

}
