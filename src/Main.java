import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//VARIABLES

        boolean [] chiffre = new boolean[10];
        int [] chaine = new int[5];
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        String proposition;
        int verif=0;

//CODE

        System.out.println("Bienvenu dans ce MasterMind, \nVous devez trouvez une séquence de chiffre compris entre 1 et 9, vous avez 12 essaies pour cela");
        

        for (int i = 0; i < 5; i++) {
            do {
                chaine[i] = rand.nextInt(9)+1;
            }while (chiffre[chaine[i]]);
            chiffre[chaine[i]] = true;
        }

        for (int i = 0; i < chaine.length; i++){
            System.out.print(chaine[i]+" ");
        }

        //REDUCTIBLE AVEC BOUCLE OU FONCTION C'EST SUR ^

        System.out.println();
        do {
            System.out.println("Entrez une proposition :");
            proposition = sc.nextLine();
        }while (verifProposition(proposition)==false);

        for (int i = 0; i < chaine.length; i++) {
            if (Character.getNumericValue(proposition.charAt(i)) == chaine[i]) {
                System.out.println(proposition.charAt(i)+" est à la bonne place");
                verif++;
            } else{
                for (int j = 0; j < chaine.length; j++){
                    if (Character.getNumericValue(proposition.charAt(i)) == chaine[j]){
                        System.out.println(proposition.charAt(i)+" est mal placé");
                    }
                }
            }
        }
        if (verif==5){
            System.out.println("Féliciation, vous avez trouvé");
        }
        verif=0;


    }

    public static boolean verifProposition(String proposition){
        boolean result = false;
        //AJOUT VERIF CHIFFRE A FAIRE
        if (proposition.length() > 5){
            System.out.println("Erreur : la proposition est trop longue (5 chiffres)");
            result = false;
        } else {
            result = true;
        }
        return result;
    }
}
