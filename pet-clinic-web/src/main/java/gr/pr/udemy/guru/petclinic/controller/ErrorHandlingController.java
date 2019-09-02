package gr.pr.udemy.guru.petclinic.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorHandlingController implements ErrorController {

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {

		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null) {
			Integer statusCOde = Integer.valueOf(status.toString());

			if (statusCOde == HttpStatus.NOT_FOUND.value()) {
				return "errors/notFound";
			}
			else if (statusCOde == HttpStatus.FORBIDDEN.value()) {
				return "errors/notAuthorized";
			}
		}
		return "errors/genericError";

	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
