class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Map<Integer, Integer> row[] = new HashMap[n]; 
        Map<Integer, Integer> col[] = new HashMap[n];
        Map<Integer, Integer> box[] = new HashMap[n];

        for(int i=0;i<n;i++){
            row[i] =  new HashMap<Integer,Integer>();
            col[i] = new HashMap<Integer,Integer>();
            box[i] = new HashMap<Integer,Integer>();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char ch = board[i][j];

                if(ch!='.'){
                    int num = ch-'0';
                    int boxIndex = (i/3)*3+(j/3);
                    row[i].put(num, row[i].getOrDefault(num,0)+1);
                    col[j].put(num, col[j].getOrDefault(num,0)+1);
                    box[boxIndex].put(num, box[boxIndex].getOrDefault(num,0)+1);
                    if(row[i].get(num)>1 || col[j].get(num)>1 || box[boxIndex].get(num)>1){
                    return false;
                }
                }

            }
        }
        return true;
    }
}