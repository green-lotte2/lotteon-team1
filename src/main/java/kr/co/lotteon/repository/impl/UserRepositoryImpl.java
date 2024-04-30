package kr.co.lotteon.repository.impl;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.lotteon.entity.QUser;
import kr.co.lotteon.entity.QUserPoint;
import kr.co.lotteon.entity.User;
import kr.co.lotteon.repository.custom.UserRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private QUser qUser = QUser.user;
    private QUserPoint qUserPoint = QUserPoint.userPoint;

    // 마이페이지 출력을 위해 user_id로 유저 정보 조회
    public User selectUserInfo(String userId) {
        return jpaQueryFactory
                .selectFrom(qUser)
                .where(qUser.userId.eq(userId))
                .fetchOne();
    }

    // UserId 찾기
    public Optional<User> findUserIdByUserNameAndUserEmail(String userName, String userEmail) {
        User user = jpaQueryFactory
                .selectFrom(qUser)
                .where(qUser.userName.eq(userName)
                        .and(qUser.userEmail.eq(userEmail)))
                .fetchOne();

        return Optional.ofNullable(user);
    }

    // UserPw update
    @Transactional
    public long updateUserPwByUserIdAndUserEmail(String userId, String userPw, String userEmail) {
        try {
            long result = jpaQueryFactory
                    .update(qUser)
                    .set(qUser.userPw, userPw)
                    .where(qUser.userId.eq(userId)
                            .and(qUser.userEmail.eq(userEmail)))
                    .execute();
            log.info("impl : " + result);
            return result;
        } catch (Exception e) {
            log.error("Error msg :" + e.getMessage());
            return -1;
        }
    }

    public Tuple selectUserInfoWithPoint(String userId){
        return jpaQueryFactory
                .select(qUser, qUserPoint)
                .from(qUser)
                .join(qUserPoint)
                .on(qUser.userId.eq(qUserPoint.userId))
                .where(qUser.userId.eq(userId))
                .fetchOne();
    }
}