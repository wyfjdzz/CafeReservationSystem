package com.example.demo.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ManagerController {

    @PostMapping("/Manager_GameManage_DeleteSuccess")

    public String DeleteGameId(@RequestParam("gameId") String gameId) {

        return "Game with ID " + gameId + " has been deactivated.";
    }

    @PostMapping("/Manager_GameManage_UpdateInfo")

    public String UpdateGameId(@RequestParam("gameId") String gameId) {

        return "这里需要 " + gameId + " 号游戏的信息填入框中";
    }

}
