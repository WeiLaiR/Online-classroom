package com.wei.kt.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KtException  extends RuntimeException {
    private Integer code;
    private String msg;
}
