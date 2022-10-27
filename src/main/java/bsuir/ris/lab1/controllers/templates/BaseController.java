package bsuir.ris.lab1.controllers.templates;

import bsuir.ris.lab1.additions.errors.ErrorContent;
import bsuir.ris.lab1.additions.errors.ErrorHeader;
import bsuir.ris.lab1.services.CookieService;
import bsuir.ris.lab1.services.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.HashMap;

@Component
public class BaseController {

    protected final String RedirectTemplate = "redirect:";

    @Autowired
    protected ErrorService errorService;

    @Autowired
    protected CookieService cookieService;

    protected String showViewWithTable(String viewName,
                                       HashMap<String, Object> attributes,
                                       Model model) {
        var view = "";
        try {
            model.addAllAttributes(attributes);
            view = viewName;
        } catch (Exception ex) {
            view = errorService.getReadyErrorPage(ErrorHeader.Common.Text,
                    ErrorContent.Common.Text + ex.getMessage());
        }

        return view;
    }

    protected String showViewWithTable(String viewName,
                                       String errorViewName,
                                       String attributeName,
                                       Object attributeValue,
                                       Model model) {
        var view = "";
        try {
            if (attributeValue != null) {
                model.addAttribute(attributeName, attributeValue);
                view = viewName;
            } else {
                view = RedirectTemplate + errorViewName;
            }
        } catch (Exception ex) {
            view = RedirectTemplate + errorService.getReadyErrorPage(ErrorHeader.Common.Text,
                    ErrorContent.Common.Text + ex.getMessage());
        }

        return view;
    }


}
