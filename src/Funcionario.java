import java.time.LocalDate;
import exceptions.DocumentException;
import exceptions.DocumentNotValidException;


public abstract class Funcionario implements Comparable<Funcionario> {

    public static int counter = 1;
    protected int id;
    protected String nome;
    protected LocalDate dataNascimento;
    protected String cpf;
    protected boolean livre;

    public Funcionario(String nome, LocalDate dataNascimento, String cpf) 
        throws DocumentException {
        if (isCpf(cpf)) {
            this.id = counter;
            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.cpf = cpf;
            this.livre = true;
            counter++;
        }
    }

    public boolean isCpf(String cpf) throws DocumentException {
        if (cpf.length() == 11) {
            return true;
        }
        throw new DocumentNotValidException("O cpf informado não possui 11 dígitos.");
    }

    public int getId() {
        return this.id;
    }
    
    public String getNome() {
        return this.nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getCpfFormatado() {
        return cpf.substring(0,3)+"."+cpf.substring(3, 6)+"."+cpf.substring(6, 9)
            +"-"+cpf.substring(9, 11);
    }

    public boolean isLivre() {
        return this.livre;
    }

    public void liberar() {
        this.livre = true;
    }

    public void ocupar() {
        this.livre = false;
    }

    @Override
    public int compareTo(Funcionario func) {
        return this.getNome().toUpperCase().compareTo(func.getNome().toUpperCase());
    }

    @Override
    public String toString() {
        return "Id: "+id+", "+nome+", Nascimento: "+dataNascimento+
                    ", Cpf: "+getCpfFormatado()+", Livre: "+livre;
    }
    
}
