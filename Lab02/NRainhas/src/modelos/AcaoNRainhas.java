package modelos;

import interfaces.Acao;

public class AcaoNRainhas implements Acao {
	
	private int linha;
	private int coluna;
	private boolean possuiRainha;
	public AcaoNRainhas(int linha, int coluna, boolean possuiRainha) {
		super();
		this.linha = linha;
		this.coluna = coluna;
		this.possuiRainha = possuiRainha;
	}

	public int getColuna() {
		return coluna;
	}
	
	public int getLinha() {
		return linha;
	}
	
	public boolean getPossuiRainha() {
		return possuiRainha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public void setPossuiRainha(boolean possuiRainha) {
		this.possuiRainha = possuiRainha;
	}
	
	
	
}
