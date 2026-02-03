package org.tergui.gui;

import java.awt.Font;

import javax.swing.JButton;

import org.tergui.enums.Ficha;

public class Casilla extends JButton {
	private static final long serialVersionUID = 1L;
	private static final Font FONT = new Font("Arial", Font.BOLD, 30);
	private int fila;
	private int columna;

	public Casilla(int fila, int columna, JugadaListener listener) {
		super();
		setFont(FONT);
		this.fila = fila;
		this.columna = columna;
		addActionListener(listener);
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public void ocupar(Ficha jugador) {
		setText(jugador.name());
		setForeground(jugador.getColor());
	}
}
