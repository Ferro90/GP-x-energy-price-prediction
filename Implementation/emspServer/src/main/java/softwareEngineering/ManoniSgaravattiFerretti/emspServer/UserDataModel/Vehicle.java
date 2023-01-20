package softwareEngineering.ManoniSgaravattiFerretti.emspServer.UserDataModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
@EnableAutoConfiguration
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name="vin_code", nullable = false, unique = true)
    private Long VINCode;
    private String socketType;
    private String model;
    @OneToMany(mappedBy = "vehicle")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<UserVehicle> usersList = new ArrayList<>();
}
