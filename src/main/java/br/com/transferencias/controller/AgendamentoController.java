package br.com.transferencias.controller;

import br.com.transferencias.dao.AgendamentoDAO;
import br.com.transferencias.dao.filter.AgendamentoFilter;
import br.com.transferencias.model.Agendamento;
import br.com.transferencias.model.TipoOperacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/**
 * Created by andreasl on 22/12/15.
 */
@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {

  @Autowired
  private AgendamentoDAO agendamentoDAO;


  @RequestMapping("/novo")
  public ModelAndView novo() {
    ModelAndView mv = new ModelAndView("addagendamento");
    mv.addObject(new Agendamento());
    return mv;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView adicionar(@Validated Agendamento agendamento, Errors errors, RedirectAttributes attributes) {
    ModelAndView mv = new ModelAndView();
    if (errors.hasErrors()) {
      mv.setViewName("addagendamento");
      return mv;
    }

    agendamentoDAO.guardar(agendamento);

    mv.setViewName("redirect:/agendamento/novo");
    attributes.addFlashAttribute("mensagem", "Transferência efetuada com sucesso!");
    return mv;
  }

  @RequestMapping("/pesquisa")
  public ModelAndView pesquisa() {
    ModelAndView mv = new ModelAndView("listaragendamentos");
    mv.addObject("filtro", new AgendamentoFilter());
    return mv;
  }

  @RequestMapping
  public ModelAndView filtrar(@ModelAttribute("filtro") AgendamentoFilter filtro) {
    ModelAndView mv = new ModelAndView("listaragendamentos");
    List<Agendamento> agendamentosFiltrados = agendamentoDAO.filtrar(filtro);
    mv.addObject(agendamentosFiltrados);

    return mv;
  }

  @ModelAttribute
  public List<TipoOperacao> tiposTaxas() {
    return Arrays.asList(TipoOperacao.values());
  }

}
