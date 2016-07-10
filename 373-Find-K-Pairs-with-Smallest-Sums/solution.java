public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if(k<=0 || nums1.length * nums2.length ==0) return list;
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        PriorityQueue<Sum> pq = new PriorityQueue<>((x,y)-> x.val-y.val);
        pq.offer(new Sum(0,0, nums1[0] + nums2[0]));
        visited[0][0] = true;
        while(k>0 && pq.size()>0){
            Sum s = pq.peek();
            pq.poll();
            list.add(new int[]{nums1[s.u], nums2[s.v]});
            if(s.u<nums1.length-1 && !visited[s.u+1][s.v]){
                pq.add(new Sum(s.u+1, s.v, nums1[s.u+1] + nums2[s.v]));
                visited[s.u+1][s.v] = true;
            }
            if(s.v<nums2.length-1 && !visited[s.u][s.v+1]){
                pq.add(new Sum(s.u, s.v+1, nums1[s.u]+nums2[s.v+1]));
                visited[s.u][s.v+1] = true;
            }
            k--;
        }
        return list;
    }
    
    private class Sum{
        public int u;
        public int v;
        public int val;
        public Sum(int i, int j, int val){
            u = i;
            v = j;
            this.val = val;
        }
    }
}