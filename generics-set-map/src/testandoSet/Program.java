package testandoSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args){
        Set<Integer> totalAlunos = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos estudantes para curso A? ");
        int qtdeEstudantes = sc.nextInt();

        for(int i = 0; i < qtdeEstudantes; i++){
            totalAlunos.add(sc.nextInt());
        }

        System.out.print("Quantos estudantes para curso B? ");
         qtdeEstudantes = sc.nextInt();

        for(int i = 0; i < qtdeEstudantes; i++){
            totalAlunos.add(sc.nextInt());
        }

        System.out.print("Quantos estudantes para curso C? ");
        qtdeEstudantes = sc.nextInt();
        for(int i = 0; i < qtdeEstudantes; i++){
            totalAlunos.add(sc.nextInt());
        }

        System.out.println("Total de estudantes: " + totalAlunos.size());
    }
}
