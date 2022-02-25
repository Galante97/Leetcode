/*
 * 2- isTreeSymmetric
 * Given a binary tree t, determine whether it is symmetric around its center,
 * i.e. each side mirrors the other.
 */
//
// Binary trees are already defined with this interface:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }
boolean solution(Tree<Integer> t) {
    return isSymmetric(t,t);

}

boolean isSymmetric(Tree<Integer> t1, Tree<Integer> t2) {
        if (t1 == null && t2 == null) { return true; }
        if (t1 == null || t2 == null) { return false; }
        
        //if not a leaf keep traversing
        return (t1.value.equals(t2.value)) &&
                isSymmetric(t1.left, t2.right) &&
                isSymmetric(t1.right, t2.left);

}
