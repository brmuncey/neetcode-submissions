class FreqStack {

    Map<Integer, Integer> map;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        map = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = map.getOrDefault(val, 0) + 1;
        map.put(val, f);
        if (f > maxFreq) maxFreq = f;
        group.computeIfAbsent(f, z -> new Stack<>()).push(val);
    }
    
    public int pop() {
        int x = group.get(maxFreq).pop();
        map.put(x, map.get(x) - 1);
        if (group.get(maxFreq).size() == 0) maxFreq--;
        return x;
    }
}
