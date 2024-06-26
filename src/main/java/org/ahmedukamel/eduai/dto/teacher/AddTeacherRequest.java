package org.ahmedukamel.eduai.dto.teacher;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.ahmedukamel.eduai.annotation.ExistRegion;
import org.ahmedukamel.eduai.annotation.UniquePhone;
import org.ahmedukamel.eduai.annotation.UserUnique;
import org.ahmedukamel.eduai.annotation.enumeration.UniquePhoneConstraint;
import org.ahmedukamel.eduai.annotation.enumeration.UserUniqueConstraint;
import org.ahmedukamel.eduai.constant.RegexConstants;
import org.ahmedukamel.eduai.model.enumeration.Gender;
import org.ahmedukamel.eduai.model.enumeration.Nationality;
import org.ahmedukamel.eduai.model.enumeration.Religion;

import java.time.LocalDate;

public record AddTeacherRequest(
        @NotBlank
        @UserUnique(constraint = UserUniqueConstraint.USERNAME)
        String username,

        @Email
        @NotBlank
        @UserUnique(constraint = UserUniqueConstraint.EMAIL)
        String email,

        @NotBlank
        @Pattern(regexp = RegexConstants.PASSWORD)
        String password,

        @NotBlank
        @UserUnique(constraint = UserUniqueConstraint.NID)
        String nid,

        @NotNull
        Religion religion,

        @NotNull
        Gender gender,

        @NotNull
        Nationality nationality,

        @NotNull
        @ExistRegion
        Integer regionId,

        @NotNull
        LocalDate birthDate,

        @NotBlank
        @UniquePhone(entity = UniquePhoneConstraint.TEACHER)
        String number,

        @NotBlank
        String firstName_en,

        @NotBlank
        String firstName_ar,

        @NotBlank
        String firstName_fr,

        @NotBlank
        String lastName_en,

        @NotBlank
        String lastName_ar,

        @NotBlank
        String lastName_fr,

        @NotBlank
        String about_en,

        @NotBlank
        String about_ar,

        @NotBlank
        String about_fr,

        @NotBlank
        String qualification_en,

        @NotBlank
        String qualification_ar,

        @NotBlank
        String qualification_fr
) implements ITeacherRegistrationRequest {
}