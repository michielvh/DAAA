package com.example.destination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DestinationService {
private Map<String,Destination> lijst=new HashMap<String,Destination>();

public Destination getbyname(String name){
	return lijst.get(name);
}
public List<Destination> getAll(){
	return null;
}
public void add(Destination d){
	lijst.put(d.getName(), d);
}
public DestinationService() {
	Destination d1=new Destination("Leuven","Oude Markt");
	Destination d2=new Destination("Antwerpen","Grote Markt");
	lijst.put(d1.getName(), d1);
	lijst.put(d2.getName(), d2);
}
}
