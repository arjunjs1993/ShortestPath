package com.telstra.optimisepath.dto;


public class PathDTO {
	Integer numOfNodes;
	String adjacencyMatrix;
	String optimalPath;
	Integer optimalTotalDistance;
	public PathDTO() {
	}

	
	public PathDTO(Integer numOfNodes, String adjacencyMatrix, String optimalPath, Integer optimalTotalDistance) {
		super();
		this.numOfNodes = numOfNodes;
		this.adjacencyMatrix = adjacencyMatrix;
		this.optimalPath = optimalPath;
		this.optimalTotalDistance = optimalTotalDistance;
	}


	public Integer getNumOfNodes() {
		return numOfNodes;
	}

	public void setNumOfNodes(Integer numOfNodes) {
		this.numOfNodes = numOfNodes;
	}

	public String getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public String getOptimalPath() {
		return optimalPath;
	}

	public void setOptimalPath(String optimalPath) {
		this.optimalPath = optimalPath;
	}

	public void setAdjacencyMatrix(String adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

	public Integer getOptimalTotalDistance() {
		return optimalTotalDistance;
	}


	public void setOptimalTotalDistance(Integer optimalTotalDistance) {
		this.optimalTotalDistance = optimalTotalDistance;
	}


	@Override
	public String toString() {
		return "PathDTO [numOfNodes=" + numOfNodes + ", adjacencyMatrix=" + adjacencyMatrix + ", optimalPath="
				+ optimalPath + ", optimalTotalDistance=" + optimalTotalDistance + "]";
	}

}
