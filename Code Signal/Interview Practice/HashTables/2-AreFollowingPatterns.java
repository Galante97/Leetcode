/*
 * 2 - Are Following patterns
 * Given an array strings, determine whether it follows the sequence given in
 * the patterns array. In other words, there should be no i and j for which
 * strings[i] = strings[j] and patterns[i] ≠ patterns[j] or for which strings[i]
 * ≠ strings[j] and patterns[i] = patterns[j].
 * 
 * Example
 * 
 * For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the
 * output should be
 * solution(strings, patterns) = true;
 * For strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], the
 * output should be
 * solution(strings, patterns) = false.
 */
boolean solution(String[] strings, String[] patterns) {
    //pattern, strings
    HashMap<String, String> correlation = new HashMap<>();
    
    for (int i = 0; i<strings.length; i++) {
        if (correlation.containsKey(patterns[i])) {
            String match = correlation.get(patterns[i]);
            
            if (!match.equals(strings[i])) {
                return false;
            }
        } else {
            if (correlation.containsValue(strings[i])) {
                return false;
            }
            correlation.put(patterns[i], strings[i]);
            
        }
    }

    return true;
}
