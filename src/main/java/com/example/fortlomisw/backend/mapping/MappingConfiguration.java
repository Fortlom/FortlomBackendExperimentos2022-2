package com.example.fortlomisw.backend.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("FortlomMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public FanaticMapper fanaticMapper() {
        return new FanaticMapper();
    }

    @Bean
    public ArtistMapper artistMapper() {
        return new ArtistMapper();
    }

    @Bean
    public ForumMapper forumMapper() {
        return new ForumMapper();
    }

    @Bean
    public PublicationMapper publicationMapper(){
        return new PublicationMapper();
    }

    @Bean
    public PublicationCommentMapper publicationCommentMapper(){
        return new PublicationCommentMapper();
    }

    @Bean
    public EventMapper eventMapper(){
        return new EventMapper();
    }

    @Bean
    public ForumCommentMapper forumcommentMapper(){ return new ForumCommentMapper(); }

    @Bean
    public FollowMapper followMapper(){ return new FollowMapper(); }


    @Bean
    public RateMapper rateMapper(){ return new RateMapper(); }


    @Bean
    public ReportMapper reportMapper(){ return new ReportMapper(); }

    @Bean
    public MultimediaMapper multimediaMapper(){ return new MultimediaMapper(); }

    @Bean
    public PersonMapper personMapper(){ return new PersonMapper(); }
}
