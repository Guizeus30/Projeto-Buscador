package projeto1;

import javax.swing.JOptionPane;

public class arvore {
	
//************ATRIBUTOS***************/
	protected No raiz; // no raiz da arvore
	protected No pt; // no de percurso
	protected No aux;// no auxiliar de percurso (guarda o ultimo no acessado)
	protected int pos; // posicao do no, 1 = esquerda, 2 = direita
	protected int tamanho;//guarda a quantidade de nos na arvore(quando o metodo tamanho() e chamado)
	protected String print; //atributo para impressao da arvore
	
//**************METODOS***************/	
	//construtor padrao
	public arvore(){
		this.raiz = null;
		this.pt = null;
		this.aux = null;
		this.tamanho = 0;
		this.print = " ";

	}

	//construtor com entrada de chave
	public arvore(int n){
		this.raiz = new No(n);
		this.pt = raiz;
		this.tamanho = 0;
		this.print = " ";
	}

/*========================================================================================*/
	//Metodo que retorna a raiz da arvore
	public No raiz(){
		return this.raiz;
	}
/*========================================================================================*/
	//Metodo que retorna o pai do no x da arvore
	public No pai(No x){
		if (x == raiz) return null;
		else return x.pai;
	}
/*========================================================================================*/
	//Metodo que retorna o numero de filhos do no p
	public int numFilhos(No p){
		int f=0;
		if( p.esq != null) f++;
		if( p.dir != null) f++;
		return f;
	}
/*========================================================================================*/
	//Metodo que verifica se o no n e' no interno
	public boolean eInterno(No n){
		if (n.dir != null || n.esq != null)
			return true;
		else return false;
	}
/*========================================================================================*/
	//Metodo que verifica se o no n e' no externo
	public boolean eExterno(No n){
		if (n.dir == null && n.esq == null)
			return true;
		else return false;
	}
/*========================================================================================*/
	//Metodo que verifica se o no n e' raiz
	public boolean eRaiz(No n){
		if (raiz == n) return true;
		else return false;
	}
/*========================================================================================*/
	//Metodo que retorna o numero de nos na arvore
	public int tamanho(){
		if (raiz == null){return 0;}
		else{
			No p =raiz;
			tamanho++; //Se chegou aqui, existe raiz. Entao, tamanho++
			if (p.dir != null){
				tamanho = 1 + somaTamanho(p.dir);
			}
			if (p.esq != null){
				tamanho = 1 + somaTamanho(p.esq);
			}
			pt = p;
		}
		
		int t = tamanho;
		tamanho = 0;//tamanho volta a ser 0 (para nova pesquisa)
		return t;
	}
/*========================================================================================*/
	//Metodo que soma o numero de nos da arvore. Este metodo e' chamado pelo metodo tamanho()
	private int somaTamanho(No p){
		
			if (p.dir != null){
				tamanho = 1 + somaTamanho(p.dir);
			}
			if (p.esq != null){
				tamanho = 1 + somaTamanho(p.esq);
			}
			return tamanho;
	}
/*========================================================================================*/
	//Metodo que testa se a arvore e' vazia
	public boolean eVazia(){
		if( raiz == null) return true;
		else return false;
	}
/*========================================================================================*/
	//Metodo que retorna o numero de ancestrais de x, excluindo o proprio x
	public int profundidade(No x){
		int prof = 0;
		No p = x;
		while(p.pai != null){
			prof++;
			p = p.pai;
		}
		return prof;
	}
/*========================================================================================*/
	//Metodo que retorna a altura do no x
	public int altura(No x){
		if (raiz == null){return 0;}
		else{
			int alt = 1; //o no tem altura 1
			while (x.pai != null){
				alt++;
				x=x.pai;
			}
			return alt;
		}
	}
/*========================================================================================*/
	//Metodo que retorna a altura da arvore
	private int maisprofundo = 1; //atributo para calculo do no mais profundo
	public int altura(){
		int x = 1;
		if (raiz == null){return 0;}
		else {
			if (raiz.esq != null){max(raiz.esq, x+1);}
			if (raiz.dir != null){max(raiz.dir, x+1);}
		}
		return maisprofundo;
	}
/*========================================================================================*/
	//Metodo que retorna o tamanho do no de maior altura da arvore 
	private int max(No p,int valor){
			int x = valor;
			if (maisprofundo < x )maisprofundo = x;
			if (p.esq != null){max(p.esq, x+1);}
			if (p.dir != null){max(p.dir, x+1);}	
		return 0;
	}
	
/*========================================================================================*/
	/*Metodo que exibe a arvore em pre ordem
	na representacao de parenteses aninhados*/
	public String exibirArvorePreOrdem(){
		if (raiz == null)return ""; 
		No p = this.raiz; // recebe o no raiz
		print = print + Integer.toString(p.info)+ " ";
		if (p.esq != null){print = print + "(" + exibirArvorePreOrdem(p.esq)+")";}
		if (p.dir != null){print = print + "(" + exibirArvorePreOrdem(p.dir)+ ")";}
		String pr =print;
		print = " ";
		return pr;
	}
/*========================================================================================*/
	/*Metodo que exibe a arvore em pre ordem (metodo privado para auxiliar 
	 para recursao) na representacao de parenteses aninhados*/
	private String exibirArvorePreOrdem(No p){
		print = Integer.toString(p.info)+ " ";
		if (p.esq != null){print = print + "( " + exibirArvorePreOrdem(p.esq) + ")";}
		if (p.dir != null){print = print + "(" + exibirArvorePreOrdem(p.dir)+ ")";}
		String pr = print;
		print = " ";
		return pr;
	}
/*========================================================================================*/
	/*Metodo que exibe a arvore em ordem
	na representacao de parenteses aninhados*/
	public String exibirArvoreInOrdem(){
		if (raiz == null)return ""; 
		No p = this.raiz; // recebe o no raiz

		if (p.esq != null){print = print + "(" + exibirArvoreInOrdem(p.esq)+")";}
		print = print + Integer.toString(p.info)+ " ";
		if (p.dir != null){print = print + "("+ exibirArvoreInOrdem(p.dir)+ ")";}
		String pr =print;
		print = " ";
		return pr;
	}
/*========================================================================================*/
	/*Metodo que exibe a arvore em ordem (metodo privado para auxiliar 
	 * para recursao) na representacao de parenteses aninhados*/
	private String exibirArvoreInOrdem(No p){

		if (p.esq != null){print = print + "(" + exibirArvoreInOrdem(p.esq)+")";}
		print = Integer.toString(p.info)+ " ";
		if (p.dir != null){print = print +"(" + exibirArvoreInOrdem(p.dir)+ ")";}
		String pr =print;
		print = " ";
		return pr;
	}
/*========================================================================================*/
	/*Metodo que exibe a arvore em pos ordem
	na representacao de parenteses aninhados*/
	public String exibirArvorePosOrdem(){
		if (raiz == null)return ""; 
		No p = this.raiz; // recebe o no raiz
		
		if (p.esq != null){print = print + "(" + exibirArvorePosOrdem(p.esq)+")";}
		if (p.dir != null){print ="(" + exibirArvorePosOrdem(p.dir)+ ")";}
		print = print + Integer.toString(p.info)+ " ";
		String pr =print;
		print = " ";
		return pr;
	}
/*========================================================================================*/
	/*Metodo que exibe a arvore em pos ordem (metodo privado para auxiliar 
	 * para recursao) na representacao de parenteses aninhados*/
	private String exibirArvorePosOrdem(No p){
		
		if (p.esq != null){print ="(" + exibirArvorePosOrdem(p.esq)+")";}
		if (p.dir != null){print ="("+ exibirArvorePosOrdem(p.dir)+ ")";}
		print = print + Integer.toString(p.info)+ " ";
		String pr =print;
		print = " ";
		return pr;
	}
/*========================================================================================*/
	//Metodo que retorna o filho esquerdo do no x. Se x for externo, retorna null 
	public No filhoEsquerdo(No p){
		if (eExterno(p)){ return null;}
		else return p.esq;
	}
/*========================================================================================*/	
	//Metodo que retorna o filho direito do no x. Se x for externo, retorna null 
	public No filhoDireito(No p){
		if (eExterno(p)){ return null;}
		else return p.dir;
	}
/*========================================================================================*/	
	//Metodo que retorna o o irmao do no x. Se x for filho unico, retorna null 
	public No irmao(No p){
		
		if (p == raiz){return null;} //p e' a raiz e nao tem pai nem irmaos
		else if (numFilhos(p.pai) == 1){return null;} //filho unico
		else {	//tem irmao
			if (p.pai.dir == p){//se p esta a direita, entao irmao esta a esquerda
				return p.pai.esq; //senao retorna irmao(que esta a esquerda)
			}
			else{ return p.pai.dir;} //senao retorna irmao(que esta a direita)
		}
		
	}
/*========================================================================================*/
	//Metodo de busca de um elemento com chave x na arvore
	public No buscarElemento(int x){
		//testa se a arvore e' vazia
		if (raiz == null){
			pos = 0;
			return raiz;
		}		
		//testa se o no e vazio
		if(pt == null)return null;		
		//achou o no
		else if (pt.info == x)return pt;	
		//no a esquerda
		else if (x < pt.info){
			aux = pt;
			pt = pt.esq;
			aux.esq = pt;
			pos = 1; //posicao indicao a insersao na esquerda
			return buscarElemento(x);
		}
		//no a direita
		else{
			aux = pt;
			pt= pt.dir;
			aux.dir = pt;
			pos = 2;//posicao indicao a insercao na direita
			return buscarElemento(x);
		}
	}
/*========================================================================================*/
	//Metodo de insercao de um elemento com chave x na arvore
	public boolean inserirElemento(int x){
		No p = null;
		this.pt = this.raiz;
		p = buscarElemento(x);
		
		if (p != null){return false;}//a chave ja existe na arvore

		else{
			p = new No(x);
			if (pos == 0){//inserir na raiz
				this.raiz = p;
			}
			//insercao do elemento sem ser raiz

			else if (pos == 1) {//filho a esquerda do pai
				p.pai = aux;
				aux.esq  = p;
			}
			else if (pos == 2) {//filho a direita do pai
				p.pai = aux;
				aux.dir  = p; 	
			}
		}
		pos = 4;//passa a nao indicar nada
		pt = raiz; //ponteiro de pesquisa volta a ser a raiz
		System.out.println(exibirArvorePreOrdem());
		return true;
	}
/*========================================================================================*/	
	//Metodo de remocao de um elemento com chave x na arvore
	public boolean removerElemento(int x){
		No p = null;
		pt = raiz;
		p = buscarElemento(x);
		int local=0; //localiza se o pai do no removido vai ter um novo
					//filho a direita ou a esquerda

		if (p == null){return false;}//nao achou, retorna sem fazer nada
		else{//achou
			if (p.esq == null && p.dir == null){//nao tem filhos
				if (p == raiz) {raiz = null;}//o no e a raiz
				else{
					if (pos == 1)//este no e' o filho da esquerda do seu pai
						p.pai.esq =null;
					else if(pos == 2)//este no e' o filho da direita do seu pai
						p.pai.dir =null;
				}
				p = null;
				System.out.println(exibirArvorePreOrdem()); //exibe a arvore
				return true;
			}
			else{//tem filhos
				aux = p;
				if (p.esq == null){ //pode ter apenas o filho da direita
					p = p.dir;
					local = 1; //pai de p tera novo filho a direita
				}
				else{
					if (p.dir == null){//tem apenas o filho da esquerda
						p = p.esq;
						local = 2; //pai de p tera novo filho a esquerda
					}
					else{//tem dois filhos

						p = minDir(aux.dir);	//achar o menor a direita
						p.esq = aux.esq;	//reordenacao de ponteiros
						if (aux == raiz){raiz = p;}//se o no a ser removido era a raiz, p e' a nova raiz
						else { 
							p.pai = aux.pai;
							if (pos == 1)//este no e' o filho da esquerda do seu pai
								aux.pai.esq =p;
							else if(pos == 2)//este no e' o filho da direita do seu pai
								aux.pai.dir =p;
						}
						aux = null;
						System.out.println(exibirArvorePreOrdem()); //exibe a arvore
						return true;
					}	
				}
			}
			if (aux == raiz){raiz = p;}//se o no a ser removido era a raiz, p e' a nova raiz
			else{//nao e a raiz(tem pai)
				if (local == 1)aux.pai.dir = p; //pai tem filho a direita
				else if (local == 2) aux.pai.esq = p; //pai tem filho a esquerda
				p.pai = aux.pai;
			}
			aux = null;
			System.out.println(exibirArvorePreOrdem()); //exibe a arvore
			return true;
		}
	}
/*========================================================================================*/
	/*Metodo auxiliar para o metodo da remocao. Acha o no de menor chave 
		ao lado direito do no dado */
	protected No minDir(No p){
		if (p.esq ==null) return p;
		else{ 
			p = p.esq;
			return minDir(p);
		}
	}
/*========================================================================================*/	
	//Metodo para remover todos os elementos da arvore
	public boolean removerTodosElementos(){
		//remove os elementos da raiz ate a arvore ficar vazia.
		while (this.raiz!=null){
			removerElemento(raiz.info);
		}
		return true;
	}
	/*========================================================================================*/
	//Metodo de execucao da Arvore Binaria
	public void start(){
		String parametro;
		String tipodeOperacao =" ";
		JOptionPane.showMessageDialog(null,"Arvore Binaria \n Aceita entrada de valores inteiros"," Arvore Binaria",JOptionPane.PLAIN_MESSAGE);
		System.out.println("**Historico de operações**");
		while (tipodeOperacao != null){//inicio do loop
			tipodeOperacao = JOptionPane.showInputDialog("Entre com o tipo de operacao" +
					" que deseja fazer:\n [1] Busca \n [2] Insercao \n [3] " +
			"Remocao\n [4] Impressao");
			if(tipodeOperacao == null || tipodeOperacao.length() == 0){return;}//entrada vazia(cancelamento do panel)

			boolean testeOperador=false;
			for(int j =0; j < tipodeOperacao.length(); j++){//testa se entrada nao é inteiro
				if (!Character.isDigit(tipodeOperacao.charAt(j))){ 
					testeOperador =true;
				}	
			}
			if (testeOperador){JOptionPane.showMessageDialog(null,"Entrada incorreta (entre com um " +
					"numero de 1 a 4)"," Arvore Binaria ",JOptionPane.PLAIN_MESSAGE);
			}
			else{
				//IMPRESSAO
				if(tipodeOperacao.length() == 1 && tipodeOperacao.charAt(0) == '4'){//impressao
					JOptionPane.showMessageDialog(null,"A arvore atual e': " + exibirArvorePreOrdem()
							,"Impressao",JOptionPane.PLAIN_MESSAGE); //impressao
					System.out.println("Impressao da arvore: " + this.exibirArvorePreOrdem());
				}//passa
				else{
					parametro = JOptionPane.showInputDialog("Entre com o parametro da operacao (Int)");
					if (parametro == null ||parametro.length() == 0){return;}//teste de cancelamento ou entrada vazia

					boolean testeParametro=false;
					for(int j =0; j < parametro.length(); j++){
						if (!Character.isDigit(parametro.charAt(j))){ //testa se entrada nao é inteiro
							testeParametro = true;
						}	
					}
					if(testeParametro){
						JOptionPane.showMessageDialog(null,"Entrada incorreta (somente inteiros)"," Arvore B ",JOptionPane.ERROR_MESSAGE);
					}
					else{
						int x = Integer.parseInt(parametro);
						//BUSCA
						if (tipodeOperacao.length() == 1 && tipodeOperacao.charAt(0) == '1'){
							if(this.buscarElemento(x) == null){//busca
								JOptionPane.showMessageDialog(null,"Nao achou elemento: " + parametro
										,"Impressao",JOptionPane.INFORMATION_MESSAGE);
								System.out.println("Busca: Nao achou o elemento" + parametro);
							}
							else{
								JOptionPane.showMessageDialog(null,"Achou elemento: " + parametro
										,"Impressao",JOptionPane.INFORMATION_MESSAGE);
								System.out.println("Busca: Achou o elemento" + parametro);
							}
						}
						//INSERCAO
						else if(tipodeOperacao.length() == 1 && tipodeOperacao.charAt(0) == '2'){//insercao
							this.inserirElemento(x);
							JOptionPane.showMessageDialog(null,"A arvore atual e': " + exibirArvorePreOrdem()
									,"Impressao",JOptionPane.PLAIN_MESSAGE);
							System.out.println("Tentativa de insercao de: " + parametro);
						}
						//REMOCAO
						else if(tipodeOperacao.length() == 1 && tipodeOperacao.charAt(0) == '3'){//remocao
							this.removerElemento(x);
							JOptionPane.showMessageDialog(null,"A arvore atual e': " + exibirArvorePreOrdem()
									,"Impressao",JOptionPane.PLAIN_MESSAGE);
							System.out.println("Tentativa de remocao de: " + parametro);
						}
						else if(tipodeOperacao == null){//cancelou 
							System.out.println("Fim da operacao");
							return; //teste de cancelamento
						}
						else{//Se diferente de todas as outras opcoes, entrada incorreta
							JOptionPane.showMessageDialog(null,"Entrada incorreta"," Arvore Binaria ",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
			System.out.println(exibirArvorePreOrdem());
		}
		System.out.println("Finalizando operacao do programa de execucao da Arvore Binaria");
	}
}