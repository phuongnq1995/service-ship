package com.service.ship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.service.ship.constants.ParamConstants;
import com.service.ship.constants.RequestPath;
import com.service.ship.constants.ViewPage;

@Controller
public class HomeController extends BaseController {

	@GetMapping(RequestPath.HOME)
	public String homePage(Model model) {

		model.addAttribute(ParamConstants.PARAM_TITLE, title);

		return ViewPage.HOME;
	}

	/**
	 * load page index
	 * @param model
	 * @return String
	 * @author DungNQ
	 */
	@GetMapping("/index")
	public String indexPage(Model model) {
		model.addAttribute("title", title);
		return "index"; 
	}
}
