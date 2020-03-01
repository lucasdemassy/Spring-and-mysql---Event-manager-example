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
public class Event {        
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String name;

	private String date;

        @ManyToMany
        private List<User> users = new ArrayList<User>();

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
        
        public List<User> getUsers(){
            return this.users;
        }
        
        public void setUsers(List<User> events){
            this.users = events;
        }
        
        public void addUser(User user){
            this.users.add(user);
        }
        
        public String getUsersToString(){
            String result = "";
            for(int i = 0; i < this.users.size(); i++){
                result += this.users.get(i).getName() + ", ";
            }
            if(result.length() > 2){
                result = result.substring(0, result.length() - 2);
            }
            return result;
        }
        
        public void clearUsers(){
            for(int i = 0; i < this.users.size(); i++){
                this.users.get(i).getEvents().remove(this);
            }
            this.users.clear();
        }
}