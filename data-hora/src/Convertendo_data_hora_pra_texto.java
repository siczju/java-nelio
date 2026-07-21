import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Convertendo_data_hora_pra_texto {
    public static void main(String[] args){
        // Transformar Data-hora para texto, como o ISO 8601 ja é padrão do java, vamos transformar num texto customizado

        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

        // FORMATANDO A FORMA COMO A DATA É IMPRIMIDA
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;

        System.out.println("d04 (ISO 8601) = " + d04);
        System.out.println("d04 (format) = " + d04.format(fmt1));
        System.out.println("d04 (format) = " + d04.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("d04 (format) = " + fmt1.format(d04));

        System.out.println("\nd05 = " + d05.format(fmt1));
        System.out.println("d05 = " + d05.format(fmt2));

        System.out.println("\nd05 = " + d05.format(fmt4));

        // PARA IMPRIMIR O INSTANT FORMATADO PRECISA TRANSFORMAR ELE EM UM LOCALDATETIME, POIS ELE NÃO TEM A CLASSE FORMATTER
        // withZone(ZoneId.systemDefault()); -> ELE PEGA O FUSO HORARIO DO COMPUTADOR DO USUÁRIO, e deixa imprimir o instant formatado
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

        // e como o instant n tem a classe DateTimeFormatter, preciso usar o método do fmt3.format()
        System.out.println("\nd06 = " + fmt3.format(d06)); // Assim consigo mostrar o Instant formatado, e
                                                            // além disso com o withZone eu consigo mostrar a data e o horário certo com base no fuso horário do usuário


    }
}
