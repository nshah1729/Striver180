package Day_6;

public class f {
    public static void main(String[] args) {
        char[][] m=new char[3][3];
        String word="aba";
        System.out.println(exists(m,word));
    }

    private static boolean exists(char[][] m, String word){
        boolean res=false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(m[i][j]==word.charAt(0))
                    res=dfs(m,i,j,0,word);
                if(res)return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] m, int i, int j, int si, String word) {
        if(si==word.length())return true;
        m[i][j]='@';
        if(m[i][j]!='@') {
            //top
            if(m[i-1][j]==word.charAt(si))
            dfs(m, i, j, si+1, word);
            //left
            dfs(m, i, j, si+1, word);
            //bottom
            dfs(m, i, j, si+1, word);
            //right
            dfs(m, i, j, si+1, word);
        }
        return true;
    }
}
