package pl.oskarpolak.blox.models.forms;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CommentForm {
    @NotEmpty //@Size, @Length, @NotNull, @Email, @Pattern(regexp = "jakis regex")
    private String context;
}
