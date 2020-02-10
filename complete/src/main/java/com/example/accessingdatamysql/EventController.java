package com.example.accessingdatamysql;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller	// This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class EventController {
	@Autowired // This means to get the bean called userRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
        
        @Autowired // This means to get the bean called eventRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
        private EventRepository eventRepository;
        
        @PostMapping(path="/join") // Map ONLY POST Requests
	public String addNewEvent (@RequestParam String name
			, @RequestParam String date, Model model) {
            // @ResponseBody means the returned String is the response, not a view name
            // @RequestParam means it is a parameter from the GET or POST request

            Event e = new Event();
            e.setName(name);
            e.setDate(date);
            eventRepository.save(e);
            return getAllEvents(model);
	}
        
        @GetMapping(path="/find")
	public String getAllEvents(Model model) {
            // This returns a JSON or XML with the users
            Iterable<Event> json = eventRepository.findAll();
            model.addAttribute("json", json);
            return "find";
            
	}
        
        @GetMapping(path="/remove/event")
	public String chooseUser(Model model, @RequestParam String eventname) {
            // This returns a JSON or XML with the users
            List<Event> events = (List<Event>) eventRepository.findAll();  
            Event event = null;
            for(int i = 0; i < events.size(); i++){
                if(events.get(i).getName().equals(eventname)){
                    event = events.get(i);
                } else {
                }
            }           
            List<User> users = event.getUsers();
            model.addAttribute("event", event);
            model.addAttribute("users", users);
            return "removingUserFromEvent";
	}
        
        
        @GetMapping(path="/removing/event")
	public String removeUser(Model model, @RequestParam Integer userID, @RequestParam String eventname) {
            // This returns a JSON or XML with the users
            System.out.println(userID);
            List<User> users = (List<User>) userRepository.findAll();  
            User user = null;
            for(int i = 0; i < users.size(); i++){
                if(users.get(i).getId().equals(userID)){
                    user = users.get(i);
                    System.out.println("User found");
                } else {
                }
            }
            List<Event> events = (List<Event>) eventRepository.findAll();  
            Event event = null;
            for(int i = 0; i < events.size(); i++){
                if(events.get(i).getName().equals(eventname)){
                    event = events.get(i);
                    System.out.println("Event found");
                } else {
                }
            }           
            System.out.println(user.getName());
            System.out.println(event.getName());
            user.getEvents().remove(event);
            event.getUsers().remove(user);
            return getAllEvents(model);
	}
        
              
        @GetMapping("/register/event")
	public String greeting(Model model) {
            Iterable<Event> events = eventRepository.findAll();
            Iterable<User> users = userRepository.findAll();
            model.addAttribute("users", users);
            model.addAttribute("events", events);
            return "event";
	}
}
