package piece;

import chess.Board;
import pair.Pair;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public ArrayList<Pair> moveList(int row, int col)
    {
        ArrayList<Pair> moves = new ArrayList<Pair>();
        Piece curr = Board.matrix[row][col].getPieceOnTile();
        //Bishop
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

        //Rook
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
        return isWhite?"WQ":"BQ";
    }

//    @Override
//    public ArrayList<Pair<int, int>> moveList(int row, int col) {
//        return null;
//    }
}
