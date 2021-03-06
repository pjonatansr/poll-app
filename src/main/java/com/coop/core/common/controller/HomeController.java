package com.coop.core.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

  /**
   * Test comment
   * 
   * @return String
   */
  @RequestMapping(method = RequestMethod.GET)
  public String home() {
    return "redirect:/swagger-ui/index.html";
  }
}
