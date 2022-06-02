/*
--------- Question ---------

Conway's Game of Life takes place on an infinite two-dimensional board of square cells. Each cell is either dead or alive, and at each tick, the following rules apply:

Conditions
1. Any live cell with less than two live neighbours dies.
2. Any live cell with two or three live neighbours remains living.
3. Any live cell with more than three live neighbours dies.
4. Any dead cell with exactly three live neighbours becomes a live cell.
A cell neighbours another cell if it is horizontally, vertically, or diagonally adjacent.

Implement Conway's Game of Life. It should be able to be initialized with a starting list of live cell coordinates and the number of steps it should run for. Once initialized, it should print out the board state at each step. Since it's an infinite board, print out only the relevant coordinates, i.e. from the top-leftmost live cell to bottom-rightmost live cell.

You can represent a live cell with an 1 and a dead cell with a 0.

---------End Question----------
*/

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int rows = board.size(); 
        if(rows == 0) return; // edge case
        int cols = board[0].size();
        for(int i =0; i< rows; i++){
            for(int j=0; j< cols; j++){
                int change = check(i,j,board,rows,cols);
                // 0 to 0 is given by 2
                // 0 to 1 is given by 3
                // 1 to 0 is given by 4
                // 1 to 1 is given by 5
                if(change == 1 || change == 3){
                    // change to 0
                    if(board[i][j] == 0) board[i][j]  = 2;
                    if(board[i][j] == 1) board[i][j]  = 4;
                }else if (change == 2 || change  == 4){
                    // change to 1
                    if(board[i][j] == 0) board[i][j]  = 3;
                    if(board[i][j] == 1) board[i][j]  = 5;
                }
            }
        }
        for(int i =0; i< rows; i++){
            for(int j=0; j< cols; j++){
                // 0 to 0 is given by 2
                // 0 to 1 is given by 3
                // 1 to 0 is given by 4
                // 1 to 1 is given by 5
                
                switch (board[i][j]){
                    case 2:
                        board[i][j] = 0;
                        break;
                    case 3:
                        board[i][j] = 1;       
                        break;
                    case 4:
                        board[i][j] = 0;
                        break;
                    case 5:
                        board[i][j] = 1;
                        break;
                }
            }
        }
        
    }
    
    int check(int &i, int &j, vector<vector<int>>& board, int &rows, int &cols) {
        bool live = false;
        if(board[i][j] ==1) live =true;
        int liveNeighbors = getLiveNeighbors(i,j,board,rows,cols);
        
        // printf("live neighbors at %d %d are %d\n", i, j, liveNeighbors);
        if(live){
            if(liveNeighbors < 2) return 1;
            else if(liveNeighbors > 3) return 3;
            else return 2;
        }else{
            if(liveNeighbors == 3) return 4;
        }
        return 0;
    }
    
    int getLiveNeighbors(int &i, int &j, vector<vector<int>>& board, int &rows, int &cols ){
        vector<int> di {1,1,1,0,0,-1,-1,-1};
        vector<int> dj {-1,0,1,-1,1,-1,0,1};
        // 1,-1 ; 1,0; 1,1 down
        // 0,-1 ; 0,1 same line
        // -1,-1 ; -1,0; -1,1 up

        int liveNeighbors = 0;
        for(int k =0 ;k<8;k++){
            int ddi = i+di[k];
            int ddj = j+dj[k];
            if(ddi < 0 || ddj <0 || ddi >= rows || ddj >= cols) continue;
            else if(board[ddi][ddj] == 1 || board[ddi][ddj] == 4 || board[ddi][ddj] == 5) liveNeighbors++;
        }
        return liveNeighbors;
        
    }     
};
