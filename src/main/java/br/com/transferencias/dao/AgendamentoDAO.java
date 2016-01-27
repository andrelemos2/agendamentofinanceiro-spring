package br.com.transferencias.dao;

import br.com.transferencias.dao.filter.AgendamentoFilter;
import br.com.transferencias.model.Agendamento;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by andreasl on 22/12/15.
 */
@Repository
public class AgendamentoDAO {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional
  public void guardar(Agendamento agendamento) {
    entityManager.persist(agendamento);
  }

  @SuppressWarnings("unchecked")
  @Transactional(readOnly = true)
  public List<Agendamento> filtrar(AgendamentoFilter filtro) {
    Session session = entityManager.unwrap(Session.class);
    Criteria criteria = session.createCriteria(Agendamento.class);

    if (filtro.getTipoOperacao() != null) {
      criteria.add(Restrictions.eq("tipoOperacao", filtro.getTipoOperacao()));
    }

    if (filtro.getValorInicial() != null) {
      criteria.add(Restrictions.ge("valor", filtro.getValorInicial()));
    }

    if (filtro.getValorFinal() != null) {
      criteria.add(Restrictions.le("valor", filtro.getValorFinal()));
    }

    return criteria.list();
  }

}
