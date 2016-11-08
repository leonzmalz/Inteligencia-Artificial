package modelos;

import interfaces.Estado;
import interfaces.TesteDeObjetivo;

public class TesteDeObjetivoNRainhas implements TesteDeObjetivo {

	//O estado final é um tabuleiro de tamanho n com n rainhas posicionadas
	@Override
	public boolean ehObjetivo(Estado e) {
		return (((Tabuleiro) e).getQtdRainhas() == ((Tabuleiro) e).getCasas().length)
				&& (e.estadoValido());
	}
	

}
