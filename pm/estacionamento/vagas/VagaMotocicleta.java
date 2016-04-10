package pm.estacionamento.vagas;

import pm.estacionamento.Veiculo;
import pm.estacionamento.niveis.IEstacionamento;

public class VagaMotocicleta extends Vaga {

    public VagaMotocicleta(IEstacionamento estacionamento, Integer numero) {
        super(estacionamento, numero);
    }

    public boolean estacionar(Veiculo veiculo) {
        if(!this.isOcupada() && veiculo.getTipo() == Veiculo.Tipo.MOTOCICLETA) {
            this.setVeiculo(veiculo);
            return true;
        } else {
            return false;
        }
    }

    public Float getPreco() {
        return 3.5f;
    }

    public Veiculo.Tipo getTipo() {
        return Veiculo.Tipo.MOTOCICLETA;
    }
}
