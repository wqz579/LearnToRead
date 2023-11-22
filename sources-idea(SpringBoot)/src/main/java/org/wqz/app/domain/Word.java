package org.wqz.app.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Word
{
    private Integer id;
    @NotBlank(message = "字名不允许为空")
    private String name;
}
