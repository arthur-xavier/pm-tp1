package pm.estacionamento;

import pm.estacionamento.niveis.IEstacionamento;
import pm.estacionamento.niveis.Nivel;
import pm.estacionamento.niveis.VagaNaoEncontradaException;
import pm.estacionamento.vagas.Vaga;
import pm.estacionamento.Veiculo;

public class Predio implements IEstacionamento {

    private IEstacionamento[] niveis;

    public Predio() {
        this.niveis = new Nivel[4];
        for(int i = 0; i < 4; i++) {
            this.niveis[i] = new Nivel(i+1);
        }
    }

    public Vaga estacionar(Veiculo veiculo) throws VagaNaoEncontradaException {
        for(IEstacionamento nivel : this.niveis) {
            try {
                return nivel.estacionar(veiculo);
            } catch(VagaNaoEncontradaException e) {
                continue;
            }
        }
        throw new VagaNaoEncontradaException("Este predio nao possui vaga para o veiculo especificado");
    }
}
