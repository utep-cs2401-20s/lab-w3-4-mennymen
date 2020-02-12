public class TorusGameOfLife extends GameOfLife{

    public TorusGameOfLife(){
    }

    public TorusGameOfLife(int size){
        this.size = size;
        this.board = new int[size][size];
        this.previous = new int[size][size];
    }

    public TorusGameOfLife(int[][] board){
        this.size = board.length;
        this.board = new int[board.length][board.length];
        this.previous = new int[board.length][board.length];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                this.board[i][j] = board[i][j];
                this.previous[i][j] = board[i][j];
            }
        }
    }

    public int[][] getBoard() {
        return this.board;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int neighbors(int row, int col) {
        int aliveNeighbors = 0;

        //check up
        if((row > 0) && (previous[row - 1][col] == 1))
            aliveNeighbors++;
        else if((row == 0) && (previous[previous.length - 1][col] == 1))
            aliveNeighbors++;


        //check down
        if((row < previous.length - 1) && (previous[row + 1][col] == 1))
            aliveNeighbors++;
        else if((row == previous.length - 1) && (previous[0][col] == 1))
            aliveNeighbors++;


        //check right
        if((col < previous.length - 1) && (previous[row][col + 1] == 1))
            aliveNeighbors++;
        else if((col == previous.length - 1) && previous[row][0] == 1)
            aliveNeighbors++;


        //check left
        if((col > 0) && (previous[row][col - 1] == 1))
            aliveNeighbors++;
        else if((col == 0) && (previous[row][previous.length - 1] == 1))
            aliveNeighbors++;


        //check upper right
        if((row > 0) && (col < previous.length - 1) && (previous[row - 1][col + 1] == 1))
            aliveNeighbors++;
        //check the upper right value of the board
        else if((row == 0) && (col == previous.length - 1) && (previous[previous.length - 1][0] == 1))
            aliveNeighbors++;
        //check the upper row
        else if((row == 0) && (col < previous.length - 1) && (previous[previous.length - 1][col + 1] == 1))
            aliveNeighbors++;
        //checks the rightmost column
        else if((col == previous.length - 1) && (row > 0) && (previous[row - 1][0] == 1))
            aliveNeighbors++;


        //check upper left
        if((row > 0) && (col > 0) && (previous[row - 1][col - 1] == 1))
            aliveNeighbors++;
        //check the upper left value of the board
        else if((row == 0) && (col == 0) && (previous[previous.length - 1][previous.length - 1] == 1))
            aliveNeighbors++;
        //check the upper row
        else if((row == 0) && (col > 0) && (previous[previous.length - 1][col - 1] == 1))
            aliveNeighbors++;
        //check the leftmost column
        else if((col == 0) && (row > 0) && previous[row - 1][previous.length - 1] == 1)
            aliveNeighbors++;


        //check bottom right
        if((row < previous.length - 1) && (col < previous.length - 1) && (previous[row + 1][col + 1] == 1))
            aliveNeighbors++;
        //check the bottom right value of the board
        else if((row == previous.length - 1) && (col == previous.length - 1) && (previous[0][0] == 1))
            aliveNeighbors++;
        //check bottom row
        else if((row == previous.length - 1) && (col < previous.length - 1) && (previous[0][col + 1] == 1))
            aliveNeighbors++;
        //check rightmost column
        else if((col == previous.length - 1) && (row < previous.length - 1) && (previous[row + 1][0] == 1))
            aliveNeighbors++;


        //check bottom left
        if((row < previous.length - 1) && (col > 0) && (previous[row + 1][col - 1] == 1))
            aliveNeighbors++;
        //check the bottom left value of the board
        else if((row == previous.length - 1) && (col == 0) && (previous[0][previous.length - 1] == 1))
            aliveNeighbors++;
        //check bottom row
        else if((row == previous.length - 1) && (col > 0) && (previous[0][col - 1] == 1))
            aliveNeighbors++;
        //check leftmost column
        else if((col == 0) && (row < previous.length - 1) && (previous[row + 1][previous.length - 1] == 1))
            aliveNeighbors++;

        return aliveNeighbors;
    }
}
