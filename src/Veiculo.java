

public abstract class Veiculo implements Comparable<Veiculo> {
    
    public static int counter = 1;
    protected int id;
    protected String placa;
    protected String modelo;
    protected int anoFabricacao;
    protected double peso; // em kg
    protected boolean livre;

    public Veiculo(String placa, String modelo, int fabricacao, double peso) {
        this.id = counter;
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = fabricacao;
        this.peso = peso;
        this.livre = true;
        counter++;
    }

    public int getId() {
        return this.id;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getAnoFabricacao() {
        return this.anoFabricacao;
    }

    public double getPeso() {
        return this.peso;
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

    public CategoriaCnh getCategoriaMinimaNecessaria() {
        return CategoriaCnh.B;
    }

    @Override
    public int compareTo(Veiculo veiculo) {
        return this.anoFabricacao - veiculo.getAnoFabricacao();
    }

    @Override
    public String toString() {
        return "Id: "+id+", Placa: "+placa+", Modelo: "+modelo+", Ano: "+anoFabricacao+", Peso: "+peso+"kg"; 
    }

}
