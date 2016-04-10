package pm.estacionamento;

import java.lang.IllegalArgumentException;
import java.lang.Math;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pm.estacionamento.niveis.IEstacionamento;
import pm.estacionamento.niveis.VagaNaoEncontradaException;
import pm.estacionamento.vagas.Vaga;

public class Totem {

    private Map<String, Ticket> tickets;
    private IEstacionamento estacionamento;

    public Totem(IEstacionamento estacionamento) {
        this.tickets = new HashMap<String, Ticket>();
        this.estacionamento = estacionamento;
    }

    public void realizarAtendimento(String entrada) {

        Ticket ticket = this.gerarTicket(entrada);

        switch(ticket.getTipo()) {
            case ENTRADA:
                try {
                    ticket.setVaga(this.estacionamento.estacionar(ticket.getVeiculo()));
                    this.tickets.put(ticket.getVeiculo().getPlaca(), ticket);
                    System.out.println(ticket.getVaga().toString());
                } catch(VagaNaoEncontradaException e) {
                    System.out.println("LOTADO");
                }
                break;

            case SAIDA:
                Ticket ticketEntrada = this.tickets.get(ticket.getVeiculo().getPlaca());
                if(ticketEntrada != null) {
                    long tempo = ticket.getHorario().getTime() - ticketEntrada.getHorario().getTime();
                    double tempoHoras = tempo / (1000.0*60.0*60.0);
                    Date horas = new Date(tempo);
                    DateFormat df = new SimpleDateFormat("hh:mm");
                    df.setTimeZone(TimeZone.getTimeZone("UTC"));

                    System.out.format("%s;%s;%.2f\n", ticketEntrada.getVaga().getTipo(), df.format(tempo), tempoHoras*ticketEntrada.getVaga().getPreco());

                    ticketEntrada.getVaga().setVeiculo(null);
                }
                break;
        }
    }

    public IEstacionamento getEstacionamento() {
        return this.estacionamento;
    }

    private Ticket gerarTicket(String entrada) {
        Pattern pattern = Pattern.compile("^(E|S);(\\d\\d:\\d\\d);([A-Za-z]{3}-\\d{4});(VP|MT|VG|NE)");
        Matcher matcher = pattern.matcher(entrada);

        if(matcher.find()) {
            try {
                return new Ticket(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
            } catch(ParseException e) {
                throw new IllegalArgumentException("Entrada invalida");
            }
        } else {
            throw new IllegalArgumentException("Entrada invalida");
        }
    }
}
