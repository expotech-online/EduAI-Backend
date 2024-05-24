package org.ahmedukamel.eduai.mapper.position;

import org.ahmedukamel.eduai.dto.position.PositionResponse;
import org.ahmedukamel.eduai.model.Position;
import org.ahmedukamel.eduai.model.enumeration.Language;
import org.ahmedukamel.eduai.util.position.PositionUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PositionResponseMapper implements Function<Position, PositionResponse> {
    @Override
    public PositionResponse apply(Position position) {
        return new PositionResponse(
                position.getId(),
                PositionUtils.getPositionDetails(position, Language.ENGLISH).getTitle(),
                PositionUtils.getPositionDetails(position, Language.ARABIC).getTitle(),
                PositionUtils.getPositionDetails(position, Language.FRENCH).getTitle(),
                position.getCreatedAt(),
                position.getUpdatedAt(),
                position.getDepartment().getId()
        );
    }
}