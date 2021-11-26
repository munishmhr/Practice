//https://leetcode.com/problems/course-schedule-ii/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || numCourses == 0){
            return new int[]{};
        }
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : prerequisites){
            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            graph.put(edge[0] , list);
        }
        Set<Integer> takenCourses = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        LinkedList<Integer> result = new LinkedList<>();
        
        for(int i = 0; i < prerequisites.length ; ++i){
            if(!dfs(prerequisites[i][0] , graph , takenCourses , seen , result)){
               return new int[]{};  
            }
        }
        for(int i = 0 ; i < numCourses ; ++i){
            if(!takenCourses.contains(i)){
                result.addFirst(i);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
    
    private boolean dfs(int course , Map<Integer, List<Integer>> graph, Set<Integer> takenCourses ,Set<Integer> seen , List<Integer> result ){
        if(takenCourses.contains(course)){
            return true;
        }
        List<Integer> children = graph.get(course);
        seen.add(course);
        if(children != null){
            for(int i = 0 ; i < children.size() ; ++i){
                if(seen.contains(children.get(i))) return false;
                if(!dfs(children.get(i) , graph , takenCourses , seen , result)){
                   return false;
                }
            }
        }
        seen.remove(course);
        takenCourses.add(course);
        result.add(course);
        return true;
    }
}
