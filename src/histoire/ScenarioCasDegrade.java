package histoire;

import villagegaulois.Etal;
import villagegaulois.EtalNonOccupeException;
import personnages.Gaulois;
import villagegaulois.Village;
import villagegaulois.VillageSansChefException;

public class ScenarioCasDegrade {
    public static void main(String[] args) {
        Gaulois bonemine = new Gaulois("Bonemine", 10);
        Gaulois abraracourcix = new Gaulois("Abraracourcix", 20);

        Etal etal = new Etal();
        try {
            etal.libererEtal();
        } catch (EtalNonOccupeException e) {
            System.out.println(e.getMessage()); 
        }

        etal.occuperEtal(bonemine, "fleurs", 10);

        try {
            etal.acheterProduit(5, null); 
        } catch (NullPointerException e) {
            e.printStackTrace(); 
        }

        try {
            etal.acheterProduit(0, abraracourcix); 
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur : " + e.getMessage());
        }

        Etal etalInoccupe = new Etal();
        try {
            etalInoccupe.acheterProduit(5, abraracourcix); 
        } catch (IllegalStateException e) {
            System.err.println("Erreur : " + e.getMessage());
        }

        try {
            String resultat = etal.acheterProduit(5, abraracourcix);
            System.out.println(resultat);
        } catch (Exception e) {
            System.err.println("Erreur inattendue : " + e.getMessage());
        }
        Village village = new Village("Le village des irréductibles", 10, 5);

        try {
            System.out.println(village.afficherVillageois());
        } catch (VillageSansChefException e) {
            System.err.println("Erreur : " + e.getMessage());
        }

        System.out.println("Fin du test");
    }
}
