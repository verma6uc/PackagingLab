package com.vaibhav.packaging;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;


/**
 * This is Class which will act as a module for solving the problem at hand
 * which is the Packaging Lab problem. The choice of methodology which we have
 * used here is the DP.
 * 
 * @author vaibhav
 */
public class PackageLabSolution {
	private static final Logger logger =
	        Logger.getLogger(PackageLabSolution.class.getName());
    private int maxWeight;
	private ArrayList<Item> listOfItems;
	private ArrayList<ArrayList<Item>> combinations;
	private ArrayList<Item> bestCombination;

	public PackageLabSolution(int maxWeight, ArrayList<Item> listOfItems) {
		super();
		this.maxWeight = maxWeight;
		this.listOfItems = listOfItems;
		this.combinations = new ArrayList<ArrayList<Item>>();
	}

	public ArrayList<Item> getBestCombination() {
		return bestCombination;
	}

	/**
	 * This method is used go filter all items which have weight more than the
	 * allowed weight.
	 * 
	 * (non-Javadoc) It is just a pre-optimization step.
	 */
	private void filterItems() {
		Iterator<Item> iter = listOfItems.iterator();
		while (iter.hasNext()) {
			Item i = iter.next();
			if (i.weight > maxWeight)
				iter.remove();
		}
		logger.debug("filtered items: " + listOfItems.toString());
	}

	/**
	 * This is a method to find the weight of certain combination to ensure a
	 * check whether the weight does not get over the limit.
	 * 
	 * (non-Javadoc) This is put in separate method to increase readability of
	 * the code.
	 * 
	 * @param items
	 * @return
	 */
	private double getWeight(ArrayList<Item> items) {
		double total = 0;
		for (Item i : items) {
			total += i.weight;
		}
		return total;
	}

	private double getPrice(ArrayList<Item> items) {
		double total = 0;
		for (Item i : items) {
			total += i.price;
		}
		return total;
	}

	private ArrayList<ArrayList<Item>> createCombinations() {
		for (int x = 0; x < listOfItems.size(); x++) {
			Item currentItem = listOfItems.get(x);
			int combinationSize = combinations.size();
			for (int y = 0; y < combinationSize; y++) {
				ArrayList<Item> combination = combinations.get(y);
				ArrayList<Item> newCombination = new ArrayList<Item>(combination);
				newCombination.add(currentItem);
				combinations.add(newCombination);
			}
			ArrayList<Item> current = new ArrayList<Item>();
			current.add(currentItem);
			combinations.add(current);
		}
		logger.debug("combinations: " + combinations);
		return combinations;
	}

	/**
	 * This uses the Dynamic Programming to get the best Package for a certain
	 * set of Items.
	 * 
	 * @return
	 */
	private ArrayList<Item> getBestPackageBasedOnDP() {
		ArrayList<Item> bestCombination = new ArrayList<Item>();
		double bestCost = 0;
		double bestWeight = 100; // max weight is 100
		for (ArrayList<Item> combination : combinations) {
			double combinationWeight = getWeight(combination);
			if (combinationWeight > maxWeight) {
				continue;
			} else {
				double combinationPrice = getPrice(combination);
				if (combinationPrice > bestCost) {
					bestCost = combinationPrice;
					bestCombination = combination;
					bestWeight = combinationWeight;
				} else if (combinationPrice == bestCost) {

					if (combinationWeight < bestWeight) {
						bestCost = combinationPrice;
						bestCombination = combination;
						bestWeight = combinationWeight;
					}
				}
			}
		}
		return bestCombination;
	}

	/**
	 * This method is used to create the best Package for the set of items
	 * provided.
	 */
	public void createBestPackage() {
		filterItems();
		combinations = createCombinations();
		if (combinations.size() == 0) {
			bestCombination = new ArrayList<Item>();
		} else {
			bestCombination = getBestPackageBasedOnDP();
		}
	}

	/* (non-Javadoc) 
	 * This method is only overridden to ensure when you want to show the result in a format as expected you can do it. 
	 */
	public String result() {
		StringBuilder builder = new StringBuilder();
		if (!bestCombination.isEmpty()) {
			for (Item item : bestCombination) {
				builder.append(item.id + ",");
			}
			return builder.toString().substring(0,builder.toString().length()-1);
		} else {
			return "-";
		}
	}
	
	
}