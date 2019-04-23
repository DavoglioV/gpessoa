package com.bibliothek.gpessoa.domain.contracts.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bibliothek.gpessoa.domain.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long>{
	
	List<PersonEntity> findAll();
	Page<PersonEntity> findAll(Pageable pageRequest);
}
