/*
 * 5 - swapLexOrder
 * Given a string str and array of pairs that indicates which indices in the
 * string can be swapped, return the lexicographically largest string that
 * results from doing the allowed swaps. You can swap indices any number of
 * times.
 */
String solution(String str, int[][] pairs) {
    Map<Integer, Set<Integer>> neighbours = new HashMap<>();
    for (int[] pair : pairs) {
        Set<Integer> l0 = neighbours.get(pair[0]);
        Set<Integer> l1 = neighbours.get(pair[1]);
        if (l0 == null) {
            l0 = l1 == null ? new TreeSet<>() : l1;
        } else if (l1 != null) {
            Set<Integer> fl0 = l0;
            l1.forEach(i -> neighbours.put(i, fl0));
            l0.addAll(l1);
        }
        l0.add(pair[0]);
        l0.add(pair[1]);
        neighbours.put(pair[0], l0);
        neighbours.put(pair[1], l0);
    }
    StringBuilder sb = new StringBuilder(str);
    for (Set<Integer> set : new HashSet<>(neighbours.values())) {
        System.out.println(set);
        Iterator<Character> c = set.stream().map(i -> str.charAt(i - 1)).sorted(Comparator.reverseOrder()).iterator();
        set.forEach(i -> sb.setCharAt(i - 1, c.next()));
    }
    return sb.toString();
}
