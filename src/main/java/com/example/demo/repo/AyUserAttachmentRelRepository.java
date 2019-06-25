package com.example.demo.repo;


import com.example.demo.model.AyUserAttachmentRel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AyUserAttachmentRelRepository extends MongoRepository<AyUserAttachmentRel,String> {

}
