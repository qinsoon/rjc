package org.rjava.compiler.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import soot.Value;

/**
 * key is always type Value
 * @author yi
 *
 * @param <K>
 */
public class SootValueMultiMap<K> {
    HashMap<Value, Set<K>> map = new HashMap<Value, Set<K>>();
    
    public void put(Value key, K value) {
        if (contains(key)) {
            Set<K> list = get(key);
            list.add(value);
        } else {
            Set<K> list = new HashSet<K>();
            list.add(value);
            map.put(key, list);
        }
    }
    
    public boolean contains(Value key) {
        return get(key) != null;
    }
    
    public Set<K> get(Value key) {
        for (Value v : map.keySet())
            if (SootCollectionUtils.isEqualValue(v, key))
                return map.get(v);
        
        return null;
    }
    
    public Set<Value> keySet() {
        return map.keySet();
    }
}
