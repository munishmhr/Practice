public class Dj<T> {
    Map<T, D> mapping = new HashMap<>();
    class D {
        T data;
        D parent;
        public D(T data ){
            this.data = data;
            this.parent = this;
        }
        
    }
    public int size(){
        Set<T> set = new HashSet<>();
        for(D s : mapping.values()){
            set.add(findParent(s.data).data);
        }
        return set.size();
    }
    
    private void add(T num) {
        mapping.put(num, new D(num));
    }
    
    private D findParent(T num) {
        D set = mapping.get(num);
        if (set.data == set.parent.data) {
            return set;
        }
        return findParent(set.parent.data);
    }

    public void union(T num1, T num2) {
        if (!mapping.containsKey(num1)) add(num1);
        if (!mapping.containsKey(num2)) add(num2);
        D set1 = findParent(num1);
        D set2 = findParent(num2);
        if (set1.data != set2.data) {
            set1.parent = set2;
        }
    }
}
