package com.example.demo.Board.Service.Implement;

import java.util.List;
import com.example.demo.Board.Service.BoardService;
import com.example.demo.Board.VO.BoardVO;
import com.example.demo.JPA.Entity.BoardEntity;
import com.example.demo.JPA.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public BoardVO create(BoardVO vo) {
        BoardEntity entity = toEntity(vo);
        BoardEntity saved = boardRepository.save(entity);
        return toVO(saved);
    }

    @Override
    public List<BoardVO> findAll() {
        return boardRepository.findAll().stream()
                .map(this::toVO)
                .toList();
    }

    @Override
    public BoardVO findById(int id) {
        return boardRepository.findById(id)
                .map(this::toVO)
                .orElse(null);  // 없으면 null 리턴해서 컨트롤러에서 404 처리 가능
    }


    @Override
    public BoardVO update(int id, BoardVO vo) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다. id: " + id));
        entity.setTitle(vo.getTitle());
        entity.setContent(vo.getContent());
        BoardEntity updated = boardRepository.save(entity);
        return toVO(updated);
    }

    @Override
    public void delete(int no) {
        boardRepository.deleteById(no);
    }

    // 변환 메서드들
    private BoardEntity toEntity(BoardVO vo) {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(vo.getTitle());
        entity.setContent(vo.getContent());
        entity.setCreateDate(vo.getCreateDate());
        entity.setUpdateDate(vo.getUpdateDate());
        return entity;
    }

    private BoardVO toVO(BoardEntity entity) {
        BoardVO vo = new BoardVO();
        vo.setNo(entity.getNo());
        vo.setTitle(entity.getTitle());
        vo.setContent(entity.getContent());
        vo.setCreateDate(entity.getCreateDate());
        vo.setUpdateDate(entity.getUpdateDate());
        return vo;
    }
}
