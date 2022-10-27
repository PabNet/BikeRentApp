package bsuir.ris.lab1.services;

import bsuir.ris.lab1.additions.web.Address;
import org.springframework.stereotype.Service;

@Service
public class ErrorService {

    public String getReadyErrorPage(String header, String content) {
        return String.format("/runtimeError/%s/%s",
                             header,
                             content);
    }
}
