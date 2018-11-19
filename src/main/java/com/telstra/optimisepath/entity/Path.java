package com.telstra.optimisepath.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Path implements Serializable {

	private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer pathId;
	@Column
	private Integer numOfNodes;
	@Column
	private String adjacencyMatrix;
	@Column
	private String optimalPath;
	@Column
	private Integer optimalCost;

	public Path(Integer numOfNodes, String adjacencyMatrix, String optimalPath, Integer optimalCost) {
		super();
		this.numOfNodes = numOfNodes;
		this.adjacencyMatrix = adjacencyMatrix;
		this.optimalPath = optimalPath;
		this.optimalCost = optimalCost;
	}

	public Path() {
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

	public void setAdjacencyMatrix(String adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

	public String getOptimalPath() {
		return optimalPath;
	}

	public void setOptimalPath(String optimalPath) {
		this.optimalPath = optimalPath;
	}

	public Integer getPathId() {
		return pathId;
	}

	public void setPathId(Integer pathId) {
		this.pathId = pathId;
	}

	public Integer getOptimalCost() {
		return optimalCost;
	}

	public void setOptimalCost(Integer optimalCost) {
		this.optimalCost = optimalCost;
	}

	@Override
	public String toString() {
		return "Path [pathId=" + pathId + ", numOfNodes=" + numOfNodes + ", adjacencyMatrix=" + adjacencyMatrix
				+ ", optimalPath=" + optimalPath + ", optimalCost=" + optimalCost + "]";
	}

	

}
