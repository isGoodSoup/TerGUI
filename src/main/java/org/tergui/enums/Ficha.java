package org.tergui.enums;

import java.awt.Color;

public enum Ficha {
	X(Color.RED), O(Color.BLUE);
	private Color color;
	
	private Ficha (Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Ficha siguiente() {
		return this == X ? O : X;
	}
}
