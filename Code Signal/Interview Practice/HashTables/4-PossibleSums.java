/*
 * 4 - possibleSums
 * You have a collection of coins, and you know the values of the coins and the
 * quantity of each type of coin in it. You want to know how many distinct sums
 * you can make from non-empty groupings of these coins.
 * 
 * Example
 * For coins = [10, 50, 100] and quantity = [1, 2, 1], the output should be
 * solution(coins, quantity) = 9.
 */

int solution(int[] coins, int[] quantity) {
    HashSet<Integer> sums = new HashSet<Integer>();
    sums.add(0);
    
    for(int i=0; i<coins.length; i++) {
        int coin = coins[i];
        HashSet<Integer> currentSums = new HashSet<Integer>();
        for(Integer sum : sums) {
            for(int j=1; j<=quantity[i]; j++) {
                currentSums.add(sum + coin*j);
            }
        }
        sums.addAll(currentSums);
    }
    
    return sums.size() - 1;
}
