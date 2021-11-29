import java.time.LocalDate;

import exceptions.DocumentException;
import exceptions.DocumentIsExpiredException;
import exceptions.DriverException;
import exceptions.DriverIsNotFreeException;
import exceptions.DriverIsNotQualifiedException;
import exceptions.VehicleIsNotFreeException;

import java.time.DateTimeException;


public abstract class Fretamento {
    
    public static int counter = 1;
    protected int id;
    protected Veiculo veiculo;
    protected Motorista condutor;
    protected LocalDate dataInicio;
    protected LocalDate dataTermino;
    protected double distanciaPercorrida; // em km

    public Fretamento(LocalDate dataInicio, LocalDate dataTermino, double distanciaPercorrida) 
        throws DateTimeException {
        if (dataTermino.isBefore(dataInicio)) {
            throw new DateTimeException("Data de término é antes que a data de inicio.");
        }
        this.id = counter;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.distanciaPercorrida = distanciaPercorrida;
        counter++;
    }

    public int getId() {
        return this.id;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public boolean setVeiculo(Veiculo veiculo) 
        throws VehicleIsNotFreeException, NullPointerException {
            
        if (veiculo != null) {
            if (veiculo.isLivre()) {
                this.veiculo = veiculo;
                if (this.dataTermino.isAfter(LocalDate.now())) {
                    this.veiculo.ocupar();
                }
                return true;
            }
            throw new VehicleIsNotFreeException("O veiculo não esta livre.");
        }
        throw new NullPointerException("O veiculo é uma referencia null.");
    }

    public Motorista getCondutor() {
        return this.condutor;
    }

    public boolean setCondutor(Motorista condutor) 
        throws NullPointerException, DriverException, DocumentException {
            if (condutor != null) {
                if (condutor.isLivre()) {
                    if (condutor.isHabilitado(this.veiculo)) {
                        if (!condutor.getCnh().isVencida()) {
                            this.condutor = condutor;
                            if (this.dataTermino.isAfter(LocalDate.now())) {
                                this.condutor.ocupar();
                            }
                            return true;
                        }
                        throw new DocumentIsExpiredException("A CNH do motorista está vencida.");
                    }
                    throw new DriverIsNotQualifiedException("O motorista não é habilitado para este tipo de veiculo.");
                }
                throw new DriverIsNotFreeException("O condutor não esta livre.");
            }
            throw new NullPointerException("O condutor é uma referencia null.");
    }

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public LocalDate getDataTermino() {
        return this.dataTermino;
    }

    public double getDistanciaPercorrida() {
        return this.distanciaPercorrida;
    }

    public double getValorCobrado() {
        return 0.0;
    }

    public void setStatusVeiculo() {
        if (dataTermino.isBefore(LocalDate.now())) {
            this.veiculo.liberar();
        }
        else {
            this.veiculo.ocupar();
        }
    }

    public void setStatusMotorista() {
        if (dataTermino.isBefore(LocalDate.now())) {
            this.condutor.liberar();
        }
        else {
            this.condutor.ocupar();
        }
    }
    
    @Override
    public String toString() {
        return "Id: "+id+", Veiculo Id: "+veiculo.getId()+", Motorista Id: "+condutor.getId()+", Data Inicio: "+
            dataInicio+", Data Termino: "+dataTermino+", Distancia percorrida: "+distanciaPercorrida+"km";
    }

}
