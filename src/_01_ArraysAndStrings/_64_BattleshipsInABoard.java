package _01_ArraysAndStrings;

import java.util.*;

public class _64_BattleshipsInABoard{

public static int countBattleships(char[][]board){
        int ans=0;
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m; i++){
        for(int j=0;j<n; j++){

        if(board[i][j]=='X'){
         if(i==0 && j==0){
                 ans++;
         }else if(i==0){
                 if(board[i-1][j]!='X'){
                         ans++;
                 }
         }else{
                 if(board[i][j-1]!='X' && board[i-1][j] != 'X'){
                         ans++;
                 }
         }
        }
        }
        }
        return ans;
        }

// ---------- MAIN WITH USER INPUT ----------
public static void main(String[]args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m=sc.nextInt();

        System.out.print("Enter number of columns: ");
        int n=sc.nextInt();

        char[][]board=new char[m][n];

        System.out.println("\nEnter board (use X and .):");

        for(int i=0;i<m; i++){
        for(int j=0;j<n; j++){
        board[i][j]=sc.next().charAt(0);
        }
        }

        int result=countBattleships(board);
        System.out.println("\nNumber of Battleships = "+result);
        }
        }
