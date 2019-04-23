package com.bibliothek.gpessoa.infra.services.contracts;

import org.springframework.data.domain.Page;

import com.bibliothek.gpessoa.domain.entity.PersonEntity;

public interface PersonService {

	Page<PersonEntity> findPaginated(int page,int size);

	void create20kItens();
}
