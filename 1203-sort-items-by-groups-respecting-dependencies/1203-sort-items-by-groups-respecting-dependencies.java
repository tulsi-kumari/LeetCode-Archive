class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = groupId++;
            }
        }
        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        int[] itemIndegree = new int[n];
        for (int i = 0; i < n; ++i) {
            itemGraph.put(i, new ArrayList<>());
        }
        
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        int[] groupIndegree = new int[groupId];
        for (int i = 0; i < groupId; ++i) {
            groupGraph.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {
                itemGraph.get(prev).add(i);
                itemIndegree[i]++;
                if (group[i] != group[prev]) {
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }
        List<Integer> itemOrder = topologicalSort(itemGraph, itemIndegree);
        List<Integer> groupOrder = topologicalSort(groupGraph, groupIndegree);
        
        if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
            return new int[0];
        }
        Map<Integer, List<Integer>> orderedGroups = new HashMap<>();
        for (Integer item : itemOrder) {
            orderedGroups.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }
        
        List<Integer> answerList = new ArrayList<>();
        for (int groupIndex : groupOrder) {
            answerList.addAll(orderedGroups.getOrDefault(groupIndex, new ArrayList<>()));
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] indegree) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i<indegree.length;i++) {
            if (indegree[i] == 0) {
                stack.add(i);
            }
        }
        
        while (!stack.isEmpty()) {
            Integer curr = stack.pop();
            visited.add(curr);
            
            for (Integer n : graph.get(curr)) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    stack.add(n);
                }
            }
        }

        return visited.size() == graph.size() ? visited : new ArrayList<>();
    }
    
//     HashMap<Integer,Integer> itemGroups;
//     HashMap<Integer,ArrayList<Integer>> groupmap;
//     int[] ans;
//     HashMap<Integer,HashMap<Integer,ArrayList<Integer>>> itemGraph;
//     ArrayList<ArrayList<Integer>> groupGraph;
    
    
    
//     public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
//         //to store answer order
//         ans=new int[n];
//         //to store mapping of groups with adjacency graph of its constituting items
//         itemGraph=new HashMap<>();
//         //store mapping of items with their groups
//         itemGroups=new HashMap<>();
//         //to store group graphs
//         groupGraph=new ArrayList<>();
        
        
//         for(int i=0;i<n;i++)
//         {
//            itemGroups.put(i,group[i]);
//         }
        
//         //to store all items of a particular group
//         groupmap=new HashMap<>();
//         for(int i=0;i<m;i++)
//         {
//             groupmap.put(i,new ArrayList<Integer>());
//         }
//         groupmap.put(-1,new ArrayList<Integer>());
//         for(int i=0;i<n;i++)
//         {
//             ArrayList<Integer> groupmem=groupmap.get(group[i]);
//             groupmem.add(i);
//         }
        
        
//         for(int i=0;i<m;i++)
//         {
//             groupGraph.add(new ArrayList<>());
//         }
//         itemGraph.put(-1,new HashMap<Integer,ArrayList<Integer>>());
//         for(int i=0;i<m;i++)
//         {
//             itemGraph.put(i,new HashMap<Integer,ArrayList<Integer>>());
//             HashMap<Integer,ArrayList<Integer>> adj=itemGraph.get(i);
//             ArrayList<Integer> items=groupmap.get(i);
            
//             for(int j=0;j<items.size();j++)
//             {
//                 int item=items.get(i);
//                 adj.put(item,new ArrayList<>());
//             }
//         }
        
        
//         for(int i=0;i<n;i++)
//         {
//             List<Integer> list=beforeItems.get(i);
//             if(list.size()==0)
//             {
//                 continue;
//             }
//             for(int j=0;j<list.size();j++)
//             {
//                  int dependedon=list.get(j);
//                  int currgroup=itemGroups.get(i);
//                  if(groupmap.get(currgroup).contains(dependedon))
//                  {
//                      itemGraph.get(currgroup).get(i).add(dependedon);
//                  }else
//                  {
//                      int targetgroup=itemGroups.get(dependedon);
//                      groupGraph.get(i).add(targetgroup);
//                  }
//             }
//         }
        
//         System.out.println(itemGraph);
//         System.out.println(groupGraph);
//         return ans;
//     }
    
}