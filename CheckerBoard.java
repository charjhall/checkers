public class CheckerBoard {
    private Piece[][] board = new Piece[8][8];
    private String finBoard = "";

    public Piece[][] getBoard() {
        return this.board;
    }

    public boolean setLocation(int row, int col, Piece apiece) {
        board[row][col] = apiece;
    }

    public CheckerBoard() {
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                board[0][i] = new Piece("Red", false, 0, i);
                board[6][i] = new Piece("Black", false, 6, i);
            } else {
                board[1][i] = new Piece("Red", false, 1, i);
                board[7][i] = new Piece("Black", false, 7, i);
            }
        }
    }

    public String toString() {
        String topBoard = "  A  B  C  D  E  F  G  H \n";
        String topBoardline = "_________________________\n";
        finBoard += topBoard;
        finBoard += topBoardline;
        for (int i = 0; i < 8; i++) {
            finBoard += "|";
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    finBoard += "__|";
                } else {
                    finBoard += board[i][j].toString();
                }
            }
            finBoard = finBoard + " " + (i+1) + "\n";
        }
        return finBoard;
    }
}