package com.valencia.ejercicio.models.servicies;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.IEvento;
import com.valencia.ejercicio.models.dao.IInvitado;
import com.valencia.ejercicio.models.entities.Evento;
<<<<<<< HEAD
import com.valencia.ejercicio.reporting.RptEventoArtista;
=======
import com.valencia.ejercicio.models.entities.Invitado;
>>>>>>> ccc5c3c5911bb6ea9230c1c7d010659173c9bc99

@Service
public class EventoService implements IEventoService {
	@Autowired//Inyeccion de dependencia
	private IEvento dao;
	
<<<<<<< HEAD
	@PersistenceContext
	private EntityManager em; 
=======
	@Autowired
	private IInvitado daoInvitado;
>>>>>>> ccc5c3c5911bb6ea9230c1c7d010659173c9bc99
	
	@Override
	@Transactional
	public void save(Evento a) {
		try {
			dao.save(a);
			for(Invitado i : a.getInvitados()) {
				i.setEvento(a);
				this.daoInvitado.save(i);			
			}
		}
		catch(Exception ex) {
				throw ex;
		}
		
		
	}

	@Override
	@Transactional
	public Evento findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Evento> findAll() {
		// TODO Auto-generated method stub
		return (List<Evento> )dao.findAll();
	}

	@Override
	public List<RptEventoArtista> rptEventoArtista() {
		StoredProcedureQuery query = em.createStoredProcedureQuery("eventos_por_artista");
		query.execute();
		List<Object[]> datos = query.getResultList();
		return datos.stream()
				.map(r-> new RptEventoArtista((String)r[0],(BigInteger)r[1] ))
				.collect(Collectors.toList());
	}

	
}
