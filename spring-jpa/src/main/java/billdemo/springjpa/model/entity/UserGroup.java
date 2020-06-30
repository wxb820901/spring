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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.List;

@lombok.Generated
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
public class UserGroup extends Default {
    private String groupName;
    private String groupId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userGroup")
    @JoinTable(name="UserGroup_User",
            joinColumns={@JoinColumn(name="group_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="id")})
    private List<User> users;
}
