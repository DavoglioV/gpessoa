package com.bibliothek.gpessoa.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bibliothek.gpessoa.domain.entity.PersonEntity;
import com.bibliothek.gpessoa.infra.services.contracts.PersonService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/person")
@Api(value = "Person", description = "Person Management")
public class PersonController {
	
	@Autowired
    private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	PersonService service;
	
//	@ApiOperation(value = "Greets the user")
//	@GetMapping("/hello")
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	@Produces(MediaType.APPLICATION_JSON)
//	public ResponseEntity<String>  hello() {
//		return new ResponseEntity<String>("Hello user", HttpStatus.OK);
//	}
	
//	@GetMapping(params = { "page", "size" })
//    public List<PersonEntity> findPaginated(@RequestParam("page") final int page, @RequestParam("size") final int size,
//        final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
//        
//		final Page<PersonEntity> resultPage = service.findPaginated(page, size);
//        if (page > resultPage.getTotalPages())
//            throw new RuntimeException();
//        
//        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<PersonEntity>(PersonEntity.class, uriBuilder, response, page,
//            resultPage.getTotalPages(), size));
//
//        return resultPage.getContent();
//    }
	
	@GetMapping()
    public Page<PersonEntity> search(
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return service.findPaginated(page, size);

    }
	
	@PostMapping()
    public ResponseEntity create20kItens() {
		service.create20kItens();
		return new ResponseEntity(HttpStatus.CREATED);

    }

}
