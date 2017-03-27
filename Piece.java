public class Piece {
    private String color;
    private boolean isKing;
    private int col;
    private int row;

    public String getColor() {
        return color;
    }

    public boolean getIsKing() {
        return isKing;
    }

    public int getCollumn() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setIsKIng(boolean value) {
        this.isKing = value;
    }

    public Piece(String color, boolean isKing, int row, int col) {
        this.color = color;
        this.isKing = isKing;
        this.col = col;
        this.row = row;
    }

    public String toString() {
        if (color == "Red") {
            return " R|";
        } return " B|";
    }

    public void move(CheckerBoard board, String direction) {
        Piece[][] theBoard = board.getBoard();
        if (this.canMove(board, direction)) {
            if (!(isKing)) {
                if (direction == "left") {
                    if (color == "Black") {
                        row -= 1;
                        col -= 1;
                        board.setLocation(row, col, this);
                        board.setLocation(row + 1, col + 1, null);
                    } else {
                        row += 1;
                        col -= 1;
                        board.setLocation(row, col, this);
                        board.setLocation(row - 1, col + 1, null);
                    }
                } else if (direction == "right") {
                    if (color == "Black") {
                        row -= 1;
                        col += 1;
                        board.setLocation(row, col, this);
                        board.setLocation(row + 1, col - 1, null);
                    } else {
                        row += 1;
                        col += 1;
                        board.setLocation(row, col, this);
                        board.setLocation(row - 1, col - 1, null);
                    }
                } else {
                    System.out.println("Invalid direction");
                }
            }
            if (direction == "fowardleft") {
                row -= 1;
                col -= 1;
                board.setLocation(row, col, this);
                board.setLocation(row + 1, col + 1, null);
            } else if (direction == "fowardright") {
                row -= 1;
                col += 1;
                board.setLocation(row, col, this);
                board.setLocation(row + 1, col - 1, null);
            } else if (direction == "backleft") {
                row += 1;
                col -= 1;
                board.setLocation(row, col, this);
                board.setLocation(row - 1, col + 1, null);
            } else if (direction == "backright") {
                row += 1;
                col += 1;
                board.setLocation(row, col, this);
                board.setLocation(row - 1, col - 1, null);
            } else {
                System.out.println("Invalid direction");
            }
        }
    }

    public boolean canMove(CheckerBoard board, String direction) {
        Piece[][] theBoard = board.getBoard();
        if (!(isKing)) {
            if (direction == "left") {
                if (col == 0) {
                    return false;
                }
                if (color == "Black") {
                    if (theBoard[row - 1][col - 1] == null) {
                            return true;
                    } return false;
                } else if (color == "Red") {
                    if (theBoard[row + 1][col - 1] == null) {
                        return true;
                    } return false;
                } else {
                    System.out.println("Invalid Color");
                    return false;
                }
            } else if (direction == "right") {
                if (col == 7) {
                    return false;
                }
                if (color == "Black") {
                    if (theBoard[row - 1][col + 1] == null) {
                        return true;
                    } return false;
                } else if (color == "Red") {
                    if (theBoard[row + 1][col + 1] == null) {
                        return true;
                    } return false;
                } else {
                    System.out.println("Invalid Color");
                    return false;
                }
            } else {
                System.out.println("Invalid direction");
                return false;
            }
        }
        if (direction == "fowardleft") {
            if (col == 0) || (row == 0) {
                return false;
            } else if (theBoard[row - 1][col - 1] == null) {
                return true;
            } return false;
        } else if (direction == "fowardright") {
            if (col == 7) || (row == 0) {
                return false;
            } else if (theBoard[row - 1][col + 1] == null) {
                return true;
            } return false;
        } else if (direction == "backleft") {
            if (col == 0) || (row == 7){
                return false;
            } else if (theBoard[row + 1][col - 1] == null) {
                return true;
            } return false;
        } else if (direction == "backright") {
            if (col == 7) || (row == 7){
                return false;
            } else if (theBoard[row + 1][col + 1] == null) {
                return true;
            } return false;
        } else {
            System.out.println("Invalid direction");
            return false;
        }
    }
}

