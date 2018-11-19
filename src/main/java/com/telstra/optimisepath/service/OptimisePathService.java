package com.telstra.optimisepath.service;


import com.telstra.optimisepath.dto.PathDTO;

public interface OptimisePathService {

	PathDTO optimisePath(PathDTO pathDTO);
	void saveOptimalPath(PathDTO pathDTO);
}
