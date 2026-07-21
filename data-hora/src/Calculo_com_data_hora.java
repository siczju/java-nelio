import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Calculo_com_data_hora {
    public static void main(String[] args){
        // Data hora é imutavel então se vc precisa modificar uma data hora vc tem q mudar dentro de outro objeto alterado

        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

        // Data-hora soma / subtrae tempo -> Data-hora
            // 1 semana anterior da d04.
            // Minus -> subtrair (dias, semanas, meses, anos...)
            // Plus -> somar (dias, semanas, meses, anos...)
        LocalDate pastWeekLocalDate = d04.minusDays(7);
        LocalDate nextYearLocalDate = d04.plusYears(1);
        System.out.println("pastWeekLocalDate: " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate: " + nextYearLocalDate);

        LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
        LocalDateTime thirtyMinutesLocalDateTime = d05.plusMinutes(30);
        System.out.println("\npastWeekLocalDateTime: " + pastWeekLocalDateTime);
        System.out.println("nextWeekLocalDateTime: " + thirtyMinutesLocalDateTime);

        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);
        System.out.println("\npastWeekInstant: " + pastWeekInstant);
        System.out.println("nextWeekInstant: " + nextWeekInstant);

        // Data-hora 1, Data-hora2 -> Duração entre elas
            // Não tem como calcular a duração entre dois LocalDate pois ele não tem segundos, tem q converter ele para LocalDateTime (.atTime(0,0))
            // atTime(0,0) ou atStartOfDay() -> Converte LocalDate para LocalDateTime
        Duration t1 = Duration.between(pastWeekLocalDate.atTime(0,0), d04.atTime(0,0));
        Duration t3 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());
        Duration t2 = Duration.between(pastWeekInstant, d06);
        Duration t4 = Duration.between(pastWeekLocalDateTime, d05);

        // !!!! TEM Q SER A DATA MENOR ANTES DA DATA MAIOR, SE NÃO VAI DAR NÚMERO NEGATIVO, EX: 7-10 = -3 e 10-3 = 3

        System.out.println("\nt1 days = " + t1.toDays());
        System.out.println("t2 days = " + t2.toDays());
        System.out.println("t3 days = " + t3.toDays());
        System.out.println("t4 days = " + t4.toDays());
    }
}
