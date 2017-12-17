package com.example.destination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
@Autowired
private DestinationService service;

@Autowired
private DiscoveryClient discoveryClient;



@RequestMapping("/destination")
public List<Destination> getAll(){
	return service.getAll();
} 

@RequestMapping("/destination/{name}")
public Destination get(@PathVariable String name){
	return service.getbyname(name);
	 
}

@RequestMapping(value="/destination", method=RequestMethod.POST)
public void add(@RequestBody Destination d){
	 service.add(d);
	
}


//@RequestMapping("/service-instances/{applicationName}")
//public List<ServiceInstance> serviceInstancesByApplicationName(
//        @PathVariable String applicationName) {
//    return this.discoveryClient.getInstances(applicationName);
//}
//
//@RequestMapping("/service-instancess/{applicationName}") //mappingpath veranderen, gewoon (destination)/stadsnaam
//public Destination serviceInstancesByApplicationNames(	//methodeinhoud naar DestinationService verplaatsen en serviceMethode aanroepen
//        @PathVariable String applicationName) {
//	RestTemplate t=new RestTemplate();		//bean maken van resttemplate +autowiren
//	//GETINSTANCES haalt van de eurekaserver(online) de verschillende instances die id lijst staan
//	List<ServiceInstance> x=discoveryClient.getInstances(applicationName);  //info over service (PC, uri)
//	String y =x.get(0).getUri().toString()+"/destination/Leuven";	//opvragen string waarmee deze controller w aangesproken en die destination-object bevat
//	return t.getForObject(y, Destination.class);   //terugsturen destinationObject (automatisch naar json)
//}
//@RequestMapping("/service-instancesss/{applicationName}") //mappingpath veranderen, gewoon (destination)/stadsnaam
//public String serviceInstancesByApplicationNamess(	//methodeinhoud naar DestinationService verplaatsen en serviceMethode aanroepen
//        @PathVariable String applicationName) {
//	RestTemplate t=new RestTemplate();		//bean maken van resttemplate +autowiren
//	//GETINSTANCES haalt van de eurekaserver(online) de verschillende instances die id lijst staan
//	List<ServiceInstance> x=discoveryClient.getInstances(applicationName);  //info over service (PC, uri)
//	String y =x.get(0).getUri().toString()+"/destination/Leuven";	//opvragen string waarmee deze controller w aangesproken en die destination-object bevat
//	ResponseEntity<String> e = t.exchange(y,HttpMethod.GET,null,String.class);
//	return e.getBody();   //terugsturen destinationObject (automatisch naar json)
//}
}
