/*
118. Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown
Example 1:
    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Constraints:
    1 <= numRows <= 30
*/

class Solution {
    //Time complexity : O(numRows^2) 
    //Space complexity : O(numRows^2)  Because we need to store each number that we update in triangle,
    // the space requirement is the same as the time complexity.

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        //base case
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        
        if (numRows == 1) {  return triangle; } 
        
        for (int i=2; i<=numRows; i++) { //iterate levels
            ArrayList<Integer> currRowList = new ArrayList<Integer>();
            int previousRowCount = i-1;
           
            currRowList.add(1);
            for (int k=0; k<previousRowCount; k++) { //iterate through previous level and add
                if (k+1 < triangle.get(triangle.size() -1).size()) {
                    // Add previous 2
                    int addition = triangle.get(triangle.size() -1).get(k) +
                                    triangle.get(triangle.size() -1).get(k + 1);

                    currRowList.add(addition);
                }
            }
            currRowList.add(1);
            triangle.add(currRowList);
        }
        return triangle;
    } 
    
}