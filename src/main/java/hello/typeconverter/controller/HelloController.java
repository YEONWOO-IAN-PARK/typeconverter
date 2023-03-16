package hello.typeconverter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data");
        Integer intValue = Integer.valueOf(data);
        System.out.println("intValue = " + intValue);
        return "ok";
    }


    @GetMapping("/hello-v2")
    // 1. @RequestParam, @ModelAttribute, @PathVariable을 요청핸들러메서드의
    // 파라미터로 받으면 스프링이 자동으로 들어오는 JSON String을 타입에 맞게 변형해준다.
    public String helloV2(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }

    // 2. @Value 등으로 YML 정보를 읽을 수 있다.
    // 3. XML에 넣은 스프링 빈 정보를 변환
    // 4. 뷰를 렌더링할 때
}
