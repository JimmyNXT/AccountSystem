package za.ac.nwu.as.domain.service;

import za.ac.nwu.as.domain.ResponseObjects.ErrorMessage;

public class ErrorResponse extends GeneralResponse<ErrorMessage> {

    public ErrorResponse(ErrorMessage payload) {
        super(false, payload);
    }
}
