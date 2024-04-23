package kr.co.lotteon.repository.admin;

import kr.co.lotteon.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminNoticeRepository extends JpaRepository<Notice, Integer> {

    // 공지사항 글 리스트 출력 페이징 메서드
    public Page<Notice> findAll(Pageable pageable);

    // 공지사항 카테고리별 조회
    public Page<Notice> findByNoticeCate(String cate, Pageable pageable);
}
