# Challenge Java Conversor

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Console](https://img.shields.io/badge/interface-console-0a7ea4)
![API](https://img.shields.io/badge/API-ExchangeRate-f97316)
![Status](https://img.shields.io/badge/status-MVP%20funcional-2e8b57)

# Conversor de Moedas

Aplicação Java de linha de comando para conversão de moedas em tempo real usando a ExchangeRate API, com menu interativo, validação de entrada, histórico de conversões na sessão e suporte a conversões rápidas e personalizadas.

O repositório agora inclui uma implementação funcional do projeto, e não apenas a descrição do challenge.

## Visão Geral

O objetivo do projeto é permitir que o usuário consulte taxas de câmbio atualizadas e converta valores entre moedas de forma simples pelo terminal.

Nesta versão, a aplicação oferece:

- menu de conversões rápidas;
- conversão personalizada entre moedas;
- consulta de taxa em tempo real;
- histórico local durante a execução;
- tratamento de erros de entrada e falhas de integração.

## Funcionalidades

- Conversão entre moedas em tempo real
- Menu com pares de moedas mais comuns
- Conversão personalizada entre moedas suportadas
- Histórico de conversões na sessão
- Validação de valor monetário e códigos de moeda
- Configuração por variável de ambiente
- Mensagens de erro mais amigáveis no console

## Moedas Suportadas no Menu Rápido

- `USD` - Dólar Americano
- `BRL` - Real Brasileiro
- `EUR` - Euro
- `GBP` - Libra Esterlina
- `JPY` - Iene Japonês
- `ARS` - Peso Argentino
- `COP` - Peso Colombiano

Na conversão personalizada, qualquer moeda suportada pela API pode ser consultada.

## Estrutura do Projeto

```text
.
├── pom.xml
├── README.md
└── src
    └── main
        └── java
            └── br/com/vicfmartins/conversor
                ├── config
                ├── model
                ├── service
                ├── ui
                ├── util
                └── Main.java
```

## Stack Utilizada

- Java 17
- Java HttpClient
- Gson
- Maven
- ExchangeRate API

## Configuração

Antes de executar, defina a variável de ambiente `EXCHANGE_RATE_API_KEY`.

### PowerShell

```powershell
$env:EXCHANGE_RATE_API_KEY="sua_chave_aqui"
```

### CMD

```cmd
set EXCHANGE_RATE_API_KEY=sua_chave_aqui
```

## Como Executar

### 1. Clonar o repositório

```bash
git clone https://github.com/VicFmartins/Challenge-java-conversor.git
cd Challenge-java-conversor
```

### 2. Compilar o projeto

```bash
mvn clean package
```

### 3. Executar

```bash
java -jar target/conversor-moedas-1.0.0-jar-with-dependencies.jar
```

## Menu Disponível

```text
1. USD -> BRL
2. BRL -> USD
3. USD -> EUR
4. EUR -> USD
5. USD -> ARS
6. ARS -> USD
7. Conversao personalizada
8. Ver historico
9. Ver moedas do menu rapido
0. Sair
```

## Exemplo de Uso

```text
Escolha uma opcao: 1
Digite o valor a converter: 100

Resultado da conversao
100.00 USD = 495.50 BRL
Taxa utilizada: 1 USD = 4.9550 BRL
```

## Regras Atuais do MVP

- a chave da API não fica hardcoded no código;
- o histórico existe durante a sessão atual da aplicação;
- a conversão personalizada aceita códigos informados pelo usuário;
- respostas inválidas da API são tratadas com erro explícito.

## Próximos Passos

- persistir histórico em arquivo;
- adicionar cache de cotações;
- incluir testes unitários;
- exportar histórico para CSV;
- adicionar interface gráfica.

## Observação

As taxas retornadas dependem da ExchangeRate API e podem variar conforme o momento da consulta e o plano da chave utilizada.
