package com.sgmarghade.dsalgo.dp;

/**
 * Created by swapnil on 03/10/16.
 */
public class Chess {
    public static void main(String[] args){
        System.out.println(new Chess().run(5,6));
    }



    /**
     * Type : DP.
     * Given Metrics find out if row,col cell is reachable by knight (horse) from 0,0 cell. is same as find out if 0,0 reachable from row,col

     * @return
     */
    public int run(int row, int col){
        int rows = row+3;
        int columns = col+3;

        int[][] board = new int[rows][columns];

        //Vertical up right

        checkAndMark(row,col,rows,columns,board,-1,row,col);

        for(int i = 0;i<rows;i++){
            for(int j = 0; j< columns;j++){
                System.out.print(board[i][j]+",");
            }
            System.out.println("");
        }
        return board[0][0];
    }

    public void checkAndMark(int row,int col,int rows,int columns, int[][] board,int currentValue,int originalRow,int originalCol){
        board[row][col] = currentValue + 1;

        //Vertical up right

        if(row - 2 >= 0 && col + 1 <= columns-1 && ( board[row - 2 ][col+1] == 0 ||  board[row - 2 ][col+1] > currentValue + 2) && !(row-2 == originalRow && col + 1 == originalCol)){
            checkAndMark(row-2,col+1,rows,columns,board,currentValue + 1,originalRow,originalCol);
        }

        //Vertical up left

        if(row - 2 >= 0 && col - 1 >= 0 && ( board[row - 2 ][col-1] == 0 || board[row - 2 ][col-1] > currentValue + 2 )  && !(row-2 == originalRow && col - 1 == originalCol)){
            checkAndMark(row-2,col-1,rows,columns,board,currentValue + 1,originalRow,originalCol);
        }


        //Vertical down right

        if(row + 2 <= rows - 1 && col + 1 <= columns-1 && ( board[row + 2 ][col+1] == 0 || board[row + 2 ][col+1] > currentValue + 2)  && !(row+2 == originalRow && col + 1 == originalCol)){
            checkAndMark(row+2,col+1,rows,columns,board,currentValue + 1,originalRow,originalCol);
        }

        //Vertical down left
        if(row + 2 <= rows - 1 && col - 1 >= 0 && ( board[row + 2 ][col - 1] == 0 || board[row + 2 ][col - 1] > currentValue + 2 )  && !(row + 2 == originalRow && col - 1 == originalCol)){
            checkAndMark(row+2,col - 1,rows,columns,board,currentValue + 1,originalRow,originalCol);
        }


        //Horizontal right up
        if(col + 2 <= columns - 1 && row - 1 >= 0 && ( board[row - 1][col+2] == 0 || board[row - 1][col+2] > currentValue + 2)  && !(row-1 == originalRow && col + 2 == originalCol) ){
            checkAndMark(row - 1, col + 2, rows,columns,board,currentValue + 1,originalRow,originalCol);
        }

        //Horizontal right down
        if(col + 2 <= columns - 1 && row + 1 <= rows - 1 && ( board[row + 1][col+2] == 0 || board[row + 1][col+2] > currentValue + 2)  && !(row + 1 == originalRow && col + 2 == originalCol) ){
            checkAndMark(row + 1, col + 2, rows,columns,board,currentValue + 1,originalRow,originalCol);
        }


        //Horizontal left up
        if(col - 2 >= 0 && row - 1 >= 0 && ( board[row - 1][col - 2] == 0  || board[row - 1][col - 2]  > currentValue + 2)  && !(row-1 == originalRow && col - 2 == originalCol)){
            checkAndMark(row - 1, col -  2, rows,columns,board,currentValue + 1,originalRow,originalCol);
        }

        //Horizontal left down
        if(col - 2 >= 0 && row + 1 <= rows - 1 && ( board[row + 1][col - 2] == 0 || board[row + 1][col - 2] > currentValue + 2 )  && !(row + 1 == originalRow && col - 2 == originalCol) ){
            checkAndMark(row + 1, col -  2, rows,columns,board,currentValue + 1,originalRow,originalCol);
        }

    }
}
