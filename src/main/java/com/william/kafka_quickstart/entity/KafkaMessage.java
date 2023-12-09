package com.william.kafka_quickstart.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KafkaMessage {

    @NotBlank
    private String topicName;

    @NotNull
    @Min(1)
    private Integer partition;

    @NotBlank
    private String messageKey;

    @NotNull
    @Min(1)
    private Integer messageId;

    @NotBlank
    private String message;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime generatedAt;

    @NotNull
    private Boolean readFlg;

}
