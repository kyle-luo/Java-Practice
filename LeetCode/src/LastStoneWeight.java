public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> stone = new ArrayList<>();
        for (int x: stones) {
            stone.add(x);
        }
        while (stone.size() != 1) {
            Collections.sort(stone);
            int first = stone.remove(stone.size() - 1);
            int second = stone.remove(stone.size() - 1);
            stone.add(first - second);
        }
        return stone.get(0);
    }
}

