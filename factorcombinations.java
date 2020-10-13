//Java Solution

class Solution {
    public List<List<Integer>> getFactors(int n) {
        if (n <= 1) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        int product = 1;
        int index = 2;
        
        backtrack(temp, result, product, index, n);
        return result;
    }
    
    public void backtrack(LinkedList<Integer> temp, List<List<Integer>> result, int product, int index, int n) {
        if (product > n) {
            return;
        }
        
        if (product == n) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = index; i <= (n / product); i++) {
            if (n % i == 0 && n != i) {
                temp.add(i);
                backtrack(temp, result, product * i, i, n);
                temp.removeLast();
            }
        }
    }
}