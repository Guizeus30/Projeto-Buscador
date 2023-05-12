package projeto1;

 public class Executor {
	
	public static void main(String[] args) {
		AVL add = new AVL();
                
                //Inserção
                System.out.println("Inserindo elementos...");
                add.inserirElemento(5);
		add.inserirElemento(3);
		add.inserirElemento(8);
		add.inserirElemento(10);                
		add.inserirElemento(15);
		add.inserirElemento(18); 
                add.inserirElemento(22);
                
                //Profundidade
                System.out.println("\nProfundidade da arvore " + add.altura());
                
                //Media
                System.out.println("\nMedia dos valores: " + (5+22+3+8+10+15+18)/7);          
                
                //Ordenação e Balanceamento
                System.out.println("\nExibindo arvore em pre ordem: " + add.exibirArvorePreOrdem());
                System.out.println("\nExibindo arvore em ordem: " + add.exibirArvoreInOrdem());
		System.out.println("\nExibindo arvore em pos ordem: " + add.exibirArvorePosOrdem());
		System.out.println("\nExibindo balanco da arvore " + add.balanco());
                
                //Busca
		System.out.println("\nBuscando o 22...");
		if(add.buscarElemento(22).info == 22){System.out.println("\nAchou o 22");}
		else {System.out.println("\nNao achou");}
		System.out.println("\nBuscando o 9...");
		if(add.buscarElemento(22).info == 9){System.out.println("\nAchou o 15");}
		else {System.out.println("\nNao achou");}
		
                //Remoção
		System.out.println("\nRemovendo o 22, 18, 5 e 10");
		add.removerElemento(5);
		add.removerElemento(10);
                add.removerElemento(18);
                add.removerElemento(22);
                
		System.out.println("\nExibindo balanco da arvore " + add.balanco());
                System.out.println("\nExibindo arvore em pre ordem: " + add.exibirArvorePreOrdem());
                System.out.println("\nExibindo arvore em ordem: " + add.exibirArvoreInOrdem());
		System.out.println("\nExibindo arvore em pos ordem: " + add.exibirArvorePosOrdem());               
	}
}
