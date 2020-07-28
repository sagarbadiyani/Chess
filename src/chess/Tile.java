package chess;

import piece.Piece;

public class Tile
{
    private Piece pieceOnTile;
    private boolean isOccupied;
    private final int row, col;
    private boolean isWhite;
    Tile(int row, int col, boolean isOccupied)
    {
        this.pieceOnTile = null;
        this.row=row;
        this.col = col;
        this.isWhite = ((row&1)==(col&1));
        this.isOccupied= isOccupied;
    }
    int getRow()
    {
        return row;
    }
    int getCol()
    {
        return col;
    }
    public boolean status() {return isOccupied;}
    boolean getColorOfTile()
    {
        return isWhite;
    }
    void setPiece(Piece piece)
    {
        if(piece==null) {
            isOccupied=false;
            pieceOnTile = null;
        }
        else
        {
            isOccupied=true;
            pieceOnTile= piece;
        }
    }
    public Piece getPieceOnTile()
    {
        return pieceOnTile;
    }


}
