package org.tergui.gui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.tergui.core.Partida;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String TITULO = "Tres En Raya";
	private static final String EMPIEZA = "Empieza jugando ";
	private final JugadaListener listener;
	private Casillero casillero;
	private JLabel estado;
	
	public GUI(Partida partida) {
		super(TITULO);
		listener = new JugadaListener(partida, this);
		casillero = new Casillero(partida, listener);
		add(casillero, BorderLayout.CENTER);
		estado = new JLabel(EMPIEZA + partida.getTurno());
		add(estado, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 200, 240);
		setVisible(true);
	}
	
	public GUI(JugadaListener listener, Casillero casillero, JLabel estado) throws HeadlessException {
		super();
		this.listener = listener;
		this.casillero = casillero;
		this.estado = estado;
	}

	public Casillero getCasillero() {
		return casillero;
	}

	public void setCasillero(Casillero casillero) {
		this.casillero = casillero;
	}

	public JLabel getEstado() {
		return estado;
	}

	public void setEstado(JLabel estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getTitulo() {
		return TITULO;
	}

	public JugadaListener getListener() {
		return listener;
	}
	
	public void update(String mensaje) {
		estado.setText(mensaje);
	}
}
