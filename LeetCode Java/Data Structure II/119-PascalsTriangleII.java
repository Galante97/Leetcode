/*
119. Pascal's Triangle II
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown
Example 1:
    Input: rowIndex = 3
    Output: [1,3,3,1]
*/

class Solution {
    //Time Complexity: O(n^2)
    //Space Complexity O(n) 
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) { return new ArrayList<Integer>(){{ add(1); }}; }
        
        //Initial set up
        Integer[] arr = new Integer[rowIndex+1];
        arr[0] = 1;
        arr[1] = 1;
        
        //loop to go through pascals triangle, editing same array
        int currLength = 1;
        while(currLength < rowIndex) {
            int counter = currLength;
            arr[counter+1] = 1; //add new 1
            
            for (int i=counter; i>0; i--) {
                arr[i] = arr[i] + arr[i-1]; //add previous 2
                counter--;
            }
            
            currLength++;
            
        }
        
        return Arrays.asList(arr);
    }
}