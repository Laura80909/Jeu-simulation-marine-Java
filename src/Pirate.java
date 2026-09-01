//STOJ Laura 21413129
public class Pirate extends AgentMarin implements InteractionMarine{
    private String nom="Pirate";
    private int stockpoisson;
    private int stockalgue;
    public Pirate( Terrain terrain, int lig, int col){
        super(lig, col, terrain);
        this.stockpoisson=0;
        this.stockalgue=0;
    }
    public Pirate(Pirate autrePirate){
        super(autrePirate.lig, autrePirate.col, autrePirate.t );
        this.stockpoisson=autrePirate.stockpoisson;
        this.stockalgue=autrePirate.stockalgue;
    }
    public boolean estSauve(){
        return stockpoisson>=2;
    }
    public double distance(int lig, int col){
        double dislig=Math.pow ((lig-this.lig),2);
        double discol=Math.pow ((col-this.col),2);
        return Math.sqrt(dislig+discol);
    }
    public void seDeplacer(int lig, int col){
        this.lig=lig;
        this.col=col;
        System.out.println(this.nom +" se déplace en " +lig + "," + col+ " et a "+stockpoisson+" poissons magiques.");
    }
    public void seFairePiller(int algues, int poissons){
        stockalgue-=algues;
        stockpoisson-=poissons;
        if(stockalgue < 0) stockalgue = 0;
        if(stockpoisson < 0) stockpoisson =0;
    }
    public boolean attaqueRequin(){
        if(!estSauve()){
            System.out.println("Pirate tué, Félicitations aux requins.");
            EtatDesClasses.getInstance().prevenirMortPirate();;
            EtatDesClasses.getInstance().ajouterEvenement("Il y a eu un mort (pirate).");
            return true;
        }else{
            System.out.println("J'ai assez de poissons magiques et je survie!");
            return false;
        }
    }
    public void augstockalgue(int i , int j){
        Ressource r = t.getCase(i, j);
        if(r!=null){
            if((i==lig && j==col) && "Algue".equals(r.type)){
                 System.out.println("J'ai "+ stockalgue+ " algues!");
                stockalgue++;
                t.viderCase(lig, col);
            }
        }
    }
    public void augstockpoisson(int i , int j){
        Ressource r = t.getCase(i, j);
        if(r!=null){
            if((i==lig && j==col) || (t.sontValides(i+1, j) && i+1==lig && j==col) || (t.sontValides(i, j+1) && i==lig && j+1==col) && "PoissonM".equals(r.type)){
                System.out.println("J'ai "+stockpoisson+ " poissons magiques!");
                stockpoisson++;
                t.viderCase(lig, col);
        }
        }
    }
    public void gagnerpoisson(){
        stockpoisson++;
    }
    public void offrir(AgentMarin a){
        if(a instanceof Requingentil){
            if(stockalgue>=1){
                ((Requingentil)(a)).energpoisson();
                stockalgue--;
            }
        }else{
            System.out.println("pas assez d'algues");
        }
    }
    public int getStockPoisson(){
        return stockpoisson;
    }
    public int getStockAlgue(){
        return stockalgue;
    }
    public boolean gagnePartie(){
        if(stockpoisson>=3){
            return true;
        }return false;
    }

}