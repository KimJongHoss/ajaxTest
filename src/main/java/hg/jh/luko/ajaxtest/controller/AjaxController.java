package hg.jh.luko.ajaxtest.controller;

import hg.jh.luko.ajaxtest.DTO.AjaxDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*; //@Controller와 @ResponseBody 어노테이션을 모두 포함

@Controller
public class AjaxController {
    @GetMapping("/ex01")
    public String ex01() {
        System.out.println("AjaxController.ex01");
        return "index"; // index.html에 작성된 내용이 출력됨
    }

    @PostMapping("/ex02")
    public @ResponseBody String ex02() {
        System.out.println("AjaxController.ex02");
        return "Hello World"; // 리턴값이 그대로 출력됨
    }

    @GetMapping("/ex03")
    public @ResponseBody String ex03(@RequestParam("param1") String param1,
                                     @RequestParam("param2") String parma2) {
        System.out.println("param1 = "+ param1 + ", param2 = " + parma2);
        return "exo3 메서드 호출 완료";
    }

    @PostMapping("/ex04")
    public @ResponseBody String ex04(@RequestParam("param1") String param1,
                                     @RequestParam("param2") String parma2) {
        System.out.println("param1 = "+ param1 + ", param2 = " + parma2);
        return "exo4 메서드 호출 완료";
    }

    @GetMapping("/ex05")
    public  @ResponseBody AjaxDTO ex05(@ModelAttribute AjaxDTO ajaxDTO){
        System.out.println("ajaxDTO = " + ajaxDTO);

        return ajaxDTO;
    }

    @PostMapping("/ex06")
    public  @ResponseBody AjaxDTO ex06(@ModelAttribute AjaxDTO ajaxDTO){
        System.out.println("ajaxDTO = " + ajaxDTO);

        return ajaxDTO;
    }

    @PostMapping("/ex07")
    public @ResponseBody AjaxDTO ex07(@RequestBody AjaxDTO ajaxDTO){
        System.out.println("ajaxDTO = " + ajaxDTO);
        return ajaxDTO;
    }

}
