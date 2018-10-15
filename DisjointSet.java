import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    Map<Integer, Set> mapping = new HashMap<>();

    class Set {
        int data;
        Set parent;
    }

    public void add(int num) {
        Set set = new Set();
        set.data = num;
        set.parent = set;
        mapping.put(num, set);
    }

    public Set findParent(int num) {
        Set set = mapping.get(num);
        if (set.data == set.parent.data) {
            return set;
        }
        return findParent(set.parent.data);
    }

    public void union(int num1, int num2) {
        Set set1 = findParent(num1);
        Set set2 = findParent(num2);
        if (set1.data != set2.data) {
            set1.parent = set2;
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet();
        ds.add(1);
        ds.add(2);
        ds.add(3);
        ds.add(4);
        ds.add(5);
        ds.add(6);

        ds.union(1, 3);
        ds.union(4, 6);
        ds.union(2, 3);

        System.out.println(ds.findParent(1).data);
        System.out.println(ds.findParent(2).data);
        System.out.println(ds.findParent(3).data);
        System.out.println(ds.findParent(4).data);
        System.out.println(ds.findParent(5).data);
        System.out.println(ds.findParent(6).data);


    }
}
