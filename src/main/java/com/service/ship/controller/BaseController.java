package com.service.ship.controller;

import org.springframework.beans.factory.annotation.Value;
import com.service.ship.constants.PropertiesConstants;

public abstract class BaseController {

	@Value(PropertiesConstants.HOME_PAGE_TITLE)
	protected String title;
}
