package com.example.accessingdatamysql;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity // This tells Hibernate to make a table out of this class
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

        @NotNull
	private String name;

        @NotNull
	private String email;
        
        @ManyToMany(mappedBy = "users")
        private List<Event> events = new ArrayList<Event>();
        
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}
        public String getEmailAsHTML() {
		return "<li>"+this.email+"</li>";
	}

	public void setEmail(String email) {
		this.email = email;
	}
        
        /*
        public Event getEvent(){
            return this.event;
        }
        
        
        public void setEvent(Event event){
            this.event = event;
        }
        
        */
        
        public List<Event> getEvents(){
            return this.events;
        }
        
        
        public String getEventsToString(){
            String result = "";
            for(int i = 0; i < this.events.size(); i++){
                result += this.events.get(i).getName() + ", ";
            }
            if(result.length() > 2){
                result = result.substring(0, result.length() - 2);
            }     
            return result;
        }
        
        public void setEvents(List<Event> events){
            this.events = events;
        }
        
        public void addEvent(Event event){
            this.events.add(event);
        }
        
        
}
