package com.kimsmile.book.springboot.web;

import com.kimsmile.book.springboot.config.auth.LoginUser;
import com.kimsmile.book.springboot.config.auth.dto.SessionUser;
import com.kimsmile.book.springboot.service.posts.PostsService;
import com.kimsmile.book.springboot.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    public IndexController(PostsService postsService, HttpSession httpSession) {
        this.postsService = postsService;
        this.httpSession = httpSession;
    }

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts",postsService.findAllDesc());


        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto =postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }
}
