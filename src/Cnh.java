import java.time.LocalDate;
import exceptions.DocumentException;
import exceptions.DocumentNotValidException;


public class Cnh {

    private String numero;
    private CategoriaCnh categoria;
    private LocalDate vencimento;

    public Cnh(String numero, CategoriaCnh categoria, LocalDate vencimento) 
        throws DocumentException {
        if (isNumeroValido(numero)) {
            this.numero = numero;
            this.categoria = categoria;
            this.vencimento = vencimento;
        }
    }

    public boolean isNumeroValido(String numero) throws DocumentException {
        if (numero.length() == 11) {
            return true;
        }
        throw new DocumentNotValidException("O número da CNH não possui 11 dígitos.");
    }

    public String getNumero() {
        return this.numero;
    }

    public CategoriaCnh getCategoria() {
        return this.categoria;
    }

    public LocalDate getVencimento() {
        return this.vencimento;
    }

    public boolean isVencida() {
        if (this.vencimento.isBefore(LocalDate.now())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[Categoria: "+categoria+", Nº: "+numero+", "+vencimento+"]";
    }

}