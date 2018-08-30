/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
	/*
		Method 1: Recursion.
		
		Recursively search each subordinate and sum up all the importance value.
	*/
	
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        
        return helper(id, map);
    }
    
    private int helper(int id, HashMap<Integer, Employee> map) {
        Employee em = map.get(id);
        int sum = em.importance;
        
        if(em.subordinates != null && em.subordinates.size() > 0) {
            for(int sub : em.subordinates) {
                sum += helper(sub, map);
            }
        }
        
        return sum;
    }
}