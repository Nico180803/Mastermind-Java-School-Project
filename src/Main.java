import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//VARIABLES

        boolean[] chiffre = new boolean[10];
        int[] chaine = new int[5];
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        String proposition;
        int verif = 0;
        boolean rejouer = false;
        int essaie = 12;

//CODE

        do {

            System.out.println("Bienvenu dans ce MasterMind, \nVous devez trouvez une séquence de chiffre compris entre 1 et 9, vous avez 12 essaies pour cela");


            for (int i = 0; i < 5; i++) {
                do {
                    chaine[i] = rand.nextInt(9) + 1;
                } while (chiffre[chaine[i]]);
                chiffre[chaine[i]] = true;
            }

            for (int i = 0; i < chaine.length; i++) {
                System.out.print(chaine[i] + " ");
            }

            do {
                System.out.println();
                System.out.println("Il vous reste "+essaie+" essai(s)");

                System.out.println();
                do {
                    System.out.println("Entrez une proposition :");
                    proposition = sc.nextLine();
                } while (!verifProposition(proposition));

                for (int i = 0; i < chaine.length; i++) {
                    if (Character.getNumericValue(proposition.charAt(i)) == chaine[i]) {
                        System.out.println(proposition.charAt(i) + " est à la bonne place");
                        verif++;
                    } else {
                        for (int j = 0; j < chaine.length; j++) {
                            if (Character.getNumericValue(proposition.charAt(i)) == chaine[j]) {
                                System.out.println(proposition.charAt(i) + " est mal placé");
                            }
                        }
                    }
                }
                if (verif == 5) {
                    System.out.println("Féliciation, vous avez trouvé");
                    System.out.println("Voulez vous rejouer ? (O/N)");
                    if (sc.nextLine().toUpperCase().equals("O")) {
                        rejouer = true;
                        for (int i = 0; i < chiffre.length; i++) {
                            chiffre[i] = false;
                        }
                    } else break;
                }
                verif = 0;
                essaie--;
            }while (essaie != 0);

        }while (rejouer);
    }

    public static boolean verifProposition (String proposition){
        boolean result = false;
        if (proposition.length() > 5) {
            System.out.println("Erreur : la proposition est trop longue (5 chiffres)");
            result = false;
        } else if (!proposition.matches("//d+")) {
            System.out.println("Erreur veuillez entrer des nombres !");
            result = false;
        } else {
            result = true;
        }
        return result;
    }
}

