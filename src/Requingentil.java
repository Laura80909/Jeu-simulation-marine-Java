//STOJ Laura 21413129
import java.util.ArrayList;
public class Requingentil extends AnimalMarin implements InteractionMarine{
    private String nom;
    public Requingentil(int algue, int poisson, Terrain t, int lig, int col){
        super(algue, poisson, t, lig, col);
        this.nom="Requin gentil";
    }
    public String getNom(){
        return nom;
    }
    public double distance(int lig, int col){
        double dislig=Math.pow ((lig-this.lig),2);
        double discol=Math.pow ((col-this.col),2);
        return Math.sqrt(dislig+discol);
    }
    public void energpoisson(){
        energiepoisson++;
    }
    public void seDeplacer(int lig, int col){
        this.lig=lig;
        this.col=col;
        System.out.println(this.nom +" se déplace en " +lig + "," + col);
    }
    public boolean agir(Pirate p, int i , int j) throws ActionMerException{
        energiepoisson++;
        if(Math.random()>0.4){
            offrir(p);
            return true;
        }else{
            manger(i, j);
            return false;
        }
    }
    public void offrir(AgentMarin a){
        if(a instanceof Pirate){
                ((Pirate)a).gagnerpoisson();
                System.out.println("Je t'offre un poisson");
            }
    }
    public void manger(int i , int j) throws ActionMerException{
        if(i==lig && j==col){
            Ressource r = t.getCase(i, j);
            if(r==null)
                throw new ActionMerException("La case n'a aucune ressource!");
            if ("Algue".equals(r.type)) {
                QuantiteRessource.retirerAlgue();
                energiealgue++;
                System.out.println("REQUIN GENTIL : Je mange une algue");
                System.out.println("Algues en mer : "+QuantiteRessource.getNbAlgues()+" Poissons en mer : "+QuantiteRessource.getNbPoissons());
            }if ("PoissonM".equals(r.type)){
                QuantiteRessource.retirerPoisson();
                energiepoisson++;
                System.out.println("REQUIN GENTIL : Je mange un poisson");
                System.out.println("Algues en mer : "+QuantiteRessource.getNbAlgues()+" Poissons en mer : "+QuantiteRessource.getNbPoissons());
            }System.out.println("Je mange l'algue !");
            t.viderCase(lig, col);
        }
    }
}