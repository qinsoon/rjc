package org.rjava.compiler.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class EqualitySet<E> implements Set<E> {
    List<E> internal = new LinkedList<E>();

    @Override
    public int size() {
        return internal.size();
    }

    @Override
    public boolean isEmpty() {
        return internal.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        for (E entity : internal)
            if (entity.equals(o))
                return true;
        
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return internal.iterator();
    }

    @Override
    public Object[] toArray() {
        return internal.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return internal.toArray(a);
    }

    @Override
    public boolean add(E e) {
        if (!contains(e)) {
            internal.add(e);
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o))
            return false;
        
        List<E> newList = new LinkedList<E>();
        for (E entity : internal) {
            if (!entity.equals(o))
                newList.add(entity);
        }
        internal = newList;
        return true;
    }

    @Override
    @Deprecated
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E entity : c)
            add(entity);
        
        return true;
    }

    @Override
    @Deprecated
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    @Deprecated
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        internal.clear();
    }

}
