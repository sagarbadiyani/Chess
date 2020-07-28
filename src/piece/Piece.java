package piece;

import pair.Pair;

import java.util.ArrayList;

public abstract class Piece
{
    public boolean isWhite;
    protected String name;
    public Piece(boolean isWhite)
    {
        this.isWhite = isWhite;
        this.name=null;
    }

    public abstract ArrayList<Pair> moveList(int row, int col);
    public boolean isValid(int row, int col)
    {
        return row>=0 && col>=0 && row<8 && col<8;
    }
}
