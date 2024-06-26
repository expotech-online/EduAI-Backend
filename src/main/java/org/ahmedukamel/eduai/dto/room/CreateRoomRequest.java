package org.ahmedukamel.eduai.dto.room;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.ahmedukamel.eduai.annotation.AllowedRoomCategories;
import org.ahmedukamel.eduai.annotation.ExistSchool;
import org.ahmedukamel.eduai.model.enumeration.RoomCategory;
import org.ahmedukamel.eduai.model.enumeration.RoomType;

public record CreateRoomRequest(
        @NotBlank
        String buildingNumber,

        @NotBlank
        String roomNumber,

        @NotNull
        Integer floorNumber,

        @NotNull
        RoomType type,

        @NotNull
        @AllowedRoomCategories
        RoomCategory category,

        @NotNull
        @Min(value = 0)
        Integer maxCapacity,

        @NotNull
        @Min(value = 1)
        @ExistSchool
        Integer schoolId
) {
}