package com.back.portal.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column(name = "user_first_name")
    private String firstName;

    @Column(name = "user_last_name")
    private String lastName;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_email")
    private String email;

    @Column(name = "registration_date")
    private Date registrationDate;

    @OneToMany(targetEntity = QuoteEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Set<QuoteEntity> quoteEntitySet;

    @OneToMany(targetEntity = VoteEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Set<VoteEntity> voteEntititySet;

}
