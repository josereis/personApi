package br.com.studyproject.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
    COMMERCIAL("Commercial"),
    MOBILE("Mobile"),
    HOME("Home");

    private final String description;
}
