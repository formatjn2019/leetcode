package leetcode._79_单词搜索;

public class ExistWord {
    public boolean exist(char[][] board, String word) {
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if (board[i][j]==word.charAt(0)){
                    if (existWord(board,new boolean[board.length][board[0].length],word,0,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean existWord(char[][]board,boolean [][]memory,String word,int index,int x,int y){
        if (index==word.length()){
            return true;
        }
        if (x<0 || x>=board.length || y<0 || y>=board[x].length){
            return false;
        }
        if (board[x][y]==word.charAt(index)&&!memory[x][y]){
            memory[x][y]=true;
            boolean result=existWord(board,memory,word,index+1,x,y+1)
                    || existWord(board,memory,word,index+1,x+1,y)
                    || existWord(board,memory,word,index+1,x,y-1)
                    || existWord(board,memory,word,index+1,x-1,y);
            if (result){
                return true;
            }
            memory[x][y]=false;
        }
        return false;
    }
    
    
    
    
    public static void main(String[] args) {
        ExistWord existWord = new ExistWord();
        char[][] chars = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(existWord.exist(chars, "ABCB"));
    }
}
