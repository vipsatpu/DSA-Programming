public class FloydWarshall {
    public int[][] solve(int[][] A) {
        int r=A.length,c=A[0].length;
//copy the initial state
        int[][] ans=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(A[i][j]==-1){
                    ans[i][j]=(int)(1e9);
                }
                else if(i==j){
                    ans[i][j]=0;
                }
                else{
                    ans[i][j]=A[i][j];
                }
            }
        }
        for(int k=0;k<r;k++){
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(i==j){
                        continue;
                    }
                    else{
                        ans[i][j]=Math.min(ans[i][j],ans[i][k]+ans[k][j]);
                    }
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(ans[i][j]==(int)(1e9)){
                    ans[i][j]=-1;
                }
            }
        }
        return ans;
    }
}
