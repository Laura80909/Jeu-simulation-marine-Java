//STOJ Laura 21413129
public abstract class AnimalMarin extends AgentMarin{
    private String nom;
    protected int energiealgue;
    protected int energiepoisson;
    public AnimalMarin(int energiealgue,  int energiepoisson, Terrain terrain, int lig, int col){
        super(lig, col, terrain);
        this.energiealgue=energiealgue;
        this.energiepoisson=energiepoisson;
    }
    public abstract void seDeplacer(int lig, int col);
    public abstract String getNom();
    public abstract double distance(int lig, int col);
    public abstract boolean agir(Pirate p, int i, int j) throws ActionMerException;
    public abstract void manger(int i, int j) throws ActionMerException;
}