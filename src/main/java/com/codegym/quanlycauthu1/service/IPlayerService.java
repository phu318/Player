package com.codegym.quanlycauthu1.service;

import com.codegym.quanlycauthu1.model.PlayerReqDto;
import com.codegym.quanlycauthu1.model.PlayerResDto;

import java.util.List;

public interface IPlayerService {
    List<PlayerResDto> findAllPlayer();
    PlayerResDto savePlayer(PlayerReqDto playerReqDto);
    void deletePlayer(Long id);
    PlayerResDto updatePlayer(Long id, PlayerReqDto playerReqDto);
    PlayerResDto findById(Long id);
}
