package com.hcolin.kafka.payload;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    private int id;
    private String firstname;
    private String lastname;

}