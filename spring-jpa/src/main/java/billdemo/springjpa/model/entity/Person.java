package billdemo.springjpa.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@lombok.Generated
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@MappedSuperclass
public class Person extends Default {
    protected String name;
    protected Date birthday;
}
