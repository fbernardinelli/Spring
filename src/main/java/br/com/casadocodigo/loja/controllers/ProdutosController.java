package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;

@Controller
@RequestMapping(value="/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoDAO dao;
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
    	binder.addValidators(new ProdutoValidation());
    }

    @RequestMapping("/form")
    public ModelAndView form() {
    	ModelAndView modelAndView = new ModelAndView("produtos/form");
    	modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView grava(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
    	
    	if (result.hasErrors()){
    		return form();
    	}

    	dao.gravar(produto);

        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
		return new ModelAndView("redirect:produtos");
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView listaProduto(){
    	List<Produto> lista = dao.listaProdutos();
    	
    	ModelAndView modelAndView = new ModelAndView("produtos/lista");
    	modelAndView.addObject("produtos", lista);
    	
    	return modelAndView;
    	
    }
    
}
