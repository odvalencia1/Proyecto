package com.valencia.ejercicio.models.servicies;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.IEvento;
import com.valencia.ejercicio.models.dao.IInvitado;
import com.valencia.ejercicio.models.entities.Evento;
import com.valencia.ejercicio.models.entities.Genero;
import com.valencia.ejercicio.reporting.RptEventoArtista;
import com.valencia.ejercicio.reporting.RptEventoArtistaGeneroMusical;
import com.valencia.ejercicio.reporting.RptEventoMes;
import com.valencia.ejercicio.models.entities.Invitado;

@Service
public class EventoService implements IEventoService {
	@Autowired // Inyeccion de dependencia
	private IEvento dao;

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private IInvitado daoInvitado;
	@Autowired
	private IGeneroService srvGenero;

	private BigInteger numero;

	@Override
	@Transactional
	public void save(Evento a) {
		try {
			dao.save(a);
			for (Invitado i : a.getInvitados()) {
				i.setEvento(a);
				this.daoInvitado.save(i);
			}
		} catch (Exception ex) {
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
		return (List<Evento>) dao.findAll();
	}

	@Override
	public List<RptEventoArtista> rptEventoArtista() {
		StoredProcedureQuery query = em.createStoredProcedureQuery("eventos_por_artista");
		query.execute();
		List<Object[]> datos = query.getResultList();
		return datos.stream().map(r -> new RptEventoArtista((String) r[0], (BigInteger) r[1]))
				.collect(Collectors.toList());
	}

	@Override
	public List<RptEventoMes> rptEventoMes(Integer id) {
		StoredProcedureQuery query = em.createStoredProcedureQuery("eventos_por_mes");
		query.registerStoredProcedureParameter("pr_artista", Integer.class, ParameterMode.IN);
		query.setParameter("pr_artista", id);
		query.execute();
		query.execute();
		List<Object[]> datos = query.getResultList();
		return datos.stream().map(r -> new RptEventoMes((String) r[0], (BigInteger) r[1])).collect(Collectors.toList());
	}

	@Override
	public List<List<RptEventoArtistaGeneroMusical>> rptEventoArtistaGeneroMusical(List<Evento> eventos) {
		List<Genero> generos = srvGenero.findAll();
		List<List<RptEventoArtistaGeneroMusical>> artistas = new ArrayList<List<RptEventoArtistaGeneroMusical>>();
		List<List<RptEventoArtistaGeneroMusical>> artistasGenero = new ArrayList<List<RptEventoArtistaGeneroMusical>>();
		for (Evento e : eventos) {
			StoredProcedureQuery query = em.createStoredProcedureQuery("eventos_por_artistas_generos");
			query.registerStoredProcedureParameter("pr_evento", Integer.class, ParameterMode.IN);
			query.setParameter("pr_evento", e.getIdEvento());
			query.execute();
			query.execute();
			List<Object[]> datos = query.getResultList();
			artistas.add(datos.stream().map(r -> new RptEventoArtistaGeneroMusical((String) r[0], (BigInteger) r[1],(String) r[2]))
					.collect(Collectors.toList()));
			{

			}

		}
		for (Genero g:generos) {
			int i=0;
			List<RptEventoArtistaGeneroMusical> datos2=new ArrayList<RptEventoArtistaGeneroMusical>();
			for (List<RptEventoArtistaGeneroMusical> a:artistas ) {
				numero = BigInteger.valueOf(0);
				RptEventoArtistaGeneroMusical art= new RptEventoArtistaGeneroMusical();
				for (RptEventoArtistaGeneroMusical mu: a) {
					if(mu.getGenero().toString().equals(g.getNombre().toString())) {
						numero= numero.add(BigInteger.valueOf(mu.getArtistas().longValue()));						
					}
					art.setEvento("Evento "+mu.getEvento());
				}
				i++;
				art.setGenero(g.getNombre());
				art.setArtistas(numero);
				
				datos2.add(art);
			}
			artistasGenero.add(datos2);
		}
		return artistasGenero;
	}

}
