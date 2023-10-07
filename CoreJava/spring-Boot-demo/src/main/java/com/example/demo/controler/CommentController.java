package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comment;
import com.example.demo.myexception.ResourceNotFoundException;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;

@RestController
public class CommentController {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	//  http://localhost:8080/comments
	@GetMapping("/comments")
	public List<Comment> getAllComments(){
		return commentRepository.findAll();
	}
	
	//   http://localhost:8080/comments/1
	@GetMapping("/comments/{id}")
	public Optional<Comment> getCommentById(@PathVariable Long id) {
		return commentRepository.findById(id);
	}

	//    http://localhost:8080/posts/1/comments
	@GetMapping("/posts/{postId}/comments")
	public List<Comment> getAllCommentsByPostId(@PathVariable Long postId){
		return commentRepository.findByPostId(postId);
	}
	
	//   http://localhost:8080/posts/1/comments/1
	@GetMapping("/posts/{postId}/comments/{id}")
	public Comment getCommentsByIdAndPostId(@PathVariable Long postId,@PathVariable Long id){
		return commentRepository.findByIdAndPostId(id, postId);
	}
	
	//    http://localhost:8080/posts/3/comments
	@PostMapping("/posts/{postId}/comments")
	public Comment createComment(@PathVariable Long postId, @Valid @RequestBody Comment comment){
		return postRepository.findById(postId).map(post -> {
			comment.setPost(post);
			return commentRepository.save(comment);
		}).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
	}
	
	//    http://localhost:8080/posts/1/comments/1
	@PutMapping("/posts/{postId}/comments/{id}")
	public Comment updateComment(@PathVariable Long postId, @PathVariable Long id,
			 			@Valid @RequestBody Comment commentReq) {
		
		if(!postRepository.existsById(postId))
			throw new ResourceNotFoundException("Post", "PostId", postId);
		
		return commentRepository.findById(id).map(comment -> {
			comment.setText(commentReq.getText());
			return commentRepository.save(comment);
		}).orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", id));
	}
	
	//  http://localhost:8080/comments/2
	@DeleteMapping("/comments/{id}")
	public void deleteComment(@PathVariable Long id) {
		
		commentRepository.findById(id).map(comment -> {
			commentRepository.delete(comment);
			return comment;
		}).orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", id));
	}	
	
	
	
}
