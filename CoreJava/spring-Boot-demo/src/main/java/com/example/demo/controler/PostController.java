package com.example.demo.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.myexception.ResourceNotFoundException;
import com.example.demo.repository.PostRepository;

@RestController
public class PostController {

	@Autowired
	private PostRepository postRepository;

	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return postRepository.findAll();

	}

	// http://localhost:8080/posts
	/*
	 "title":"post1"
	 "description":"description1"
	 "content":"conten1" 
	 */
	@PostMapping("/posts")
	public Post createPost(@Valid @RequestBody Post post) {
		return postRepository.save(post);
	}

	
	//       http://localhost:8080/posts/1
	@PutMapping("/posts/{postId}")
	public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postReq) {
		return postRepository.findById(postId).map(post -> {
			post.setTitle(postReq.getTitle());
			post.setDescription(postReq.getDescription());
			post.setContent(postReq.getContent());
			return postRepository.save(post);
		}).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
	}

	//    http://localhost:8080/postss/2
	@DeleteMapping("/postss/{postId}")
	public Post deletepost(@PathVariable Long postId) {
		return postRepository.findById(postId).map(post -> {
			postRepository.delete(post);
			return post;
		}).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));

	}
}
