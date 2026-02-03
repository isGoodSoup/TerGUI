package org.tergui.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import org.tergui.core.Partida;

public class Casillero extends JPanel {
	private static final long serialVersionUID = 1L;
	private final int TAMANHO;
	private Casilla[][] botones;
	
	public Casillero(Partida partida, JugadaListener listener) {
		this.TAMANHO = partida.getTamanho();
		
		setLayout(new GridLayout(TAMANHO, TAMANHO));
		botones = new Casilla[TAMANHO][TAMANHO];
		for (int i = 0; i < TAMANHO; i++) {
			for (int j = 0; j < TAMANHO; j++) {
				botones[i][j] = new Casilla(i, j, listener);
				add(botones[i][j]);
			}
		}
	}
}
