import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Instanciando_data_hora {
    public static void main(String[] args){

        // Instanciando no AGORA
        LocalDate d01 = LocalDate.now();
        System.out.println("d01 = " + d01.toString());

        LocalDateTime d02 = LocalDateTime.now();
        System.out.println("d02 = " + d02);

        Instant d03 = Instant.now(); // Com fuso horário de londres GMT-> 3 hora a mais q SP
        System.out.println("d03 = " + d03);

        // Pegar um texto ISO 8601 e gerar uma Data-hora apartir dele
        LocalDate d04 = LocalDate.parse("2022-07-20");
        System.out.println("d04 = " + d04);

        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26"); // 1 da manha 30 minutos e 26 segundos
        System.out.println("d05 = " + d05);

        Instant d06 = Instant.parse("2022-07-20T01:30:26Z"); // Com Z no final pois é Zulu/GMT/UTC
        System.out.println("d06 = " + d06);

        // E se eu quiser especificar um horário do Brasil e vira um horário equivalente no GMT
        Instant d07 = Instant.parse("2022-07-20T01:30:26-03:00"); // No lugar do Z coloca MENOS (-) / MAIS (+) e a qtde de horas q está adiantada/atrasada.
            // Então supondo q to no horário de são paulo q é 3 horas atrasado, eu coloco ele e -03:00, assim o horário de GMT vai vir certo 3 horas a mais
            // Então se é 11 horas em sp vai retornar 14 horas em GMT
        System.out.println("d07 = " + d07);


        // Texto formato customizado -> Data-hora (Usar a classe DateTimeFormatter para definir o padrão)
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);
        System.out.println("d08 = " + d08.format(fmt1)); // .format(fmt1) para imprimir no formato dia/mes/ano
            // Então precisamos passar como segundo argumento o DateTimeFormatter, que vai definir o padrão de data
            // Então o método parse() do LocalDate e LocalDateTime, eles tem uma sobrecarga q aceita o segundo argumento, q é como q vai interpretar o texto

        LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println("d09 = " + d09);

        // Instanciar data apartir de dia, mês, ano, [horário]
        LocalDate d10 = LocalDate.of(2022, 7, 20); // ano/mes/dia
        System.out.println("d10 = " + d10);

        LocalDateTime d11 = LocalDateTime.of(2022, 7, 20, 1, 30); // ano/mes/dia/minuto/segundo
        System.out.println("d11 = " + d11);
    }
}
