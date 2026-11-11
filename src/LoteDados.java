import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/** Lote de dados acompanhado por um especialista em limpeza. */
public class LoteDados {
    private LocalDate iniciadoEm;
    private LocalDate finalizadoEm;
    private String nome;

    public LoteDados(String nome, LocalDate dataInicio) {
        this.nome = nome;
        this.iniciadoEm = dataInicio;
        this.finalizadoEm = null;
    }

    public int finalizar() {
        this.finalizadoEm = LocalDate.now();
        return (int) ChronoUnit.DAYS.between(iniciadoEm, finalizadoEm);
    }

    /**
     * Dias desde a finalização até hoje.
     * @return -1 se ainda não foi finalizado
     */
    public int diasAposFinalizacao() {
        // TODO: se finalizadoEm == null, devolver -1; senão, dias entre finalizadoEm e LocalDate.now()
        if (finalizadoEm == null) {
            return -1;
        }
        return (int) ChronoUnit.DAYS.between(finalizadoEm, LocalDate.now());
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return nome + " | inicio=" + iniciadoEm + " | fim=" + finalizadoEm;
    }
}
