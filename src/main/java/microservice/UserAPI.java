package microservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@RequestMapping("api/user")
public class UserAPI {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    String list(@RequestHeader HttpHeaders headers, @RequestParam("name") String name)
    {
        return "Listing of User\n";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    String add(@RequestHeader HttpHeaders headers, @RequestParam("name") String name){
        return "Added User :\n";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    String update(@RequestHeader HttpHeaders headers, @RequestParam("name") String name){
        System.out.println(headers);
        return "Updated user :\n";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    String delete(@RequestHeader HttpHeaders headers, @RequestParam("name") String name)
    {
        return "Deleted User :"+name+"\n";
    }
}
