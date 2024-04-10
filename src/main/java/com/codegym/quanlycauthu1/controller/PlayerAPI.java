package com.codegym.quanlycauthu1.controller;

import com.codegym.quanlycauthu1.model.PlayerReqDto;
import com.codegym.quanlycauthu1.model.PlayerResDto;
import com.codegym.quanlycauthu1.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/player")
@CrossOrigin
public class PlayerAPI {
    @Autowired
    private PlayerService playerService;
    @GetMapping
    public ResponseEntity<?> findAllPlayer(){
        return ResponseEntity.ok(playerService.findAllPlayer());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        PlayerResDto playerResDto = playerService.findById(id);
        return new ResponseEntity<>(playerResDto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody PlayerReqDto playerReqDto) {
        PlayerResDto playerResDto = playerService.savePlayer(playerReqDto);
        return new ResponseEntity<>(playerResDto, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PlayerResDto> update(@PathVariable Long id, @RequestBody PlayerReqDto playerReqDto) {
        PlayerResDto playerResDto = playerService.updatePlayer(id, playerReqDto);
        return new ResponseEntity<>(playerResDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>("Player with ID " + id + " deleted successfully.", HttpStatus.OK);
    }
}
