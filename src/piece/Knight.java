package piece;

import pair.Pair;

import java.util.ArrayList;
import chess.*;
public class Knight extends Piece{
    public Knight(boolean isWhite) {
        super(isWhite);
    }
    int[] dx = {1, 2, 1,  2, -1, -2, -1, -2};
    int[] dy = {2, 1, -2, -1, 2, 1, -2, -1};
    @Override
    public ArrayList<Pair> moveList(int row, int col)
    {
        ArrayList<Pair> moves = new ArrayList<Pair>();
        for(int i=0; i<8; i++)
        {
            int nx = row+dx[i];
            int ny = col+ dy[i];
            if(isValid(nx,ny) &&
                (!Board.matrix[nx][ny].status() || Board.matrix[nx][ny].getPieceOnTile().isWhite!= Board.matrix[row][col].getPieceOnTile().isWhite ))
            {
                moves.add(new Pair(nx,ny));
            }

        }
        return moves;
    }

    @Override
    public String toString()
    {
        return isWhite?"WN":"BN";
    }

//    @Override
//    public ArrayList<Pair<int, int>> moveList(int row, int col) {
//        return null;
//    }
}
