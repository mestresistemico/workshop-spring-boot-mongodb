package com.mestresistemico.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mestresistemico.workshopmongo.domain.Post;
import com.mestresistemico.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;

//	@GetMapping
//	public ResponseEntity<List<PostDTO>> findAll(){
//		List<Post> list = service.findAll();
//		List<PostDTO> listDTO = list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDTO);
//	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}


//	@PutMapping(value="/{id}")
//	public ResponseEntity<Void> update(@RequestBody PostDTO objDTO, @PathVariable String id){
//		Post obj = service.fromDTO(objDTO);
//		obj.setId(id);
//		obj = service.update(obj);
//		return ResponseEntity.noContent().build();
//	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.findById(id);
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
