package projeto1;

//ArvoreBinaria
public class arvore {
    protected No raiz;
    protected No pt;
    protected No aux;
    protected int pos;
    protected int tamanho;
    protected String vazio;
    
    public arvore(){
        this.raiz = null;
        this.pt = null;
        this.aux = null;
	this.tamanho = 0;
        this.vazio = " ";
    }

    public arvore(int n){
        this.raiz = new No(n);
        this.pt = raiz;
        this.tamanho = 0;
        this.vazio = " ";
    }
    
    public No raiz(){
        return this.raiz;
    }
    
    public No pai(No x){
        if (x == raiz) return null;
	else return x.pai;
    }

    public boolean eInterno(No n){
        if (n.dir != null || n.esq != null)
		return true;
        else return false;
    }

    public boolean eExterno(No n){
        if (n.dir == null && n.esq == null)
		return true;
        else return false;
    }

    public boolean eRaiz(No n){
        if (raiz == n) return true;
	else return false;
    }

    public int tamanho(){
        if (raiz == null){return 0;}
	else{
            No p =raiz;
            tamanho++;
            if (p.dir != null){
                tamanho = 1 + somaTamanho(p.dir);
            }
            if (p.esq != null){
                tamanho = 1 + somaTamanho(p.esq);
            }
            pt = p;
        }
        int t = tamanho;
        tamanho = 0;
        return t;
    }

    private int somaTamanho(No p){		
        if (p.dir != null){
            tamanho = 1 + somaTamanho(p.dir);
        }
        if (p.esq != null){
            tamanho = 1 + somaTamanho(p.esq);
        }
        return tamanho;
	}

    public int profundidade(No x){
        int prof = 0;
        No p = x;
        while(p.pai != null){
            prof++;
            p = p.pai;
        }
        return prof;
    }

    public int altura(No x){
        if (raiz == null){return 0;}
        else{
            int alt = 1;
            while (x.pai != null){
                alt++;
                x=x.pai;
            }
            return alt;
        }
    }

    private int VP = 1;
    public int altura(){
        int x = 1;
        if (raiz == null){return 0;}
        else {
            if (raiz.esq != null){max(raiz.esq, x+1);}
            if (raiz.dir != null){max(raiz.dir, x+1);}
        }
        return VP;
    }

    private int max(No p,int valor){
        int x = valor;
        if (VP < x )VP = x;
        if (p.esq != null){max(p.esq, x+1);}
        if (p.dir != null){max(p.dir, x+1);}	
        return 0;
    }
     
    public String exibirArvorePreOrdem(){
        if (raiz == null)return ""; 
        No p = this.raiz;
        vazio = vazio + Integer.toString(p.info)+ " ";
        if (p.esq != null){vazio = vazio + "<" + exibirArvorePreOrdem(p.esq)+">";}
        if (p.dir != null){vazio = vazio + "<" + exibirArvorePreOrdem(p.dir)+ ">";}
        String pr =vazio;
        vazio = " ";
        return pr;
    }
    
    private String exibirArvorePreOrdem(No p){
        vazio = Integer.toString(p.info)+ " ";
        if (p.esq != null){vazio = vazio + "<" + exibirArvorePreOrdem(p.esq) + ">";}
	if (p.dir != null){vazio = vazio + "<" + exibirArvorePreOrdem(p.dir)+ ">";}
        String pr = vazio;
	vazio = " ";
        return pr;
    }

    public String exibirArvoreInOrdem(){
        if (raiz == null)return ""; 
	No p = this.raiz;
        if (p.esq != null){vazio = vazio + "<" + exibirArvoreInOrdem(p.esq)+"<";}
	vazio = vazio + Integer.toString(p.info)+ " ";
        if (p.dir != null){vazio = vazio + "<"+ exibirArvoreInOrdem(p.dir)+ ">";}
	String pr = vazio;
        vazio = " ";
	return pr;
    }

    private String exibirArvoreInOrdem(No p){
        if (p.esq != null){vazio = vazio + "<" + exibirArvoreInOrdem(p.esq)+">";}
	vazio = Integer.toString(p.info)+ " ";
        if (p.dir != null){vazio = vazio +"<" + exibirArvoreInOrdem(p.dir)+ ">";}
	String pr = vazio;
        vazio = " ";
	return pr;
    }

    public String exibirArvorePosOrdem(){
        if (raiz == null)return ""; 
	No p = this.raiz;
        if (p.esq != null){vazio = vazio + "<" + exibirArvorePosOrdem(p.esq)+">";}
	if (p.dir != null){vazio ="<" + exibirArvorePosOrdem(p.dir)+ ">";}
        vazio = vazio + Integer.toString(p.info)+ " ";
	String pr = vazio;
        vazio = " ";
	return pr;
    }

    private String exibirArvorePosOrdem(No p){
        if (p.esq != null){vazio ="<" + exibirArvorePosOrdem(p.esq)+">";}
	if (p.dir != null){vazio ="<"+ exibirArvorePosOrdem(p.dir)+ ">";}
        vazio = vazio + Integer.toString(p.info)+ " ";
	String pr = vazio;
        vazio = " ";
	return pr;
    }

    public No buscarElemento(int x){
        if (raiz == null){
		pos = 0;
                return raiz;
        }		
        if(pt == null)return null;		
        else if (pt.info == x)return pt;	
        else if (x < pt.info){
            aux = pt;
            pt = pt.esq;
            aux.esq = pt;
            pos = 1;
            return buscarElemento(x);
        }
        else{
            aux = pt;
            pt= pt.dir;
            aux.dir = pt;
            pos = 2;
            return buscarElemento(x);
        }
    }

    public boolean inserirElemento(int x){
        No p = null;
        this.pt = this.raiz;
        p = buscarElemento(x);
        if (p != null){return false;}
        else{
            p = new No(x);
            if (pos == 0){
                this.raiz = p;
            }
            else if (pos == 1) {
                p.pai = aux;
                aux.esq  = p;
            }
            else if (pos == 2) {
                p.pai = aux;
                aux.dir  = p; 	
            }
        }
        pos = 4;
        pt = raiz; 
        System.out.println(exibirArvorePreOrdem());
        return true;
    }
        
    public boolean removerElemento(int x){
        No p = null;
        pt = raiz;
        p = buscarElemento(x);
        int local=0;
        if (p == null){return false;}
        else{
            if (p.esq == null && p.dir == null){
                if (p == raiz) {raiz = null;}
                else{
                    if (pos == 1)
                        p.pai.esq =null;
                    else if(pos == 2)
                        p.pai.dir =null;	
                }
                p = null;
                System.out.println(exibirArvorePreOrdem());
                return true;
            }
            else{
                aux = p;
                if (p.esq == null){
                    p = p.dir;
                    local = 1;
                }
                else{
                    if (p.dir == null){
                        p = p.esq;
                        local = 2; 
                    }
                    else{
                        p = minDir(aux.dir);
                        p.esq = aux.esq;
                        if (aux == raiz){raiz = p;}
                        else { 
                            p.pai = aux.pai;
                            if (pos == 1)
                                aux.pai.esq =p;
                            else if(pos == 2)
                                aux.pai.dir =p;
                        }
                        aux = null;
                        System.out.println(exibirArvorePreOrdem());
                        return true;
                    }	
                }
            }
            if (aux == raiz){raiz = p;}
            else{
                if (local == 1)aux.pai.dir = p;
                else if (local == 2) aux.pai.esq = p;
                p.pai = aux.pai;
            }
            aux = null;
            System.out.println(exibirArvorePreOrdem());
            return true;
        }
    }
    
	protected No minDir(No p){
            if (p.esq ==null) return p;
            else{ 
                p = p.esq;
                return minDir(p);
            }
        }
}