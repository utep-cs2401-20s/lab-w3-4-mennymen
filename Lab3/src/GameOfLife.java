public class GameOfLife {
    int size = 0;
    int[][] board;
    int[][] previous;

    public GameOfLife(){
    }

    public GameOfLife(int size){
        this.size = size;
        this.board = new int[size][size];
        this.previous = new int[size][size];
    }

    public GameOfLife(int[][] board){
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

    public int[][] getPrevious() {
        return previous;
    }

    public void printBoard(){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length;j++){
                System.out.print(this.board[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void printPrevious(){
        for(int i = 0; i<previous.length; i++){
            for(int j = 0; j<previous[i].length;j++){
                System.out.print(this.previous[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void oneStep(){
        for(int i = 0; i<previous.length; i++){
            for(int j = 0; j<previous.length; j++){
                previous[i][j] = board[i][j];
            }
        }

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                if(this.neighbors(i,j) < 2 && previous[i][j] == 1)
                    board[i][j] = 0;

                else if(((this.neighbors(i,j) == 2) || (neighbors(i,j) == 3)) && previous[i][j] == 1)
                    continue;

                else if(this.neighbors(i,j) > 3 && previous[i][j] == 1)
                    board[i][j] = 0;

                else if(this.neighbors(i,j) == 3 && previous[i][j] == 0)
                    board[i][j] = 1;
            }
        }

    }

    public int neighbors(int row, int col){
        int aliveNeighbors = 0;

        //check up
        if((row > 0) && (previous[row - 1][col] == 1))
            aliveNeighbors++;

        //check down
        if((row < previous.length - 1) && (previous[row + 1][col] == 1))
            aliveNeighbors++;

        //check right
        if((col < previous.length - 1) && (previous[row][col + 1] == 1))
            aliveNeighbors++;

        //check left
        if((col > 0) && (previous[row][col - 1] == 1))
            aliveNeighbors++;

        //check upper right
        if((row > 0) && (col < previous.length - 1) && (previous[row - 1][col + 1] == 1))
            aliveNeighbors++;

        //check upper left
        if((row > 0) && (col > 0) && (previous[row - 1][col - 1] == 1))
            aliveNeighbors++;

        //check bottom right
        if((row < previous.length - 1) && (col < previous.length - 1) && (previous[row + 1][col + 1] == 1))
            aliveNeighbors++;

        //check bottom left
        if((row < previous.length - 1) && (col > 0) && (previous[row + 1][col - 1] == 1))
            aliveNeighbors++;

        return aliveNeighbors;
    }

    public void evolution(int n){
        if(n < 0){
            System.out.println("Use only positive integers");
            return;
        }
        System.out.println("Starting board");
        this.printBoard();
        for(int i = 1; i <= n; i++) {
            this.oneStep();
            System.out.println("Board at step: " + i);
            this.printBoard();
        }
    }
}
