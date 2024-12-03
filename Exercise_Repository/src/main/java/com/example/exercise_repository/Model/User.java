package com.example.exercise_repository.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "myUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can not be Empty")
    @Size(min = 4 ,max = 20)
    @Column(columnDefinition = "varchar(20) not null")
    private String name ;

    @NotEmpty(message = "username can not be Empty")
    @Size(min = 4, message = "must be more than 4")
    @Column(unique = true, columnDefinition = "varchar(15) not null")
    private String userName ;

    @NotEmpty(message = "can not be null")
    @Size(min = 6 , max = 20 , message = "must be between 6 or 12 letter")
//    @Pattern(regexp = )
    @Column(columnDefinition = "varchar(20)")
    private String password ;

    @NotEmpty(message = "email can not be null")
    @Email
    @Column(columnDefinition = "varchar(50) not null")

    private String email ;

    @NotEmpty(message = "Role can not be empty")
//    @Pattern(regexp = "^(user|admin)$" , message = "Enter between user OR admin")
    @Column(columnDefinition = "varchar(5) not null")
    @Check(constraints = "role=user OR role=admin")
    private String role;
//
    @NotNull(message = "age can not be null")
    @Positive
    @Column(columnDefinition = "int not null")
    @Check(constraints = "age>=15")
//    @Size(min = 15 , message = "must be more than 15 letter")
    private Integer age;




}
