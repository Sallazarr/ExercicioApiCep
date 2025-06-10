import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String cep = "";
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        List<Endereco> enderecos = new ArrayList<>();

        while (!cep.equalsIgnoreCase("sair")) {
            System.out.println("Digite seu CEP:");
            cep = scanner.nextLine();
            if (cep.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                String buscaCep = "https://viacep.com.br/ws/" + cep + "/json/";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(buscaCep))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                EnderecoApiCep enderecoApi = gson.fromJson(json, EnderecoApiCep.class);

                Endereco meuEndereco = new Endereco(enderecoApi);
                System.out.println("\nMeu endereço");
                System.out.println(meuEndereco);
                enderecos.add(meuEndereco);
            } catch (Exception e){
                System.out.println("Erro ao tentar consultar o CEP: " + e.getMessage());
            }


        }

        System.out.println("Consulta de CEP finalizada, verifique o arquivo gerado");
        System.out.println(enderecos);
        FileWriter escrita = new FileWriter("endereço.json");
        escrita.write(gson.toJson(enderecos));
        escrita.close();
        scanner.close();
    }
}
