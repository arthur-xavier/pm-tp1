package pm.estacionamento.vagas;

import pm.estacionamento.Veiculo;
import pm.estacionamento.niveis.IEstacionamento;

public class VagaGrande extends Vaga {

    public VagaGrande(IEstacionamento estacionamento, Integer numero) {
        super(estacionamento, numero);
    }

    public boolean estacionar(Veiculo veiculo) {
        if(!this.isOcupada() &&
            (veiculo.getTipo() == Veiculo.Tipo.MOTOCICLETA ||
            veiculo.getTipo() == Veiculo.Tipo.VEICULO_PEQUENO ||
            veiculo.getTipo() == Veiculo.Tipo.VEICULO_GRANDE))
        {
            this.setVeiculo(veiculo);
            return true;
        } else {
            return false;
        }
    }

    public Float getPreco() {
        return 8.0f;
    }

    public Veiculo.Tipo getTipo() {
        return Veiculo.Tipo.VEICULO_GRANDE;
    }
}
