package org.ahmedukamel.eduai.dto.user;

import org.ahmedukamel.eduai.model.enumeration.Gender;
import org.ahmedukamel.eduai.model.enumeration.Nationality;
import org.ahmedukamel.eduai.model.enumeration.Religion;

import java.time.LocalDate;

public interface IUserRegistrationRequest {
    String username();

    String email();

    String password();

    String nid();

    Gender gender();

    Nationality nationality();

    Integer regionId();

    String firstName_en();

    String firstName_ar();

    String firstName_fr();

    String lastName_en();

    String lastName_ar();

    String lastName_fr();

    String about_en();

    String about_ar();

    String about_fr();

    LocalDate birthDate();

    Religion religion();
}