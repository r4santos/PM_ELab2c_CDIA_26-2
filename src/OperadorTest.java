import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Escolha ColetorDados ou EspecialistaLimpeza e complete 2 testes.
 * Um deles deve obrigatoriamente verificar registrarPagamento.
 */
public class OperadorTest {
    @Test
    void exemploEstruturaAaa() {
        ColetorDados c = new ColetorDados("Ana", "C001");
        double turnos = c.addTurnoExtra(1.0);
        assertEquals(0.0, turnos, 0.001,
                "este exemplo só ilustra AAA; substitua pelos seus 2 testes");
    }

    // TODO: criar 2 testes unitários (AAA + mensagem na asserção)
    // TODO: um deles deve testar registrarPagamento

    @Test
    void registrarPagamentoSomaSalarioMaisHorasEZeraAsHoras() {
        // 10 horas de turno extra = 10 * 3100 / 70 = 442,85
        ColetorDados coletor = new ColetorDados("Jão", "J01");
        coletor.addTurnoExtra(10.0);

        double pagamento = coletor.registrarPagamento();

        assertEquals(3542.85, pagamento, 0.01,
                "O pagamento deve ser salário (3100) + 10 horas de turno extra (525)");
        assertEquals(3542.85, coletor.getUltimoPagamento(), 0.01,
                "O total pago deve ficar guardado em ultimoPagamento");
        assertEquals(3100.0, coletor.registrarPagamento(), 0.01,
                "As horas devem ter sido zeradas: o pagamento seguinte é só o salário");
    }

        @Test
    void addHoraPipelineNaoUltrapassaOMaximoMensal() {
        ColetorDados coletor = new ColetorDados("Jão", "J01");
        coletor.addTurnoExtra(30.0);

        // Act: 20 + 10 = 30, mas o máximo mensal é 28
        double horas = coletor.addTurnoExtra(10.0);

        // Assert
        assertEquals(28.0, horas, 0.001,
                "O total de turnos deve ser limitado ao máximo mensal de 28");
    }
}