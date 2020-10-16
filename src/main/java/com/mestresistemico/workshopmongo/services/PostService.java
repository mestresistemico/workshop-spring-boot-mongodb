package com.mestresistemico.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mestresistemico.workshopmongo.domain.Post;
import com.mestresistemico.workshopmongo.repositories.PostRepository;
import com.mestresistemico.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public List<Post> findAll() {
		return repo.findAll();
	}

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
	
	public Post insert(Post obj) {
		return repo.insert(obj);
	}
	
//	public Post update(Post obj) {
//		Post newObj = findById(obj.getId());
//		updateData(newObj, obj);
//		return repo.save(newObj);
//	}
//	
//	private void updateData(Post newObj, Post obj) {
//		newObj.setName(obj.getName());
//		newObj.setEmail(obj.getEmail());
//	}

	public void delete(String id) {
		repo.deleteById(id);
	}
	
//	public Post fromDTO(PostDTO objDTO) {
//		return new Post(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
//	}

}
