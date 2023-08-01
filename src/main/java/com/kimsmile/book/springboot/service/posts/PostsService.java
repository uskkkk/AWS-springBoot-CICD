package com.kimsmile.book.springboot.service.posts;

import com.kimsmile.book.springboot.domain.posts.Posts;
import com.kimsmile.book.springboot.domain.posts.PostsRepository;
import com.kimsmile.book.springboot.web.dto.PostsResponseDto;
import com.kimsmile.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

//    public PostsService(PostsRepository postsRepository) {
//        this.postsRepository = postsRepository;
//    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id,PostsSaveRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다.  id= " + id));

        return new PostsResponseDto(entity);
    }
}
