class RandomizedCollection {
    List<Integer> list;
    
    // key : unique value
    // value: list of indexes respectively
    Map<Integer, Set<Integer>> map;
    Random rd;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rd = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        
        if (map.containsKey(val)) {
            map.get(val).add(list.size() - 1);
            return false;
        } else {
            Set<Integer> indexes = new HashSet<>();
            indexes.add(list.size() - 1);
            map.put(val, indexes);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Set<Integer> indexes = map.get(val);
            Iterator<Integer> itr = indexes.iterator();
            
            if (itr.hasNext()) {
                int valIndex = itr.next();
                
                // Condition 1: valIndex is the last index of list
                // Then, we just need to remove it from list and map.
                if (valIndex == list.size() - 1) {
                    indexes.remove(valIndex);
                    list.remove(list.size() - 1);
                } else {
                    // Condition 2: valIndex is not the last index of list
                    // Then, swap it with the last element of list.
                    // Remove the index record in map
                    // Update the index records of swapped element in map
                    // Remove the last element of list
                    
                    // remove index
                    indexes.remove(valIndex);
                    
                    int tailVal = list.get(list.size() - 1);
                    
                    Set<Integer> tailIndexes = map.get(tailVal);
                    
                    // swap valIndex and last element
                    list.set(valIndex, tailVal);
                    
                    // delete the last element in list
                    list.remove(list.size() - 1);

                    // update index
                    tailIndexes.remove(list.size());
                    tailIndexes.add(valIndex);
                }
                return true;
            } else {
                map.remove(val);
                return false;
            }
        } 
        return false;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int index = rd.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */