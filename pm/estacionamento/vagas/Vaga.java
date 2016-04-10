package pm.estacionamento.vagas;

import pm.estacionamento.Veiculo;
import pm.estacionamento.niveis.IEstacionamento;

public abstract class Vaga {

    private IEstacionamento estacionamento;
    private Integer numero;
    private Veiculo veiculo;

    public Vaga(IEstacionamento estacionamento, Integer numero) {
        this.estacionamento = estacionamento;
        this.numero = numero;
        this.veiculo = null;
    }

    public abstract Float getPreco();
    public abstract Veiculo.Tipo getTipo();

    public abstract boolean estacionar(Veiculo veiculo);

    public final IEstacionamento getEstacionamento() {
        return this.estacionamento;
    }

    public final Integer getNumero() {
        return this.numero;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public final Veiculo getVeiculo() {
        return this.veiculo;
    }

    public final boolean isOcupada() {
        return this.veiculo != null;
    }

    public String toString() {
        return this.estacionamento.toString() + this.getTipo().toString() + this.numero.toString();
    }
}
