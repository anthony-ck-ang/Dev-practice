package com.anthonyang.ds.hashtable;

public class HashTable {

	String[] hashArray;
	int arraySize; // no of slots in entire array
	int size = 0; // counter for number of elements in hash table

	public HashTable(int noOfSlots) {

		if (isPrime(noOfSlots)) {
			hashArray = new String[noOfSlots];
			arraySize = noOfSlots;
		} else {
			int newPrimeNo = getNextPrime(noOfSlots);
			hashArray = new String[newPrimeNo];
			arraySize = newPrimeNo;

			System.out.println("Hash table size given " + noOfSlots + " is not a prime");
			System.out.println("Hash table size changed: " + newPrimeNo);
		}
	}

	// instantiation of hashArray must be a prime

//	private boolean isPrime(int anyNumber) {
//		for (int i = 2; i * i <= anyNumber; i++) {
//			if (anyNumber % i == 0) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	//bug tbc -> Prime no can only be divided by 1 or itself
	private boolean isPrime(int anyNumber) {
		for (int i = 2; i <= anyNumber/anyNumber; i++) {
			if (anyNumber % i == 0) {
				return false;
			}
		}
		return true;
	}

	private int getNextPrime(int minNumber) {
		for (int i = minNumber; true; i++) {
			if (isPrime(minNumber)) {
				return i;
			}
		}
	}

	// Hash Functions

	// First method -> give ideal position to insert element
	private int hashFunc1(String word) {
		int hashValue = word.hashCode();
		hashValue = hashValue % arraySize; // % to reduce +/- hashvalue

		if (hashValue < 0) {
			hashValue += arraySize;
		}

		return hashValue; // ideal index position to insert or search in
	}

	// Second method -> step size to the next open slot/address
	private int hashFunc2(String word) {
		int hashValue = word.hashCode();
		hashValue = hashValue % arraySize;

		if (hashValue < 0) {
			hashValue += arraySize; // value must be > 0
		}

		/*
		 * Step size: Use a prime number less than array size, eg. 7 is a prime
		 * no return value must be less than arraySize
		 */
		return 7 - hashValue % 7;
	}

	// Insert data -> data structure
	public void insert(String word) {
		int hashValue = hashFunc1(word);
		int stepSize = hashFunc2(word);

		// current slot is occupied
		while (hashArray[hashValue] != null) {
			hashValue = hashValue + stepSize;
			hashValue = hashValue % arraySize;
		}

		hashArray[hashValue] = word;
		System.out.println("inserted word: " + word);
		size++; // how many elements have been inserted into the hash table
	}

	// Find data
	public String find(String word) {
		int hashValue = hashFunc1(word);
		int stepSize = hashFunc2(word);

		// current slot is occupied
		while (hashArray[hashValue] != null) {
			if(hashArray[hashValue].equals(word)){
				return hashArray[hashValue];
			}
			hashValue = hashValue + stepSize;
			hashValue = hashValue % arraySize;
		}
		return hashArray[hashValue]; //returns null if unable to find... catch exception?
	}

	public void displayTable(){
		System.out.println("Table: ");
		for (int i = 0; i < arraySize; i++) {
			if(hashArray[i] != null){
				System.out.print(hashArray[i] + " ");
			}else{
				System.out.print("** ");
			}
			System.out.println("");
		}
	}
}
