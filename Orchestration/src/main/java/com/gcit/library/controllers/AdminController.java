/**
 * 
 */
package com.gcit.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.gcit.library.model.Author;
import com.gcit.library.model.Book;

/**
 * @author gcit
 *
 */

@RestController
public class AdminController{
	
	private String url = "http://localhost:8081";
	
	@Autowired
	RestTemplate restTemplate;
	
	/*
	 * Admin Book Services
	 */
	@RequestMapping(value="/books", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<Object> getBooks(@RequestParam(value="pageNo",required=false) Integer pageNo,
			@RequestParam(value="search",required=false) String search){
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/books")
											.queryParam("pageNo", pageNo)
											.queryParam("search", search);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<Object> res = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET,entity,Object.class);
		return res;
	}
	
	@RequestMapping(value="/books/{bookId}", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<Object> getBookByPK(@PathVariable(value="bookId") Integer bookId){
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/books/"+bookId);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<Object> res = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET,entity,Object.class);
		return res;
	}
	
	
	@RequestMapping(value="/books/count",method=RequestMethod.GET)
	public ResponseEntity<Object> getBookCount(@RequestParam(value="search",required=false)  String search)  {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/books/count/")
				.queryParam("search", search);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<Object> res = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET,entity,Object.class);
		return res;
	}
	
	@RequestMapping(value="/books/{bookId}",method=RequestMethod.PUT, consumes = {"application/json"},produces= {"application/json"})
	public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable(value="bookId") Integer bookId)  {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/books/"+bookId);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(book,headers);
		ResponseEntity<Object> res = restTemplate.exchange(builder.build().toUri(), HttpMethod.PUT,entity,Object.class);
		return res;
	}
	
	@RequestMapping(value="/books/{bookId}", method=RequestMethod.DELETE,produces= {"application/json"})
	public ResponseEntity<Object> deleteBookByPK(@PathVariable("bookId") Integer bookId)  {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/books/"+bookId);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<Object> res = restTemplate.exchange(builder.build().toUri(), HttpMethod.DELETE,entity,Object.class);
		return res;
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST,consumes= {"application/json"},produces= {"application/json"})
	public ResponseEntity<Object> addBook(@RequestBody Book book)  {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/books");
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(book,headers);
		ResponseEntity<Object> res = restTemplate.exchange(builder.build().toUri(), HttpMethod.POST,entity,Object.class);
		return res;
	}
	
	/*
	 * Admin Author
	 */
	@RequestMapping(value="/authors", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<Object> getAuthors(@RequestParam(value="pageNo",required=false) Integer pageNo,
			@RequestParam(value="search",required=false) String search){
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/authors")
											.queryParam("pageNo", pageNo)
											.queryParam("search", search);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<Object> res = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET,entity,Object.class);
		return res;
	}
	
	@RequestMapping(value="/authors/{authorId}", method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<Object> getAuthorByPK(@PathVariable(value="authorId") Integer authorId){
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/authors/"+authorId);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<Object> res = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET,entity,Object.class);
		return res;
	}
	
	
	@RequestMapping(value="/authors/count",method=RequestMethod.GET)
	public ResponseEntity<Object> getAuthorCount(@RequestParam(value="search",required=false)  String search)  {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/authors/count/")
				.queryParam("search", search);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<Object> res = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET,entity,Object.class);
		return res;
	}
	
	@RequestMapping(value="/authors/{authorId}",method=RequestMethod.PUT, consumes = {"application/json"},produces= {"application/json"})
	public ResponseEntity<Object> updateAuthor(@RequestBody Author author, @PathVariable(value="authorId") Integer authorId)  {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/authors/"+authorId);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(author,headers);
		ResponseEntity<Object> res = restTemplate.exchange(builder.build().toUri(), HttpMethod.PUT,entity,Object.class);
		return res;
	}
	
	@RequestMapping(value="/authors/{authorId}", method=RequestMethod.DELETE,produces= {"application/json"})
	public ResponseEntity<Object> deleteAuthorByPK(@PathVariable("authorId") Integer authorId)  {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/authors/"+authorId);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<Object> res = restTemplate.exchange(builder.build().toUri(), HttpMethod.DELETE,entity,Object.class);
		return res;
	}
	
	@RequestMapping(value="/authors", method=RequestMethod.POST,consumes= {"application/json"},produces= {"application/json"})
	public ResponseEntity<Object> addAuthor(@RequestBody Author author)  {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/authors");
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(author,headers);
		ResponseEntity<Object> res = restTemplate.exchange(builder.build().toUri(), HttpMethod.POST,entity,Object.class);
		return res;
	}
}