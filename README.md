# Challenge-java-conversor

# Conversor de Moedas

Aplicação Java para conversão de moedas em tempo real utilizando a ExchangeRate-API.

## 📋 Sobre o Projeto

Conversor de moedas desenvolvido em Java que permite realizar conversões entre diferentes moedas utilizando taxas de câmbio atualizadas em tempo real através da ExchangeRate-API.

### Funcionalidades

- ✅ Conversão entre múltiplas moedas
- ✅ Taxas de câmbio em tempo real
- ✅ Interface de linha de comando intuitiva
- ✅ Histórico de conversões na sessão
- ✅ Tratamento de erros e validações
- ✅ Suporte para as principais moedas mundiais

### Moedas Suportadas

- **USD** - Dólar Americano
- **BRL** - Real Brasileiro
- **EUR** - Euro
- **GBP** - Libra Esterlina
- **JPY** - Iene Japonês
- **ARS** - Peso Argentino
- **COP** - Peso Colombiano

## 🚀 Começando

### Pré-requisitos

- Java JDK 17 ou superior
- Conexão com a internet
- Chave de API da ExchangeRate-API

### Obtendo a Chave da API

1. Acesse [ExchangeRate-API](https://www.exchangerate-api.com/)
2. Insira seu e-mail para registro
3. Você receberá a chave de API no e-mail cadastrado
4. A chave gratuita permite até 1.500 requisições por mês

### Instalação

1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/conversor-moedas.git
cd conversor-moedas
```

2. Configure sua chave da API

Edite o arquivo `src/config/ApiConfig.java` e insira sua chave:
```java
private static final String API_KEY = "sua_chave_aqui";
```

3. Compile o projeto
```bash
javac -d bin src/**/*.java
```

4. Execute a aplicação
```bash
java -cp bin Main
```

## 💻 Como Usar

Ao executar a aplicação, você verá um menu interativo:

```
========================================
      CONVERSOR DE MOEDAS
========================================
1. Dólar (USD) → Real Brasileiro (BRL)
2. Real Brasileiro (BRL) → Dólar (USD)
3. Dólar (USD) → Euro (EUR)
4. Euro (EUR) → Dólar (USD)
5. Dólar (USD) → Peso Argentino (ARS)
6. Peso Argentino (ARS) → Dólar (USD)
7. Conversão personalizada
8. Ver histórico de conversões
9. Sair
========================================
Escolha uma opção:
```

Selecione a opção desejada e insira o valor a ser convertido.

### Exemplo de Uso

```
Escolha uma opção: 1
Digite o valor a converter: 100

Resultado da Conversão:
----------------------------------------
100.00 USD = 495.50 BRL
Taxa de câmbio: 1 USD = 4.955 BRL
Data: 15/12/2025 14:30:45
----------------------------------------
```

## 📁 Estrutura do Projeto

```
conversor-moedas/
│
├── src/
│   ├── Main.java
│   ├── config/
│   │   └── ApiConfig.java
│   ├── model/
│   │   ├── Currency.java
│   │   └── ConversionResult.java
│   ├── service/
│   │   ├── ExchangeRateService.java
│   │   └── ConversionService.java
│   └── util/
│       ├── InputValidator.java
│       └── ConsoleHelper.java
│
├── README.md
└── .gitignore
```

## 🛠️ Tecnologias Utilizadas

- **Java 17+** - Linguagem de programação
- **ExchangeRate-API** - API de taxas de câmbio
- **Gson** - Processamento de JSON
- **HttpClient** - Requisições HTTP

## 🔧 Configurações Avançadas

### Adicionar Novas Moedas

Para adicionar suporte a novas moedas, edite o enum `Currency` em `src/model/Currency.java`:

```java
public enum Currency {
    USD("Dólar Americano"),
    BRL("Real Brasileiro"),
    // Adicione aqui...
}
```

## 📝 Tratamento de Erros

A aplicação possui tratamento para:

- Falhas na conexão com a API
- Valores inválidos de entrada
- Moedas não suportadas
- Limites de requisição excedidos

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/NovaFuncionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/NovaFuncionalidade`)
5. Abra um Pull Request


## ✨ Agradecimentos

- [Alura](https://www.alura.com.br/) - Plataforma de ensino
- [Oracle Next Education](https://www.oracle.com/br/education/oracle-next-education/) - Programa ONE
- [ExchangeRate-API](https://www.exchangerate-api.com/) - API de taxas de câmbio



---

Desenvolvido como parte do Challenge ONE - Oracle Next Education 🚀
