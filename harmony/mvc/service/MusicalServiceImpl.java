package mvc.service;

import mvc.dao.MusicalDAO;
import mvc.dao.MusicalDAOImpl;
import mvc.dto.MusicalDTO;
import mvc.dto.SeatDTO;
import mvc.exception.SearchWrongException;

import java.util.List;

public class MusicalServiceImpl implements MusicalService{
    private static final MusicalService instance = new MusicalServiceImpl();

    private final MusicalDAO musicalDAO = MusicalDAOImpl.getInstance();

    private MusicalServiceImpl() {}
    public static MusicalService getInstance() {
        return instance;
    }

    /**
     * 뮤지컬 차트 조회 - 현재 예매 가능한 뮤지컬 목록
     * */
    @Override
    public List<String> musicalSelectAll() throws SearchWrongException {
        List<String> musicalList = musicalDAO.musicalSelectAll();
        if(musicalList.size()==0){
            throw new SearchWrongException("조회할 수 있는 뮤지컬이 존재하지 않습니다.");
        }
        return musicalList;

    }


    @Override
    public List<MusicalDTO> musicalSelectByTitle(String title) throws SearchWrongException {
        List<MusicalDTO> musicalList = musicalDAO.musicalSelectByTitle(title);
        if(musicalList.size()==0){
            throw new SearchWrongException("조회할 수 있는 뮤지컬이 존재하지 않습니다.");
        }
        return musicalList;

    }

    /**
     * 뮤지컬의 상세 정보 조회
     * */
    @Override
    public MusicalDTO musicalDetailSelect(String title) throws SearchWrongException {
        MusicalDTO musical = musicalDAO.musicalDetailSelect(title);
        if(musical == null){
            throw new SearchWrongException("입력에 해당하는 뮤지컬이 존재하지 않습니다.");
        }

        return musical;
    }

    /**
     * 좌석 현황 조회 - 선택한 뮤지컬의 현재 좌석 정보 조회
     * */
    @Override
    public List<SeatDTO> musicalSeatSelect(int musical_id) throws SearchWrongException {
        List<SeatDTO> seatList = musicalDAO.musicalSeatSelect(musical_id);
        if(seatList.size()==0){
            throw new SearchWrongException(musical_id + "에 해당하는 좌석 정보가 존재하지 않습니다.");
        }

        return seatList;
    }
}
