package pm.estacionamento.vagas;

import pm.estacionamento.Veiculo;
import pm.estacionamento.niveis.IEstacionamento;

public class VagaEspecial extends Vaga {

    public VagaEspecial(IEstacionamento estacionamento, Integer numero) {
        super(estacionamento, numero);
    }

    public boolean estacionar(Veiculo veiculo) {
        if(!this.isOcupada() && veiculo.getTipo() == Veiculo.Tipo.NECESSIDADES_ESPECIAIS) {
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
        return Veiculo.Tipo.NECESSIDADES_ESPECIAIS;
    }
}
