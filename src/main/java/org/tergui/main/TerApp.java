package org.tergui.main;

import org.tergui.core.Partida;
import org.tergui.gui.GUI;

public class TerApp {
	
	public static void main(String[] args) {
		new GUI(new Partida(3));
	}
}
