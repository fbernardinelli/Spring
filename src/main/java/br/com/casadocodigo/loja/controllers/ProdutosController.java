package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;

@Controller
public class ProdutosController {

    @Autowired
    private ProdutoDAO dao;

    @RequestMapping("/produtos/form")
    public String form() {
        return "produtos/form";
    }

    @RequestMapping("/produtos")
    public String grava(Produto produto) {

        dao.gravar(produto);

        return "produtos/ok";
    }
}
