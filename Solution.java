import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static boolean shouldVisit(boolean[][] visited,int row,int col,int ROW,int COL){
        System.out.println("in if should visit with operands" + Integer.toString(row)+' '+Integer.toString(col)+' '+Integer.toString(ROW)+' '+Integer.toString(COL));

        if((row>=0)&&(col>=0)&&(row<ROW)&&(col<COL)){
            System.out.println("in if should visit returning"+Boolean.toString(!visited[row][col]));
            return (!visited[row][col]);
        }else{
            System.out.println("in should visit returning"+Boolean.toString(false));
            return false;
        }
    }
    public static int countConnected(int[][] matrix,boolean[][] visited,int row,int col,int ROW,int COL){
        System.out.println("in count connected with the following operands" + Integer.toString(row)+Integer.toString(col));
        int count= 1;
        if(visited[row][col]|| matrix[row][col]==0){
            System.out.println("in if count connected returning 0");
            return 0;
        }
        else{
            visited[row][col]=true;
            int rows[]={-1,-1,-1,0,0,1,1,1};
            int cols[]={-1,0,1,-1,1,-1,0,1};
            for(int z=0;z<8;z++){
                 System.out.println("in for loop");
                if(shouldVisit(visited,row+rows[z],col+cols[z],ROW,COL)){
                    System.out.println("in if with the following operands" + Integer.toString(row+rows[z])+Integer.toString(col+cols[z]));
                    
                    count+=countConnected(matrix,visited,row+rows[z],col+cols[z],ROW,COL);
                }
            }
            System.out.println("in end of count connected and returning" + Integer.toString(count));
            return count;
        }
    }
    public static int getBiggestRegion(int[][] matrix, boolean[][] visited,int row, int col) {
        int max=0;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                count=countConnected(matrix,visited,i,j,row,col);
                if(count>max){
                    max=count;
                }
            }
        }
            
        return max;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        boolean visited[][]= new boolean[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                visited[grid_i][grid_j] = false;
            }
        }
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid,visited,n,m));
    }
}
