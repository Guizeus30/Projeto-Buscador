package test;

import classes.arvore;

public class ArvoreAVL {

    public static void main(String [] argr) {
        arvore Tree = new arvore(); //nova arvore
		//Teste de insercao e rotacoes da arvore AVL
		Tree.inserirElemento(5);
		Tree.inserirElemento(7);
		System.out.println("inserindo elemento repetido(7)...");
		Tree.inserirElemento(7);
		//teste de impressao do balanco de cada no da arvore
		System.out.println("Exibindo balanco da arvore em pre ordem " + Tree.balanco());
		Tree.inserirElemento(11);
		Tree.inserirElemento(3);
		System.out.println("Exibindo balanco da arvore em pre ordem " + Tree.balanco());
		Tree.inserirElemento(8);
		System.out.println("Exibindo balanco da arvore em pre ordem " + Tree.balanco());
		Tree.inserirElemento(10);
		System.out.println("Exibindo balanco da arvore em pre ordem " + Tree.balanco());
		Tree.inserirElemento(15);
		System.out.println("Exibindo balanco da arvore em pre ordem " + Tree.balanco());
		System.out.println("Exibindo arvore em pre ordem " + Tree.exibirArvorePreOrdem());
		//teste de busca
		System.out.println("Buscando o 15...");
		if(Tree.buscarElemento(15).info == 15){System.out.println("Achou o 15");}
		else {System.out.println("Nao achou");}
		System.out.println("Exibindo arvore em pre ordem " + Tree.exibirArvorePreOrdem());
		Tree.inserirElemento(15);
		Tree.inserirElemento(18);
		System.out.println("Exibindo balanco da arvore em pre ordem " + Tree.balanco());
		//Teste de Remocao
		System.out.println("Removendo o 18");//no sem filhos
		Tree.removerElemento(18);
		System.out.println("Exibindo balanco da arvore em pre ordem " + Tree.balanco());
		System.out.println("Removendo o 5");//no com um filho (desbalanceamento da raiz)
		Tree.removerElemento(5);
		System.out.println("Removendo o 10");
		Tree.removerElemento(10);
		//insercao de novos elementos
		System.out.println("Inserindo novos elementos");
		Tree.inserirElemento(2);
		Tree.inserirElemento(20);
		Tree.inserirElemento(14);
		Tree.inserirElemento(58);
		
		System.out.println("Removendo todos os elementos...");
		Tree.removerTodosElementos();
		
		//Teste da arvore AVL com JOptionPane
		arvore Tree2 = new arvore(); //nova arvore
		Tree2.start();

    }
}
