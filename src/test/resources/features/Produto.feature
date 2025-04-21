# language: pt
# charset: UTF-8

Funcionalidade: Produto


  Esquema do Cenário:<ct> Inserir produto "<produto>" no carrinho de compras

    Dado eu tenha acessado o site PETZ e tenha feito a pesquisa por: "<produto>"
    Quando eu selecionar o produto "<num_lista>", validar os dados: "<nome>","<fornecedor>","<preco_normal>","<preco_assinante>"
    E incluir no carrinho de compras
    Então o produto deve continuar com os dados idênticos ao da página de produto: "<nome>","<preco_normal>"

    Exemplos:
      | ct  | produto | num_lista | nome                                                                           | fornecedor | preco_normal | preco_assinante |
      | 001 | ração   | 2         | Ração Selections For Pet para Cães Adultos Médios/Grandes Sabor Carne e Frango | Petz       | R$ 143,99    | R$ 129,59       |
#      | 001 | Ração   | 3         | Ração N&D Prime para Cães Adultos de Raças Grandes Sabor Cordeiro e Blueberry - 10,1kg | N&D        | R$ 546,99    | R$ 492,29       |

#      | 002 | Petisco    | 5         | Snack Petz Acerola, Graviola e Banana para Cães                           | Petz        | R$ 5,99      | R$ 5,39         |
#      | 003 | Bola       | 10        | Brinquedo Chalesco Para Gatos Rato, Bola e Sininho                        | Chalesco    | R$ 24,99     | R$ 22,49        |
#      | 004 | Brinquedo  | 2         | Brinquedo Bola de Futebol Petz - Cores Sortidas                           | Petz        | R$ 44,99     | R$ 40,49        |
#      | 005 | Cama       | 7         | Cama Ferplast Siesta Deluxe Para Cães e Gatos Violeta                     | Ferplast    | R$ 169,99    | R$ 152,99       |
#      | 006 | Arranhador | 13        | Brinquedo Arranhador São Pet para Gatos Torre Marrom                      | São Pet     | R$ 499,99    | R$ 449,99       |
#      | 007 | Pelucia    | 11        | Brinquedo de Pelúcia Chalesco Girafa                                      | Chalesco    | R$ 49,39     | R$ 44,45        |
#      | 008 | Pote       | 9         | Porta Ração Furacão Pet para Cães Vermelho 15kg                           | Furacão Pet | R$ 98,99     | R$ 89,09        |
#      | 009 | Coleira    | 4         | Coleira Petz Coroa para Cães                                              | Petz        | R$ 29,99     | R$ 26,99        |
#      | 010 | Guia       | 1         | Guia Petz Geométrica para Cães                                            | Petz        | R$ 69,99     | R$ 62,99        |
#
#










