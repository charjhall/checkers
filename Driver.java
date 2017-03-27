public class Driver {
    public static void main(String[] args) {
        CheckerBoard checkBoard = new CheckerBoard();
        Piece[][] theBoard = checkBoard.getBoard();
        System.out.println(checkBoard);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (theBoard[i][j] != null) {
                    Piece apiece = theBoard[i][j];
                    boolean left = apiece.canMove(checkBoard, "left");
                    boolean right = apiece.canMove(checkBoard, "right");
                    System.out.println("The piece on row: " + i
                        + " and collumn: " + j + " can move left: " + left
                        + " and can move right: " + right + ".");
                }
            }
        }
    }
}
