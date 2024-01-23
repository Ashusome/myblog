package com.myblog9.serviceimpl;

import com.myblog9.entity.Post;
import com.myblog9.exception.ResourceNotFound;
import com.myblog9.payload.PostDto;
import com.myblog9.repository.PostRepository;
import com.myblog9.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    @Override
    public PostDto savePost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedPost = postRepo.save(post);
        PostDto dto = mapToDto(savedPost);
        return dto;
    }

    @Override
    public void deletePostById(Long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Post Not Found with id:" + id));
        postRepo.deleteById(id);
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Post not found with id: " + id));
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFound("post not found with id: "));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getDescription());
        Post savedPost = postRepo.save(post);
        PostDto dto = mapToDto(savedPost);
        return dto;


    }

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Post> pagePostObjects = postRepo.findAll(pageable);
        List<Post> Posts = pagePostObjects.getContent();
        List<PostDto> dto = (List<PostDto>) Posts.stream().map(post->mapToDto(post).Collect(Collectors.toList()));

        return dto;
    }

    Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

        
        PostDto mapToDto(Post savedPost){
        PostDto postDto = new PostDto();
        postDto.setId(savedPost.getId());
        postDto.setTitle(savedPost.getTitle());
        postDto.setDescription(savedPost.getDescription());
        postDto.setContent(savedPost.getContent());
        return postDto;
        

    }
}
