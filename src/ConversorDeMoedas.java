import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorDeMoedas {

    private static final String API_KEY = "13c3819c73e5a8cbf54694d8";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    private static final String[] MOEDAS = {"USD", "EUR", "BRL", "GBP", "JPY", "AUD"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Conversor de Moedas ===");
            for (int i = 0; i < MOEDAS.length; i++) {
                System.out.println((i + 1) + ". " + MOEDAS[i]);
            }

            int origemIndex = -1;
            while (origemIndex < 0 || origemIndex >= MOEDAS.length) {
                System.out.print("Escolha a moeda de origem (número): ");
                origemIndex = scanner.nextInt() - 1;
                if (origemIndex < 0 || origemIndex >= MOEDAS.length) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }

            int destinoIndex = -1;
            while (destinoIndex < 0 || destinoIndex >= MOEDAS.length) {
                System.out.print("Escolha a moeda de destino (número): ");
                destinoIndex = scanner.nextInt() - 1;
                if (destinoIndex < 0 || destinoIndex >= MOEDAS.length) {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            String moedaOrigem = MOEDAS[origemIndex];
            String moedaDestino = MOEDAS[destinoIndex];

            try {
                double taxa = buscarTaxaDeCambio(moedaOrigem, moedaDestino);
                double convertido = valor * taxa;

                System.out.printf("Valor convertido: %.2f %s = %.2f %s\n",
                        valor, moedaOrigem, convertido, moedaDestino);
            } catch (Exception e) {
                System.out.println("Erro ao buscar taxa de câmbio: " + e.getMessage());
            }

            System.out.print("Deseja fazer outra conversão? (s/n): ");
            String resposta = scanner.next();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println("Programa encerrado. Até mais!");
    }

    private static double buscarTaxaDeCambio(String moedaOrigem, String moedaDestino) throws Exception {
        String urlStr = API_URL + moedaOrigem;
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        Reader reader = new InputStreamReader(connection.getInputStream());
        JsonObject json = new Gson().fromJson(reader, JsonObject.class);

        if (!json.get("result").getAsString().equals("success")) {
            throw new RuntimeException("Falha na requisição da API.");
        }

        JsonObject taxas = json.getAsJsonObject("conversion_rates");
        return taxas.get(moedaDestino).getAsDouble();
    }
}
