import java.time.LocalDate;

import exceptions.DocumentException;
import exceptions.DriverException;
import exceptions.DriverIsNotQualifiedException;
import exceptions.VehicleIsNotFreeException;


public class FretamentoCargas extends Fretamento {
    
    //private VeiculoCarga veiculo;
    private boolean cargaPerigosa;

    public FretamentoCargas(LocalDate dataInicio, LocalDate dataTermino, 
        double distaciaPercorrida, boolean cargaPerigosa) {
            
        super(dataInicio, dataTermino, distaciaPercorrida);
        this.cargaPerigosa = cargaPerigosa;
    }

    @Override
    public VeiculoCarga getVeiculo() {
        return (VeiculoCarga)super.getVeiculo();
    }

    public boolean setVeiculo(VeiculoCarga veiculo) 
        throws VehicleIsNotFreeException, NullPointerException {
        return super.setVeiculo(veiculo);
    }

    public boolean setCondutor(Motorista condutor) 
        throws NullPointerException, DriverException, DocumentException {
        if (cargaPerigosa) {
            if (!condutor.isHabilitadoCargasPerigosas()) {
                throw new DriverIsNotQualifiedException("O motorista não é habilitado para transportar cargas perigosas.");
            }
        }
        return super.setCondutor(condutor);       
    }

    public boolean isCargaPerigosa() {
        return cargaPerigosa;
    }

    @Override
    public double getValorCobrado() {
        return getValorKm()*distanciaPercorrida;
    }

    public double getValorKm() {
        if (cargaPerigosa) {
            return 1.5*getVeiculo().getNumeroEixos();
        }
        return 1.2*getVeiculo().getNumeroEixos();
    }

    @Override
    public String toString() {
        return "CARGAS ["+super.toString()+", Valor cobrado: R$"+getValorCobrado()+
                    ", Carga perigosa: "+cargaPerigosa+"]";
    }

}
