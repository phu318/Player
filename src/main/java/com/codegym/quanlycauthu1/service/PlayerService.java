package com.codegym.quanlycauthu1.service;

import com.codegym.quanlycauthu1.model.Player;
import com.codegym.quanlycauthu1.model.PlayerReqDto;
import com.codegym.quanlycauthu1.model.PlayerResDto;
import com.codegym.quanlycauthu1.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository playerRepository;

    @Override
    public List<PlayerResDto> findAllPlayer() {
        return playerRepository.findAll().stream().map(player -> new PlayerResDto(player.getId(), player.getName(), player.getDateOfBirth(),player.getEposition(),player.getExperience())).collect(Collectors.toList());
    }

    @Override
    public PlayerResDto savePlayer(PlayerReqDto playerReqDto) {
        Player player = new Player();
        player.setName(playerReqDto.getName());
        player.setDateOfBirth(playerReqDto.getDateOfBirth());
        player.setEposition(playerReqDto.getEposition());
        player.setExperience(playerReqDto.getExperience());
        playerRepository.save(player);
        return player.toResDto();
    }

    @Override
    public void deletePlayer(Long id) {
playerRepository.deleteById(id);
    }

    @Override
    public PlayerResDto updatePlayer(Long id, PlayerReqDto playerReqDto) {
       Player player = playerRepository.findById(id).orElse(null);
       if (player != null) {
           player.setName(playerReqDto.getName());
           player.setDateOfBirth(playerReqDto.getDateOfBirth());
           player.setEposition(playerReqDto.getEposition());
           player.setExperience(playerReqDto.getExperience());
           playerRepository.save(player);
           return player.toResDto();
       }else {
           return player.toResDto();
       }
    }

    @Override
    public PlayerResDto findById(Long id) {
        Player player = playerRepository.findById(id).orElse(null);
        return player.toResDto();
    }
}
