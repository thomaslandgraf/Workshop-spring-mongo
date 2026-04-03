package com.landgraf.workshopmongo.services;

import com.landgraf.workshopmongo.domain.Post;
import com.landgraf.workshopmongo.domain.User;
import com.landgraf.workshopmongo.repository.PostRepository;
import com.landgraf.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found!"));
    }

}
