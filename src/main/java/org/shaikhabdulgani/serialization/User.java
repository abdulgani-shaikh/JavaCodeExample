package org.shaikhabdulgani.serialization;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private String username;
    private String name;
    private int age;
    private String[] skills;
}
