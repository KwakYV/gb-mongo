package com.example.gbmongo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Product {
    @Id
    private String id;
    @Indexed(unique = true)
    private String title;
    private BigDecimal cost;

    @JsonDeserialize(
            using = LocalDateDeserializer.class
    )
    @JsonSerialize(
            using = LocalDateSerializer.class
    )
    private LocalDate manufactureDate;
    private Manufacturer manufacturer;
    private Set<Category> categories;
    private Status status;
}
