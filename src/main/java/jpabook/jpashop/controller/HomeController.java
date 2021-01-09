package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j // 로거 사용
public class HomeController {

    // 처음 화면이 mapping됨
    @RequestMapping("/")
    public String home() {
        log.info("home controller");
        return "home"; // home.html을 찾음
    }
}
