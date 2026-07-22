## Composição
    -> É um tipo de associação que permite que um objeto contenha outro
    -> Relação "tem-um" ou "tem-vários"
    
    Vantagens: Organização (divisão de responsabilidades), Coesão, Flexibilidade, Reuso.
    

    -> na foto uml-application.Main:
        -> Num pedido (Order), ele tem vários itens (OrderItem), esse asterisco significa que tem vários.
        -> E essa seta partindo do Order e indo pro OrderItem indica a relação de composição
        -> uma Order contém vários itens.
        -> Simbolo UML para composição é o diamante preto
        -> Sendo que a classe que estiver do lado do Diamante preto (Order) é o lado do TODO, e o outro lado é as PARTES.
            ou seja um Pedido é um TODO e ele contém as PARTES que são os itens 
        -> Isso então é uma associação de composição que representa uma relação TODO-PARTE entre objetos

        -> Mas olhando a relaçao entre o pedido e o cliente, não tem diamante preto pois não é uma relação de TODO-PARTE
        -> pois o cliente não é parte do pedido mas está associado ao pedido.
        -> A seta indica que o Pedido tem um Cliente. Mesmo assim chamamos de composição de objetos.
        -> Então na hora de implementar, dentro da classe Order vai ter um atributo do tipo Cliente