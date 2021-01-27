package simple.rest.server.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import simple.rest.server.models.server.response.SimpleServerResponse;


@ControllerAdvice
public class ErrorController {

    private static Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(Throwable.class)
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SimpleServerResponse exception(final Throwable throwable, final Model model) {
        logger.error("Exception during execution of SpringSecurity application", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        return new SimpleServerResponse()
                .setMessage(errorMessage)
                .setError(true);
    }

}
