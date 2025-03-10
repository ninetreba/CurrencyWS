package com.example.CurrencyWS.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "currency_pair", uniqueConstraints = @UniqueConstraint(columnNames = {"base_charcode", "quoted_charcode"}))
public class CurrencyPair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "base_charcode", length = 5, nullable = false)
    private String baseCharcode;

    @Column(name = "quoted_charcode", length = 5, nullable = false)
    private String quotedCharcode;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

}