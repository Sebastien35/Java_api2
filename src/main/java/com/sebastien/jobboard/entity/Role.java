package com.sebastien.jobboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.sebastien.jobboard.roleName;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom_du_role")
    @Enumerated(EnumType.STRING)
    private roleName nom_du_role;

    public void setNom_du_role(roleName nom_du_role) {
        this.nom_du_role = nom_du_role;
    }

    public String getNomDuRole() {
        return nom_du_role.name();
    }




}