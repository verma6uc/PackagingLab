package com.vaibhav.packaging;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;



/**
 * This is the JUNIT Test Class for PackageLab Problem, which covers the 4 sample test given. 
 * @author vaibhav
 */
public class PackageLabSolutionTest {

	
	@Test
	public final void testGetBoxContent1() {
		PackageLabSolution solution = new PackageLabSolution(81, generateInputItems(
				"(1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48)"));
		ArrayList<Item> expectedAnswer = new ArrayList<Item>(Arrays.asList(new Item(4, 72.30, 76)));
		solution.createBestPackage();
		System.out.println(solution.result());
		Assert.assertEquals(expectedAnswer, solution.getBestCombination());
	}
	
	@Test
	public final void testGetBoxContent2() {
		PackageLabSolution solution = new PackageLabSolution(8, generateInputItems(
				"(1,15.3,$34)"));
		ArrayList<Item> expectedAnswer = new ArrayList<Item>();
		solution.createBestPackage();
		System.out.println(solution.result());
		Assert.assertEquals(expectedAnswer, solution.getBestCombination());
	}
	
	@Test
	public final void testGetBoxContent3() {
		PackageLabSolution solution = new PackageLabSolution(75, generateInputItems(
				"(1,85.31,$29) (2,14.55,$74) (3,3.98,$16) (4,26.24,$55) (5,63.69,$52) (6,76.25,$75) (7,60.02,$74) (8,93.18,$35) (9,89.95,$78)"));
		//(2,14.55,$74)  (7,60.02,$74) 
		ArrayList<Item> expectedAnswer = new ArrayList<Item>(Arrays.asList(new Item(2, 14.55, 74), new Item(7, 60.02, 74)));
		solution.createBestPackage();
		System.out.println(solution.result());
		Assert.assertEquals(expectedAnswer, solution.getBestCombination());
	}
	
	
	@Test
	public final void testGetBoxContent4() {
		PackageLabSolution solution = new PackageLabSolution(56, generateInputItems(
				"(1,90.72,$13) (2,33.80,$40) (3,43.15,$10) (4,37.97,$16) (5,46.81,$36) (6,48.77,$79) (7,81.80,$45) (8,19.36,$79) (9,6.76,$64)"));
		ArrayList<Item> expectedAnswer = new ArrayList<Item>(Arrays.asList(new Item(8, 19.36, 79) , new Item(9, 6.76, 64)));
		solution.createBestPackage();
		System.out.println(solution.result());
		Assert.assertEquals(expectedAnswer, solution.getBestCombination());
	}

	

	private ArrayList<Item> generateInputItems(String line) {
		ArrayList<Item> inputs = new ArrayList<Item>();
		if (line.length() != 0) {
			for (String itemText : line.split(" ")) {
				int id = Integer.parseInt(itemText.split(",")[0].substring(1));
				double weight = Double.parseDouble(itemText.split(",")[1]);
				double price = Double
						.parseDouble(itemText.split(",")[2].substring(1, itemText.split(",")[2].length() - 1));
				Item item = new Item(id, weight, price);
				inputs.add(item);
			}
		}
		return inputs;
	}
}