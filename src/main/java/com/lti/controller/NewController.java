package com.lti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lti.dao.JdbcDao;
import com.lti.model.Login;
import com.lti.model.Registration;
@Controller
public class NewController {
	@Autowired
	private JdbcDao jdbcDAO;
	private String uname;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("register") Registration r) {
		return new ModelAndView("redirect:/LoginPage");
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Login u) {
		ModelAndView mv = new ModelAndView("WelcomePage");
		uname = u.getPass();
		int flag = jdbcDAO.validate(u);
		if (flag > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);

			return mv;
		} else {
			return new ModelAndView("redirect:/index");
		}

	}

}
