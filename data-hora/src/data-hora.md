# Data - Hora
    
    !! Data hora é imutavel então se vc precisa modificar uma data hora vc tem q mudar dentro de outro objeto alterado    

    * Data-[hora] local:
        -> ano-mês-dia-[hora] sem fuso horário
        -> [hora] opcional
    
    * Data-hora global:
        -> ano-mês-dia-hora com fuso horário

    * Duração:
        -> tempo decorrido entre duas data-horas

## Quando usar?

    * Data-[hora] local: 
        -> Quando o momento exato não interessa a pessoas de outro fuso horário.
        -> Uso comum: sistemas de região única, Excel, Data de nascimento.

    * Data-hora global:
        -> Quando o momento exato interessa a pessoas de outro fuso horário.
        -> Uso comum: sistemas multi-região, web.
            ex: Qnd o comentário foi postado? = "13/08/2022 às 15:32 (horário de São Paulo)"

## Timezone (fuso horário)

    * GMT - Greenwich Mean Time 
        -> Marco 0 dos fuso horário, ai tem horários que são antes do GMT e depois do GMT
        -> Horário de Londres
        -> Horário do padrão UTC - Coordinated Universal Time
        -> Também chamado de "Z" time, ou Zulu time

    * Outros fuso horários são relativos ao GMT/UTC:
        -> São Paulo: GMT-3 -> 3 horas a menos que o GMT
        -> Manaus: GMT-4 -> 3 horas a menso que o GMT
        -> Portugal: GMT+1 -> 1 hora adiantado ao GMT 

    * Muitas linguagens/tecnologias usam nomes para as timezones:
        -> "US/Pacific" 
        -> "America/Sao_Paulo"
        -> etc.

## Padrão ISO 8601

    * Data-[hora] local:
        -> 2022-07-21
        -> 2022-07-21T14:52
        -> 2022-07-21T14:52:09
        -> 2022-07-21T14:52:09.4073 (4073 -> fração de segundos)

    * Data-hora global:
        -> 2022-07-23T14:52:09Z -> Z é Zulu Time -> GMT
        -> 2022-07-23T14:52:09.254935Z (2549 -> fração de segundo)
        -> 2022-07-23T14:52:09-03:00 -> "-" é um menos, então menos 3 o horário de gmt

## Operações importantes com data-hora

    * Instanciação
        -> Tenho que saber instanciar um momento atual e gerar um data-hora apartir disso. (agora) -> Data-hora
            LocalDate / LocalDateTime / Instant  -> .now()
        -> Texto ISO 8601 -> Data-hora
            LocalDate / LocalDateTime / Instant -> .parse("2022-06-16T13:23:54.23Z")
        -> Texto formato customizado -> Data-hora
            LocalDateTime.parse("20/07/2022 01:30", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        -> dia, mês, ano, [horário] -> Data-hora local
            LocalDateTime.of(2022, 7, 20, 1, 30); 

    * Formatação
        -> Data-hora -> Texto ISO 8601 (Padrão)
        -> Data-hora -> Texto formato customizado
            d04.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        -> Data-hora global formatado / Instant formatado E no fuso horário do usuário
            DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
            System.out.println("\nd06 = " + fmt3.format(d06));

    * Obter dados de uma data-hora local
        -> Data-hora local -> dia, mês, ano, horário
            LocalDate nextYearLocalDate = d04.plusYears(1);
            Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);

    * Converter data-hora global para local
        -> Data-hora global, timezone (sistema local) -> Data-hora local

    * Cálculos com data-hora
        -> Data-hora +/- tempo -> Data-hora
        -> Data-hora 1, Data-hora 2 -> Duração
            Duration t3 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay()); -> com LocalDate

## Principais tipos Java (Versão 8+)

    * Data-hora local
        -> LocalDate -> qnd tiver só as informações da  DATA
        -> LocalDateTime -> qnd tiver DATA  e HORÁRIO

    * Data-hora global
        -> Instant -> instante no tempo

    * Duração
        -> Duration

    * Outros
        -> ZoneId
        -> ChronoUnit