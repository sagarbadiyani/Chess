package chess;

import java.lang.reflect.Array;
import java.util.*;

import pair.Pair;
import piece.Bishop;
import piece.Knight;
import piece.Piece;
import piece.Queen;
import piece.Rook;

public class Main {
	
	public static void printBoard() {
		System.out.print("\t");
		for(int i=0; i<8; i++)
            System.out.print(i+"\t");
        System.out.println();
        for(int i=0; i<8; i++)
        {
            System.out.print(i+"\t");
            for(int j=0; j<8; j++)
            {
                if(Board.matrix[i][j].status()) System.out.print(Board.matrix[i][j].getPieceOnTile().toString()+"\t");
                else System.out.print("."+'\t');
            }
            System.out.println();
        }
	}
	
	public static int getInput() {
		 Scanner scanner = new Scanner( System.in );
		 String input = scanner.nextLine();
		 int number = Integer.parseInt( input );
		 return number;
	}
	
	public static boolean isValidSelection(int row, int col) {
		if(row<0 || row>=8 || col<0 || col>=8) return false;
		return Board.matrix[row][col].status();
	}
	
	public static boolean isOccupied(int row, int col) {
		return Board.matrix[row][col].status();
	}
	
	public static ArrayList<Pair> moves(int row, int col)
	{
      ArrayList<Pair> a = Board.matrix[row][col].getPieceOnTile().moveList(row,col);
      
//      for(int i=0; i<a.size(); i++)
//      {
//          System.out.println(a.get(i).first + " " + a.get(i).second);
//
//      }
      return a;
	}
		
	public static void step(int dr, int dc, int sr, int sc) {
		Board.matrix[dr][dc].setPiece(Board.matrix[sr][sc].getPieceOnTile());
		Board.matrix[sr][sc] = new Tile(sr, sc, false);
	}
	
	public static boolean isPresent(ArrayList<Pair> m, int row, int col) {
		int len = m.size();
		for(int i=0;i<len;i++) {
			if(m.get(i).first==row && m.get(i).second==col) return true;
		}
		return false;
	}
	
	public static void print(Object o) {
		System.out.println(o);
	}
	
	public static HashSet<Pair> genMoves(boolean color) //generates moves for the idle player
	{
		HashSet<Pair> ans = new HashSet<Pair>();
		for(int i=0;i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				Piece p = Board.matrix[i][j].getPieceOnTile();
				if(p!=null && p.isWhite==color )
					ans.addAll((Collection)moves(i,j));
			}
		}
		return ans;
	}
	public static boolean isCheck(boolean color, Pair kingPos)
	{
		HashSet<Pair> idleMoves = genMoves(!color);
		for(Pair x: idleMoves)
			if(x.first==kingPos.first && x.second==kingPos.second) return true;
		return false;
	}
	public static boolean trial(Pair s, Pair d, boolean color, Pair kingPos)
	{
//		print();
		Piece atD = Board.matrix[d.first][d.second].getPieceOnTile();
		step(d.first, d.second, s.first, s.second);
		boolean c;
		if(s.first==kingPos.first && s.second==kingPos.second)
		{
			c= isCheck(color,d);
		}
		else
			c = isCheck(color, kingPos);
		step(s.first,s.second, d.first, d.second);
		Board.matrix[d.first][d.second].setPiece(atD);
//		print(c);
		return !c;
	}
	public static ArrayList<Pair> checkoutMoves(int sourceRow, int sourceCol, boolean isWhite, Pair wkp, Pair bkp)
	{
		ArrayList<Pair> possible = moves(sourceRow, sourceCol);
//		print(possible.size());
		ArrayList<Pair> m = new ArrayList<Pair>();
		for(Pair x : possible)
		{
			boolean flag;
			if(isWhite)
				flag = trial(new Pair(sourceRow,sourceCol), x, isWhite, wkp);
			else
				flag = trial(new Pair(sourceRow,sourceCol), x, isWhite, bkp);
			if(flag) m.add(x);
		}
		return m;
	}
	public static boolean isCheckMate(boolean color, Pair wkp, Pair bkp)
	{
		int count=0;
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				Piece p = Board.matrix[i][j].getPieceOnTile();
				if(p!=null)
				{
					if(p.isWhite==color) {
						count+=checkoutMoves(i,j,color,wkp,bkp).size();
						print(i+" "+j+" "+count);
//						if(count>0) return false;
					}
				}
			}
		}
		print(count);
		return count==0;

	}
	
	public static void pawnPromotion(boolean isWhite, int destRow, int destCol) {
		print("1 for Queen");
		print("2 for Bishop");
		print("3 for Knight");
		print("4 for Rook");
		
		int x = getInput();
		
		if(x==1) {
			Board.matrix[destRow][destCol].setPiece(new Queen(isWhite));
		}
		if(x==2) {
			Board.matrix[destRow][destCol].setPiece(new Bishop(isWhite));
		}
		if(x==3) {
			Board.matrix[destRow][destCol].setPiece(new Knight(isWhite));
		}
		if(x==4) {
			Board.matrix[destRow][destCol].setPiece(new Rook(isWhite));
		}
		
        
	}
	
	public static void main(String args[])
    {
        new Board();
        printBoard();
        
        boolean isWhite = true;
        Pair bkp, wkp; //black and white king positions
		bkp = new Pair(0,4);
		wkp = new Pair(7,4);
		Piece selected;
		
		//take input for selected piece
        while(true) {
        	if((!isWhite && isCheck(isWhite,bkp))|| (isWhite &&  isCheck(isWhite,wkp))){
				print(isCheckMate(isWhite,wkp,bkp));
				if(isCheckMate(isWhite, wkp, bkp)) {
					print("Game Over");
					break;
				}
			}
        	int sourceRow;
            int sourceCol;
         
            while(true) {
            	 sourceRow = getInput();
                 sourceCol = getInput();
                 selected = Board.matrix[sourceRow][sourceCol].getPieceOnTile();
                 if(isValidSelection(sourceRow, sourceCol) && (selected.isWhite == isWhite )  ) {
                	 break;
                 }
                 else {
                	 System.out.println("No piece found at selected row, col");
                 }
            }
            ArrayList<Pair> m = checkoutMoves(sourceRow,sourceCol,isWhite,wkp,bkp);
            
            print(m.size());
            if(m.size()==0) continue;
            //select the destination
            int destRow;
            int destCol;
            while(true) {
           	 	destRow = getInput();
    	        destCol = getInput();
    	        
    	        if(isPresent(m, destRow, destCol)) {
    	       	 	break;
    	        }
    	        else {
    	        	System.out.println("Not a valid Pair");
    	        }
            }

            //move the piece to new position
            step(destRow, destCol, sourceRow, sourceCol);

            //update king position
            if(selected.toString()== "WK") wkp = new Pair(destRow,destCol);
            else if(selected.toString()=="BK") bkp = new Pair(destRow, destCol);
            if(selected.toString() == "WP" && destRow==0) {
            	pawnPromotion(isWhite, destRow, destCol);
            }
            if(selected.toString() == "BP" && destRow==7) {
            	pawnPromotion(isWhite, destRow, destCol);
            }
            printBoard();
            isWhite ^= true;
        }
    
    }
}
