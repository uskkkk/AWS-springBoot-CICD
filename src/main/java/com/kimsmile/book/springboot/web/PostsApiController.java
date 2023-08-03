package com.kimsmile.book.springboot.web;

import com.kimsmile.book.springboot.service.posts.PostsService;
import com.kimsmile.book.springboot.web.dto.PostsResponseDto;
import com.kimsmile.book.springboot.web.dto.PostsSaveRequestDto;
import com.kimsmile.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PostsApiController {

    private final PostsService postsService;



    @PostMapping("/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PostMapping("/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id,requestDto);
    }

    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
