package ProblemsIn_Java.NoteBook;

public class Varios {

	class tablero15PuzzleSolucionable {
		status init;

		boolean solvable() {
			int sum = 0, row = 0, i, j;
			for (i = 0; i < 16; i++) {
				if (init.board[i / 4][i % 4] == 0) {
					row = i / 4 + 1;
					continue;
				}
				for (j = i + 1; j < 16; j++) {
					if (init.board[j / 4][j % 4] < init.board[i / 4][i % 4]) {
						if (init.board[j / 4][j % 4] != 0)
							sum++;
					}
				}
			}
			return (1 - (sum + row) % 2) != 0;
		}

		class status {
			char[][] board;
			int ix, iy;

			public status() {
				board = new char[4][4];
			}
		}

	}

}
