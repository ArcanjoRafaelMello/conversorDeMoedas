# 💱 Conversor de Moedas em Java

Este é um projeto simples de conversor de moedas, desenvolvido em Java, que utiliza a [ExchangeRate API](https://app.exchangerate-api.com/) para buscar cotações em tempo real. A conversão é feita entre 6 moedas diferentes com base em valores atualizados diretamente da internet.

## 📌 Funcionalidades

- Conversão de moedas com cotação em tempo real.
- Interface de linha de comando.
- Validação de entradas do usuário.
- Opção de realizar múltiplas conversões sem reiniciar o programa.

## 💡 Tecnologias utilizadas

- Java 8 ou superior
- [Gson](https://github.com/google/gson) (para manipulação de JSON)
- API: [ExchangeRate API](https://app.exchangerate-api.com/)

## 💵 Moedas disponíveis

- USD (Dólar Americano)
- EUR (Euro)
- BRL (Real Brasileiro)
- GBP (Libra Esterlina)
- JPY (Iene Japonês)
- AUD (Dólar Australiano)

## 🚀 Como executar

### 1. Clonar o repositório

```bash
git clone https://github.com/ArcanjoRafaelMello/conversor-moedas-java.git
cd conversor-moedas-java
```

### 2. Adicionar dependência do Gson

Se estiver usando Maven, adicione ao seu `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

Se não estiver usando Maven, baixe o JAR do Gson [aqui](https://repo1.maven.org/maven2/com/google/code/gson/gson/) e adicione ao seu classpath.

### 3. Executar o programa

Você pode compilar e rodar o programa no IntelliJ ou pelo terminal:

```bash
javac ConversorDeMoedas.java
java ConversorDeMoedas
```

## 🔐 Chave da API

Este projeto utiliza uma chave da [ExchangeRate API](https://app.exchangerate-api.com/). Você pode usar a chave gratuita de demonstração:

```
13c3819c73e5a8cbf54694d8
```

Para projetos em produção, recomenda-se gerar uma chave pessoal na plataforma.

## 🧪 Exemplo de uso

```
=== Conversor de Moedas ===
1. USD
2. EUR
3. BRL
4. GBP
5. JPY
6. AUD
Escolha a moeda de origem (número): 3
Escolha a moeda de destino (número): 1
Digite o valor a ser convertido: 100
Valor convertido: 100.00 BRL = 19.30 USD
Deseja fazer outra conversão? (s/n): s
```

## 🛠️ Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## 📄 Licença

Este projeto está sob a licença MIT.

---

Desenvolvido com 💙 por [ArcanjoRafaelMello](https://github.com/ArcanjoRafaelMello)
