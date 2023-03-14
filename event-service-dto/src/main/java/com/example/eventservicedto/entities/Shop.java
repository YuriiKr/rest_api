package com.example.eventservicedto.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shop")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_number")
    @SequenceGenerator(name = "seq_number", sequenceName = "seq_number", allocationSize = 1)
    private Long id;

    private String name;

    private String address;

    @JsonManagedReference
    @OneToMany(mappedBy="shop", fetch = FetchType.LAZY)
    private List<Vehicle> vehicle;
}
