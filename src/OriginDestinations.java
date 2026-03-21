package src;

import java.util.*;

public class OriginDestinations {
    static Map<Character, Set<Character>> orgDestMap = new HashMap<>();
    static Set<Character> VISITED = new HashSet<>();
    static List<Character> PATH = new ArrayList<>();

    public void dfs(char start, char end) {
        if (start == end) {
            PATH.add(end);
            System.out.println(PATH);
            PATH.removeLast();
            return;
        }

        PATH.add(start);
        VISITED.add(start);

        Set<Character> children = orgDestMap.get(start);

        if (children != null) {
            for(char c: children) {
                dfs(c, end);
            }
        }
        PATH.removeLast();
    }

    public static void init(List<List<Character>> destinations) {
        for (List<Character> pair: destinations) {
            orgDestMap.putIfAbsent(pair.getFirst(), new HashSet<>());
            orgDestMap.get(pair.getFirst()).add(pair.getLast());
        }
    }

    public static void main(String[] args) {
        OriginDestinations obj = new OriginDestinations();

        Character[][] originAndDestinations = {{'A', 'B'}, {'B', 'C'}, {'C', 'D'}, {'A', 'D'}};
        List<List<Character>> flightList = new ArrayList<>();
        Arrays.stream(originAndDestinations).forEach(arr -> flightList.add(Arrays.asList(arr)));

        init(flightList);

        // When Path exists.
        obj.dfs('A', 'D');

        // When Path doesn't exist.
        obj.dfs('A', 'E');

    }
}
