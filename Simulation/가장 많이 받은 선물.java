import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer=0;
        int n=friends.length;
        
        // KEY POINT: 이름->인덱스 매핑
        HashMap<String,Integer> idx=new HashMap<>();
        for(int i=0;i<n;i++){
            idx.put(friends[i],i);
        }
        
        // i->j 준 횟수
        int[][] gift=new int[n][n];
        int[] give=new int[n];
        int[] take=new int[n];
        
        for(String s:gifts){
            String[] p=s.split(" ");
            int a=idx.get(p[0]);
            int b=idx.get(p[1]);
            
            gift[a][b]++;
            give[a]++;
            take[b]++;
        }
        
        int[] 선물지수=new int[n];
        for(int i=0;i<n;i++){
            선물지수[i]=give[i]-take[i];
        }
        
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(gift[i][j]>gift[j][i]){
                    cnt++;
                }else if(gift[i][j]==gift[j][i]){
                    if(선물지수[i]>선물지수[j]){
                        cnt++;
                    }
                }
            }
            answer=Math.max(answer,cnt);
        }
        
        return answer;
    }
}