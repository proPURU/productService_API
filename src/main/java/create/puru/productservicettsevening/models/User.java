package create.puru.productservicettsevening.models;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Column(nullable = false,unique = true)
    @NotNull

    private String email;

}
