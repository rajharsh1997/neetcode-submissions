class MyHashMap {
    private int[] values;
    private boolean[] present;
    public MyHashMap() {
        values = new int[1_000_001];
        present = new boolean[1_000_001];
    }
    
    public void put(int key, int value) {
        values[key]=value;
        present[key]=true;
    }
    
    public int get(int key) {
        if(!present[key]){
            return -1;
        }
        return values[key];
    }
    
    public void remove(int key) {
        present[key]=false;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */