package moduls;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class mapaPrint {

	public mapaPrint() {
		print();
	}

	public void print() {
		String fileName = "MapaASCII.txt";

		int maxRows = 29;
		int maxCols = 91;

		char[][] mapaAscii = new char[maxRows][maxCols];
		check(fileName, maxRows, maxCols, mapaAscii);
	}

	public void check(String fileName, int maxRows, int maxCols, char[][] mapaAscii) {

		try {
			InputStream is = getClass().getResourceAsStream("/map/MapaASCII.txt");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
			String line;

			int row = 0;
			
			System.out.println();
			while (row < maxRows && (line = bufferedReader.readLine()) != null) {
				for (int col = 0; col < maxCols && col < line.length(); col++) {
					System.out.print(line.charAt(col));
				}
				row++;
				System.out.println();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
