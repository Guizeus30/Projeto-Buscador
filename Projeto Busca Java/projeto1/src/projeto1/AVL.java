package projeto1;

//Arvore AVL
public class AVL extends arvore{
    
    private boolean t;
    private int local;	
    
    public AVL() {
        super();	
    }
    
    public No buscarElemento(int x){
        return super.buscarElemento(x);
    }
    
    private void caso1(No p,boolean h){
        No ptu = new No();
        boolean testeraiz = false;	
        if (p == raiz) testeraiz = true;
        ptu = p.esq;
        if (ptu.balanco == -1){
            p.esq = ptu.dir;
            if (ptu.dir != null){
                ptu.dir.pai = p;
            }
            if (p !=raiz){ p.pai.esq = ptu; }	  
            ptu.pai = p.pai;
            ptu.dir = p;
            p.pai = ptu;
            p.balanco = 0;
            p = ptu;
            if (testeraiz) raiz = ptu; 
        }
        else{
            No ptv = new No();
            ptv = ptu.dir;
            ptu.dir = ptv.esq;
            if (ptv.esq != null){
                ptv.esq.pai= ptu;
            }
            ptv.esq = ptu;
            ptu.pai = ptv;
            p.esq = ptv.dir;
            if (ptv.dir !=null){
                ptv.dir.pai = p;
            }
            ptv.dir = p;
            if (p.pai !=null){p.pai.dir = ptv;}
            ptv.pai = p.pai;
            p.pai =ptv;
            if (ptv.balanco == -1)p.balanco = 1;
            else p.balanco = 0;
            if (ptv.balanco == 1) ptu.balanco = -1;
            else ptu.balanco = 0;
            if (testeraiz)raiz = ptv;
            p = ptv;
        }
        p.balanco = 0;
        t = false;	
    }
    
    private void caso2(No p,boolean h){
        No ptu = new No();
        boolean testeraiz = false;	
        if (p == raiz) testeraiz = true;
        ptu = p.dir;
        if (ptu.balanco == 1){
            p.dir = ptu.esq;
            if (ptu.esq != null){
                ptu.esq.pai = p;
            }
            if (p !=raiz) {p.pai.dir = ptu;}
            ptu.pai = p.pai;
            ptu.esq = p;
            p.pai = ptu;
            p.balanco = 0;
            p = ptu;
            if (testeraiz) raiz = ptu; 
        }
        else{
            No ptv = new No();
            ptv = ptu.esq;
            ptu.esq = ptv.dir;
            if (ptv.dir !=null){
                ptv.dir.pai= ptu;
            }
            ptv.dir = ptu;
            ptu.pai = ptv;
            p.dir = ptv.esq;
            if (ptv.esq !=null){
                ptv.esq.pai = p;
            }
            ptv.esq = p;
            if (p.pai !=null){p.pai.esq = ptv;}
            p.pai =ptv;
            if (ptv.balanco == 1)p.balanco = -1;
            else p.balanco = 0;
            if (ptv.balanco == -1) ptu.balanco = 1;
            else ptu.balanco = 0;
            if (testeraiz)raiz = ptv;
            p = ptv;
        }
        p.balanco = 0;
        t = false;
    }

    public boolean inserirElemento(int x){
        pt = new No(x);
        if (raiz == null){			
            raiz = pt;}
        else{
            pt = raiz;
            insAVL(x,pt,false);
        }
        System.out.println(exibirArvorePreOrdem());
        return true;
    }
    
    private boolean insAVL(int x,No pt,boolean h){
        t = h; 
        if (pt == null){
            pt = new No(x);
            if(pos==1){aux.esq= pt;} 
            else if (pos == 2){aux.dir = pt;}
            pt.pai = aux;
            t=true;
            pos=0;
        }
        else{
            if (x == pt.info){
                pt = null;
                return false;
            }
            if (x < pt.info){
                aux = pt;
                pos = 1;
                insAVL(x,pt.esq,t);
                if (t){
                    if (pt.balanco == 1){
                        pt.balanco = 0;
                        t = false;
                    }
                    else if (pt.balanco == 0) pt.balanco = -1;
                    else if (pt.balanco == -1) caso1(pt,t);
                }
            }
            else{
                aux = pt; 
                pos = 2;
                insAVL(x,pt.dir,t);
                if (t){
                    if (pt.balanco == -1){
                        pt.balanco = 0;
                        t = false;
                    }
                    else if (pt.balanco == 0) pt.balanco = 1;
                    else if (pt.balanco == 1) caso2(pt,t);
                }
            }
        }
        return true;
    }
        
    public boolean removerElemento(int x){
        if (raiz == null){return false;}
        else{
            pt = raiz;
            remAVL(x,pt,false);
        }
        System.out.println(exibirArvorePreOrdem());
        return true;
    }
    
    public boolean remAVL(int x,No pt,boolean h){
        t=h;
        if (pt == null){return false;}
        else{
            if (x == pt.info ){
                if (pt.esq == null && pt.dir == null){
                    if (pt == raiz) {raiz = null;}
                    else{
                        if (pos == 1)
                            pt.pai.esq = null;
                        else if(pos == 2)
                            pt.pai.dir = null;
                    }
                    pt =null;
                    t = true;
                }
                else {
                    aux = pt;
                    if (pt.esq == null){
                        pt = pt.dir;
                        local = 1;
                    }
                    else{
                        if (pt.dir == null){
                            pt = pt.esq;
                            local = 2;
                        }
                        else{
                            pt = minDir(aux.dir);
                            pt.esq = aux.esq;
                            if (aux == raiz){raiz = pt;}
                            else { 
                                pt.pai = aux.pai;
                                if (pos == 1)
                                    aux.pai.esq =pt;
                                else if(pos == 2)
                                    aux.pai.dir =pt;
                            }
                            aux = null;
                            return true;
                        }	
                    }
                }
                if (aux == raiz){raiz = pt;}
                else{
                    if (local == 1){aux.pai.dir = pt;}
                    else if (local == 2) {aux.pai.esq = pt; }
                }
                aux = null;
            }
            else{
                if (x < pt.info){
                    aux = pt;
                    pos=1;
                    remAVL(x,pt.esq,t);
                    if (t){
                        if(pt.balanco == -1)
                            pt.balanco = 0;
                        t = false;
                    }
                    else if (pt.balanco == 0) pt.balanco = 1;
                    else if (pt.balanco == 1)caso2(pt,t);
                }
                else{
                    aux = pt;
                    pos=2;
                    remAVL(x,pt.dir,t);
                    if (t){
                        if (pt.balanco == 1){
                            pt.balanco = 0;
                            t = false;
                        }
                        else if (pt.balanco == 0) pt.balanco = -1;
                        else if (pt.balanco == -1) caso1(pt,t);
                    }
                }
            }
        }
        local=0;
        return true;
    }

    public String exibirArvorePreOrdem(){
        return super.exibirArvorePreOrdem();
    }
        
    public String balanco(){
        if (raiz == null)return ""; 
        No p = this.raiz;
        vazio = vazio + Integer.toString(p.balanco)+ " ";
        if (p.esq != null){vazio = vazio + "<" + balanco(p.esq)+">";}
        if (p.dir != null){vazio = vazio + "<" + balanco(p.dir)+ ">";}
        String pr = vazio;
        vazio = " ";
        return pr;
    }
    
    private String balanco(No p){
        vazio = Integer.toString(p.balanco)+ " ";
        if (p.esq != null){vazio = vazio + "<" + balanco(p.esq) + ">";}
        if (p.dir != null){vazio = vazio + "<" + balanco(p.dir)+ ">";}
        String pr = vazio;
        vazio = " ";
        return pr;
    }
}