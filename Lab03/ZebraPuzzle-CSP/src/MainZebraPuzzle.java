import java.util.Scanner;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.BacktrackingStrategy;

public class MainZebraPuzzle {

	public static void main(String[] args) {
		
		System.out.println("Zebra Puzzle");
		
		System.out.println("Existem 5 casas de diferentes cores,"
				+ " habitadas por pessoas de diferentes nacionalidades"
				+ " que praticam esportes diferentes"
				+ "bebem bebidas diferentes e "
				+ "possuem animais diferentes");
		
		System.out.println("De acordo com as seguintes afirmações: ");
		System.out.println("O inglês mora na casa amarela");
		System.out.println("O espanhol possui um cachorro");
		System.out.println("O homem na casa verde bebe café");
		System.out.println("O irlandês bebe chá");
		System.out.println("A casa verde fica à direita da casa marfim");
		System.out.println("O jogador de xadrez possui um caracol");
		System.out.println("O morador da casa amarela joga cricket");
		System.out.println("O morador da casa do meio bebe leite");
		System.out.println("O nigeriano mora na primeira casa");
		System.out.println("O lutador de judo mora próximo do dono da raposa");
		System.out.println("O jogador de cricket mora próximo do dono do cavalo");
		System.out.println("O jogador de poker toma suco");
		System.out.println("O japonês joga polo");
		System.out.println("O nigeriano mora próximo da casa azul");
		
		System.out.println("PERGUNTA: QUEM É O DONO DA ZEBRA?\n");
		
		String resposta = new Scanner(System.in).nextLine();
		
		ZebraPuzzle zebraPuzzle = new ZebraPuzzle();
		zebraPuzzle.loadDomains();
		zebraPuzzle.loadConstraints();
		BacktrackingStrategy baStrategy = new BacktrackingStrategy();
		
		Assignment solve = baStrategy.solve(zebraPuzzle);
		
		if (solve != null){
			Object zebra = solve.getAssignment(ZebraPuzzle.ZEBRA);
			
			for(int i = 0; i < zebraPuzzle.nacionalidades.length; i ++){
				if (zebra.equals(solve.getAssignment(zebraPuzzle.nacionalidades[i]))){
					if (resposta.toUpperCase().equals(zebraPuzzle.nacionalidades[i].toString()))
						System.out.println("Você acertou!");
					else
						System.out.println("Você errou!");	
					System.out.println("O dono da zebra é o " + zebraPuzzle.nacionalidades[i]);
				}	
			}
		}else
			System.out.println("Não existe solução");
		
	}

}
