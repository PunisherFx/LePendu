package application;

public class GestionOptions {
    private static double taillePolice = 15;// on met la taille de la lettre au debut a 15 
    private static boolean modeSombre = true;// mode sombre toujours active (activer par defaut)

    public static boolean isModeSombre() {
        return modeSombre;
    }

    public static void setModeSombre(boolean mode) {
        modeSombre = mode;
    }
    
    public static double getTaillePolice() {
        return taillePolice;
    }

    public static void setTaillePolice(double taille) {
        taillePolice = taille;
    }
}
