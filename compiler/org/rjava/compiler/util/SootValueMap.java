package org.rjava.compiler.util;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.rjava.compiler.RJavaCompiler;

import soot.Value;

public class SootValueMap<K> {
    HashMap<Value, K> map = new HashMap<Value, K>();
    
    public void put(Value key, K value) {
        Set<Entry<Value, K>> set = map.entrySet();
        for (Entry<Value, K> entry : set) 
            if (SootCollectionUtils.isEqualValue(entry.getKey(), key)) {
                entry.setValue(value);
                return;
            }
        
        map.put(key, value);
    }
    
    public boolean contains(Value key) {
        return get(key) != null;
    }
    
    public K get(Value key) {
        for (Value v : map.keySet())
            if (SootCollectionUtils.isEqualValue(v, key))
                return map.get(v);
        
        return null;
    }
    
    public void remove(Value key) {
        if (contains(key)) {
            HashMap<Value, K> another = new HashMap<Value, K>();
            for (Value v : map.keySet())
                if (!SootCollectionUtils.isEqualValue(v, key))
                   another.put(v, get(v));
            map = another;
        }
    }
    
    public Set<Value> keySet() {
        return map.keySet();
    }
}
