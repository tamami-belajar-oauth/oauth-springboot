package lab.aikibo.oauthauthserver.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by tamami on 05/09/17.
 */
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    @Getter @Setter @NonNull
    private String username;

    @Getter @Setter @NonNull
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Getter @Setter @NonNull
    private List<Role> roles;

}
