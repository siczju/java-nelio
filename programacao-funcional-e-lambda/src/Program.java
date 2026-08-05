import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args){

        String path = "C:\\Users\\JúlioCésar\\source\\github\\java-nelio\\programacao-funcional-e-lambda\\src\\in.csv";

        List<Employee> list = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while(line != null){
                String[] campos = line.split(";");
                Employee e = new Employee(campos[0], campos[1], Double.parseDouble(campos[2]));
                list.add(e);

                line = br.readLine();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        Integer salary = 3100;

        list.stream()
                .filter(e -> e.getSalary() >= salary)
                .map(e -> e.getEmail())
                .sorted((e1, e2) -> e1.compareTo(e2))
                .forEach(System.out::println);

        double soma = list.stream()
                .filter(e -> e.getName().toUpperCase().startsWith("M"))
                .map(Employee::getSalary)
                .reduce(0.0, (x,y) -> x + y);

        System.out.println("A soma de todos salarios com M é: " + soma);


    }
}
