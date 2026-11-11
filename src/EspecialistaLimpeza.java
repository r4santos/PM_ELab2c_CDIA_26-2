import java.util.ArrayList;
import java.util.List;

/** Especialista em limpeza (PJ): salário base + bônus por lotes finalizados recentemente. */
public class EspecialistaLimpeza extends Operador {
    private static final double SALARIO = 5500.0;
    private static final double BONUS = 9.0 / 100.0;
    private static final int TEMPO_BONUS = 30;
    private List<LoteDados> lotes;

    public EspecialistaLimpeza(String nome, String registro) {
        super(nome, registro);
        this.lotes = new ArrayList<>();
    }

    /**
     * Soma SALARIO × BONUS para cada lote finalizado
     * há no máximo TEMPO_BONUS dias (diasAposFinalizacao entre 0 e TEMPO_BONUS, inclusive).
     */
    private double valorBonus() {
        // TODO: percorrer lotes e acumular o bônus dos elegíveis
        double total = 0.0;
        for (LoteDados l : lotes) {
            int dias = l.diasAposFinalizacao();
            if (dias >= 0 && dias <= TEMPO_BONUS)
                total += SALARIO * BONUS;
        }

        return total;
    }

    public int alocarLote(LoteDados lote) {
        for (LoteDados l :   lotes) {
            if (l.diasAposFinalizacao() == -1) return -1;
        }
        lotes.add(lote);
        return lotes.size();
    }

    @Override
    public double registrarPagamento() {
        // TODO: calcular total, armazenar em ultimoPagamento e devolver
        double total = SALARIO + valorBonus();
        ultimoPagamento = total;
        return total;
    }

    @Override
    public String toString() {
        return "EspecialistaLimpeza " + super.toString() + " | lotes=" + lotes.size();
    }
}
