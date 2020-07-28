package chess;

import piece.King;
import piece.Pawn;
import piece.*;
import pair.*;

import java.util.ArrayList;

public class Board
{
    public static Tile[][] matrix =new Tile[8][8];
    public Board()
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                matrix[i][j] = new Tile(i,j,false);
            }
        }
        for(int i=0; i<8; i++)
        {
            matrix[1][i]= new Tile(1, i, true);
            matrix[1][i].setPiece(new Pawn(false));
        }
        for(int i=0; i<8; i++)
        {
            matrix[6][i]= new Tile(6, i, true);
            matrix[6][i].setPiece(new Pawn(true));
        }
        //Rook assembled
        matrix[0][0]= new Tile(0,0, true);
        matrix[0][7]= new Tile(0,7, true);
        matrix[7][0]= new Tile(7,0, true);
        matrix[7][7]= new Tile(7,7, true);
        matrix[0][0].setPiece(new Rook(false));
        matrix[0][7].setPiece(new Rook(false));
        matrix[7][0].setPiece(new Rook(true));
        matrix[7][7].setPiece(new Rook(true));

        //Knight assembled
        matrix[0][1]= new Tile(0,1, true);
        matrix[0][6]= new Tile(0,6, true);
        matrix[7][1]= new Tile(7,1, true);
        matrix[7][6]= new Tile(7,6, true);
        matrix[0][1].setPiece(new Knight(false));
        matrix[0][6].setPiece(new Knight(false));
        matrix[7][1].setPiece(new Knight(true));
        matrix[7][6].setPiece(new Knight(true));

        //Bishop assembled
        matrix[0][2]= new Tile(0,2, true);
        matrix[0][5]= new Tile(0,5, true);
        matrix[7][2]= new Tile(7,2, true);
        matrix[7][5]= new Tile(7,5, true);
        matrix[0][2].setPiece(new Bishop(false));
        matrix[0][5].setPiece(new Bishop(false));
        matrix[7][2].setPiece(new Bishop(true));
        matrix[7][5].setPiece(new Bishop(true));

        //Queens
        matrix[0][3]= new Tile(0,3, true);
        matrix[7][3]= new Tile(7,3, true);
        matrix[0][3].setPiece(new Queen(false));
        matrix[7][3].setPiece(new Queen(true));

        //Kings
        matrix[0][4]= new Tile(0,4, true);
        matrix[7][4]= new Tile(7,4, true);
        matrix[0][4].setPiece(new King(false));
        matrix[7][4].setPiece(new King(true));

//        matrix[5][4].setPiece(new King(false));
//        matrix[3][4].setPiece(new Queen(false));
//        matrix[1][4].setPiece(null);

    }
}
