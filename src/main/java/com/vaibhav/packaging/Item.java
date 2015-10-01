package com.vaibhav.packaging;
/**
 * @author vaibhav
 * This is the item holder class which will hold the item object. 
 */ 
 /* (non-Javadoc) We can have a set of getters and setters here but avoiding them as they are nor necessary. 
 * Having getters and setters does not in itself break encapsulation. What does break encapsulation is
 * having a getter and a setter for every data member (every field, in java lingo).
 * That is one step away from making all data members public.
 * The point of encapsulation is not that you should not be able to know or to change the object's state
 * from outside the object, but that you should have a reasonable policy for doing it.
 */
public class Item {
	int id;
	double weight, price;

	public Item(int id, double weight, double price) {
		this.id = id;
		this.weight = weight;
		this.price = price;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * This method is being used to printing the Item object.
	 */
	public String toString() {
		return "ID-> " + id + ", Weight-> " + weight + ", Price ->" + price + " ";
	}

	public boolean equals(Object other){
	    boolean result = false;
	    if((other == null) || (getClass() != other.getClass())){
	       return result;
	    } 
	    else{
	        Item otherItem = (Item)other;
	        result = (id == otherItem.id) && (weight == otherItem.weight) && (price == otherItem.price);
	    } 
	    return result;
	} 
}