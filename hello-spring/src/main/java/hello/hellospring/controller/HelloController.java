package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //주소에서 /hello가 들어간 주소를 받음.get
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello"; //templates아래에 있는 hello.html로 가라
    }

    @GetMapping("hello-mvc") //view를 조작
    public String helloMvc(@RequestParam("name") String name,Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //화면을 가지고 조작하지만 그대로 데이터(return값인 "hello"+name)를 넘겨준다.
    public String helloString(@RequestParam("name") String name) { http://localhost:8080/hello-string?name=spring
        return "hello " + name; //header와 body부분중에서 body
    }

    @GetMapping("hello-api")
    @ResponseBody //기본은 JSON형식으로 됨(key:Value)
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); //ctrl+cift+enter를 치면 ;가 자동으로 쳐짐
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
