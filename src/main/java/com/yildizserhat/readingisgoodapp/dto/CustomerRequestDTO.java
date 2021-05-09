package com.yildizserhat.readingisgoodapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {

    @NotNull(message = "Please do not leave empty.")
    @Size(min = 2, max = 100, message = "First Name must be greater than 2 character and less than 100 character.")
    private String firstName;

    @NotNull(message = "Please provide a name")
    @Size(min = 2, max = 100, message = "Last Name must be greater than 2 character and less than 100 character.")
    private String lastName;

    @NotNull(message = "Please provide a name")
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
    private String email;

    @NotNull(message = "Phone cannot be null")
    @Size(min = 3, max = 14, message = "Phone length should be between 3-14 characters ")
    private String phone;

    private String token;
}
