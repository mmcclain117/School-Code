package ND;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob13 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob13.txt"));

    }

}
//
//typedef char FrogPart;
//typedef char FrogColor;
//
//struct Frog
//{
//    FrogColor color;
//    FrogPart part;
//};
//
//const int TOP = 0;
//const int RIGHT = 1;
//const int BOTTOM = 2;
//const int LEFT = 3;
//
//struct Square
//{
//    Frog frog[4];
//    bool used;
//};
//
//
//void GetFrog( Square& s, Frog &f, int direction, int rotation )
//{
//    int index = direction - rotation;
//    while( index < 0 )
//        index += 4;
//    f.color = s.frog[index].color;
//    f.part  = s.frog[index].part;
//}
//
//Square PieceList[9];
//
///*
//Square PieceList[9] =
//{
//  { {{Y,H},{B,H},{R,F},{G,H}},false},
//  { {{G,H},{Y,F},{R,H},{B,H}},false},
//  { {{Y,H},{R,F},{B,F},{G,F}},false},
//  { {{G,F},{Y,F},{R,F},{G,H}},false}, // 4
//  { {{G,F},{R,F},{Y,F},{B,H}},false}, // 5
//  { {{Y,H},{B,H},{Y,H},{B,F}},false}, // 6
//  { {{G,F},{R,H},{R,F},{B,H}},false}, // 7
//  { {{G,H},{Y,F},{B,F},{R,H}},false}, // 8
//  { {{Y,F},{G,H},{R,F},{B,H}},false},
//};
//*/
//
//const char UNASSIGNED = -1;
//const char MATCH_ALL  = -9;
//
//struct Position
//{
//    int piece;
//    int rotation;
//};
//
//Position Board[4][4];
//
//bool IsValid( void ) {
//    bool result = true;
//    struct Offset
//    {
//        int dir, dr, dc;
//    };
//    Offset offs[4] =
//    {
//      {  RIGHT,  0, 1 },
//      {  BOTTOM, 1, 0 },
//    };
//    int r1, c1;
//    for( int row=0; result && row<3; row++ )
//        for( int col=0; result && col<3; col++ )
//        {
//            Frog f0, f1;
//            for( int i=0; result && i<2; i++ )
//            {
//              r1  =  row + offs[i].dr;
//              c1  =  col + offs[i].dc;
//              if( r1 == 3 || c1 == 3 )
//                  continue;
//              if( Board[row][col].piece == UNASSIGNED || Board[r1][c1].piece == UNASSIGNED )
//                  continue;
//              GetFrog( PieceList[ Board[row][col].piece ], f0, offs[i].dir, Board[row][col].rotation );
//              GetFrog( PieceList[ Board[r1][c1].piece ],   f1, offs[i].dir-2, Board[r1][c1].rotation );
//              if( f0.color != f1.color )
//                  result = false;
//              else if( f0.part == f1.part )
//                  result = false;
//            }
//        }
//    return result;
//}
//
//int comparisons = 0;
//
//bool NextPiece( int row, int col )
//{
//    int nextRow, nextCol;
//    nextRow  =  row;
//    nextCol  =  col+1;
//    if( nextCol == 3 )
//    {
//        nextCol  =  0;
//        nextRow  =  row+1;
//    }
//    if( row == 3 )
//        return true;
//    for( int i=0; i<9; i++ )
//    {
//        if( ! PieceList[i].used )
//        {
//            PieceList[i].used  =  true;
//            Board[row][col].piece  =  i;
//            for( int r=0; r<4; r++ )
//            {
//                Board[row][col].rotation = r;
//                ++comparisons;
//                if( IsValid() )
//                {
//                    if( NextPiece( nextRow, nextCol ) )
//                        return true;
//                }
//            }
//            Board[row][col].piece  =  UNASSIGNED;
//            PieceList[i].used  =  false;
//        }
//    }
//    return false;
//}
//
//void ReadPieces( Square PieceList[9] )
//{
//    FILE* infile = fopen( "TumbledTiles.in", "r" );
//    for( int i=0; i<9; i++ )
//    {
//        char line[80];
//        fscanf( infile, "%[^\n]\n", line );
//        for( int p=0; p<4; p++ )
//        {
//            PieceList[i].frog[p].color = line[2+p*3];
//            PieceList[i].frog[p].part  = line[3+p*3];
//        }
//    }
//    fclose(infile);
//
//    for( int i=0; i<9; i++ )
//    {
//        for( int j=0; j<4; j++ )
//            System.out.printf( "%c%c ", PieceList[i].frog[j].color, PieceList[i].frog[j].part );
//        System.out.printf( "\n" );
//    }
//}
//
//
//public static void main(String args[]) throws Exception {
//
//    ReadPieces( PieceList );
//
//    for( int i=0; i<9; i++ )
//        PieceList[i].used = false;
//    for( int row=0; row<3; row++ )
//        for( int col=0; col<3; col++ )
//            Board[row][col].piece = UNASSIGNED;
//
//    for( int i=0; i<4; i++ )    {
//      Board[3][i].piece  =  MATCH_ALL;
//      Board[i][3].piece  =  MATCH_ALL;
//    }
//
//    if( ! NextPiece( 0, 0 ) )
//        System.out.printf( "no solution\n" );
//    else
//
//    for( int row=0; row<3; row++ )
//    {
//        for( int col=0; col<3; col++ )
//            System.out.printf( "%d:%3d   ", 1+Board[row][col].piece, Board[row][col].rotation );
//        System.out.printf( "\n" );
//    }
//    System.out.printf( "comparisons: %d\n", comparisons );
//
//    for( int row=0; row<3; row++ )
//    {
//        for( int tmb=0; tmb<3; tmb++ )
//        {
//            for( int col=0; col<3; col++ )
//            {
//                int p = Board[row][col].piece;
//                int r = Board[row][col].rotation;
//                int top = (4-r)%4;
//                int right = ( top + 1 ) % 4;
//                int bottom = ( right + 1 ) % 4;
//                int left = ( bottom + 1 ) % 4;
//                switch( tmb )
//                {
//                   case 0:
//                       System.out.printf( "   %c%c    ", PieceList[p].frog[top].color,
//                                              PieceList[p].frog[top].part );
//                       break;
//                   case 1:
//                       System.out.printf( "%c%c- %d-%c%c ", PieceList[p].frog[left].color,
//                                                 PieceList[p].frog[left].part,
//                                                 1+p,
//                                                 PieceList[p].frog[right].color,
//                                                 PieceList[p].frog[right].part );
//                       break;
//                   case 2:
//                       System.out.printf( "   %c%c    ", PieceList[p].frog[bottom].color,
//                                              PieceList[p].frog[bottom].part );
//                       break;
//                }
//            }
//            System.out.printf( "\n" );
//        }
//        System.out.printf( "\n" );
//    }
//
//    int i;
//    scanf( "%d", &i );
//
//    return 0;
//}
