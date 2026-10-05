package edu.ifmt.cobrancaifmt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ifmt.cobrancaifmt2.model.Titulo;
import edu.ifmt.cobrancaifmt2.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {

    @Autowired
    private Titulos titulos;

    @RequestMapping("/novo")
    public String novo() {
        return "CadastroTitulo";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(Titulo titulo) {
        titulos.save(titulo);
        ModelAndView mv = new ModelAndView("CadastroTitulo");
        mv.addObject("mensagem", "Foi salvo com sucesso!");
        return mv;
    }
}