package piece;

import chess.Board;
import chess.Main;
import pair.Pair;

import javax.sql.rowset.BaseRowSet;
import java.util.ArrayList;

public class Pawn extends Piece
{
    public Pawn(boolean isWhite)
    {
        super(isWhite);
    }
//
    @Override
    public ArrayList<Pair> moveList(int row, int col) {
        ArrayList<Pair> moves = new ArrayList<Pair>();
        if(this.isWhite)
        {
            if(row==0)
            {
//                PromotePawn(row,col);
            }
            else
            {
                Piece p = Board.matrix[row-1][col].getPieceOnTile();
                if(p==null)
                {
                    moves.add(new Pair(row-1,col));
                    if(row==6)
                    {
                        if(Board.matrix[row-2][col].getPieceOnTile()==null)
                        {
                            moves.add(new Pair(row-2,col));
                        }
                    }
                }
                Piece a=null, b=null;
                if(isValid(row-1, col+1)) {
                    a = Board.matrix[row-1][col+1].getPieceOnTile();
                }
                if(isValid(row-1, col-1))
                b = Board.matrix[row-1][col-1].getPieceOnTile();

                if(a!=null)
                if(a.isWhite!=this.isWhite) moves.add(new Pair(row-1, col+1));

                if(b!=null)
                if(b.isWhite!=this.isWhite) moves.add(new Pair(row-1, col-1));


            }
        }

        //blacky
        else
        {
            if(row==7)
            {
//                PromotePawn(row,col);
            }
            else
            {
                Piece p = Board.matrix[row+1][col].getPieceOnTile();
                if(p==null)
                {
                    moves.add(new Pair(row+1,col));
                    if(row==1)
                    {
                        if(Board.matrix[row+2][col].getPieceOnTile()==null)
                        {
                            moves.add(new Pair(row+2,col));
                        }
                    }
                }
                Piece a= null, b=null;
                if(isValid(row+1, col+1))
                a = Board.matrix[row+1][col+1].getPieceOnTile();
                if(isValid(row+1, col-1))
                b = Board.matrix[row+1][col-1].getPieceOnTile();

                if(a!=null)
                if(a.isWhite!=this.isWhite) moves.add(new Pair(row+1, col+1));
                if(b!=null)
                if(b.isWhite!=this.isWhite) moves.add(new Pair(row+1, col-1));


            }
        }
        return moves;
    }

    public String toString()
    {
        return isWhite?"WP":"BP";
    }

}
