package pm.estacionamento.niveis;

import pm.estacionamento.Veiculo;
import pm.estacionamento.vagas.Vaga;

public interface IEstacionamento {
    public Vaga estacionar(Veiculo veiculo) throws VagaNaoEncontradaException;
}
