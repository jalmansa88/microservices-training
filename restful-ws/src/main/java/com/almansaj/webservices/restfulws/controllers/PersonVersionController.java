package com.almansaj.webservices.restfulws.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almansaj.webservices.restfulws.versioning.Name;
import com.almansaj.webservices.restfulws.versioning.PersonV1;
import com.almansaj.webservices.restfulws.versioning.PersonV2;

@RestController
@RequestMapping("/person")
public class PersonVersionController {

	@GetMapping("/v1")
	public PersonV1 pv1() {
		return new PersonV1("Pepe Nuñez");
	}
	
	@GetMapping("/v2")
	public PersonV2 pv2() {
		return new PersonV2(new Name("Pepe", "Nuñez"));
	}
	@GetMapping(value="/param", params="version=1")
	public PersonV2 paramv1() {
		return new PersonV2(new Name("Pepe", "Nuñez"));
	}
	@GetMapping(value="/param", params="version=2")
	public PersonV2 paramv2() {
		return new PersonV2(new Name("Pepe", "Nuñez"));
	}
	@GetMapping(value="/header", headers="X-API-VERSION=1")
	public PersonV2 headerParamv1() {
		return new PersonV2(new Name("Pepe", "Nuñez"));
	}
	@GetMapping(value="/header", headers="X-API-VERSION=2")
	public PersonV2 headerParamv2() {
		return new PersonV2(new Name("Pepe", "Nuñez"));
	}
	@GetMapping(value="/produces", produces="application/vnd.company.app-v1+json")
	public PersonV2 producesParamv1() {
		return new PersonV2(new Name("Pepe", "Nuñez"));
	}
	@GetMapping(value="/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 producesParamv2() {
		return new PersonV2(new Name("Pepe", "Nuñez"));
	}
}
