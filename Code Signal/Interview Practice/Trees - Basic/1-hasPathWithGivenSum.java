/*
 * 1 - hasPathWithGivenSum
 * Given a binary tree t and an integer s, determine whether there is a root to
 * leaf path in t such that the sum of vertex values equals s.
 */
//
// Definition for binary tree:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }
boolean solution(Tree<Integer> t, int s) {
    //If just one of left or right was null, then it was not a child node and false can be returned safely
    if(t == null) return false;
    
    //If this is a child AND sum is input, then we have a path
    if(t.left == null && t.right == null) {
        return (s == t.value);
    }
    
    return solution(t.left, s-t.value) || solution(t.right, s-t.value);
}
