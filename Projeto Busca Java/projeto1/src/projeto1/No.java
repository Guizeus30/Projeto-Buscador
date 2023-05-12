package projeto1;

public class No {
    public int info;
    public No dir;
    public No esq;
    public No pai;
    public int balanco;
        
    public No(int x){
        this.info = x;
        this.dir = null;
        this.esq = null;
        this.pai = null;
        this.balanco = 0;
        }
        
    public No(){}

	public No(int x,No esq,No dir){
		this.info = x;
		this.dir = dir;
		this.esq = esq;
		this.pai = null;
		this.dir.pai = this;
		this.esq.pai =this;

	}

	public No elemento(){
		return this;	
	}
        
}
