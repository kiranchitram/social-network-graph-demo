package com.example.socialnetwork.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Node("User")
@JsonIgnoreProperties("friends")  // avoid infinite recursion in JSON
public class User {
    @Id
    private String name;

    @Relationship(type = "FRIEND")
    private List<User> friends;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public List<User> getFriends() { return friends; }
}
