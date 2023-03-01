import java.util.ArrayList;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
    }
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> rows = new ArrayList<HashSet<Character>>();
        ArrayList<HashSet<Character>> cols = new ArrayList<HashSet<Character>>();
        ArrayList<HashSet<Character>> squares = new ArrayList<HashSet<Character>>();
        for (int i = 0; i < board.length; i++) {
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            squares.add(new HashSet<Character>());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.')
                    continue;
                if (!rows.get(i).add(board[i][j]) || !cols.get(j).add(board[i][j])
                        || !squares.get((i / 3) * 3 + (j / 3)).add(board[i][j]))
                    return false;
            }
        }
        return true;
    }
}