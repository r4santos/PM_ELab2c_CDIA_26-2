/** Coletor de dados (CLT): salário base + turnos extras. */
public class ColetorDados extends Operador {
    private static final double SALARIO = 3100.0;
    private static final double FRACAO_TURNO = 1.0 / 70.0;
    private static final int MAX_TURNOS = 28;
    private double turnosExtras;

    public ColetorDados(String nome, String registro) {
        super(nome, registro);
        this.turnosExtras = 0.0;
    }

    private double valorTurnosExtras() {
        return turnosExtras * SALARIO * FRACAO_TURNO;
    }

    /**
     * Acrescenta turnos extras, respeitando o máximo mensal.
     * @return a quantidade efetiva de turnos após a operação
     */
    public double addTurnoExtra(double quantidade) {
        // TODO: se quantidade <= 0, não altera e devolve turnosExtras atual
        if (quantidade <= 0)
            return turnosExtras;
        // TODO: soma quantidade, sem ultrapassar MAX_TURNOS; devolve o novo total
        turnosExtras = Math.min(MAX_TURNOS, turnosExtras + quantidade);
        return turnosExtras;
    }

    @Override
    public double registrarPagamento() {
        // TODO: calcular total, armazenar, zerar turnosExtras e devolver
        double total = SALARIO + valorTurnosExtras();
        ultimoPagamento = total;
        turnosExtras = 0.0;
        return total;
    }                            

    @Override
    public String toString() {
        return "ColetorDados " + super.toString() + " | turnosExtras=" + turnosExtras;
    }
}
