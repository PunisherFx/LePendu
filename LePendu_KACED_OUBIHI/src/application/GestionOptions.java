package application;

public class GestionOptions {
    private static double taillePolice = 15; // taille par défaut

    public static double getTaillePolice() {
        return taillePolice;
    }

    public static void setTaillePolice(double taille) {
        taillePolice = taille;
    }
}
