package entities;

import java.io.IOException;

public interface ILevel {
	public boolean hasFinished();
	public boolean saveToFile();
	public Level getFromFile(int levelNum) throws IOException, ClassNotFoundException;
}
