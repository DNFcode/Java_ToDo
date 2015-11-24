package ru.ifmo.database;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;

/**
 * Created by nikolayemrikh on 23.11.15.
 */
@Entity
@Table(name = "USER_VERIFY")
public class UserVerify {
    @Id
    //@GeneratedValue(generator="gen")
    //@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="user"))
    @Column(name = "USER_ID", unique=true)
    private Long userId;
    @Column(name = "HASH")
    private String hash;


    public UserVerify () {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}
