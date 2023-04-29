package com.apiuniversity.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idUser;

    @Column(nullable = false , length = 150)
    private String lastName;

    @Column(nullable = false, length = 150 )
    private String firstName;

    @ManyToOne
    @JoinColumn( name = "id_type_identification", foreignKey = @ForeignKey(name = "FK_TYPE_IDENTIFICATION"))
    private TypeIdentification typeIdentification;

    @Column(length = 15, nullable = false, unique = true)
    private String identification;

    @Column(length = 25)
    private String phone;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "id_user" , referencedColumnName = "idUser") ,
            inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole")
    )
    private List<Role> roles;

}
