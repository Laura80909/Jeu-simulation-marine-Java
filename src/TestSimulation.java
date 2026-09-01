//STOJ Laura 21413129
public class TestSimulation {
    public static void main(String[] args) {
        Simulation sim = new Simulation(10, 3,20, 20);
        System.out.println(" DÉBUT DU JEU ");
        int nb=0;
        while (!sim.estFinie() && nb<15) {
            nb++;
            try {
                sim.manche();
            } catch (ActionMerException e) {
                System.out.println("Un incident est survenu en mer : ");
            }
            try { 
                Thread.sleep(500); 
            } catch (InterruptedException e) {}
        }if(nb==15)System.out.println("Trop de manches!!!");
        EtatDesClasses.getInstance().historique();
    }
}