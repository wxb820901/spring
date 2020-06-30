package billdemo.springjpa.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@lombok.Generated
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class User extends Person {
    private String userId;
    private String userName;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = UserGroup.class)
    private UserGroup userGroup;
}
