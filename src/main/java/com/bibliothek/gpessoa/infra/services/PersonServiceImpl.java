package com.bibliothek.gpessoa.infra.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bibliothek.gpessoa.domain.contracts.repository.PersonRepository;
import com.bibliothek.gpessoa.domain.entity.PersonEntity;
import com.bibliothek.gpessoa.infra.services.contracts.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository repository;
	
	public Page<PersonEntity> search(
            String searchTerm,
            int page,
            int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "name");

        return repository.findAll(pageRequest);
    }
	
	public Page<PersonEntity> findPaginated(int page,int size){
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");
		return new PageImpl<>(repository.findAll(), pageRequest, size);
	}
	
	public void create20kItens() {
		List<PersonEntity> list = new ArrayList<>();
		for(int i=0; i <20000; i++) {
			PersonEntity person = new PersonEntity();
			person.setName("AAA" + i);
			person.setEmail("aaa"+i+"@gmail.com");
			list.add(person);
		}
		repository.saveAll(list);
	}
}
