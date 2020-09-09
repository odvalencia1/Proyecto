package com.valencia.ejercicio.models.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valencia.ejercicio.models.dao.IInstrumento;
import com.valencia.ejercicio.models.entities.Instrumento;

@Service
public class InstrumentoService implements IInstrumentoService {

	@Autowired
	private IInstrumento dao;
	
	@Override
	@Transactional
	public void save(Instrumento i) {
		dao.save(i);
		
	}

	@Override
	@Transactional
	public List<Instrumento> findAll() {
		return (List<Instrumento>)dao.findAll();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

}
