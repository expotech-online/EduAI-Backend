package org.ahmedukamel.eduai.dto.teacher;

import org.ahmedukamel.eduai.dto.user.IUserRegistrationRequest;

public interface ITeacherRegistrationRequest extends IUserRegistrationRequest {
    String number();

    String qualification_en();

    String qualification_ar();

    String qualification_fr();
}