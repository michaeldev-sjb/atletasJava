import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual a quantidade de atletas?");
        int athletes = sc.nextInt();

        double tallestAthlete = 0.0;
        String tallAthlete = "";
        double percentageMen = 0.0;
        double womenHeight = 0.0;
        int womenAmount = 0;
        int menAmonunt = 0;
        double weightAthletes = 0.0;

        for (int x = 1; x <= athletes; x++) {
            System.out.printf("Digite os dados do atleta numero " + x + ":%n");

            System.out.print("Nome: ");
            sc.nextLine();
            String athleteName = sc.nextLine();
            System.out.print("Sexo: ");
            char sex = sc.next().charAt(0);
            while (sex != 'F' && sex != 'M') {
                System.out.print("Valor invalido! Favor digitar F ou M: ");
                sex = sc.next().charAt(0);
            }
            System.out.print("Altura: ");
            double athleteHeight = sc.nextDouble();
            while (athleteHeight <= 0.0) {
                System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                athleteHeight = sc.nextDouble();
            }

            System.out.print("Peso: ");
            double athleteWeight = sc.nextDouble();
            while (athleteWeight <= 0.0) {
                System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                athleteWeight = sc.nextDouble();
            }
            weightAthletes += athleteWeight;

            if (sex == 'F') {
                womenAmount++;
                womenHeight += athleteHeight;
            }
            if (sex == 'M') {
                menAmonunt++;
            }

            if (tallestAthlete < athleteHeight) {
                tallestAthlete = athleteHeight;
                tallAthlete = athleteName;
            }

        }

        weightAthletes = weightAthletes / athletes;
        percentageMen = (double) (100 / athletes) * menAmonunt;
        womenHeight = womenHeight / womenAmount;

        System.out.println("\nRELATÓRIO: ");
        System.out.printf("Peso médio dos atletas: %.2f%n", weightAthletes);
        System.out.println("Atleta mais alto: " + tallAthlete);
        System.out.printf("Porcentagem de homens: %.2f%%%n", percentageMen);
        if (womenAmount > 0) {
            System.out.printf("Altura média das mulheres: %.2f%n", womenHeight);
        } else {
            System.out.println("Não há mulheres cadastradas");
        }
        sc.close();
    }
}