package classes;

public class No extends classes.NoEXT {
public int info;//atributo que guarda a informação do no
	public No dir;//atributo que aponta para o no esquerdo
	public No esq;//atributo que aponta para o no direito
	public No pai;//atributo que aponta para o pai do no
	public int balanco; //atributo utilizado apenas na arvore avl. 
						// balanco = altura(arvore a esq) - altura(arvore a dir)
	
	//**************METODOS***************/
	//construtor com entrada da chave
	public No(int x){
		this.info = x;
		this.dir = null;
		this.esq = null;
		this.pai = null;
		this.balanco = 0;
	}
	//construtor padrao
	public No(){}

	//construtor com entrada da chave e Node dir e esq
	public No(int x,No esq,No dir){
		this.info = x;
		this.dir = dir;
		this.esq = esq;
		this.pai = null;
		this.dir.pai = this;
		this.esq.pai =this;

	}
/*========================================================================================*/
	//Metodo que retorna o elemento
	public No elemento(){
		return this;	
	}
	
}
