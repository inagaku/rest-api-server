package com.example.restapiserver.models;

import lombok.CustomLog;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "criteries", schema = "public")
public class Criterion {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;

    @Column(name = "start_value")
    double startValue;
    @Column(name = "end_value")
    double endValue;
    @Column
    String subway;
}
