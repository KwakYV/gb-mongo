package com.example.gbmongo.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    private Product product;
    private Integer count;
}
