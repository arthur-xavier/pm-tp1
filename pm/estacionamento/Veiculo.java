package pm.estacionamento;

import java.text.ParseException;

public class Veiculo {

    public enum Tipo {
        MOTOCICLETA("MT"),
        VEICULO_PEQUENO("VP"),
        VEICULO_GRANDE("VG"),
        NECESSIDADES_ESPECIAIS("NE");

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
            throw new ParseException("Tipo de veiculo invalido", 0);
        }
    }

    private String placa;
    private Tipo tipo;

    public Veiculo(String placa, Tipo tipo) {
        this.placa = placa;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public Tipo getTipo() {
        return this.tipo;
    }
}
