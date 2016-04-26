package entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface ILevel {
	public boolean hasFinished();
	public boolean saveToFile();
	public Level getFromFile(int levelNum) throws IOException, ClassNotFoundException;
}
