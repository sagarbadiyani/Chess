package piece;

import pair.Pair;

import java.util.ArrayList;

import chess.Board;

public class Rook extends Piece {
    public Rook(boolean isWhite)
    {
        super(isWhite);
    }

    public ArrayList<Pair> moveList(int row, int col)
    {
        ArrayList<Pair> moves = new ArrayList<Pair>();
        //right
        for(int c=col+1;c<8; c++)
        {
            if(!Board.matrix[row][c].status())
            {
                Pair p = new Pair(row,c);
                moves.add(p);
            }
            else
            {
                if(Board.matrix[row][c].getPieceOnTile().isWhite == this.isWhite) break;
                else moves.add(new Pair(row,c));
                if(Board.matrix[row][c].status()) break;
            }
        }
        //left
        for(int c=col-1;c>=0; c--)
        {
            if(!Board.matrix[row][c].status())
            {
                Pair p = new Pair(row,c);
                moves.add(p);
            }
            else
            {
                if(Board.matrix[row][c].getPieceOnTile().isWhite == this.isWhite) break;
                else moves.add(new Pair(row,c));
                if(Board.matrix[row][c].status()) break;
            }
        }
        //down
        for(int r=row+1;r<8; r++)
        {
            if(!Board.matrix[r][col].status())
            {
                Pair p = new Pair(r,col);
                moves.add(p);
            }
            else
            {
                if(Board.matrix[r][col].getPieceOnTile().isWhite == this.isWhite) break;
                else moves.add(new Pair(r,col));
                if(Board.matrix[r][col].status()) break;
            }
        }
        //up
        for(int r=row-1;r>=0; r--)
        {
            if(!Board.matrix[r][col].status())
            {
                Pair p = new Pair(r,col);
                moves.add(p);
            }
            else
            {
                if(Board.matrix[r][col].getPieceOnTile().isWhite == this.isWhite) break;
                else moves.add(new Pair(r,col));
                if(Board.matrix[r][col].status()) break;
            }
        }
        return moves;
    }
    @Override
    public String toString()
    {
        return isWhite?"WR":"BR";
    }




}
