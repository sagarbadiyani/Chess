package piece;

import chess.Board;
import pair.Pair;

import java.util.ArrayList;

public class Bishop extends Piece
{

    public Bishop(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public ArrayList<Pair> moveList(int row, int col)
    {
        ArrayList<Pair> moves = new ArrayList<Pair>();
        Piece curr = Board.matrix[row][col].getPieceOnTile();
//        quad 4
        for(int i=row+1,j=col+1; i<8 && j<8; i++, j++)
        {
            Piece p = Board.matrix[i][j].getPieceOnTile();
            if(p!=null)
            {
                if(p.isWhite== curr.isWhite) break;
                else
                {
                    moves.add(new Pair(i,j));
                    break;
                }
            }
            moves.add(new Pair(i,j));
        }
        //quad 3
        for(int i=row+1,j=col-1; i<8 && j>=0; i++, j--)
        {
            Piece p = Board.matrix[i][j].getPieceOnTile();
            if(p!=null)
            {
                if(p.isWhite== curr.isWhite) break;
                else
                {
                    moves.add(new Pair(i,j));
                    break;
                }
            }
            moves.add(new Pair(i,j));
        }
//        quad 1
        for(int i=row-1,j=col+1; j<8 && i>=0; i--, j++)
        {
            Piece p = Board.matrix[i][j].getPieceOnTile();
            if(p!=null)
            {
                if(p.isWhite== curr.isWhite) break;
                else
                {
                    moves.add(new Pair(i,j));
                    break;
                }
            }
            moves.add(new Pair(i,j));
        }
//        quad 2
        for(int i=row-1,j=col-1; j>=0 && i>=0; i--, j--)
        {
            Piece p = Board.matrix[i][j].getPieceOnTile();
            if(p!=null)
            {
                if(p.isWhite== curr.isWhite) break;
                else
                {
                    moves.add(new Pair(i,j));
                    break;
                }
            }
            moves.add(new Pair(i,j));
        }
        return moves;
    }

    @Override
    public String toString()
    {
        return isWhite?"WB":"BB";
    }

//    @Override
//    public ArrayList<Pair<int, int>> moveList(int row, int col) {
//        return null;
//    }
}
