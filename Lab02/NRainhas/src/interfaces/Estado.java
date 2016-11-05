/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */

package interfaces;

/**
 * Estado representa uma configuração do mundo em um dado momento. 
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public interface Estado {
    public boolean estadoValido();
    public boolean igual(Estado e);
}
