package com.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {
	private static final Logger log = Logger.getLogger(UomController.class);

	@Autowired
	private IUomService service;
	@Autowired
	private UomValidator uomValidator;

	// 1 to display create uom page
	@RequestMapping("/create")
	public String showCreateUomPage(ModelMap map) {
		// create model attribute object
		map.addAttribute("uom", new Uom());
		return "UomCreate";
	}

	// 2 on click on submit button
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveUomData(@ModelAttribute Uom uom, Errors errors, ModelMap map) {
		
		log.info("Entered into save method");
		
		uomValidator.validate(uom, errors);
		
		log.info("No errors found in save");
		
		if (!errors.hasErrors()) {
			
			log.info("No errors found in save");
			
			try {
				
			Integer uomId = service.saveUom(uom);
			log.debug("uom created with Id:"+uomId);
			String msg = "Uom '" + uomId + "' saved";
			// clear form data
			map.addAttribute("uom", new Uom());
			map.addAttribute("message", msg);
			
			}catch(Exception e){
				log.error("Exception"+e.getMessage());
				map.addAttribute("message","problem in operation");
				
			}
		}
		log.info("About to leave save code");
		return "UomCreate";
	}

	// 3 get data from db to ui
	@RequestMapping("/all")
	public String showUomData(ModelMap map) {
		List<Uom> uoms = service.getAllUoms();
		map.addAttribute("list", uoms);
		return "UomData";
	}

	// 4 delete uom by id
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer uomId, ModelMap map) {
		String msg = null;
		try {
			service.deleteUom(uomId);
			msg = "Uom '" + uomId + "' deleted";

		} catch (HibernateOptimisticLockingFailureException e) {
			msg = "Uom '" + uomId + "'not found";

		}
		List<Uom> uoms = service.getAllUoms();
		map.addAttribute("message", msg);
		map.addAttribute("list", uoms);
		return "UomData";
	}

	// 5 show edit page
	@RequestMapping("/edit")
	public String showUomEdit(@RequestParam("id") Integer uomId, ModelMap map) {
		Uom uom = service.getOneUom(uomId);
		map.addAttribute("uom", uom);
		return "UomEdit";
	}

	// do update operation
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String doUomUpdateData(@ModelAttribute Uom uom, Errors errors, ModelMap map) {
		service.updateUom(uom);
		String msg = "Uom '" + uom.getUomId() + "' Updated";
		List<Uom> uoms = service.getAllUoms();
		map.addAttribute("list", uoms);
		map.addAttribute("message", msg);
		return "UomData";
	}

	// export to excel
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Uom> uoms = service.getAllUoms();
		ModelAndView mav = new ModelAndView();
		mav.setView(new UomExcelView());
		mav.addObject("uoms", uoms);
		return mav;
	}

	// export to pdf
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		List<Uom> uoms = service.getAllUoms();
		ModelAndView mav = new ModelAndView();
		mav.setView(new UomPdfView());
		mav.addObject("uoms", uoms);
		return mav;
	}
}
