class Solution {

    public String smallestEquivalentString(String A, String B, String S) {

        int[] graph = new int[26];

        for(int i = 0; i < 26; i++) {

            graph[i] = i;

        }

        for(int i = 0; i < A.length(); i++) {

            int a = A.charAt(i) - 'a';

            int b = B.charAt(i) - 'a';

            int end1 = find(graph, b);

            int end2 = find(graph, a);

            if(end1 < end2) {

                graph[end2] = end1;

            } else {

                graph[end1] = end2;

            }

        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < S.length(); i++) {

            char c = S.charAt(i);

            sb.append((char)('a' + find(graph, c - 'a')));

        }

        return sb.toString();

    }

    

    private int find(int[] graph, int idx) {

        while(graph[idx] != idx) {

            idx = graph[idx];

        }

        return idx;

    }

}