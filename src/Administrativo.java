import java.time.LocalDate;

import exceptions.DocumentException;


public class Administrativo extends Funcionario {
    
    public Administrativo(String nome, LocalDate dataNascimento, String cpf)
        throws DocumentException {
        super(nome, dataNascimento, cpf);
    }

    @Override
    public String toString() {
        return "ADMINISTRATIVO ["+super.toString()+"]";
    }

}
