package hg.jh.luko.ajaxtest.controller;

import hg.jh.luko.ajaxtest.DTO.AjaxDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*; //@Controller와 @ResponseBody 어노테이션을 모두 포함

import java.util.ArrayList;
import java.util.List;

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

    private List<AjaxDTO> DTOList() {
        List<AjaxDTO> dtoList = new ArrayList<>();
        dtoList.add(new AjaxDTO("data1", "data11"));
        dtoList.add(new AjaxDTO("data2", "data22"));
        return  dtoList;
    }

    @PostMapping("/ex08")
    public @ResponseBody List<AjaxDTO> ex08(@RequestBody AjaxDTO ajaxDTO){
        System.out.println("ajaxDTO = " + ajaxDTO);
        List<AjaxDTO> dtoList = DTOList();
        dtoList.add(ajaxDTO);
        return dtoList;
    }

    @PostMapping("/ex09") // success로 보낼건지 error로 보낼건지 제어
    public ResponseEntity ex09(@RequestBody AjaxDTO ajaxDTO){
        System.out.println("ajaxDTO = " + ajaxDTO);

//        return new ResponseEntity<>(HttpStatus.NOT_FOUND); //error로 보내기 (404)
        return new ResponseEntity<>(ajaxDTO, HttpStatus.OK); //데이터도 같이 보내기, success로 보내기
    }

    @PostMapping("/ex10")
    public ResponseEntity ex10(@RequestBody AjaxDTO ajaxDTO){
        System.out.println("ajaxDTO = " + ajaxDTO);
        List<AjaxDTO> dtoList = DTOList();
        dtoList.add(ajaxDTO);

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

}
