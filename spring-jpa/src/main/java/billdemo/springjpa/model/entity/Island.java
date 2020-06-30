package billdemo.springjpa.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@lombok.Generated
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Island extends Default {
    private String name;
}
