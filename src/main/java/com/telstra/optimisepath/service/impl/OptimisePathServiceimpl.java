package com.telstra.optimisepath.service.impl;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telstra.optimisepath.algorithm.BellmanHeldKarpAlgorithm;
import com.telstra.optimisepath.converter.OptimisePathConverter;
import com.telstra.optimisepath.dto.PathDTO;
import com.telstra.optimisepath.repository.PathRepository;
import com.telstra.optimisepath.service.OptimisePathService;


@Service
public class OptimisePathServiceimpl implements OptimisePathService {
	
	private static final Logger logger = LoggerFactory.getLogger(OptimisePathService.class);
	
	@Autowired
	PathRepository repo;



	@Override
	public void saveOptimalPath(PathDTO pathDTO) {
		repo.save(OptimisePathConverter.dtoToEntity(pathDTO));
	}


	@Override
	public PathDTO optimisePath(PathDTO pathDTO) {
		logger.info("Entered optimisePath method in OptimisePathServiceimpl");
		try {
			//call BellmanHeldKarpAlgorithm to get the optimal distance between cities
			BellmanHeldKarpAlgorithm algorithm = new BellmanHeldKarpAlgorithm();
			pathDTO = algorithm.getOptimisedPath(pathDTO);
			
			//save the optimal distance between cities into H2 database
			repo.save(OptimisePathConverter.dtoToEntity(pathDTO));
			logger.info("Exit optimisePath method in OptimisePathServiceimpl");
		} catch (IOException e) {
			logger.info("Error in optimisePath method in OptimisePathServiceimpl "+e.getMessage());
		}
		return pathDTO;
	}
}
