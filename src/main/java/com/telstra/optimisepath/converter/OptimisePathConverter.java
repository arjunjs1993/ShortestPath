package com.telstra.optimisepath.converter;



import com.telstra.optimisepath.dto.PathDTO;
import com.telstra.optimisepath.entity.Path;


public class OptimisePathConverter {
	public static Path dtoToEntity(PathDTO pathDTO) {
		Path path = new Path( pathDTO.getNumOfNodes(), pathDTO.getAdjacencyMatrix(), pathDTO.getOptimalPath(), pathDTO.getOptimalTotalDistance());
		return path;
	}

}
