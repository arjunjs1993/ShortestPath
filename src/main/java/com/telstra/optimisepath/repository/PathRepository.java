package com.telstra.optimisepath.repository;

import com.telstra.optimisepath.entity.Path;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathRepository extends JpaRepository<Path, Integer>{
}
