// STOJ Laura 21413129
import java.util.ArrayList;
public class Simulation {
    public Terrain terrain;
    private ArrayList<AgentMarin> listeAgents;
    private boolean pirateVivant = true;

    public Simulation(int nbress, int nbag, int li, int co) {
        this.terrain = new Terrain(li, co);
        this.listeAgents = new ArrayList<AgentMarin>();
        int nbr = 0;
        for (int i = 1; i <= terrain.nbLignes; i++) {
            for (int j = 1; j <= terrain.nbColonnes; j++) {
                if (nbr < nbress) {
                    if (Math.random() > 0.2 && terrain.caseEstVide(i, j)) { 
                        terrain.setCase(i, j, new Ressource("PoissonM", 1));
                        QuantiteRessource.ajouterPoisson(); 
                        nbr++;
                    } else if (Math.random() > 0.8 && terrain.caseEstVide(i, j)) {
                        terrain.setCase(i, j, new Ressource("Algue", 1));
                        QuantiteRessource.ajouterAlgue(); 
                        nbr++;
                    }
                }
            }
        }

        for (int i = 0; i< nbag; i++) {
            int h1 = (int)(Math.random()* li) + 1;
            int h2 = (int)(Math.random()* co) + 1;
            
            if (i == 0) {
                listeAgents.add(new Pirate( terrain, h1, h2));
            } else {
                if (i%2 ==0) { 
                    listeAgents.add(new Requingentil(0, 0, terrain, h1, h2));
                } else {
                    listeAgents.add(new RequinPilleur(0, 0, terrain, h1, h2));
                }
            }
        }
    }
    public void manche() throws ActionMerException{
        if (!pirateVivant) return;
        Pirate lePirate = (Pirate) (listeAgents.get(0));

        for (AgentMarin agent : listeAgents) {
            if (agent == null || agent == lePirate) continue; 

            if (agent instanceof AnimalMarin) {
                AnimalMarin am = (AnimalMarin) agent;
                if (am instanceof RequinPilleur) {
                    int ml = (int) (Math.random() * terrain.nbLignes) + 1;
                    int mc = (int) (Math.random() * terrain.nbColonnes) + 1;
                    am.seDeplacer(ml, mc);
                    System.out.println("TOUR DU REQUIN PILLEUR");
                    try{
                        if (((RequinPilleur)am).agir(lePirate, ml, mc)) {
                            this.pirateVivant = false; 
                            System.out.println("LE PIRATE EST MORT VICTOIRE DES REQUINS !");
                            return; 
                        } else {
                        System.out.println("LE PIRATE SE FAIT PILLER DE 3 POISSONS ET 3 ALGUES !");
                        System.out.println(" POISSONS DU PIRATE: "+lePirate.getStockPoisson());
                        }
                    }catch(ActionMerException e){
                        System.out.println("Incident en mer!");
                    }

                } else if (am instanceof Requingentil) {
                    int ll = (int) (Math.random() *terrain.nbLignes) + 1;
                    int lc = (int) (Math.random() *terrain.nbColonnes) + 1;
                    am.seDeplacer(ll, lc);
                    System.out.println("TOUR DU REQUIN GENTIL");
                    try{
                        if(((Requingentil)am).agir(lePirate, ll, lc)){
                            System.out.println("J'offre un poisson au pirate!");
                            System.out.println(" POISSONS DU PIRATE: "+lePirate.getStockPoisson());
                        }else{
                            System.out.println("Je me balade et je n'offre rien");
                        }
                    }catch(ActionMerException e){
                        System.out.println("Incident en mer!");
                    }
                    }
                } 
        System.out.println("  TOUR DU PIRATE  ");
        int nl = (int) (Math.random() * terrain.nbLignes) + 1;
        int nc = (int) (Math.random() * terrain.nbColonnes) + 1;
        lePirate.seDeplacer(nl, nc);
        lePirate.augstockalgue(nl, nc);
        lePirate.augstockpoisson(nl, nc);
        System.out.println(" POISSONS DU PIRATE: " + lePirate.getStockPoisson());

        if (lePirate.gagnePartie()) {
            System.out.println("LE PIRATE SURVIT ET GAGNE LA PARTIE !");
        }
        }
        actualiserAlgues();
    }

    private void actualiserAlgues() {
        for (int i = 1; i <= terrain.nbLignes; i++) {
            for (int j = 1; j <= terrain.nbColonnes; j++) {
                Ressource r = terrain.getCase(i, j);
                if (r != null && "Algue".equals(r.type)) {
                    r.setQuantite(r.getQuantite() + 1);
                    QuantiteRessource.ajouterAlgue();
                }
            }
        }
    }
    public boolean estFinie() {
        if (!pirateVivant) return true;
        Pirate p = (Pirate)(listeAgents.get(0));
        return p.gagnePartie();
    }
}