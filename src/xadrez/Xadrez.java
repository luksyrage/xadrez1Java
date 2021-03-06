package xadrez;

import boardgame.Board;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Xadrez {
    public static void main(String[] args) {
        
        Scanner le = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        
        while (true){
            try{
                UI.clearScreen();
                UI.printMatch(chessMatch);
                System.out.println();
                System.out.print("Origem: ");
                ChessPosition source = UI.readChessPosition(le);
                
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
               
                System.out.println();
                System.out.print("Destino: ");
                ChessPosition target = UI.readChessPosition(le);
                
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
            catch (ChessException e){
                System.out.println(e.getMessage());
                le.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
                le.nextLine();
            }
        }
        
        
    }
    
}
