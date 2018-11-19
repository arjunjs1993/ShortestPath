package com.telstra.optimisepath.algorithm;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.telstra.optimisepath.dto.PathDTO;

public class BellmanHeldKarpAlgorithm {
	private static final Logger logger = LoggerFactory.getLogger(BellmanHeldKarpAlgorithm.class);
	/*
	 * GLOBAL VARIABLES
	 */
	private  int[][] distances;
	private  int finalResults[];
	private  String paths[];
	private  int counter = 0;

	public  PathDTO getOptimisedPath(PathDTO pathDTO) throws IOException {

		try {

			// get the number of nodes
			int size = pathDTO.getNumOfNodes();

			// Global variables are initialized considering the size of the matrix
			int numSolutions = factorial(size - 1);
			distances = new int[size][size];
			finalResults = new int[numSolutions];
			paths = new String[numSolutions];

			String[] inputValues = pathDTO.getAdjacencyMatrix().split("\n");

			int inputValuesIncrement = 0;

			for (int i = 0; i < size; i++) {

				String[] inputValues1 = inputValues[inputValuesIncrement].split(" ");
				int input = 0;
				for (int j = 0; j < size; j++) {
					distances[i][j] = Integer.parseInt(inputValues1[input]);
					input++;
				}
				inputValuesIncrement++;
			}

			// Start algorithm
			String path = "";
			int[] vertices = new int[size - 1];

			// Filling the initial vertices array with the proper values
			for (int i = 1; i < size; i++) {
				vertices[i - 1] = i;
			}

			int distance = calculateDistance(0, vertices, path, 0);

			int optimal = 0;
			for (int i = 0; i < numSolutions; i++) {

				// When we reach the optimal one, its index is saved
				if (finalResults[i] == distance) {
					optimal = i;
				}
			}
			pathDTO.setOptimalPath(paths[optimal]);
			pathDTO.setOptimalTotalDistance(finalResults[optimal]);
			logger.info("Path: " + paths[optimal] + ". Distance = " + finalResults[optimal]);
		} catch (Exception e) {
			logger.info("Error in BellmanHeldKarpAlgorithm"+e.getMessage());
			throw new IOException("Exception from algorithm" + e.getMessage());
		}

		return pathDTO;

	}

	public  int calculateDistance(int initial, int vertices[], String path, int unitCost) {

		// We concatenate the current path and the vertex taken as initial
		path = path + Integer.toString(initial) + " - ";
		int length = vertices.length;
		int newCostUntilHere;

		// Exit case, if there are no more options to evaluate (last node)
		if (length == 0) {

			// Both results, numerical distances and paths to those distances, are stored
			paths[counter] = path + "0";
			finalResults[counter] = unitCost + distances[initial][0];

			counter++;
			return (distances[initial][0]);
		}

		// if there are more than 1 node
		else {

			int[][] newVertices = new int[length][(length - 1)];
			int costCurrentNode, costChild;
			int bestCost = Integer.MAX_VALUE;

			// For each of the nodes of the list
			for (int i = 0; i < length; i++) {

				// Each recursion new vertices list is constructed
				for (int j = 0, k = 0; j < length; j++, k++) {

					// The current child is not stored in the new vertices array
					if (j == i) {
						k--;
						continue;
					}
					newVertices[i][k] = vertices[j];
				}

				// Cost of arriving the current node from its parent
				costCurrentNode = distances[initial][vertices[i]];

				// Here the cost to be passed to the recursive function is computed
				newCostUntilHere = costCurrentNode + unitCost;

				// RECURSIVE CALLS TO THE FUNCTION IN ORDER TO COMPUTE THE COSTS
				costChild = calculateDistance(vertices[i], newVertices[i], path, newCostUntilHere);

				// The cost of every child + the current node cost is computed
				int totalCost = costChild + costCurrentNode;

				// Finally we select from the minimum from all possible children costs
				if (totalCost < bestCost) {
					bestCost = totalCost;
				}
			}

			return (bestCost);
		}
	}

	// Factorial function used to calculate the number of solutions
	public  int factorial(int n) {

		if (n <= 1) {
			return 1;
		} else {
			return (n * factorial(n - 1));
		}
	}
}