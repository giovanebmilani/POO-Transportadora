import java.time.LocalDate;
import exceptions.DocumentException;


public class Motorista extends Funcionario {

    private Cnh cnh;
    private boolean habilitadoCargasPerigosas;
    private boolean habilitadoPassageiros;

    public Motorista(String nome, LocalDate dataNascimento, String cpf, Cnh cnh,
        boolean cargasPerigosas, boolean passageiros) throws DocumentException {
        
        super(nome, dataNascimento, cpf);
        this.cnh = cnh;
        this.habilitadoCargasPerigosas = cargasPerigosas;
        this.habilitadoPassageiros = passageiros;
    }

    public Cnh getCnh() {
        return this.cnh;
    }

    public CategoriaCnh getCategoria() {
        return this.cnh.getCategoria();
    }

    public boolean isHabilitadoCargasPerigosas() {
        return this.habilitadoCargasPerigosas;
    }

    public boolean isHabilitadoPassageiros() {
        return this.habilitadoPassageiros;
    }

    public boolean isHabilitado(Veiculo veiculo) {

        CategoriaCnh categoriaMinima = veiculo.getCategoriaMinimaNecessaria();
        CategoriaCnh categoriaMotorista = this.getCategoria();

        if (categoriaMotorista.compareTo(categoriaMinima) >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "MOTORISTA ["+super.toString()+", Cnh: "+cnh
        +", Curso cargas perigosas: "+habilitadoCargasPerigosas+", Curso passageiros: "+habilitadoPassageiros+"]";
    }

}
