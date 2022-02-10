/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.samples.petclinic.vet.SpecialityRepository;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.samples.petclinic.visit.VisitRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class PetClinicApplication {
	private static final Logger LOG = LoggerFactory.getLogger(PetClinicApplication.class);
    public static void main(String[] args) throws Exception {
        SpringApplication.run(PetClinicApplication.class, args);
   
        
    }

    @Bean
    public CommandLineRunner demoVetRepository(VetRepository vetRepository, SpecialityRepository specialityRepository, PetRepository petRepository, VisitRepository visitRepository) {
    	return (args) -> {
    		
    		LOG.info("********************************************************");
    		LOG.info("BOOTCAMP -Spring y Spring Data - vetRepository");
    		LOG.info("********************************************************");
    		/*	
    		LOG.info("Creamos un objeto Vet");
    		Vet vet = new Vet();
    		vet.setFirstName("Manuel");
    		vet.setLastName("Vargas Llosa");
    		
    		LOG.info("Persistimos en BBDD");
    		vet = vetRepository.save(vet);
    		
    		LOG.info("Comprobamos que se ha creado correctamente");
    		Vet vetAux = vetRepository.findOne(vet.getId());
    		LOG.info(vetAux.toString());
    		
    		LOG.info("Editamos el objeto añadimos una Speciality");
    		Specialty s = specialityRepository.findOne(1);
    		vet.addSpecialty(s);
    		vet=vetRepository.save(vet);
    		LOG.info(vet.toString());
    	
    		LOG.info("Listamos todos los veterinarios");
    		for(Vet v: vetRepository.findAll()) {
    			LOG.info("Vet: "+v.getFirstName());
    		}
    		LOG.info("Filtramos por lastName=Raposo Vargas");
			for(Vet v: vetRepository.findByLastName("Raposo Vargas")){
				LOG.info("Vet: "+v.getFirstName());
			}

			LOG.info("Filtramos por lastName=Raposo Vargas y firstName=Sergio");
			for(Vet v: vetRepository.findByFirstNameAndLastName("Sergio","Raposo Vargas")){
			LOG.info("Vet: "+v.getFirstName());
			}

			LOG.info("Filtramos por Sergio en firstName o lastName");
			for(Vet v: vetRepository.findByFirstNameAndLastName("Sergio", "Sergio")){
			LOG.info("Vet: "+v.getFirstName());
			}
*/

    		
    		
    		//Obtener las mascotas nacidas en 2000 ordenadas por fecha de nacimiento ascendente
    		LOG.info("Filtramos las mascotas por el año 2000");
    		for(Pet p: petRepository.findByBirthDate(2000)) {
    			LOG.info(p.getName()+"-----"+p.getBirthDate());
    			
    		}
    		
    		//Obtener todas las visitas para una mascota
    		LOG.info("Visitas para la mascota con id 7");
    		for(Visit v:visitRepository.findByPetId(7)) {
    			LOG.info(v.getId()+"-----"+v.getDescription()+"-----"+v.getDate());
    		}
    		
    		//Obtener las 4 visitas más recientes de todo el sistema
    		LOG.info("Las últimas 4 visitas");
    		for(Visit v:visitRepository.findTop4ByOrderByDateDesc()) {
    			LOG.info(v.getId()+"-----"+v.getPetId()+"-----"+v.getDescription());
    		}
    		
    	};
    }
    

}
