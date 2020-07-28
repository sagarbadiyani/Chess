package piece;

import chess.Board;
import pair.Pair;

import java.util.*;
public class King extends Piece
{
    public King(boolean isWhite) {
        super(isWhite);
    }

    int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    @Override
    public ArrayList<Pair> moveList(int row, int col) {
        ArrayList<Pair> moves = new ArrayList<Pair>();
        for (int i = 0; i < 8; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (isValid(nx, ny)) {
                Piece p = Board.matrix[nx][ny].getPieceOnTile();
                if (p == null || p.isWhite != this.isWhite) {
                    moves.add(new Pair(nx, ny));
                }
            }
        }
        return moves;
    }

    @Override
    public String toString() {
        return isWhite ? "WK" : "BK";
    }
}
