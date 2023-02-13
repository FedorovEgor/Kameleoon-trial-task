package com.back.portal.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "votes")
public class VoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer voteId;

    @Column(name = "quote_id")
    private Integer quoteId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "is_upvote")
    private Boolean isUpvote;

    @Column(name = "creation_date")
    private Date creationDate;
}
