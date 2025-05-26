

public class Tour{
    private int moveNum = 1;
    private int[][] board = new int[8][8];
    private int xPos;
    private int yPos;

    public Tour(){
        xPos = 0;
        yPos = 0;
        board[xPos][yPos] = 1;
    }

    public boolean moveCheck(int changeX, int changeY){
        int newX = xPos + changeX;
        int newY = yPos + changeY;
        return((board[newX][newY] == 0) && ((newX > 0) && (newX < 8)) && ((newY > 0) && (newY < 8)));
    }

    public void printBoard(){
        for(int[] row : board){
            for(int square : row){
                System.out.println(square + " ");
            }
            System.out.println("");
        }
    }

    public int[][] getBoard(){
        return board;
    }

    public boolean knightsTour(int startX, int startY){
        board[startX][startY] = 1;
        if (moveNum == 64){
            return true;
        }
        else{
            int[][] posMoves = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
            for (int[] move : posMoves){
                if(moveCheck(move[0], move[1])){
                    xPos += move[0];
                    yPos += move[1];
                    moveNum++;
                    board[xPos][yPos] = moveNum;
                    if (knightsTour(xPos, yPos)){
                        return true;
                    }
                    else{
                        board[xPos][yPos] = 0;
                        xPos -= move[0];
                        yPos -= move[1];
                        moveNum--;
                    }
                }
            }
            return false;
        }
    }


    
}