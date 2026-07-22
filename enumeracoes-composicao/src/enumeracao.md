# Enumeração

    O que veremos:
        * Definição / discussão
        * Exemplo: estados de um pedido 
        * Conversão de string para enum 
        * Representação UML

    -> Enumeração é um tipo especial que serve para especificar de forma literal um conjunto de constantes relacionadas
    -> Palavra chave em java: enum
    -> Vantagem: melhor semântica, código mais legível e auxiliado pelo compilador

    Exemplo: 
        Ciclo de vida de um pedido:
            Aguardando pagamento -> Processando -> Enviado -> Entregue
        -> Esses sã o os estados de um pedido, e para representar eles de uma forma semanticamente boa e facil de trabalhar
            usamos o enum

## Sintaxe:
    
        public enum OrderStatus {
            PENDING_PAYMENT,
            PROCESSING,
            SHIPPED,
            DELIVERED,
        }
        
        public class Order {
            private Integer id; 
            private Date moment;
            private OrderStatus status; (declarando enum na classe)
        }
    
    -> Por padrão no java ele transforma o enum em string, com o mesmo nome q vc deu, ex: "PENDING_PAYMENT"

## Conversão de string para enum:
    (Caso o usuário envie o status de algo em algum contexto):
        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED"); -> Converti string para enum