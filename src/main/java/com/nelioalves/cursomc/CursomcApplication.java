package com.nelioalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.CategoriaDomain;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
//import com.sun.tools.javac.code.Attribute.*;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CategoriaDomain cat1 = new CategoriaDomain(null,"informática");
		CategoriaDomain cat2 = new CategoriaDomain(null,"escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}

}
