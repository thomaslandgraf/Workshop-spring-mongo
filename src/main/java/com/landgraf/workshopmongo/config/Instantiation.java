package com.landgraf.workshopmongo.config;

import com.landgraf.workshopmongo.domain.Post;
import com.landgraf.workshopmongo.domain.User;
import com.landgraf.workshopmongo.dto.AuthorDTO;
import com.landgraf.workshopmongo.repository.PostRepository;
import com.landgraf.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation  implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("04/02/2026"), "Let's travel", "I'm going to NY tomorrow morning!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("04/02/2026"), "Good Morning", "Hope you guys have a great day today!", new AuthorDTO(alex));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

    }
}
