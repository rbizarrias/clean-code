# Refinamento Sucessivo

Este projeto foi desenvolvido como estudo prático do **Capítulo 14 - Refinamento Sucessivo** do livro **Clean Code**, de Robert C. Martin (Uncle Bob).

Em vez de apresentar apenas o código final, o capítulo mostra como um software evolui ao longo do tempo. O objetivo é demonstrar que **código limpo não surge na primeira implementação**: ele é resultado de um processo contínuo de refatoração, simplificação e melhoria do design. Para ilustrar esse conceito, Uncle Bob utiliza a construção de um **parser de argumentos de linha de comando**, permitindo acompanhar cada etapa da evolução do código até chegar a uma solução mais flexível, organizada e extensível.

## O problema

Programas executados pela linha de comando normalmente recebem argumentos para configurar seu comportamento. Por exemplo:

```bash
java Main -l -p 8080 -d /var/logs
```

Nesse comando:

- `-l` habilita uma funcionalidade (flag booleana);
- `-p 8080` informa uma porta;
- `-d /var/logs` define um diretório.

Embora pareça simples, interpretar esses argumentos exige diversas responsabilidades:

- identificar quais argumentos foram informados;
- validar seus tipos;
- associar cada valor ao parâmetro correto;
- tratar erros de entrada.

Quando essa lógica é implementada manualmente, o código tende a crescer rapidamente em complexidade conforme novos tipos de argumentos são adicionados.

## A solução

O projeto implementa um pequeno framework responsável por fazer o parsing desses argumentos automaticamente. Primeiro é definido um **esquema (schema)** que descreve quais argumentos são aceitos e seus respectivos tipos. Cada símbolo representa um tipo diferente:

| Esquema | Tipo |
|---------|------|
| `l` | Booleano (flag simples) |
| `p#` | Inteiro |
| `d*` | String |
| `[*]` | Array de Strings |

Com esse esquema e os argumentos informados na linha de comando, o parser interpreta automaticamente cada valor e disponibiliza os resultados já convertidos para seus respectivos tipos.

## Arquitetura

O projeto utiliza o padrão **ArgumentMarshaler**, no qual cada tipo de argumento possui sua própria classe responsável por interpretar e validar seu valor. Alguns exemplos são:

- `BooleanArgumentMarshaler`
- `IntegerArgumentMarshaler`
- `StringArgumentMarshaler`
- `StringArrayArgumentMarshaler`

Essa separação segue o princípio da **Responsabilidade Única (SRP)**, tornando o sistema mais simples de manter e facilitando a inclusão de novos tipos de argumentos no futuro.

## Ideia central

> "Ninguém escreve um código limpo de primeira; para criar um código limpo, é preciso primeiro criar um código sujo e então limpá-lo."
>
> — Robert C. Martin (Uncle Bob)

Assim como uma redação começa com um rascunho e passa por várias revisões antes da versão final, o desenvolvimento de software também é um processo iterativo. Resolver o problema é apenas o primeiro passo; o verdadeiro objetivo é evoluir continuamente a solução, tornando-a cada vez mais simples, clara e sustentável.