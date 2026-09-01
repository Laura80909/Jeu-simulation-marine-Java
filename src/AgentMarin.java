//STOJ Laura 21413129
public abstract class AgentMarin{
    private String nom;
    protected Terrain t;
    protected int lig, col;
    public AgentMarin(int lig, int col, Terrain t){
        this.lig=lig;
        this.col=col;
        this.t=t;
    }
    public abstract double distance(int lig, int col);
    public abstract void seDeplacer(int lig,int col);
}