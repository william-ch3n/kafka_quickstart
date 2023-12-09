package com.william.kafka_quickstart.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class KafkaTopic {

    @NotBlank
    private String name;

    @NotNull
    @Min(1)
    private Integer numPartitions;

    @NotNull
    @Min(1)
    private Short replicationFactor;

}
