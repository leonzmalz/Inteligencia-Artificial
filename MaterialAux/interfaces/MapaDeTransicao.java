/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */

package interfaces;

import java.util.Set;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public interface MapaDeTransicao {
    public Set<Acao> acoes(Estado e);
    public Estado resultado(Acao a, Estado e);
    public double custo(Acao a, Estado de, Estado para);
    
}
