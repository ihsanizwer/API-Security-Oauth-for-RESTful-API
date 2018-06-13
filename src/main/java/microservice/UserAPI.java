package microservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@RequestMapping("api/user")
public class UserAPI {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    String list(){
        return "Listing of User\n";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    String add(String name){
        return "Added User :"+name+"\n";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    String update(String name){
        return "Updated user :"+name+"\n";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    String delete(String name){
        return "Deleted User :"+name+"\n";
    }
}
