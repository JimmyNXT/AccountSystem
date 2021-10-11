package za.ac.nwu.as.domain.ResponseObjects;

import java.io.Serializable;

public class ErrorMessage implements Serializable {

    private static final long serialVersionUID = 6779566161150168088L;

    private String Details;

    public ErrorMessage(String details) {
        Details = details;
    }
}
