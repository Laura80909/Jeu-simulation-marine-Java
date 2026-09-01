//STOJ Laura 21413129
import java.util.ArrayList;
public class EtatDesClasses {
    private static EtatDesClasses instance = null;
    private ArrayList<String> historique;
    private int compteurMorts;
    private EtatDesClasses() {
        historique = new ArrayList<>();
        compteurMorts= 0;
    }
    public static EtatDesClasses getInstance() {
        if (instance == null) {
            instance = new EtatDesClasses();
        }
        return instance;
    }
    public void ajouterEvenement(String msg) {
        historique.add(msg);
        System.out.println(" MESSAGE : " + msg);
    }

    public void prevenirMortPirate() {
        compteurMorts++;
        System.out.println("Un mort de plus !");
    }
    public void historique() {
        System.out.println("résumé : ");
        for (String s : historique) {
            System.out.println(s);
        }
    }
}