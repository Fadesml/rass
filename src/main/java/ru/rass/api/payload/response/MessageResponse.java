package ru.rass.api.payload.response;

import lombok.Data;

/**
 * Class MessageResponse.
 *
 * @version 1.0
 * @autor Fadesml
 */
@Data
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }
}
