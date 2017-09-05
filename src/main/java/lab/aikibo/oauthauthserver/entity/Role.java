package lab.aikibo.oauthauthserver.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tamami on 05/09/17.
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    @Getter @Setter @NonNull
    private String name;
}
