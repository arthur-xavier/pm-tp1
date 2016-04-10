package pm.estacionamento;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pm.estacionamento.vagas.Vaga;
import pm.estacionamento.Veiculo;

public class Ticket {

    public enum Tipo {
        ENTRADA("E"),
        SAIDA("S");

        private String tipo;

        Tipo(String tipo) {
            this.tipo = tipo;
        }
        public String toString() {
            return this.tipo;
        }
        public static Tipo fromString(String tipo) throws ParseException {
            if(tipo != null) {
                for(Tipo t : Tipo.values()) {
                    if(tipo.equals(t.tipo)) {
                        return t;
                    }
                }
            }
            throw new ParseException("Tipo de ticket de atendimento invalido", 0);
        }
    }

    private Ticket.Tipo tipo;
    private Date horario;
    private Veiculo veiculo;
    private Vaga vaga;

    public Ticket(String tipo, String horario, String placa, String tipoVeiculo) throws ParseException {
        this.tipo = Ticket.Tipo.fromString(tipo);
        this.veiculo = new Veiculo(placa, Veiculo.Tipo.fromString(tipoVeiculo));

        DateFormat df = new SimpleDateFormat("hh:mm");
        this.horario = df.parse(horario);
    }

    public Ticket(Ticket.Tipo tipo, Date horario, Veiculo veiculo) {
        this.tipo = tipo;
        this.horario = horario;
        this.veiculo = veiculo;
    }

    public Ticket.Tipo getTipo() {
        return this.tipo;
    }

    public Date getHorario() {
        return this.horario;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
    public Vaga getVaga() {
        return this.vaga;
    }
}
