package com.example.webappspringboot;

import javax.persistence.*;

@Entity
@Table(name = "usertypelinks")
public class Usertypelink {
    @Id
    @Column(name = "id", nullable = false, length = 5)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usertypelinks_id_seq")
//    @SequenceGenerator(name = "usertypelinks_id_seq", sequenceName = "usertypelinks_id_seq", allocationSize = 1)
    private String id;

    @Column(name = "username", length = 40)
    private String username;

    @Column(name = "type", length = 20)
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}