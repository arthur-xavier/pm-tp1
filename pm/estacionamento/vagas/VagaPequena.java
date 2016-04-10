package pm.estacionamento.vagas;

import pm.estacionamento.Veiculo;
import pm.estacionamento.niveis.IEstacionamento;

public class VagaPequena extends Vaga {

    public VagaPequena(IEstacionamento estacionamento, Integer numero) {
        super(estacionamento, numero);
    }

    public boolean estacionar(Veiculo veiculo) {
        if(!this.isOcupada() &&
            (veiculo.getTipo() == Veiculo.Tipo.MOTOCICLETA ||
            veiculo.getTipo() == Veiculo.Tipo.VEICULO_PEQUENO))
        {
            this.setVeiculo(veiculo);
            return true;
        } else {
            return false;
        }
    }

    public Float getPreco() {
        return 6.0f;
    }

    public Veiculo.Tipo getTipo() {
        return Veiculo.Tipo.VEICULO_PEQUENO;
    }
}
