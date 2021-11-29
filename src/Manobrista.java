import java.time.LocalDate;
import exceptions.DocumentException;


public class Manobrista extends Funcionario {

    private Cnh cnh;
    
    public Manobrista(String nome, LocalDate dataNascimento, String cpf, Cnh cnh)
        throws DocumentException {
            super(nome,dataNascimento,cpf);
            this.cnh = cnh;
        }

    public Cnh getCnh() {
        return this.cnh;
    }

    public CategoriaCnh getCategoria() {
        return this.cnh.getCategoria();
    }

    @Override
    public String toString() {
        return "MANOBRISTA ["+super.toString()+" ,Cnh: "+cnh+"]";
    }

}