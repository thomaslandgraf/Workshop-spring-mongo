package com.landgraf.workshopmongo.resources;

import com.landgraf.workshopmongo.domain.Post;
import com.landgraf.workshopmongo.domain.User;
import com.landgraf.workshopmongo.dto.UserDTO;
import com.landgraf.workshopmongo.resources.util.URL;
import com.landgraf.workshopmongo.services.PostService;
import com.landgraf.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;


    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value= "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value= "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text,
                                                 @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value = "maxDate", defaultValue = "") String maxDate){
        text = URL.decodeParam(text);
        Date min = URL.converterDate(minDate, new Date(0L));
        Date max = URL.converterDate(maxDate, new Date());
        List<Post> list = postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }
}
