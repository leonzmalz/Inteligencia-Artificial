import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import aima.core.search.csp.examples.NotEqualConstraint;

public class ZebraPuzzle extends CSP {
	//CASA
	public static final int CASA1 = 1;
	public static final int CASA2 = 2;
	public static final int CASA3 = 3;
	public static final int CASA4 = 4;
	public static final int CASA5 = 5;

	//CORES
	public static final Variable AMARELO = new Variable("AMARELO");
	public static final Variable AZUL = new Variable("AZUL");
	public static final Variable VERMELHO = new Variable("VERMELHO");
	public static final Variable MARFIM= new Variable("MARFIM");
	public static final Variable VERDE = new Variable("VERDE");
	public Variable[] cores = new Variable[] {AMARELO,AZUL,VERMELHO, MARFIM,VERDE};

	//NACIONALIDADES
	public static final Variable INGLES = new Variable("INGLES");
	public static final Variable ESPANHOL = new Variable("ESPANHOL");
	public static final Variable IRLANDES = new Variable("IRLANDES");
	public static final Variable NIGERIANO = new Variable("NIGERIANO");
	public static final Variable JAPONES = new Variable("JAPONES");
	public Variable[] nacionalidades = new Variable[] {INGLES,ESPANHOL,IRLANDES, NIGERIANO,JAPONES};

	//ESPORTES
	public static final Variable XADREZ = new Variable("XADREZ");
	public static final Variable CRICKET = new Variable("CRICKET");
	public static final Variable JUDO = new Variable("JUDO");
	public static final Variable POKER = new Variable("POKER");
	public static final Variable POLO = new Variable("POLO");
	public Variable[] esportes = new Variable[] {XADREZ,CRICKET,JUDO, POKER,POLO};

	//BEBIDAS
	public static final Variable CAFE = new Variable("CAFE");
	public static final Variable CHA = new Variable("CHA");
	public static final Variable LEITE = new Variable("LEITE");
	public static final Variable SUCO = new Variable("SUCO");
	public static final Variable CERVEJA = new Variable("CERVEJA");
	public Variable[] bebidas = new Variable[] {CAFE,CHA,LEITE, SUCO,CERVEJA};

	//ANIMAIS
	public static final Variable CACHORRO = new Variable("CACHORRO");
	public static final Variable CARACOL = new Variable("CARACOL");
	public static final Variable RAPOSA = new Variable("RAPOSA");
	public static final Variable CAVALO = new Variable("CAVALO");
	public static final Variable ZEBRA = new Variable("ZEBRA");	
	public Variable[] animais = new Variable[] {CACHORRO,CARACOL,RAPOSA, CAVALO, ZEBRA};
	
	public ZebraPuzzle() {
		addDefaultVariables(cores);
		addDefaultVariables(nacionalidades);
		addDefaultVariables(esportes);
		addDefaultVariables(bebidas);
		addDefaultVariables(animais);
	}
	
	
	public void loadDomains(){
		for (Variable variable : getVariables()){
			if (variable == NIGERIANO)
				setDomain(variable, new Domain( new Object[]{CASA1}));
			else if (variable == LEITE)
				setDomain(variable, new Domain( new Object[]{CASA3}));
			else
				setDomain(variable, new Domain( new Object[] {CASA1, CASA2, CASA3, CASA4, CASA5}));
		}
	}
	
	private void addDefaultVariables(Variable[] variables){
	    for (int i = 0; i < variables.length; i++) {
			addVariable(variables[i]);
		}
	}
	
	private void addDefaultConstraints(Variable[] variables){
		for (int i = 0;  i < variables.length;  i ++) {
			for (int j = i + 1;  j < variables.length;  j ++) {
				addConstraint(new NotEqualConstraint(variables[i], variables[j]));
			}
		}
	}
	
	
	public void loadConstraints(){
		addDefaultConstraints(cores);
		addDefaultConstraints(nacionalidades);
		addDefaultConstraints(bebidas);
		addDefaultConstraints(esportes);
		addDefaultConstraints(animais);
		
		addConstraint(new EqualConstraint(INGLES, VERMELHO));
		addConstraint(new EqualConstraint(ESPANHOL, CACHORRO));
		addConstraint(new EqualConstraint(VERDE, CAFE));
		addConstraint(new EqualConstraint(IRLANDES, CHA));
		addConstraint(new DiffEqualConstraint(VERDE, MARFIM, 1));
		addConstraint(new EqualConstraint(XADREZ, CARACOL));
		addConstraint(new EqualConstraint(AMARELO, CRICKET));
		addConstraint(new DiffEqualConstraint(JUDO, RAPOSA, 1));
		addConstraint(new DiffEqualConstraint(CRICKET, CAVALO, 1));
		addConstraint(new EqualConstraint(POKER, SUCO));
		addConstraint(new EqualConstraint(JAPONES, POLO));
		addConstraint(new DiffEqualConstraint(NIGERIANO, AZUL, 1));
	}
	
	
}

