package org.tergui.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.tergui.core.Partida;
import org.tergui.enums.Ficha;

public class JugadaListener implements ActionListener {
	private static final String TURNO = "Turno: %s";
	private static final String OCUPADA = "Casilla Ocupada - Turno: %s";
	private static final String GANADOR = "%s gana!";
	private static final String TERMINADA = "Partida terminada";
	private static final String EMPATE = "Partida terminada: Empate";
	private Partida partida;
	private GUI gui;
	private Ficha jugador;
	private Ficha ganador;
	private Casilla casilla;
	private Integer fila;
	private Integer columna;
	
	public JugadaListener(Partida partida, GUI gui) {
		super();
		this.partida = partida;
		this.gui = gui;
	}

	public Partida getPartida() {
		return partida;
	}

	public GUI getGui() {
		return gui;
	}

	public Ficha getJugador() {
		return jugador;
	}

	public Casilla getCasilla() {
		return casilla;
	}

	public Integer getFila() {
		return fila;
	}

	public Integer getColumna() {
		return columna;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (partida.terminada()) {
			gui.update(String.format(TERMINADA, partida.ganador()));
			return;
		}
		jugador = partida.getTurno();
		casilla = (Casilla) e.getSource();
		fila = casilla.getFila();
		columna = casilla.getColumna();
		
		if(partida.jugar(fila, columna)) {
			casilla.ocupar(jugador);
			ganador = partida.ganador();
			if(ganador == null) { 
				if(partida.terminada()) { 
					gui.update(EMPATE); 
				} else {
					gui.update(String.format(TURNO,  partida.getTurno()));
				}
			} else {
				gui.update(String.format(GANADOR, jugador));
			}
		} else {
			gui.update(String.format(OCUPADA, jugador));
		}
	}
}
