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

### File
    
    Representação abstrata de um arquivo ou diretório.
    
    O objeto `File` **não abre nem lê o arquivo**. Ele apenas representa seu caminho e permite diversas operações.
    
    Exemplo:
    
    ```java
    File file = new File("c:\\temp\\in.txt");
    ```
    
    Principais operações:
    
      - `exists()` → verifica se existe.
      - `isFile()` → verifica se é um arquivo.
      - `isDirectory()` → verifica se é uma pasta.
      - `getName()` → retorna apenas o nome.
      - `getPath()` → retorna o caminho informado.
      - `getAbsolutePath()` → retorna o caminho absoluto.
      - `getParent()` → retorna a pasta pai.
      - `listFiles()` → lista arquivos e pastas.
      - `mkdir()` → cria uma pasta.
    
    ---
    
### Scanner
    
    Leitor de texto.
    
    Pode ler:
    
    - teclado (`System.in`)
    - arquivos (`File`)
    
    Exemplo:
    

```java
    Scanner sc = new Scanner(file);
```
    
    Métodos importantes:
    
      - `next()`
      - `nextLine()`
      - `nextInt()`
      - `nextDouble()`
      - `hasNext()`
      - `hasNextLine()`
    
    No seu código:
    
```java
    while(sc.hasNextLine()){
        System.out.println(sc.nextLine());
    }
```
    
    Enquanto existir uma próxima linha, ela será lida.
    
    ---
    
### IOException
    
    Exceção utilizada para erros de Entrada/Saída (Input/Output).
    
    Exemplos:
    
    - arquivo não encontrado;
      - sem permissão para acessar;
      - erro durante leitura;
      - erro durante escrita.
    
    Como `IOException` herda de `Exception`, ela é uma **Checked Exception**, ou seja, o compilador obriga que seja tratada com `try/catch` ou `throws`. 
    
    ---
    
### FileReader
    
    Responsável por abrir um arquivo para leitura de caracteres.
    
    Ele cria uma **stream de leitura**.
    
    Uma stream é uma sequência de dados que vai sendo lida aos poucos.
    
```java
    FileReader fr = new FileReader(path);
```
    
    Sozinho é mais lento, pois acessa diretamente o arquivo.
    
    Normalmente é utilizado junto com `BufferedReader`. 
    
---
    
### BufferedReader
    
    Recebe um `Reader` (como um `FileReader`) e cria um buffer em memória.
    
    Isso reduz a quantidade de acessos ao disco, tornando a leitura muito mais rápida.
    
```java
    BufferedReader br = new BufferedReader(new FileReader(path));
```
    
    Métodos importantes:
    
    - `read()`
    - `readLine()`
    
    No seu código:
    
```java
    String line = br.readLine();
    
    while(line != null){
        System.out.println(line);
        line = br.readLine();
    }
```
    
    O método `readLine()`:
    
    - retorna uma linha inteira;
    - retorna `null` quando chega ao final do arquivo.
    
---
    
### FileWriter
    
    Responsável por escrever caracteres em arquivos.
    
```java
    new FileWriter(path);
```
    
    Cria ou recria o arquivo.
    Se ele já existir, seu conteúdo será apagado.
    
    Para acrescentar conteúdo ao final:
    
```java
    new FileWriter(path, true);
```
    
    O parâmetro `true` ativa o modo **append**, preservando o conteúdo existente.
    
    ---
    
    ### BufferedWriter
    
    Também utiliza buffer de memória para escrever os dados de forma mais eficiente. 
    
    Normalmente é usado assim:
    
```java
    BufferedWriter bw = new BufferedWriter(new FileWriter(path));
```
    
    Métodos importantes:
    
      - `write()`
      - `newLine()`
      - `flush()`
    
    No seu código:
    
```java
    bw.write(line);
    bw.newLine(); 
```
    
    `newLine()` quebra a linha utilizando o padrão do sistema operacional.
    
---

# Try-with-resources
    
    É uma forma moderna de trabalhar com arquivos.
    
    Antes do Java 7 era necessário fechar tudo manualmente.
    
    Exemplo antigo:
    
```java
    finally{
        if(br != null)
            br.close();
    }
```
    
    Hoje basta:
    
```java
    try(BufferedReader br = new BufferedReader(new FileReader(path))){
    
    }
```
    
    Ao terminar o bloco `try`, o Java fecha automaticamente todos os recursos.
    
    Isso evita vazamento de memória e arquivos abertos.
    
---
    
# Streams
    
    Uma Stream é um fluxo de dados.
    
    Imagine um cano de água.
    
```
    Arquivo  -------------> Programa
```
    
    Enquanto o programa precisa dos dados, eles vão chegando pela stream.
    
    Existem dois tipos principais:
    
      - **Input Stream** → leitura.
      - **Output Stream** → escrita.
    
    No caso de arquivos texto usamos:
    
      - `FileReader`
      - `BufferedReader`
      - `FileWriter`
      - `BufferedWriter`
    
---
    
# Buffer
    
    Buffer é uma pequena área de memória temporária.
    
    Sem buffer:
    
```
    Arquivo
     ↓
    1 caractere
     ↓
    Programa
    
    Arquivo
     ↓
    1 caractere
     ↓
    Programa
    ```
    
    Com buffer:
    
    ```
    Arquivo
     ↓↓↓↓↓↓↓↓↓↓↓↓
    
    Buffer (memória)
    
    ↓↓↓↓↓↓↓↓↓↓↓↓
    
    Programa
```
    
    Como o acesso à memória é muito mais rápido do que acessar o disco, o desempenho melhora bastante.
    
---
    
# Manipulando pastas com File
    
    No seu código:
    
```java
    File path = new File(strPath);
    
    File[] folders =
            path.listFiles(File::isDirectory);
```
    
    `listFiles()` retorna todos os arquivos e pastas.
    
    O filtro:
    
```java
    File::isDirectory
```

    faz com que apenas as pastas sejam retornadas.

    Da mesma forma poderia usar:
    
```java
    File::isFile
```
    
    para listar somente arquivos.
    
---
    
# Resumo
    
    | Classe | Função |
    |---------|--------|
    | `File` | Representa um arquivo ou pasta |
    | `Scanner` | Lê dados do teclado ou de arquivos |
    | `IOException` | Exceção de entrada e saída |
    | `FileReader` | Lê caracteres de um arquivo |
    | `BufferedReader` | Lê utilizando buffer (mais rápido) |
    | `FileWriter` | Escreve caracteres em um arquivo |
    | `BufferedWriter` | Escreve utilizando buffer (mais rápido) |
    
---
