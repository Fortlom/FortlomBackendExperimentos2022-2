package com.example.fortlomisw.backend.service;


import com.example.fortlomisw.backend.domain.model.entity.ForumComment;
import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.backend.domain.persistence.ForumCommentRepository;
import com.example.fortlomisw.backend.domain.persistence.ForumRepository;
import com.example.fortlomisw.backend.domain.persistence.UserRepository;
import com.example.fortlomisw.backend.domain.service.ForumCommentService;
import com.example.fortlomisw.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;

@Service
public class ForumCommentServiceImpl implements ForumCommentService {


    private static final String ENTITY = "ForumComment";

    @Autowired
    private  ForumCommentRepository forumcommentRepository;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  ForumRepository forumRepository;



    public ForumCommentServiceImpl() {

    }


    @Override
    public List<ForumComment> getAll() {
        return forumcommentRepository.findAll();
    }

    @Override
    public Page<ForumComment> getAll(Pageable pageable) {
        return forumcommentRepository.findAll(pageable);
    }

    @Override
    public ForumComment getById(Long forumcommentId) {
        return forumcommentRepository.findById(forumcommentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, forumcommentId));
    }

    @Override
    public ForumComment create(Long userId, Long forumId, ForumComment request) {
        Date date = new Date();
        Person user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Person", userId));
        return forumRepository.findById(forumId)
                .map(forums -> {
                    request.setForum(forums);
                    request.setPerson(user);
                    request.setRegisterdate(date);
                    return forumcommentRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Forum", forumId));
    }

    @Override
    public ForumComment update(Long forumcommentId, ForumComment request) {
        return null;
    }

    @Override
    public List<ForumComment> getForumCommentByForumId(Long forumId) {
        return forumcommentRepository.findByForumId(forumId);
    }

    @Override
    public ResponseEntity<?> delete(Long forumcommentId) {
        return forumcommentRepository.findById(forumcommentId).map(forumComment -> {
            forumcommentRepository.delete(forumComment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, forumcommentId));
    }




}
