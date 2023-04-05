package mvc.dao;

import mvc.dto.UsersDTO;
import mvc.exception.SearchWrongException;

public interface UsersDAO {
    /**
     * 회원 가입
     * */
    int userInsert(UsersDTO userDTO);

    /**
     * 카드 변경
     * */
    int userCardUpdate(String user_id, String card);

    /**
     * 개인 정보 조회
     */
    UsersDTO userSelect(String user_id);

}