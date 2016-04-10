package pm.estacionamento.niveis;

import java.util.Collection;
import java.util.ArrayList;

import pm.estacionamento.Veiculo;
import pm.estacionamento.vagas.*;

public class Nivel implements IEstacionamento {

    private Collection<Vaga> vagas;
    private Integer numero;

    public Nivel(Integer numero) {
        this.numero = numero;
        this.vagas = new ArrayList<Vaga>();

        // inicializa vagas
        this.vagas.add(new VagaEspecial(this, 1));
        this.vagas.add(new VagaEspecial(this, 2));

        this.vagas.add(new VagaMotocicleta(this, 1));
        this.vagas.add(new VagaMotocicleta(this, 2));

        this.vagas.add(new VagaPequena(this, 1));
        this.vagas.add(new VagaPequena(this, 2));
        this.vagas.add(new VagaPequena(this, 3));
        this.vagas.add(new VagaPequena(this, 4));

        this.vagas.add(new VagaGrande(this, 1));
        this.vagas.add(new VagaGrande(this, 2));
    }

    public Vaga estacionar(Veiculo veiculo) throws VagaNaoEncontradaException {
        for(Vaga vaga : this.vagas) {
            if(vaga.estacionar(veiculo)) {
                return vaga;
            }
        }
        throw new VagaNaoEncontradaException("Este nivel nao possui vaga para o veiculo especificado");
    }

    public Collection<Vaga> getVagas() {
        return this.vagas;
    }

    public String toString() {
        return "N" + this.numero;
    }
}
