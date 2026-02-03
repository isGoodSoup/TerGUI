package org.tergui.core;

import org.tergui.enums.Ficha;

public class Tablero {
	private Ficha[][] tablero;
	private boolean gana = false;
	
	public Tablero(int tamanho) {
		tablero = new Ficha[tamanho][tamanho];
	}
	
	public boolean jugar(Ficha ficha, int fila, int columna) {
		if(tablero[fila][columna] == null) {
			tablero[fila][columna] = ficha;
			return true;
		}
		return false;
	}
	
	public boolean isLleno() {
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				if(tablero[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}
	
	public int getTamanho() {
		return tablero.length;
	}
	
	public boolean gana(Ficha jugador) {
		return horizontal(jugador) || vertical(jugador) ||
			   diagonal(jugador) || diagonalInversa(jugador);
	}
	
	public boolean horizontal(Ficha jugador) {
		for(int i = 0; i < tablero.length && !gana; i++) {
			gana = true;
			for(int j = 0; j < tablero[i].length && gana; j++) {
				gana &= tablero[i][j] == jugador;
			}
		}
		return gana;
	}
	
	public boolean vertical(Ficha jugador) {
		for(int i = 0; i < tablero.length && !gana; i++) {
			gana = true;
			for(int j = 0; j < tablero[i].length && gana; j++) {
				gana &= tablero[j][i] == jugador;
			}
		}
		return gana;
	}
	
	public boolean diagonal(Ficha jugador) {
		gana = true;
		for(int i = 0; i < tablero.length; i++) {
			gana &= tablero[i][i] == jugador;
		}
		return gana;
	}
	
	public boolean diagonalInversa(Ficha jugador) {
		gana = true;
		for(int i = 0; i < tablero.length; i++) {
			gana &= tablero[tablero.length - 1 - i][i] == jugador;
		}
		return gana;
	}
}
