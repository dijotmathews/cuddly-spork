package lc150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    private HashMap<Integer, Integer> mp;
    private ArrayList<Integer> l;
    private Random rand;

    public RandomizedSet() {
        mp = new HashMap<Integer, Integer>();
        l = new ArrayList<Integer>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if(mp.containsKey(val)) {
            return false;
        }
        l.add(val);
        mp.put(val, l.size() -1);
        return true;
    }

    public boolean remove(int val) {
        if(!mp.containsKey(val)) {
            return false;
        }
        int index = mp.get(val);
        l.remove(index);
        mp.remove(val);
        return true;
    }

    public int getRandom() {
        int index = rand.nextInt(l.size());
        return l.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */