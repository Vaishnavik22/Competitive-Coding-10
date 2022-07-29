/*
Problem: https://leetcode.com/problems/peeking-iterator/
TC: O(1) for each of the methods
SC: O(1)
*/
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator = null;
    Integer peek;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        peek = null;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        
        if (peek == null) {
            peek = iterator.next();
        }
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer elementToReturn = null;
        if (peek == null) {
            elementToReturn = iterator.next();
        } else {
            elementToReturn = peek;
        }
        
        if (iterator.hasNext()) {
            peek = iterator.next();
        } else {
            peek = null;
        }
        return elementToReturn;
	}
	
	@Override
	public boolean hasNext() {
        if (peek != null)
            return true;
	    return iterator.hasNext();
	}
}