package ProjetAJC.ProjetAJCSpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, value = HttpStatus.BAD_REQUEST, reason = "donnees invalides")
public class UserInvalidException extends RuntimeException {

}
