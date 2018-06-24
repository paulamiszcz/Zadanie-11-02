import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Weather {
    public static void main(String[] args) throws IOException {
        WeatherApi wApi = new WeatherApi();
        List<String> lista = new ArrayList<>();
        File file = new File("miasta.txt");
        Scanner scanner = new Scanner(file);


        while (scanner.hasNextLine()) {
            lista.add(scanner.nextLine());
        }
        scanner.close();

        List<WeatherInfo> listaWeather = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            listaWeather.add(new WeatherInfo(lista.get(i), wApi.getDescription(lista.get(i)), wApi.getTemperature(lista.get(i))));
        }
        FileWriter fileWriter = new FileWriter("MiastaInfo.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < listaWeather.size(); i++) {
            bufferedWriter.write(""+ listaWeather.get(i));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();

    }
}
