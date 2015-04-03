import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dimension = input.nextInt();
        
        int[][] grid = new int[dimension][dimension];
        
        for(int i = 0; i < dimension; i++){
            String a = input.next();
            for(int j = 0; j < dimension; j++){
                
                grid[i][j] = (int)a.charAt(j)-'0';
            }
        }
        
        boolean[][] cavity = new boolean[dimension][dimension];
        
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                if(cavitySeeker(grid, i, j)){
                    cavity[i][j] = true;
                }
                else cavity[i][j] = false;
            }
        }
        
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                if(cavity[i][j]){
                    System.out.print("X");
                }
                else System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        
        
    }
    
    static boolean cavitySeeker(int[][] grid, int x, int y){
        if(x == 0 && y ==0){
            return topLeftCorner(grid);
        }
        else if(x == 0 && y == grid.length - 1) return topRightCorner(grid);
        else if(x == grid.length - 1 && y == 0) return bottomLeftCorner(grid);
        else if(x == grid.length - 1 && y == grid.length - 1) return bottomRightCorner(grid);
        else if(x == 0) return topSide(grid, x, y);
        else if(x == grid.length - 1) return bottomSide(grid, x, y);
        else if(y == 0) return leftSide(grid, x, y);
        else if(y == grid.length - 1) return rightSide(grid, x, y);
        else if(grid[x - 1][y] < grid[x][y] && grid[x + 1][y] < grid[x][y] && grid[x][y + 1] < grid[x][y] && grid[x][y - 1] < grid[x][y]){
            return true;}
        else return false;
        
    }
    
    static boolean topLeftCorner(int [][] grid){
        if(grid[0][1] < grid[0][0] && grid[1][0] < grid[0][0]){
            return true;}
        else return false;
    }   
    
    static boolean topRightCorner(int [][] grid){
        if(grid[0][grid.length - 2] < grid[0][grid.length - 1] && grid[1][grid.length - 1] < grid[0][grid.length - 1]){
            return true;
        } else return false;
    }
    
    static boolean bottomLeftCorner(int [][] grid){
        if(grid[grid.length - 2][0] < grid[grid.length - 1][0] && grid[grid.length - 1][1] < grid[grid.length - 1][0]){
            return true;}
        else return false;
    }   
    
    static boolean bottomRightCorner(int [][] grid){
        if(grid[grid.length - 1][grid.length - 2] < grid[grid.length - 1][grid.length - 1] && grid[grid.length - 2][grid.length - 1] < grid[grid.length - 1][grid.length - 1]){
            return true;
        } else return false;
    }
    
    static boolean topSide(int [][] grid, int x, int y){
        if(grid[0][y - 1] < grid[x][y] && grid[0][y + 1] < grid[x][y] && grid[x - 1][y] < grid[x][y]){
            return true;
        }   else return false;
    } 
    
    static boolean bottomSide(int [][] grid, int x, int y){
        if(grid[x][y - 1] < grid[x][y] && grid[x][y + 1] < grid[x][y] && grid[x + 1][y] < grid[x][y]){
            return true;
        }   else return false;
    } 
    
    static boolean leftSide(int [][] grid, int x, int y){
        if(grid[x - 1][y] < grid[x][y] && grid[x][y + 1] < grid[x][y] && grid[x + 1][y] < grid[x][y]){
            return true;
        }   else return false;
    } 
    
    static boolean rightSide(int [][] grid, int x, int y){
        if(grid[x - 1][y] < grid[x][y] && grid[x][y - 1] < grid[x][y] && grid[x + 1][y] < grid[x][y]){
            return true;
        }   else return false;
    } 
}
