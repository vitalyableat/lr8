package org.example.LR8.repository;

import org.example.LR8.entity.Town;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends CrudRepository<Town, Integer> {
}