class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int l=1,r=100_000;
        while(l<=r){
            int m=(l+r)/2;
            if(solvePuzzle(diffs,times,m)<=limit){
                r=m-1;
            }else{
                l=m+1;
            }
        }
        
        return l;
    }
    
    
    public long solvePuzzle(int[] diffs, int[] times, int level){
        long cnt = 0;

        for(int i=0;i<diffs.length;i++){
            int diff=diffs[i];
            int time_cur=times[i];
            if(diff<=level){
                cnt+=times[i];
            }else{
                int time_prev = times[i - 1];
                cnt+=(diff-level)*(time_cur+time_prev)+time_cur;
            }
        }
        
        return cnt;
    }
}