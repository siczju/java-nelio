import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Converter_data_hora_global_para_local {
    public static void main(String[] args){

        // CONVERTER DATA HORA GLOBAL PARA LOCAL (INSTANT -> LOCALDATETIME)
        // PARA FAZER ESSA CONVERSÃO TENHO QUE USAR O TIMEZONE: (Data-hora global, timezone -> Data-hora local)

        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

        /* -> Printando TODOS os ZoneId (fusos) disponíveis para usar
        for(String s : ZoneId.getAvailableZoneIds())
            System.out.println(s);
         */

         // Convertendo data-hora global para data local
        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault()); // aqui considero o fuso default do computador
        System.out.println("r1 = " + r1);

        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal")); // Aqui considero o fuso de PORTUGAL
        System.out.println("r2 = " + r2);

        // Convertendo data-hora global para data hora local
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault()); // aqui considero o fuso default do computador
        System.out.println("\nr3 = " + r3);

        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal")); // Aqui considero o fuso de PORTUGAL
        System.out.println("r4 = " + r4);

        // Obter dados de uma data-hora local (Data-hora local -> dia, mês, ano, horário)

        System.out.println("\nd04 day = " + d04.getDayOfMonth());
        System.out.println("d04 month = " + d04.getMonthValue());
        System.out.println("d04 year = " + d04.getYear());

        System.out.println("\nd05 hour = " + d05.getHour());
        System.out.println("d05 minute = " + d05.getMinute());
        System.out.println("d05 second = " + d05.getSecond());


    }
}
