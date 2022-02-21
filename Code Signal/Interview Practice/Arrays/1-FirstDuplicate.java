/*
 * first dup
 * Given an array a that contains only numbers in the range from 1 to a.length,
 * find the first duplicate number for which the second occurrence has the
 * minimal index. In other words, if there are more than 1 duplicated numbers,
 * return the number for which the second occurrence has a smaller index than
 * the second occurrence of the other number does. If there are no such
 * elements, return -1.
 */
int solution(int[] a) {
    HashSet<Integer> set = new HashSet<Integer>();
    
    for (int i=0; i<a.length; i++) {
        if (set.contains(a[i])) {
            return a[i];
        } else {
            set.add(a[i]);
        }
    }
    
    return -1;
    
}
