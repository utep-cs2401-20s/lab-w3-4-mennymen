import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GOLTester {

    @Test
    public void neighbors1() {
        int[][] a = {
                {1,0,0},
                {1,0,1},
                {1,1,1}};
        GameOfLife sol = new GameOfLife(a);
        assertEquals(6, sol.neighbors(1,1));
    }


    @Test
    public void neighbors2() {
        int[][] a = {
                {1,0,0},
                {1,0,1},
                {1,1,1}};
        GameOfLife sol = new GameOfLife(a);
        assertEquals(3, sol.neighbors(0,1));
    }


    @Test
    public void neighbors3() {
        int[][] a = {
                {1,0,0,1},
                {1,0,1,0},
                {1,1,1,0},
                {0,1,1,0}};
        GameOfLife sol = new GameOfLife(a);
        assertEquals(1, sol.neighbors(0,3));
    }


    @Test
    public void neighbors4() {
        int[][] a = {
                {1,0,0,1},
                {1,1,1,1},
                {1,1,1,1},
                {0,1,1,1}};
        GameOfLife sol = new GameOfLife(a);
        assertEquals(8, sol.neighbors(2,2));
    }


    @Test
    public void neighbors5() {
        int[][] a = {
                {1,0,0,1},
                {0,0,0,1},
                {0,0,0,1},
                {0,0,0,1}};
        GameOfLife sol = new GameOfLife(a);
        assertEquals(0, sol.neighbors(2,1));
    }


    @Test
    public void neighborsTorus1() {
        int[][] a = {
                {1,0,0},
                {1,0,1},
                {1,1,1}};
        TorusGameOfLife sol = new TorusGameOfLife(a);
        assertEquals(6, sol.neighbors(1,1));
    }


    @Test
    public void neighborsTorus2() {
        int[][] a = {
                {1,0,0},
                {1,0,1},
                {1,1,1}};
        TorusGameOfLife sol = new TorusGameOfLife(a);
        assertEquals(6, sol.neighbors(0,1));
    }

    @Test
    public void neighborsTorus3() {
        int[][] a = {
                {1,0,0,1},
                {1,0,1,0},
                {1,1,1,0},
                {1,1,1,0}};
        TorusGameOfLife sol = new TorusGameOfLife(a);
        assertEquals(5, sol.neighbors(0,3));
    }


    @Test
    public void neighborsTorus4() {
        int[][] a = {
                {1,0,0,1},
                {1,1,1,1},
                {1,1,1,1},
                {0,1,1,1}};
        TorusGameOfLife sol = new TorusGameOfLife(a);
        assertEquals(7, sol.neighbors(2,0));
    }


    @Test
    public void neighborsTorus5() {
        int[][] a = {
                {1,0,0,1},
                {0,0,0,1},
                {0,0,0,1},
                {0,0,0,1}};
        TorusGameOfLife sol = new TorusGameOfLife(a);
        assertEquals(0, sol.neighbors(2,1));
    }

    @Test
    public void oneStep1() {

        int[][] a = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0}};

        GameOfLife game1 = new GameOfLife(a);
        game1.oneStep();
        int[][] board = game1.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {0, 0, 1, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 0, 1, 0, 0});
        assertArrayEquals(board[3], new int[] {0, 0, 1, 0, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0});
    }

    @Test
    public void oneStep2(){
        int[][] b = {
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,1,1,1,0},
                {0,1,1,1,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}};

        GameOfLife game2 = new GameOfLife(b);
        game2.oneStep();
        int[][] board = game2.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {0, 0, 0, 1, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 1, 0, 0, 1, 0});
        assertArrayEquals(board[3], new int[] {0, 1, 0, 0, 1, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 1, 0, 0, 0});
        assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
    }

    @Test
    public void oneStep3(){
        int[][] c = {
                {0,0,0,0,0,0},
                {0,1,1,0,0,0},
                {0,1,1,0,0,0},
                {0,0,0,1,1,0},
                {0,0,0,1,1,0},
                {0,0,0,0,0,0}};

        GameOfLife game3 = new GameOfLife(c);
        game3.oneStep();
        int[][] board = game3.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {0, 1, 1, 0, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 1, 0, 0, 0, 0});
        assertArrayEquals(board[3], new int[] {0, 0, 0, 0, 1, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 0, 1, 1, 0});
        assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
    }

    @Test
    public void oneStep4(){
        int[][] d = {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};



        TorusGameOfLife game4 = new TorusGameOfLife(d);
        game4.oneStep();
        int[][] board = game4.getBoard();
        assertArrayEquals(board[0], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[1], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[2], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[3], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[4], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[5], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[6], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[7], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[8], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[9], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[10], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[11], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[12], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[13], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[14], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[15], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[16], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[17], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[18], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    }

    @Test
    public void oneStep5(){
        int[][] e = {
                {0,0,0,0,0,0},
                {0,0,1,0,0,0},
                {0,0,1,0,0,0},
                {0,0,1,0,0,0},
                {0,0,1,0,0,0},
                {0,0,0,0,0,0}};

        GameOfLife game5 = new GameOfLife(e);
        game5.oneStep();
        int[][] board = game5.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 1, 1, 1, 0, 0});
        assertArrayEquals(board[3], new int[] {0, 1, 1, 1, 0, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
    }

    @Test
    public void oneStepTorus1() {

        int[][] a = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {1,1,0,0,1},
                {0,0,0,0,0},
                {0,0,0,0,0}};

        TorusGameOfLife game1 = new TorusGameOfLife(a);
        game1.oneStep();
        int[][] board = game1.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {1, 0, 0, 0, 0});
        assertArrayEquals(board[2], new int[] {1, 0, 0, 0, 0});
        assertArrayEquals(board[3], new int[] {1, 0, 0, 0, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0});
    }

    @Test
    public void oneStepTorus2(){
        int[][] b = {
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {1,0,0,0,1,1},
                {0,0,0,1,1,1},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}};

        TorusGameOfLife game2 = new TorusGameOfLife(b);
        game2.oneStep();
        int[][] board = game2.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {0, 0, 0, 0, 0, 1});
        assertArrayEquals(board[2], new int[] {1, 0, 0, 1, 0, 0});
        assertArrayEquals(board[3], new int[] {1, 0, 0, 1, 0, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 1, 0});
        assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
    }

    @Test
    public void oneStepTorus3(){
        int[][] c = {
                {1,1,0,0,0,0},
                {1,1,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,1,1},
                {0,0,0,0,1,1}};

        TorusGameOfLife game3 = new TorusGameOfLife(c);
        game3.oneStep();
        int[][] board = game3.getBoard();
        assertArrayEquals(board[0], new int[] {0, 1, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {1, 1, 0, 0, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[3], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 1, 1});
        assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 1, 0});
    }

    @Test
    public void oneStepTorus4(){
        int[][] d = {
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},};

        TorusGameOfLife game4 = new TorusGameOfLife(d);
        game4.oneStep();
        game4.printBoard();
        int[][] board = game4.getBoard();
        assertArrayEquals(board[0], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[1], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[2], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[3], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[4], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[5], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[6], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[7], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[8], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[9], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[10], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[11], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[12], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[13], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[14], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[15], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[16], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[17], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[18], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    }

    @Test
    public void oneStepTorus5(){
        int[][] e = {
                {0,0,0,0,0,0},
                {0,0,0,0,0,1},
                {0,0,0,0,0,1},
                {0,0,0,0,0,1},
                {0,0,0,0,0,1},
                {0,0,0,0,0,0}};

        TorusGameOfLife game5 = new TorusGameOfLife(e);
        game5.oneStep();
        int[][] board = game5.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[2], new int[] {1, 0, 0, 0, 1, 1});
        assertArrayEquals(board[3], new int[] {1, 0, 0, 0, 1, 1});
        assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
    }

    @Test
    public void evolution1() {

        int[][] a = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0}};

        GameOfLife game1 = new GameOfLife(a);
        game1.evolution(5);
        int[][] board = game1.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {0, 0, 1, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 0, 1, 0, 0});
        assertArrayEquals(board[3], new int[] {0, 0, 1, 0, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0});
    }

    @Test
    public void evolution2(){
        int[][] b = {
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,1,1,1,0},
                {0,1,1,1,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}};

        GameOfLife game2 = new GameOfLife(b);
        game2.evolution(5);
        int[][] board = game2.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {0, 0, 0, 1, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 1, 0, 0, 1, 0});
        assertArrayEquals(board[3], new int[] {0, 1, 0, 0, 1, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 1, 0, 0, 0});
        assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
    }

    @Test
    public void evolution3(){
        int[][] c = {
                {0,0,0,0,0,0},
                {0,1,1,0,0,0},
                {0,1,1,0,0,0},
                {0,0,0,1,1,0},
                {0,0,0,1,1,0},
                {0,0,0,0,0,0}};

        GameOfLife game3 = new GameOfLife(c);
        game3.evolution(5);
        int[][] board = game3.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {0, 1, 1, 0, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 1, 0, 0, 0, 0});
        assertArrayEquals(board[3], new int[] {0, 0, 0, 0, 1, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 0, 1, 1, 0});
        assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
    }

    @Test
    public void evolution4(){
        int[][] d = {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};



        TorusGameOfLife game4 = new TorusGameOfLife(d);
        game4.evolution(15);
        int[][] board = game4.getBoard();
        assertArrayEquals(board[0], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[1], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[2], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[3], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[4], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[5], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[6], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[7], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[8], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[9], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[10], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[11], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[12], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[13], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[14], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[15], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[16], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[17], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[18], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    }

    @Test
    public void evolution5(){
        int[][] e = {
                {0,0,0,0,0,0},
                {0,0,1,0,0,0},
                {0,0,1,0,0,0},
                {0,0,1,0,0,0},
                {0,0,1,0,0,0},
                {0,0,0,0,0,0}};

        GameOfLife game5 = new GameOfLife(e);
        game5.evolution(5);
        int[][] board = game5.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {0, 0, 1, 0, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 1, 0, 1, 0, 0});
        assertArrayEquals(board[3], new int[] {0, 1, 0, 1, 0, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 1, 0, 0, 0});
        assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
    }

    @Test
    public void evolution6(){
        int[][] e = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,1,1,1,1,0,0,0,0},
                {0,1,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0},
                {0,1,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}};

        GameOfLife game6 = new GameOfLife(e);
        game6.evolution(18);
        int[][] board = game6.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[3], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0, 0, 1, 0, 0, 0});
        assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 1, 0, 0, 0, 0});
        assertArrayEquals(board[6], new int[] {0, 0, 0, 0, 0, 1, 1, 1, 0, 0});
        assertArrayEquals(board[7], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[8], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[9], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }



    @Test
    public void evolutionTorus1() {

        int[][] a = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {1,0,0,1,1},
                {0,0,0,0,0},
                {0,0,0,0,0}};

        TorusGameOfLife game1 = new TorusGameOfLife(a);
        game1.evolution(5);
        int[][] board = game1.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {0, 0, 0, 0, 1});
        assertArrayEquals(board[2], new int[] {0, 0, 0, 0, 1});
        assertArrayEquals(board[3], new int[] {0, 0, 0, 0, 1});
        assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0});
    }

    @Test
    public void evolutionTorus2(){
        int[][] b = {
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {1,1,0,0,0,1},
                {1,0,0,0,1,1},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}};

        TorusGameOfLife game2 = new TorusGameOfLife(b);
        game2.evolution(5);
        int[][] board = game2.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {1, 0, 0, 0, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 1, 0, 0, 1, 0});
        assertArrayEquals(board[3], new int[] {0, 1, 0, 0, 1, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0, 1});
        assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
    }

    @Test
    public void evolutionTorus3(){
        int[][] c = {
                {1,1,0,0,0,0},
                {1,1,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,1,1},
                {0,0,0,0,1,1}};

        TorusGameOfLife game3 = new TorusGameOfLife(c);
        game3.evolution(5);
        int[][] board = game3.getBoard();
        assertArrayEquals(board[0], new int[] {0, 1, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {1, 1, 0, 0, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[3], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 1, 1});
        assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 1, 0});
    }

    @Test
    public void evolutionTorus4(){
        int[][] d = {

                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},};

        TorusGameOfLife game4 = new TorusGameOfLife(d);
        game4.evolution(15);
        int[][] board = game4.getBoard();
        assertArrayEquals(board[0], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[1], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[2], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[3], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[4], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[5], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[6], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[7], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[8], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[9], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[10], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[11], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[12], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[13], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[14], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[15], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[16], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[17], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
        assertArrayEquals(board[18], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
    }

    @Test
    public void evolutionTorus5(){
        int[][] e = {
                {0,0,1,0,0,0},
                {0,0,1,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,1,0,0,0},
                {0,0,1,0,0,0}};

        TorusGameOfLife game5 = new TorusGameOfLife(e);
        game5.evolution(5);
        int[][] board = game5.getBoard();
        assertArrayEquals(board[0], new int[] {0, 1, 0, 1, 0, 0});
        assertArrayEquals(board[1], new int[] {0, 0, 1, 0, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[3], new int[] {0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[4], new int[] {0, 0, 1, 0, 0, 0});
        assertArrayEquals(board[5], new int[] {0, 1, 0, 1, 0, 0});
    }

    @Test
    public void evolutionTorus6(){
        int[][] e = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,1,1,1,1,0,0,0,0},
                {0,1,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,1,0,0,0,0},
                {0,1,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}};

        TorusGameOfLife game6 = new TorusGameOfLife(e);
        game6.evolution(18);
        int[][] board = game6.getBoard();
        assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[1], new int[] {1, 0, 0, 1, 0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[2], new int[] {0, 0, 0, 0, 1, 0, 0, 0, 0, 0});
        assertArrayEquals(board[3], new int[] {1, 0, 0, 0, 1, 0, 0, 0, 0, 0});
        assertArrayEquals(board[4], new int[] {0, 1, 1, 1, 1, 0, 0, 0, 0, 0});
        assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[6], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[7], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[8], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertArrayEquals(board[9], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }
}

