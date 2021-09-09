package br.com.rafabank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.rafabank.model.Account;
import br.com.rafabank.repository.AccountRepository;
import br.com.rafabank.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "name", "asc", model);		
	}
	
	@GetMapping("/showNewAccountForm")
	public String showNewAccountForm(Model model) {
		Account account = new Account();
		model.addAttribute("account", account);
		return "new_account";
	}
	
	@PostMapping("/saveAccount")
	public String saveAccount(@ModelAttribute("account") Account account) {
		accountService.saveAccount(account);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{codigo}")
	public String showFormForUpdate(@PathVariable ( value = "codigo") long codigo, Model model) {
		
		Account account = accountService.getAccountByCodigo(codigo);
		
		model.addAttribute("account", account);
		return "update_account";
	}
	
	
	@GetMapping("/deleteAccount/{codigo}")
	public String deleteAccount(@PathVariable (value = "codigo") long codigo) {
		
		this.accountService.deleteAccountByCodigo(codigo);
		return "redirect:/";
	}
	
	
	@PostMapping("/findAccount")
	public ModelAndView find(@RequestParam("nomePesquisa") String nomePesquisa) {
		ModelAndView modelAndView = new ModelAndView("/index");
		modelAndView.addObject("listAccount", accountRepository.findAccountByName(nomePesquisa));
		
		return modelAndView;
		
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Account> page = accountService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Account> listAccount = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listAccount", listAccount);
		return "index";
	}
}
