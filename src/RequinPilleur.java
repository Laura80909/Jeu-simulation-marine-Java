//STOJ Laura 21413129
public class RequinPilleur extends Requingentil{
    public RequinPilleur(int algue, int poisson, Terrain t, int lig, int col){
        super(algue, poisson, t, lig, col);
    }
    public String getNom(){
        return "Requin Pilleur";
    }
    public double distance(int lig, int col){
        double dislig=Math.pow ((lig-this.lig),2);
        double discol=Math.pow ((col-this.col),2);
        return Math.sqrt(dislig+discol);
    }
    public void seDeplacer(int lig, int col){
            this.lig=lig;
            this.col=col;
        System.out.println(this.getNom() +" se déplace en " +lig + "," + col);
    }
    public boolean agir(Pirate p, int i, int j) throws ActionMerException{
        double de=Math.random();
        if(de<=0.1){
                p.attaqueRequin();
                return true;
        }else if(de<=0.2){
                p.seFairePiller(3, 3);
                return false;
        }else{
            System.out.println("Je préfère manger des algues que piller.");
            manger(i, j);
            return false;
        }
    }
    public void offrir(AgentMarin a){
        System.out.println("je ne t offrirai rien je ne suis pas gentil");
    }
    public void manger(int i , int j) throws ActionMerException{
        if(i==lig && j==col){
            Ressource r = t.getCase(i, j);
            if(r==null)
                throw new ActionMerException("La case n'a aucune ressource!");
            if ("Algue".equals(r.type)){
                QuantiteRessource.retirerAlgue();
                System.out.println("REQUIN PILLEUR : Je mange une algue");
                System.out.println("Algues en mer : "+QuantiteRessource.getNbAlgues()+" Poissons en mer : "+QuantiteRessource.getNbPoissons());
                energiealgue++;
            }if ("PoissonM".equals(r.type)) if(Math.random() >0.9 ){
                QuantiteRessource.retirerPoisson();
                energiepoisson++;
                System.out.println("REQUIN PILLEUR : Je mange un poisson");
                System.out.println("Algues en mer : "+QuantiteRessource.getNbAlgues()+" Poissons en mer : "+QuantiteRessource.getNbPoissons());
            }
            System.out.println("Je mange l'algue ou le poisson!");
            t.viderCase(lig, col);
        }
    }
}