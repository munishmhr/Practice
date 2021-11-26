//https://leetcode.com/problems/graph-valid-tree/
class Solution {
    public boolean validTree(int n, int[][] edges) {
        DS ds = new DS(n);
        for(int[] edge : edges){
            // In case both edges alreay exist either they should be pointed to themself. If they are already pointed to same parent and they are adding
            // another edge between them that means its an circle
            if(ds.findParent(edge[0]).val == ds.findParent(edge[1]).val){
                return false;
            }
            ds.union(edge[0], edge[1]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; ++i){
            set.add(ds.findParent(i).val);
        }
        return set.size() == 1;
    }
    
     class DS{
        class Sets{
            int val;
            Sets parent;
            public Sets(int x){
                this.val = x;
                this.parent = this;
            }
        }
        private Map<Integer, Sets> forest = new HashMap<>();
        
        public DS(int n){
            for(int i = 0 ; i < n ; ++i){
                forest.put(i , new Sets(i));
            }
        }
        
        public Sets findParent(int x){
            if(!forest.containsKey(x)) return null;
            if(forest.get(x).val == forest.get(x).parent.val){
                return forest.get(x);
            }
            forest.get(x).parent = findParent(forest.get(x).parent.val);
            return forest.get(x).parent;
        }
        
        public void union(int x , int y){
            Sets s1 = findParent(x);
            Sets s2 = findParent(y);
            if(s1.val != s2.val){
                s1.parent = s2.parent;
            }
        }
    }
}
