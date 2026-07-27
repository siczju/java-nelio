# Lendo arquivos textocom classes File e Scanner

    Classes que vamos utilizar:
        - File -> Representação abstrata de um arquivo e seu caminho
        - Scanner -> Leitor de texto, scanner pode ler dados do console e de txt
        - IOException (herda de Exception) -> exceção padrão de entrada e saída qnd mexe com arquivos
        - FileReader (stream (sequencia) de leitura de caracteres a partir de arquivos) -> qnd eu
            instanciar um filereader eu vou estabelecer uma sequencia de leitura a partir de um
            arquivo, a medida q eu precisar ler esse arquivo vou acessar esse stream
        - BufferedReader (mais rápido) -> vai ser instanciado a partir do FileReader e 
            implementa algumas otimizações utilizando buffer de memória sendo mais rápido
        - FileWriter (Stream de escrita de caracteres em arquivos) -> 
            - Cria/recria o arquivo: new FileWrite(path) -> Se o arquivo não existir será criado, e se ja existir será recriado
            - Acrescenta ao arquivo existente: new FileWriter(path,true); -> o arquivo existente será aberto e tudo q vc escrever será escrito no final do arquivo. 
        -BufferedWriter (mais rápido)