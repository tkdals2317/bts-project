package com.sangmin.bts.domain.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sangmin.bts.domain.BaseEntity;
import com.sangmin.bts.utils.RegexPattern;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.intellij.lang.annotations.Pattern;

/**
 * 멤버 Entity
 */
@Table(
        name = "member",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_member_001", columnNames = "email"),
                @UniqueConstraint(name = "uk_member_002", columnNames = "phone"),
        })
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(value = RegexPattern.EMAIL_REGEX)
    @Column(nullable = false, length = 350)
    private String email;

    @Column(nullable = false, length = 100)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false, length = 40)
    private String memberName;

    @Column(nullable = false, length = 40)
    private String nickName;

    @Column(length = 100)
    @Pattern(value = RegexPattern.PHONE_REGEX)
    private String phone;

    @Column(length = 100)
    private String department;

}