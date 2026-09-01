//STOJ Laura 21413129
public class QuantiteRessource{
    public static int nbalgues=0;
    public static int nbpoissons=0;
    public static int getNbAlgues(){
        return nbalgues;
    }
    public static int getNbPoissons(){
        return nbpoissons;
    }
    public static void ajouterAlgue(){
        nbalgues++;
    }
    public static void ajouterPoisson(){
        nbpoissons++;
    }
    public static void retirerAlgue(){
        if(nbalgues>0) nbalgues--;
    }
    public static void retirerPoisson(){
        if(nbpoissons>0) nbpoissons--;
    }
}