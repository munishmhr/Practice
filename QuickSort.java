class Solution {
    private int[] nums;
    private int k;
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        this.k = nums.length - k;
        return quickSelect(0 , nums.length - 1 );
    }
    
    public int quickSelect(int s , int e){
        int index = partition(s , e);
        if(index == k){
            return nums[k];
        }
        if(index < k){
           return quickSelect(index+1 , e);
        }
        return quickSelect( s , index-1);
        
    }
    
    private int partition(int i , int e){
        int p = e;
        int j = i-1;
        while(i <= e-1){
            if(nums[i] < nums[p]){
                ++j;
                swap(i , j);
            }
            ++i;
        }
        ++j;
        swap( j, p);
        return j;
    }
    
    private void swap(int i , int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
