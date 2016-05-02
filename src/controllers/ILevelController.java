package controllers;

import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JLayeredPane;

import boundary.JBlockPanel;
import entities.Tile;

public interface ILevelController {
	public void piecePressed(JBlockPanel jBlockPanel);
	public void pieceReleased(JBlockPanel jBlockPanel);
	public void requestReRender();
	public void stateUpdated();
}
