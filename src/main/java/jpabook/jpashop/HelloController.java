package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // hello라는 URL로 오면 이 컨트롤러가 호출됨
    // model에 데이터를 넘겨 view로 넘김
    // key: data, value : hello!
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello"; // hello 뒤에 .html이 자동으로 붙음. 위의 결과가 hello.html로 넘겨짐
    }
}
