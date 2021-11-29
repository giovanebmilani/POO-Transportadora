import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import exceptions.DocumentException;
import exceptions.DriverException;
import exceptions.DriverIsNotQualifiedException;
import exceptions.VehicleIsNotFreeException;


public class FretamentoPassageiros extends Fretamento {
    
    public FretamentoPassageiros(LocalDate dataInicio, LocalDate dataTermino, double distaciaPercorrida) { 
        super(dataInicio, dataTermino, distaciaPercorrida);
    }

    @Override
    public VeiculoPassageiros getVeiculo() {
        return (VeiculoPassageiros)super.getVeiculo();
    }

    public boolean setVeiculo(VeiculoPassageiros veiculo) 
        throws VehicleIsNotFreeException, NullPointerException {
        return super.setVeiculo(veiculo);
    }

    public boolean setCondutor(Motorista condutor) 
        throws NullPointerException, DriverException, DocumentException {
        if (condutor.isHabilitadoPassageiros()) {
            return super.setCondutor(condutor);
        }
        throw new DriverIsNotQualifiedException("O motorista não é habilitado para transportar passageiros.");
    }

    @Override
    public double getValorCobrado() {
        return getValorDiaria()*getDiasEmUso() + distanciaPercorrida*getValorKm();
    }

    public double getValorDiaria() {
        int maxPassageiros = getVeiculo().getMaxPassageiros();
        if (maxPassageiros > 26) {
            return 560.0;
        }
        else if (maxPassageiros > 15) {
            return 490.0;
        }   
        return 410.0;
    }

    public int getDiasEmUso() {
        return (int)ChronoUnit.DAYS.between(dataInicio, dataTermino);
    }

    public double getValorKm() {
        int maxPassageiros = getVeiculo().getMaxPassageiros();
        if (maxPassageiros > 46) {
            return 3.0;
        }
        else if (maxPassageiros > 26) {
            return 2.8;
        }   
        return 2.2;
    }

    @Override
    public String toString() {
        return "PASSAGEIROS ["+super.toString()+", Valor cobrado: R$"+getValorCobrado()+"]";
    }

}
