import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fourinaline {
	static int ROWS;
	static int COLUMNS;
	public static void main(String args[]) throws IOException {

		String filename = args[0];
		FileReader fr = new FileReader(filename);
		BufferedReader bfr = new BufferedReader(fr);

		int count = 0;
		String str;
		str = bfr.readLine();
		String[] temp = str.split(",");
		COLUMNS = temp.length;
		bfr.close();
		FileReader fr1 = new FileReader(filename);
		BufferedReader bfr1 = new BufferedReader(fr1);

		while ((str = bfr1.readLine()) != null) {
			if (str.length() > 3) { // To remove rows with characters like \n
				count++;
			}
		}

		ROWS = count;
		// Array
		int[][] Array = new int[ROWS][COLUMNS];
		FileReader fr2 = new FileReader(filename);
		BufferedReader bfr2 = new BufferedReader(fr2);

		// Initializing Array
		int rx = 0;
		while (rx < ROWS) {
			str = bfr2.readLine();
			String[] temp1 = str.split(",");
			for (int j = 0; j < COLUMNS; j++) {
				if (temp1[j].equals("0")) {
					Array[rx][j] = 0;
				}
				if (temp1[j].equals("1")) {
					Array[rx][j] = 1;
				}
				if (temp1[j].equals("2")) {
					Array[rx][j] = -1;
				}
			}
			rx++;
		}
		int f = checkBoard(Array);
		if (f != 0) {
			System.out.println(f);
			System.exit(1);
		}
		System.out.println(checkDraw(Array));
	}

	private static String checkDraw(int[][] array) {
		for (int j = 0; j < COLUMNS; j++) {
			if (array[0][j] == 0) {
				return "play";
			}
		}
		return "draw";
	}

	private static int checkBoard(int[][] Array) {
		// Row Wise
		for (int r = ROWS - 1; r >= 0; r--) {
			int total;
			for (int c = 0; c < COLUMNS - 3; c++) {
				total = Array[r][c] + Array[r][c + 1] + Array[r][c + 2]
						+ Array[r][c + 3];
				if (total == 4) {
					return 1;
				}
				if (total == -4) {
					return 2;
				}
			}
		}
		// Column Wise

		for (int c = 0; c < COLUMNS - 1; c++) {
			int total;
			for (int r = ROWS - 1 - 3; r >= 0; r--) {
				total = Array[r][c] + Array[r + 1][c] + Array[r + 2][c]
						+ Array[r + 3][c];
				if (total == 4) {
					return 1;
				}
				if (total == -4) {
					return 2;
				}
			}
		}
		// Diagonals
		for (int r = ROWS - 1 - 3; r >= 3; r--) {
			int total;
			for (int c = 0; c < COLUMNS - 1 - 3; c++) {
				total = Array[r][c] + Array[r + 1][c + 1] + Array[r + 2][c + 2]
						+ Array[r + 3][c + 3];
				if (total == 4) {
					return 1;
				}
				if (total == -4) {
					return 2;
				}
			}
		}
		for (int r = ROWS - 1 - 3; r >= 3; r--) {
			int total;
			for (int c = 3; c < COLUMNS - 1; c++) {
				total = Array[r][c] + Array[r - 1][c - 1] + Array[r - 2][c - 2]
						+ Array[r - 3][c - 3];
				if (total == 4) {
					return 1;
				}
				if (total == -4) {
					return 2;
				}
			}
		}
		for (int r = ROWS - 1 - 3; r >= 3; r--) {
			int total;
			for (int c = 0; c < COLUMNS - 3; c++) {
				total = Array[r][c] + Array[r - 1][c + 1] + Array[r - 2][c + 2]
						+ Array[r - 3][c + 3];
				if (total == 4) {
					return 1;
				}
				if (total == -4) {
					return 2;
				}
			}
		}
		for (int r = ROWS - 1 - 3; r >= 3; r--) {
			int total;
			for (int c = 3; c < COLUMNS - 3; c++) {
				total = Array[r][c] + Array[r + 1][c - 1] + Array[r + 2][c - 2]
						+ Array[r + 3][c - 3];
				if (total == 4) {
					return 1;
				}
				if (total == -4) {
					return 2;
				}
			}
		}
		return 0;
	}
}
