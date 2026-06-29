import java.util.*;

class Solution {
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};
    
    int m;
    int n;
    int[][] picture;
    
    public int[] solution(int m, int n, int[][] picture) {
        this.m=m;
        this.n=n;
        this.picture=picture;
        
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]>0){
                    int areaSize=bfs(i,j);
                    numberOfArea++;
                    maxSizeOfOneArea=Math.max(maxSizeOfOneArea,areaSize);
                }
            }
        }
        
        return new int[]{numberOfArea,maxSizeOfOneArea};
    }
    
    public int bfs(int x,int y){
        Queue<int[]> q=new LinkedList<>();
        int color=picture[x][y];
        // 넓이 1로 초기화
        int areaSize=1;
        // 큐 삽입
        q.offer(new int[]{x,y});
        // 방문 표시
        picture[x][y]=0;
        
        // 반복문으로 너비우선탐색 방문 후 영역 0으로 변경
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int cx=cur[0];
            int cy=cur[1];
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                
                // 영역 밖
                if(nx<0||nx>=m||ny<0||ny>=n){
                    continue;
                }
                // 다른 색
                if(picture[nx][ny]!=color){
                    continue;
                }
                
                q.offer(new int[]{nx,ny});
                picture[nx][ny]=0;
                
                // 방문 시 넓이 1 추가
                areaSize++;
            }
        }
        return areaSize;
    }
}