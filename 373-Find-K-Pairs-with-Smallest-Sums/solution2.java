public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if(k<=0 || nums1.length * nums2.length ==0) return list;
        
        PriorityQueue<Data> pq = new PriorityQueue<>((x,y)-> x.val-y.val);
        pq.offer(new Data(0,0, nums1[0] + nums2[0]));

        while(k>0 && pq.size()>0){
            Data s = pq.poll();
            list.add(new int[]{nums1[s.u], nums2[s.v]});
            if(s.u<nums1.length-1 ){
                pq.add(new Data(s.u+1, s.v, nums1[s.u+1] + nums2[s.v]));
            }
            if(s.v<nums2.length-1 && s.u==0){
                pq.add(new Data(s.u, s.v+1, nums1[s.u]+nums2[s.v+1]));
            }
            k--;
        }
        return list;
    }
    
    private class Data{
        public int u;
        public int v;
        public int val;
        public Data(int i, int j, int val){
            u = i;
            v = j;
            this.val = val;
        }
    }
}