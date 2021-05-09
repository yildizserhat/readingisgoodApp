package com.yildizserhat.readingisgoodapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {
    private boolean success;
    private String message;
    private T object;
}
