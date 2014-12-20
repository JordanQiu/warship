package org.sevenup.rest.controller.memo;

import java.util.UUID;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sevenup.domain.memo.Memo;
import org.sevenup.service.memo.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.SortDefault;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/memo")
@Produces(MediaType.APPLICATION_JSON)
public class MemoController {
	@Autowired
	private MemoService memoService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<Page> getMemo(@PageableDefault(page =0,size=10) Pageable pageable,@SortDefault Sort sort) {
		Page<Memo> pageMemo = memoService.findMemos(pageable,sort);
		return new ResponseEntity<Page>(pageMemo, HttpStatus.OK);
	}
	
    @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Memo> createMemo(@RequestBody Memo memo, UriComponentsBuilder builder) {
    	Pageable  page = new PageRequest(0, 0);
    	new Sort(Sort.Direction.ASC, "lastName");
    	new Sort(
    		    new Order(Direction.ASC, "lastName"), 
    		    new Order(Direction.DESC, "salary")
    		  );
    	UUID id = UUID.randomUUID();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/memo/{id}").buildAndExpand(id.toString()).toUri());
        return new ResponseEntity<Memo>(memo, headers, HttpStatus.CREATED);
	}

	// for Hateoas use
	@RequestMapping(method = RequestMethod.GET,value="/number")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<PagedResources<Memo>> findMemos(Pageable pageable, PagedResourcesAssembler assembler) {
		Page<Memo> pageMemo = memoService.findMemos(pageable);
//		Link link = null;
//		PagedResources<Memo> resource = assembler.toResource(pageMemo, assembler, link);
		PagedResources<Memo> resource = assembler.toResource(pageMemo);
		return new ResponseEntity<>(resource, HttpStatus.OK);
	}
	
}
