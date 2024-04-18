package kr.co.lotteon.controller;

import kr.co.lotteon.dto.UserDTO;
import kr.co.lotteon.service.MyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MyController {

    private final MyService myService;

    //마이페이지-홈 이동
    @GetMapping("/my/home")
    public String myHome(){
        return "/my/home";
    }

    //마이페이지-쿠폰 이동
    @GetMapping("/my/coupon")
    public String myCoupon(){
        return "/my/coupon";
    }

    //마이페이지-정보 이동
    @GetMapping("/my/info")
    public String myInfo(Model model, String userId){
        UserDTO userDTO = myService.selectUserInfo(userId);
        model.addAttribute("userDTO", userDTO);
        log.info("userDTO : " + userDTO);
        return "/my/info";
    }

    // 마이페이지 - 연락처 수정
    @PostMapping("/my/updateHp")
    public ResponseEntity<?> myInfoUpdateHp(@RequestBody Map<String, String> requestData){

        String userId = requestData.get("userId");
        String userHp = requestData.get("userHp");
        log.info("userId : " + userId);
        log.info("userHp : " + userHp);
        return myService.myInfoUpdateHp(userId, userHp);
    }

    // 마이페이지 - 이메일 수정
    @PostMapping("/my/updateEmail")
    public ResponseEntity<?> myInfoUpdateEmail(@RequestBody Map<String, String> requestData){

        String userId = requestData.get("userId");
        String userEmail = requestData.get("userEmail");
        log.info("userId : " + userId);
        log.info("userEmail : " + userEmail);
        return myService.myInfoUpdateEmail(userId, userEmail);
    }

    // 마이페이지 - 비밀번호 수정
    @PostMapping("/my/updatePw")
    public ResponseEntity<?> myInfoUpdatePw(@RequestBody Map<String, String> requestData){

        String userId = requestData.get("userId");
        String userPw = requestData.get("userPw");
        log.info("userId : " + userId);
        log.info("userPw : " + userPw);
        return myService.myInfoUpdatePw(userId, userPw);
    }

    //마이페이지-주문내역 이동
    @GetMapping("/my/order")
    public String myOrder(){
        return "/my/order";
    }

    //마이페이지-포인트 이동
    @GetMapping("/my/point")
    public String myPoint(){
        return "/my/point";
    }

    //마이페이지-QnA 이동
    @GetMapping("/my/qna")
    public String myQna(){
        return "/my/qna";
    }

    //마이페이지-리뷰 이동
    @GetMapping("/my/review")
    public String myReview(){
        return "/my/review";
    }


}