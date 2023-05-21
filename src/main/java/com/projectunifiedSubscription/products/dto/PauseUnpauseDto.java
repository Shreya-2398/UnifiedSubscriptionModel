package com.projectunifiedSubscription.products.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PauseUnpauseDto {

    private int id;
    private boolean paused;
}
