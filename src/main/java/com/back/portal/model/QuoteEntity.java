package com.back.portal.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "quotes")
public class QuoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer quoteId;

    @Column(name = "user_id",nullable = false)
    private Integer userId;

    @Column(name = "text")
    private String text;

    @Column(name = "like_counter")
    private int likeCounter;

    @Column(name = "creation_date")
    private Date dateOfCreation;

    @OneToMany(targetEntity = VoteEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "quote_id")
    private Set<VoteEntity> voteEntities;
}
