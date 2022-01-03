/*
 * 997. Find the Town Judge
 * In a town, there are n people labeled from 1 to n. There is a rumor that one
 * of these people is secretly the town judge.
 * 
 * If the town judge exists, then:
    * The town judge trusts nobody.
    * Everybody (except for the town judge) trusts the town judge.
    * There is exactly one person that satisfies properties 1 and 2.
    * You are given an array trust where trust[i] = [ai, bi] representing that the
    * person labeled ai trusts the person labeled bi.
 * 
 * Return the label of the town judge if the town judge exists and can be
 * identified, or return -1 otherwise.
 */
public class Solution {
    // Time Complexity : O(E).
    // Same as above. We still need to loop through the E edges in trust, and the
    // argument about the relationship between N and E still applies.
    // Space Complexity : O(N). Same as above. We're still allocating an array of
    // length N.
    public int findJudge(int n, int[][] trust) {
        // judge is not trusted by all members of the town
        if (trust.length < n - 1) {
            return -1;
        }

        int[] trustScores = new int[n + 1];

        // Indegree and outdegree
        for (int[] relation : trust) {
            trustScores[relation[0]]--; // this person trusts someone, subtract their score
            trustScores[relation[1]]++; // this person is trusted, add to their score
        }

        // The town judge is the only person who could possibly have indegree -
        // outdegree equal to N - 1.
        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }

        // no judge found
        return -1;

    }
}