package com.ganjatec.ticketmaster.dataclasses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashRepository extends CrudRepository<Hash, Long> {

    Hash findByID(long ID);
    Hash findByHash(String hash);
}
