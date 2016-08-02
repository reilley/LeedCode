public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length==0|| matrix[0].length==0) return 0;
        if(k==1) return matrix[0][0];
        int m = matrix.length;
        int n = matrix[0].length;
        
        PriorityQueue<Node> pq = new PriorityQueue<>(m*n, (n1, n2) -> n1.val-n2.val);
        
        int[] dx = new int[]{1, 0};
        int[] dy = new int[]{0, 1};
        pq.add(new Node(0, 0, matrix[0][0]));
        
        boolean[][] visited = new boolean[m][n];
        
        int index = 1;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(index++ == k) return node.val;
            
            for(int i=0; i<dx.length; i++){
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];
                if(nx<m && ny<n && !visited[nx][ny]) {
                    pq.add(new Node(nx, ny, matrix[nx][ny]));
                    visited[nx][ny] = true;
                }
            }
        }
        
        return 0;
    }
    
    class Node{
        int x, y;
        int val;
        public Node(int xx, int yy, int v){
            x = xx;
            y = yy;
            val = v;
        }
    }
}