package exercicioEleicaoMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Program {
    public static void main(String[] args){

        HashMap<String, Integer> totalVotos = new LinkedHashMap<>();
        String path = "C:\\Users\\JúlioCésar\\source\\github\\java-nelio\\generics-set-map\\src\\exercicioEleicaoMap\\eleicao.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String lines = br.readLine();

            while(lines != null){

                String[] dados = lines.split(",");

                if(totalVotos.containsKey(dados[0]))
                    totalVotos.put(dados[0], totalVotos.get(dados[0]) + Integer.parseInt(dados[1]));
                else
                    totalVotos.put(dados[0], Integer.parseInt(dados[1]));

                lines = br.readLine();
            }

            for(String key : totalVotos.keySet()){
                System.out.println(key + ": " + totalVotos.get(key));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
