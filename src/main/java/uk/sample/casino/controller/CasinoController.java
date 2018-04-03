package uk.sample.casino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Casino app main controller.
 */
@Controller
public class CasinoController {

    /**
     * Casino app main page.
     *
     * @return main page content
     */
    @GetMapping("/")
    @ResponseBody
    public String getIndex() {
        return "Hello";
    }

}
