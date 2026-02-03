package org.tergui.core;

import org.tergui.enums.Ficha;

public class Partida {
	private Tablero tablero;
	private Ficha turno;

	public Tablero getTablero() {
		return tablero;
	}

	public Ficha getTurno() {
		return turno;
	}

	public int getTamanho() {
		return tablero.getTamanho();
	}

	public Partida(int tamanho) {
		tablero = new Tablero(tamanho);
		turno = Ficha.values()[
			(int) (Math.random() * Ficha.values().length)
		]; 
	}
	
	public boolean jugar(int fila, int columna) {
		if(tablero.jugar(turno, fila, columna)) {
			turno = turno.siguiente();
			return true;
		}
		return false;
	}
	
	public boolean terminada() {
		return tablero.isLleno() || ganador() != null;
	}
	
	public Ficha ganador() {
		for (Ficha f : Ficha.values()) {
			if(tablero.gana(f)) { return f; };
		}
		return null;
	}
}
