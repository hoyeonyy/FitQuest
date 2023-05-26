package fitrecommend.fitquest;

import fitrecommend.fitquest.domain.Gym;
import fitrecommend.fitquest.domain.GymType;
import fitrecommend.fitquest.domain.Home;
import fitrecommend.fitquest.domain.HomeType;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 모든 운동을 데이터베이스에 저장해두고 시작한다.
 */
@Component
@RequiredArgsConstructor
public class InitDb {

    @Autowired
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1(); // 헬스데이터
        initService.dbInit2(); // 홈트 데이터
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            Gym gym1 = createGym("푸쉬 업", GymType.CHEST, "가슴, 어깨, 삼두근을 강화하는 상체 운동으로, 몸을 바닥에 대고 팔을 펴고 다시 올리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=aoH7qNedO8k", 0.8);
            em.persist(gym1);
            Gym gym2 = createGym("바벨 벤치프레스", GymType.CHEST, "가슴과 삼두근을 주로 강화하는 대표적인 운동으로, 가슴 위에 바벨을 올려놓고 팔을 펴고 다시 내리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=A2kHURY746E", 0.7);
            em.persist(gym2);
            Gym gym3 = createGym("팩 덱 플라이", GymType.CHEST, "가슴의 외측 부분을 강화하는 운동으로, 팩 덱 머신에서 팔을 벌리고 다시 모으는 동작을 반복합니다.", "https://www.youtube.com/watch?v=Og9pgOtL-04", 0.5);
            em.persist(gym3);
            Gym gym4 = createGym("머신 체스트 프레스", GymType.CHEST, "가슴을 강화하는 운동으로, 머신에서 가슴 앞으로 팔을 밀고 다시 원위치로 돌아오는 동작을 반복합니다.", "https://www.youtube.com/watch?v=cZnN10iJJJU", 0.5);
            em.persist(gym4);
            Gym gym5 = createGym("디클라인 바벨 벤치프레스", GymType.CHEST, "하부 가슴을 강화하는 운동으로, 바벨을 디클라인 벤치에 놓고 가슴 아래로 내리고 다시 올리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=jYgpC5pFb20", 0.6);
            em.persist(gym5);
            Gym gym6 = createGym("덤벨 벤치프레스", GymType.CHEST, " 가슴과 어깨를 강화하는 운동으로, 덤벨을 손에 들고 가슴 앞으로 내리고 다시 올리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=xTQL6jvVMNA", 0.8);
            em.persist(gym6);
            Gym gym7 = createGym("인클라인 덤벨 벤치프레스", GymType.CHEST, "상부 가슴을 강화하는 운동으로, 인클라인 벤치에서 덤벨을 가슴 위로 올리고 다시 내리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=tIdle9XsoKs", 0.8);
            em.persist(gym7);
            Gym gym8 = createGym("딥스", GymType.CHEST, "삼두근과 가슴의 하부를 강화하는 운동으로, 병렬 바에 손을 놓고 팔을 굽혀 몸을 내리고 다시 올리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=pQSfXvaQGas", 0.7);
            em.persist(gym8);
            Gym gym9 = createGym("케이블 플라이", GymType.CHEST, "가슴의 중앙과 외측 부분을 강화하는 운동으로, 케이블 머신에서 팔을 벌리고 다시 모으는 동작을 반복합니다.", "https://www.youtube.com/watch?v=jtH2YmpGqI8", 0.4);
            em.persist(gym9);
            Gym gym10 = createGym("덤벨 플라이", GymType.CHEST, "가슴의 외측을 강화하는 운동으로, 덤벨을 들고 팔을 벌리고 다시 모으는 동작을 반복합니다.", "https://www.youtube.com/watch?v=gmVan01OP9E", 0.4);
            em.persist(gym10);
            Gym gym11 = createGym("디클라인 덤벨 벤치프레스", GymType.CHEST, "하부 가슴을 강화하는 운동으로, 디클라인 벤치에서 덤벨을 가슴 아래로 내리고 다시 올리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=i2Cp0HCFQfU", 0.5);
            em.persist(gym11);


            // 삼두운동
            Gym gym12 = createGym("덤벨 스컬크러셔", GymType.TRICEPS, "삼두근을 강화하는 운동으로, 덤벨을 들고 팔을 굽혀 머리 뒤로 내리고 다시 올리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=uZOwQLaq0-g", 0.4);
            em.persist(gym12);
            Gym gym13 = createGym("트라이셉스 익스텐션", GymType.TRICEPS, "삼두근을 강화하는 운동으로, 팔을 굽혀 삼두근을 늘리고 다시 펴는 동작을 반복합니다.", "https://www.youtube.com/watch?v=ogyGQxuxxn4", 0.4);
            em.persist(gym13);
            Gym gym14 = createGym("케이블 푸시 다운", GymType.TRICEPS, "삼두근을 강화하는 운동으로, 케이블 머신에서 팔을 펴고 다시 구부리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=ObEtLS9heOo", 0.5);
            em.persist(gym14);
            Gym gym15 = createGym("바벨 스컬크러셔", GymType.TRICEPS, "삼두근을 강화하는 운동으로, 바벨을 들고 팔을 굽혀 머리 뒤로 내리고 다시 올리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=kOrn-StwaSc", 0.6);
            em.persist(gym15);
            Gym gym16 = createGym("오버헤드 트라이셉스 익스텐션", GymType.TRICEPS, "삼두근을 강화하는 운동으로, 머리 위로 팔을 올리고 다시 구부리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=3Nqt05cRhpU", 0.4);
            em.persist(gym16);

            // 등운동
            Gym gym17 = createGym("풀업", GymType.BACK, "상체 전체를 강화하는 운동으로, 막대나 패턴에서 매달려서 팔을 구부리고 다시 펴는 동작을 반복합니다.", "https://www.youtube.com/watch?v=nWhS28U6bCY", 0.9);
            em.persist(gym17);
            Gym gym18 = createGym("랫 풀다운", GymType.BACK, "상체 전체를 강화하는 운동으로, 랫 풀다운 머신에서 매달려서 막대를 가슴 쪽으로 당기는 동작을 반복합니다.", "https://www.youtube.com/watch?v=2K2WCGstHOY", 0.4);
            em.persist(gym18);
            Gym gym19 = createGym("시티드 로우", GymType.BACK, "등을 강화하는 운동으로, 시티드 로우 머신에서 상체를 앞으로 구부리고 등을 당기는 동작을 반복합니다.", "https://www.youtube.com/watch?v=pkKfWeQ9APQ", 0.4);
            em.persist(gym19);
            Gym gym20 = createGym("백 익스텐션", GymType.BACK, "등과 허리를 강화하는 운동으로, 백 익스텐션 머신에서 상체를 앞으로 구부리고 등과 허리를 힘으로 들어올리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=0KXqeI-uJ3s", 0.5);
            em.persist(gym20);
            Gym gym21 = createGym("원암 케이블 로우", GymType.BACK, "등을 강화하는 운동으로, 케이블 머신을 이용하여 한 손으로 로우 동작을 수행하는 운동입니다.", "https://www.youtube.com/watch?v=VDPteW0KjDA", 0.4);
            em.persist(gym21);
            Gym gym22 = createGym("원암 덤벨 로우", GymType.BACK, "등을 강화하는 운동으로, 덤벨을 이용하여 한 손씩 로우 동작을 수행하는 운동입니다.", "https://www.youtube.com/watch?v=2i1v1UvsP_w", 0.4);
            em.persist(gym22);
            Gym gym23 = createGym("체스트 서포터드 로우", GymType.BACK, "등과 상체를 강화하는 운동으로, 체스트 서포터드 머신에서 가슴을 지지하고 등을 당기는 동작을 반복합니다.", "https://www.youtube.com/watch?v=w5Juhckt-2g", 0.5);
            em.persist(gym23);
            Gym gym24 = createGym("암 풀 다운", GymType.BACK, "등과 상체를 강화하는 운동으로, 암 풀 다운 머신에서 팔을 구부리고 등을 당기는 동작을 반복합니다.", "https://www.youtube.com/watch?v=bIo6_iFHE6U", 0.4);
            em.persist(gym24);
            Gym gym25 = createGym("데드 리프트", GymType.BACK, "전신을 강화하는 운동으로, 막대를 손에 들고 허리를 펴고 엉덩이를 뒤로 밀며 일어서는 동작을 반복합니다.", "https://www.youtube.com/watch?v=C8YzWMsNF9s", 1D);
            em.persist(gym25);
            Gym gym26 = createGym("바벨로우", GymType.BACK, "등을 강화하는 운동으로, 바벨을 손에 들고 허리를 펴고 상체를 앞으로 구부리고 다시 등을 당기는 동작을 반복합니다.", "https://www.youtube.com/watch?v=EEqGCoTuYfQ", 0.5);
            em.persist(gym26);

            // 이두
            Gym gym27 = createGym("바벨 컬", GymType.BICEP, "이두근을 강화하는 운동으로, 바벨을 들고 팔을 구부리고 다시 펴는 동작을 반복합니다.", "https://www.youtube.com/watch?v=Dlg0W_5mq98", 0.4);
            em.persist(gym27);
            Gym gym28 = createGym("해머 컬", GymType.BICEP, "이두근을 강화하는 운동으로, 해머(망치)처럼 생긴 덤벨을 들고 팔을 구부리고 다시 펴는 동작을 반복합니다.", "https://www.youtube.com/watch?v=hFM3GLw9Cfk", 0.3);
            em.persist(gym28);
            Gym gym29 = createGym("프리쳐 컬 머신", GymType.BICEP, "이두근을 강화하는 운동으로, 프리쳐 컬 머신에서 팔을 구부리고 다시 펴는 동작을 반복합니다.", "https://www.youtube.com/watch?v=X1FSQR3EOPY", 0.3);
            em.persist(gym29);
            Gym gym30 = createGym("덤벨 컬", GymType.BICEP, "이두근을 강화하는 운동으로, 덤벨을 들고 팔을 구부리고 다시 펴는 동작을 반복합니다.", "https://www.youtube.com/watch?v=cOver4_h5Uw",0.4);
            em.persist(gym30);
            Gym gym31 = createGym("케이블 컬", GymType.BICEP, "이두근을 강화하는 운동으로, 케이블 머신에서 팔을 구부리고 다시 펴는 동작을 반복합니다.", "https://www.youtube.com/watch?v=5bPGsV7aTKU", 0.4);
            em.persist(gym31);

            // 하체
            Gym gym32 = createGym("레그익스텐션", GymType.LEG, "허벅지 앞쪽을 강화하는 운동으로, 레그 익스텐션 머신에서 다리를 펴는 동작을 반복합니다.", "https://www.youtube.com/watch?v=mS9iwXhycJI", 0.6);
            em.persist(gym32);
            Gym gym33 = createGym("레그컬", GymType.LEG, "허벅지 뒷쪽을 강화하는 운동으로, 레그 컬 머신에서 다리를 구부리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=9w8d_EL-7e4", 0.7);
            em.persist(gym33);
            Gym gym34 = createGym("레그프레스", GymType.LEG, "허벅지 전체를 강화하는 운동으로, 레그프레스 머신에서 다리를 펴는 동작을 반복합니다.", "https://www.youtube.com/watch?v=EV0F_3S7Sks", 0.9);
            em.persist(gym34);
            Gym gym35 = createGym("카프 레이즈", GymType.LEG, "종아리를 강화하는 운동으로, 스탠딩 카프 레이즈 머신에서 발을 들어올리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=QdAtQJMKi0U", 0.3);
            em.persist(gym35);
            Gym gym36 = createGym("런지", GymType.LEG, "허벅지와 엉덩이를 강화하는 운동으로, 한 다리를 앞으로 내밀고 다시 원위치로 돌아가는 동작을 반복합니다.", "https://www.youtube.com/watch?v=oPkwl7cFlyk", 0.5);
            em.persist(gym36);
            Gym gym37 = createGym("스쿼트", GymType.LEG, "허벅지와 엉덩이를 강화하는 운동으로, 머신이나 바벨을 등에 짊어지고 앉았다 일어나는 동작을 반복합니다.", "https://www.youtube.com/watch?v=MWjKQGoNW0U", 0.9);
            em.persist(gym37);
            Gym gym38 = createGym("힙 어브덕션", GymType.LEG, "엉덩이 측면을 강화하는 운동으로, 힙 어브덕션 머신에서 다리를 옆으로 벌리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=E-BbAqqRV94", 0.5);
            em.persist(gym38);

            // 어깨
            Gym gym39 = createGym("숄더프레스", GymType.SHOULDER, "어깨를 강화하는 운동으로, 바벨이나 덤벨을 들어 어깨 위로 올리고 내리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=rHk4j2WRAE4", 0.6);
            em.persist(gym39);
            Gym gym40 = createGym("사이드 래터럴 레이즈", GymType.SHOULDER, "어깨 측면을 강화하는 운동으로, 덤벨을 들고 옆으로 올리고 내리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=iNgwwI3WBTo", 0.4);
            em.persist(gym40);
            Gym gym41 = createGym("벤트 오버 레터럴 레이즈", GymType.SHOULDER, "어깨와 상체 뒷부분을 강화하는 운동으로, 허리를 숙인 상태에서 덤벨을 들어 옆으로 올리고 내리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=n3aX0oJyvWA", 0.4);
            em.persist(gym41);
            Gym gym42 = createGym("프론트 레이즈", GymType.SHOULDER, "어깨 전면을 강화하는 운동으로, 덤벨을 들고 앞으로 올리고 내리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=nMUQR-dI_S8", 0.4);
            em.persist(gym42);
            Gym gym43 = createGym("오버 헤드 프레스", GymType.SHOULDER, "어깨와 삼두근을 강화하는 운동으로, 바벨이나 덤벨을 어깨 위로 올리고 내리는 동작을 반복합니다.", "https://www.youtube.com/watch?v=DgS7Y2bj2NM", 0.8);
            em.persist(gym43);
        }

        public void dbInit2() {
            Home home1 = createHome("필라테스 개인레슨 받고 가세요\uD83D\uDC9B 전신 구석구석 자극을 느낄 수 있어요 (Whole body workout)", HomeType.PILATES, "https://www.youtube.com/watch?v=sb51gF18cYo&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home1);

            Home home2 = createHome("속근육 꽉 채우는 40분 전신 매트필라테스 꼭 하고 가세요 /홈트 다이어트", HomeType.PILATES, "https://www.youtube.com/watch?v=iRQ_qeA1j-M&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home2);

            Home home3 = createHome("필라테스 개인레슨 받고가세요\uD83D\uDC9B 손목, 무릎에 무리없이 전신 구석구석 자극 해볼게요! (Pilates lesson)", HomeType.PILATES, "https://www.youtube.com/watch?v=RMyfEJkBa88&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home3);

            Home home4 = createHome("[소피아의 필라테스 홈트] 15분 프로그램", HomeType.PILATES, "https://www.youtube.com/watch?v=3TU81R9D1ao&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home4);

            Home home5 = createHome("[하루1시간] 전신 체지방 감량 & 라인 만들기 합본 / 홈트,필라테스,근력,유산소,스트레칭,코어/Fullbody workout", HomeType.PILATES, "https://www.youtube.com/watch?v=rIZ144yzlMM&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home5);

            Home home6 = createHome("필라테스 개인레슨 받고가세요\uD83E\uDDE1 25분 온전히 내 몸에 집중하는 시간을 가져보세요 (Pilates lesson)", HomeType.PILATES, "https://www.youtube.com/watch?v=i3tPc64VIuY&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home6);

            Home home7 = createHome("홈트레이닝 | 스파인코렉터 40분 전신운동 시퀀스 | 필라테스 초보자도 따라할 수 있는 홈트", HomeType.PILATES, "https://www.youtube.com/watch?v=OHntgFCzfm0&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home7);

            Home home8 = createHome("필라테스 개인레슨 받고 가세요\uD83D\uDC9C 코어 바로잡기 (Whole body workout)", HomeType.PILATES, "https://www.youtube.com/watch?v=tyb35HA55vE&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home8);

            Home home9 = createHome("필라테스 개인레슨 받고가세요❤️ 무너진 몸의 밸런스를 코어운동으로 확실히 잡아볼게요! (Pilates lesson)", HomeType.PILATES, "https://www.youtube.com/watch?v=g71vuJ2btHY&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home9);

            Home home10 = createHome("집에서 배우는 기초 필라테스 I \"코어에 좋아요\" I 심으뜸 필라테스", HomeType.PILATES, "https://www.youtube.com/watch?v=gbZwjeX3-hk&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home10);

            Home home11 = createHome("필라테스 개인레슨 받고 가세요❤️ 응용된 동작을 통해 새로운 자극을 느껴보세요! (Whole body workout)", HomeType.PILATES, "https://www.youtube.com/watch?v=E1mzapjcBxw&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home11);

            Home home12 = createHome("필라테스 입문자를 위한 초급 레슨\uD83D\uDC9B 쉽고 자세한 설명과 함께해요｜전신, 코어 강화 루틴", HomeType.PILATES, "https://www.youtube.com/watch?v=gcpiKiweo2I&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home12);

            Home home13 = createHome("필라테스 레슨 - 전신코어/ 속근육을 단련하여 균형잡힌 몸 만들기 (Pilates lesson)", HomeType.PILATES, "https://www.youtube.com/watch?v=VFn-N-s89l4&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home13);

            Home home14 = createHome("SUB) 운동초보자는 이거 무조건 해야함 | 필라테스 입문자 Q&A 꿀팁 | 필라테스 가격정보 | 필라테스 효과 | 운동 루틴 | 스트레칭 | 자기관리 | 자기계발 | 갓생 살기", HomeType.PILATES, "https://www.youtube.com/watch?v=xV3hK7agKk4&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home14);

            Home home15 = createHome("[1주Day1] 4주 필라테스 프로젝트", HomeType.PILATES, "https://www.youtube.com/watch?v=iSNZS5tGQ6E&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home15);

            Home home16 = createHome("필라테스 개인레슨 받고 가세요\uD83D\uDC9B 기본기부터 탄탄히!! (Whole body Workout)", HomeType.PILATES, "https://www.youtube.com/watch?v=3zRMZ4Uijlo&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home16);

            Home home17 = createHome("필라테스vs헬스 구분해드림!!!!! 어떤 운동이 살이 더 잘 빠질까?", HomeType.PILATES, "https://www.youtube.com/watch?v=oaIZI3yjUlM&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home17);

            Home home18 = createHome("58kg →52kg 다이어트‼️(통통에서 마름으로) 3천만원 쓰고 찾아낸 살 잘빠지는 운동 추천 \uD83C\uDFCB\uD83C\uDFFB (헬스vs필라테스)", HomeType.PILATES, "https://www.youtube.com/watch?v=pUKZt7Jx7Kk&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home18);

            Home home19 = createHome("[코로나 홈트]서클링을 이용한 소도구 매트 필라테스 50분 풀 시퀀스입니다. -전신 근력 운동 편-", HomeType.PILATES, "https://www.youtube.com/watch?v=2kSU6J0dBi0&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home19);

            Home home20 = createHome("[ohhoho\uD83D\uDCAA] 집에서 할 수 있는 근력 운동\uD83C\uDFCB l 홈트 l 필라테스\uD83E\uDD38 l 원호 WONHO", HomeType.PILATES, "https://www.youtube.com/watch?v=cRjh1grurJg&pp=ygUT7ZmI7Yq4IO2VhOudvO2FjOyKpA%3D%3D");
            em.persist(home20);


            //
            Home home21 = createHome("요가와 근력운동 한번에 하는 루틴 | 근력 유산소, 전신 올인원 운동, 요가 워크아웃", HomeType.YOGA, "https://www.youtube.com/watch?v=8bhVTAOIZ7E&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home21);

            Home home22 = createHome("Yoga hip-up stretch 힙업 홈트 요가스트레칭  | at Home Training 9 min work out ホームトレーニング 家居訓練 #11", HomeType.YOGA, "https://www.youtube.com/watch?v=2O2-vYVyHK8&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home22);

            Home home23 = createHome("��January 9 홈트 요가 \uD83C\uDF38 Morning Stretching to Open Hips Simple yoga  work out at home in hotWorkout 運動", HomeType.YOGA, "https://www.youtube.com/watch?v=shUDk1RBOMU&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home23);

            Home home24 = createHome("누구나 할 수 있는 홈요가 수련 | 50분 전신 스트레칭", HomeType.YOGA, "https://www.youtube.com/watch?v=x2IWl3wT8Zc&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home24);

            Home home25 = createHome("전신순환을 위한 30분 요가 | 혈액순환 스트레칭", HomeType.YOGA, "https://www.youtube.com/watch?v=ZgBfmJfE1Sk&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home25);

            Home home26 = createHome("[일일홈트48] 오리지널 요가팬츠입고 폼롤러 운동. foam roller w/ yellow yoga pants.", HomeType.YOGA, "https://www.youtube.com/watch?v=Y99f2ACrEko&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home26);

            Home home27 = createHome("주말의 홈트｜한수진의 요가 한 수, ‘남녀노소 누구나 할 수있는 스트레칭’", HomeType.YOGA, "https://www.youtube.com/watch?v=TEQ4FapAZe4&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home27);

            Home home28 = createHome("주말의 홈트｜한수진의 요가 한 수, ‘상체 전체 근육 스트레칭'", HomeType.YOGA, "https://www.youtube.com/watch?v=7X17oHFW4v4&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home28);

            Home home29 = createHome("4.26\uD83D\uDC83Exercise in black pantyhose運動\uD83D\uDC83hip up\uD83C\uDFE1초보 요가\uD83D\uDE1Baimier Stretching Yoga스트레칭 홈트요가", HomeType.YOGA, "https://www.youtube.com/watch?v=F32_6GFXIdU&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home29);

            Home home30 = createHome("애플힙 Workout \uD83D\uDE1B 홈트 운동 エクササイズヨガ 運動 \uD83C\uDF0A Yoga Stretching hip up 요가운동", HomeType.YOGA, "https://www.youtube.com/watch?v=Plxjt-rZOuQ&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home30);

            Home home31 = createHome("11 Min Full Body Morning Yoga Home workout @ABBY FIT YOGA 11분 홈트 요가 스트레칭 레깅스 필라테스 홈트레이닝 ヨガ йога 瑜伽", HomeType.YOGA, "https://www.youtube.com/watch?v=qhPofwDU45U&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home31);

            Home home32 = createHome("시간 순삭 홈트레이닝 요가 스트레칭 1편 | 새로운 식구 왔어요 | 보기만해도 건강해 지는 영상 | korean sexy model girl home training", HomeType.YOGA, "https://www.youtube.com/watch?v=eGCHiTK3WYQ&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home32);

            Home home33 = createHome("Stretching Yoga Home Training 힙업 홈트 요가스트레칭 hip-up", HomeType.YOGA, "https://www.youtube.com/watch?v=38Aok-0LRfI&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home33);

            Home home34 = createHome("yoga 힙업 홈트 요가스트레칭 hip-up stretch before work at home \uD83D\uDE1B at Home stretches workout 運動", HomeType.YOGA, "https://www.youtube.com/watch?v=XWD4ZDAP0BU&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home34);

            Home home35 = createHome("Home Sports workout project yoga workout 家庭有氧運動모닝 요가 運動 瑜伽 拉伸 홈트 줌마hip", HomeType.YOGA, "https://www.youtube.com/watch?v=Dqv2yC4cMhQ&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home35);

            Home home36 = createHome("홈트 요가 필라테스 다양한 자세 새로운 1편  Home Yoga and Pilates Various Postures Part New 1", HomeType.YOGA, "https://www.youtube.com/watch?v=JHNaqr-q3to&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home36);

            Home home37 = createHome("Daily workout Yoga stretch 힙업 홈트 요가스트레칭  | at Home Training ホームトレーニング 家居訓練 hip-up", HomeType.YOGA, "https://www.youtube.com/watch?v=pW_kHFpwgcY&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home37);

            Home home38 = createHome("요통 완전 정복 요가(ft.안다르)", HomeType.YOGA, "https://www.youtube.com/watch?v=r9P6AqQNZBo&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home38);

            Home home39 = createHome("7min Yoga 힙업 홈트 요가스트레칭 Contortion | Splits Stretching, Yoga Stretching - Beautiful Yona", HomeType.YOGA, "https://www.youtube.com/watch?v=7HrJLnHfVcw&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home39);

            Home home40 = createHome("매일하기 좋은 15분 데일리 스트레칭 | 기초 요가 스트레칭, 전신 스트레칭", HomeType.YOGA, "https://www.youtube.com/watch?v=tZEZNsuDkLY&pp=ygUN7ZmI7Yq4IOyalOqwgA%3D%3D");
            em.persist(home40);

            Home home41 = createHome("NO 층간소음 - 20분 상체운동 루틴 + 스트레칭", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=e1DHt9wfQOA&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home41);

            Home home42 = createHome("Lv.3 8분만에 상체전체를 탈탈 털어버리는 홈트루틴 (누구나 쉽게 가능)", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=uTmsvZOAh5U&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home42);

            Home home43 = createHome("1200만뷰돌파! 삐약스핏 레전드팔뚝살 리뉴얼 Ejercicio de la parte superior del cuerpo en casa집에서상체운동Upper body workout", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=I6N1v1Jqazo&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home43);

            Home home44 = createHome("※등살, 겨살, 팔뚝살※ 10분 만에 탈탈 털어버리는 운동 - 이 영상으로 상체 정리하고 여름에 같이 민소매 입어요❤️", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=UF34fAIoX1A&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home44);

            Home home45 = createHome("난리난 상체운동 겨드랑이살 팔뚝살 집중편 slim upper body, upper arm workout, lymphokinesis", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=wuR-vSf2oFg&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home45);

            Home home46 = createHome("\uD83D\uDD25건장한 상체\uD83D\uDD25가 여리+슬림+탄탄해지는 '상체올킬루틴' (7일효과: 팔뚝살,등살,뱃살 완전빠짐&탄력up!!!)", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=XjEfUcZLbG4&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home46);

            Home home47 = createHome("[PPIYAK's FIT]Ejercicio de la parte superior del cuerpo en casa집에서하는 상체운동!Upper body workout at home", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=2swcod5RYvU&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home47);

            Home home48 = createHome("상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=54tTYO-vU2E&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home48);

            Home home49 = createHome("상체 다이어트 운동 BEST [팔뚝살/겨드랑이살/가슴어깨/등살]", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=C3TqpGgnIoI&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home49);

            Home home50 = createHome("단기간 상체토닝 루틴! 여리탄탄 보장! 매일15분, 일주일만 해보세요! (덤벨O)", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=jGKiwk3aNFI&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home50);

            Home home51 = createHome("덤벨 상체 운동 10분 루틴 - 팔, 가슴, 어깨, 등에 자극 대박이에요!! (Upper body workout with dumbbell)", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=MknWfiAmqx8&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home51);

            Home home52 = createHome("기구없이❌ 따라하는 ALL 상체근육 홈트레이닝 루틴 (등, 가슴, 어깨, 팔, 복근)", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=cUjNYSSlwts&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home52);

            Home home53 = createHome("균형잡힌 탄탄한 상체와 멋진 자세를 위한 덤벨 상체 운동 홈트 22분", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=U7IH4wyVMBU&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home53);

            Home home54 = createHome("[상체편] 상체 덤벨운동의 끝판왕 - 두번째 달", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=igSinYhgcvM&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home54);

            Home home55 = createHome("��요일별운동\uD83C\uDFC5 목요일 상체집중 근력운동 15분 루틴!", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=Vx2yxXQ0Pkk&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home55);

            Home home56 = createHome("초중급 Day 3 - 5일 홈트 초보 챌린지 - 올인원 운동 / 상체운동 + 근력 유산소 (48분)", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=w9_nD8SUwzA&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home56);

            Home home57 = createHome("탄탄한 가슴, 어깨, 등 만들기 - 10분 라텍스 밴드 상체 운동 l 10min RESISTANCE BAND WORKOUT (Chest, Shoulder, Back target)", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=Mt083IzdqIE&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home57);

            Home home58 = createHome("1000만뷰 팔뚝살 운동법 리뉴얼편!! 집에서 하는 상체운동 Ejercicio de la parte superior del cuerpo. Upper body workout", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=LpesyhVZWxY&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home58);

            Home home59 = createHome("등, 가슴, 팔, 어깨 탄탄하게 만들기 - 덤벨 상체 운동 홈트 루틴", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=xoWKLNwNva0&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home59);

            Home home60 = createHome("집에서 할 수 있는 상체운동 루틴 | 다이어트+근육증가 버전!! 이대로만 하세요 [DAY3]", HomeType.UPPERBODY, "https://www.youtube.com/watch?v=GZtB7W9Uafk&pp=ygUT7ZmI7Yq4IOyDgeyytOyatOuPmQ%3D%3D");
            em.persist(home60);

            Home home61 = createHome("Lv.5 13분만에 하체 마비시키는 루틴! 근육통100% 옵니다. (누구나 집에서 가능) 13mins intense Legs Workout", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=KXYi6bI-UPE&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home61);

            Home home62 = createHome("(층간소음X, 설명O) 진짜 힘듦주의.. \uD83D\uDD25초강력\uD83D\uDD25 힙으뜸 하체운동 2주 챌린지", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=js8z5wIZ0wg&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home62);

            Home home63 = createHome("토탈 하체 운동 \uD83D\uDC36(앞벅지,뒷벅지,안벅지,외벅지,엉덩이 맛집)", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=OaFsK9xUhX4&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home63);

            Home home64 = createHome("하체비만 11자다리 최고의 운동 [하체 핵매운맛]", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=NDsjmxTROEo&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home64);

            Home home65 = createHome("하체 날, 딱 10분 밖에 없다면 - 스쿼트 10가지 동작 - 하체운동 홈트 루틴", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=DWYDL-WxF1U&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home65);

            Home home66 = createHome("무릎관절에 무리없는 걷기 대신 이 운동을 무조건 꼭 해보세요! 한달 후 엉덩이 하체 근력에 놀라운 변화가 생깁니다. 스쿼트 대신 체력 기르는 운동 40대 50대 60대 다리운동", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=eY-Rzg-_XQw&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home66);

            Home home67 = createHome("스쿼트 없는 근력 유산소 전신운동 - 관절에 무리없이 체지방 태우기 - 하체와 코어 강화", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=GoxGhz_6VRA&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home67);

            Home home68 = createHome("달리기에 최적화된 5분하체운동! 하체 중량운동을 하지 않는 이유?", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=FS_hmVHlFVs&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home68);

            Home home69 = createHome("Lv.5 딱 11분! 노빠꾸 하체루틴! 근육UP 지방은DOWN!", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=4aI2kfahWP0&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home69);

            Home home70 = createHome("엉덩이와 하체를 탄탄하게 - 하체운동 18분 - 덤벨운동 홈트", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=4qqBQ0Xs4nc&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home70);

            Home home71 = createHome("단기간 하체토닝 루틴, 힙업보장! 매일15분, 일주일만 해보세요!", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=saVNCLGvics&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home71);

            Home home72 = createHome("��요일별운동\uD83C\uDFC5 금요일 하체집중 근력운동 15분 루틴!", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=pDFuLG0xrsU&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home72);

            Home home73 = createHome("하체운동 허벅지운동 런지! 홈트에서 많이 하는 운동!  잘못하시면 무릎박살납니다", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=7erin-2cpRo&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home73);

            Home home74 = createHome("Lv.5 7분 고강도 하체 기능상실 루틴", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=NE2NV_iljxg&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home74);

            Home home75 = createHome("Lv.1.5 누구나 쌉 가능한 하체 마스터 루틴 (웜업포함)", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=6R2fLpXOKQI&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home75);

            Home home76 = createHome("초보자도 쉽고,재밌게! 하루 딱15분 하체운동 홈트레이닝!", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=GASCMxaAHKw&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home76);

            Home home77 = createHome("하루10분 투자로 하체와 힙업을 한번에 (칼로리소모 끝판왕) 하체운동루틴 [오늘의루틴]", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=0GwwUTYAOTg&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home77);

            Home home78 = createHome("다리가 길어보이는 힙딥 없는 힙업 운동 - 하체운동 25분", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=0s9W3-CD0cE&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home78);

            Home home79 = createHome("스쿼트 없이 하체를 키우는 최고의 하체운동", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=QSCeJ__akl0&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home79);

            Home home80 = createHome("집에서 부담없이 하는 10분 하체운동 루틴! 데스런.", HomeType.LOWERBODY,"https://www.youtube.com/watch?v=6qDagGUbERM&pp=ygUT7ZmI7Yq4IO2VmOyytOyatOuPmQ%3D%3D");
            em.persist(home80);

            Home home81 = createHome("Lv.3 완벽한 복근을 만들기 위한 8분 루틴! 따라만하세요! (누구나 집에서도 가능) [8mins intense Abs Workout]", HomeType.CORE,"https://www.youtube.com/watch?v=jj6ze_eqmYI&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home81);

            Home home82 = createHome("(층간소음X, 설명O) 복근운동과 유산소를 한번에❗️서서하는 복근운동 1탄\uD83D\uDD25", HomeType.CORE,"https://www.youtube.com/watch?v=kETh8T3it4k&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home82);

            Home home83 = createHome("(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", HomeType.CORE,"https://www.youtube.com/watch?v=7TLk7pscICk&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home83);

            Home home84 = createHome("12분 서서하는 복근운동 홈트레이닝 - 체지방 태우기는 보너스", HomeType.CORE,"https://www.youtube.com/watch?v=sqQpL1wKW6M&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home84);

            Home home85 = createHome("11자복근 복부 최고의 운동 [복근 핵매운맛]", HomeType.CORE,"https://www.youtube.com/watch?v=PjGcOP-TQPE&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home85);

            Home home86 = createHome("아랫배, 옆구리, 허리라인을 매끈하고 탄탄하게 - 코어 힘도 길러주는 복근운동 10분 홈트 루틴", HomeType.CORE,"https://www.youtube.com/watch?v=vckr1GJ0JMs&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home86);

            Home home87 = createHome("2주만에 뱃살빼기! 효과보장! \uD83D\uDD2520분 논스탑 서서하는 복근 운동 - 스쿼트X 런지X 점핑X", HomeType.CORE,"https://www.youtube.com/watch?v=CcbOzO3-V14&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home87);

            Home home88 = createHome("일주일만에 뱃살 빼기\uD83D\uDD2530분 서서하는 복근 운동 - 스쿼트X 런지X 점핑X", HomeType.CORE,"https://www.youtube.com/watch?v=u_9untoVK7w&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home88);

            Home home89 = createHome("Lv2.5 9분만에 복근 찢어집니다! 누구나 가능한 완벽한 복근루틴 9Mins Intense Abs Workout! Make Sixpack Together!", HomeType.CORE,"https://www.youtube.com/watch?v=SwlS857LjVc&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home89);

            Home home90 = createHome("르세라핌 카즈하가 실.제.로 하고있는 복근운동 루틴 10분 ( * 진짜 11자 복근이 단기간에 너무 예쁘게 만들어집니다 )", HomeType.CORE,"https://www.youtube.com/watch?v=P81i-Umj6i8&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home90);

            Home home91 = createHome("[ENG]세계 1등 홍범석 복근운동법..딱 11분인데..이게 가능하다고?", HomeType.CORE,"https://www.youtube.com/watch?v=K9XGEwgs47M&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home91);

            Home home92 = createHome("고강도 날씬한 허리라인운동 - 복근운동 홈트 루틴", HomeType.CORE,"https://www.youtube.com/watch?v=fmy6uC0Im3s&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home92);

            Home home93 = createHome("10분  덤벨 서서하는 복근운동 홈트", HomeType.CORE,"https://www.youtube.com/watch?v=gpTYMAxN0CM&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home93);

            Home home94 = createHome("2주 플랭크 챌린지 - 10가지 동작 - 코어운동 복근운동 홈트의 왕! \uD83D\uDC51", HomeType.CORE,"https://www.youtube.com/watch?v=VgM5QjnAM84&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home94);

            Home home95 = createHome("일반인들이 '식스팩' 만들려면 얼마나 걸릴까? (빠르게 복근 만드는 운동루틴)", HomeType.CORE,"https://www.youtube.com/watch?v=f6MrRoFRG6Y&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home95);

            Home home96 = createHome("[주원홈트 복근] 뱃살빼는 운동 레전드가 될 영상입니다!!! [PPIYAK's FIT] legend of abs workout", HomeType.CORE,"https://www.youtube.com/watch?v=tJXz1hFUBLA&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home96);

            Home home97 = createHome("복부운동 짧고 굵게! 운동효율 갑!  [6 MINS ABS WORKOUT]", HomeType.CORE,"https://www.youtube.com/watch?v=sVQqBDBZhmI&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home97);

            Home home98 = createHome("짧은 복근 운동 루틴. 직장인도 하루 5분이면 식스팩 가능합니다.", HomeType.CORE,"https://www.youtube.com/watch?v=eIq2h1aZ8lA&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home98);

            Home home99 = createHome("10분 서서하는 복근운동 홈트", HomeType.CORE,"https://www.youtube.com/watch?v=xG6epreSCek&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home99);

            Home home100 = createHome("[데스런] 집에서 하는 맨몸 10분 복근운동.", HomeType.CORE,"https://www.youtube.com/watch?v=EFadnuaH-Jg&pp=ygUT7ZmI7Yq4IOuzteq3vOyatOuPmQ%3D%3D");
            em.persist(home100);

            Home home101 = createHome("집에서 칼로리 불태우는 최고의 유산소운동 [칼소폭 매운맛]", HomeType.CARDIO,"https://www.youtube.com/watch?v=lKwZ2DU4P-A&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home101);

            Home home102 = createHome("NO 층간소음 올인원 운동 - 40분 유산소운동 홈트 - 관절에 무리없이 체지방 태우기", HomeType.CARDIO,"https://www.youtube.com/watch?v=myNjmnvI6x0&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home102);

            Home home103 = createHome("몸 무거운 월요일 - 가볍게 부담없이 28분 층간소음 없는 관절무리없는 유산소 운동 - 초보 홈트", HomeType.CARDIO,"https://www.youtube.com/watch?v=0IWibGOf1jU&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home103);

            Home home104 = createHome("��출렁이는 지방\uD83D\uDD25단기간에 빼고 싶으면 이 유산소운동 1달만 하세요. (유산소 다이어트/전신 유산소 타바타/칼로리 폭발 운동)", HomeType.CARDIO,"https://www.youtube.com/watch?v=sucNosF93w8&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home104);

            Home home105 = createHome("[ENG] (층간소음 X) 진짜 역대급 20분 루틴ㅣ전신올인원 I 힙으뜸 유산소 운동", HomeType.CARDIO,"https://www.youtube.com/watch?v=46vQnzaZ6aU&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home105);

            Home home106 = createHome("체지방 길게 태워보자 - 본운동만 40분 서서하는 유산소 운동 홈트", HomeType.CARDIO,"https://www.youtube.com/watch?v=sTX0C08SYBM&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home106);

            Home home107 = createHome("[SUB] 20분만에 1시간 30분 걷기운동 효과! 집에서 하는 유산소 운동", HomeType.CARDIO,"https://www.youtube.com/watch?v=5vL7aGYl_AI&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home107);

            Home home108 = createHome("가볍지만 확실하게 체지방 걷어내는 유산소 / 다이어트 운동 홈트레이닝 - 논스탑 휴식없음", HomeType.CARDIO,"https://www.youtube.com/watch?v=yJm9SGS2IhA&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home108);

            Home home109 = createHome("기초체력 기르는 20분 전신 유산소 운동 (No 런지, No 스쿼트)", HomeType.CARDIO,"https://www.youtube.com/watch?v=OoytN1a8Klc&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home109);

            Home home110 = createHome("NO 층간소음 - 고민없이 하나로 끝내는 전신운동 근력 유산소 - 운동 못한 날 죄책감 씻어줄 30분 홈트", HomeType.CARDIO,"https://www.youtube.com/watch?v=4kZHHPH6heY&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home110);

            Home home111 = createHome("정말 무서운 속도로 살이 빠지는 극강의 유산소 - 41kg 까지 빠졌던 문제의 그 운동입니다 (반복X, 쉬는시간X)", HomeType.CARDIO,"https://www.youtube.com/watch?v=S4xfkLMJdwI&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home111);

            Home home112 = createHome("20분 걸으면서 살빼는 유산소운동/난이도:하", HomeType.CARDIO,"https://www.youtube.com/watch?v=dWsWZZQ-dWM&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home112);

            Home home113 = createHome("매일 ‘이 동작’을 6분씩 한 후로 헬스장 환불했다(ㅋㅋ) / 전신유산소운동", HomeType.CARDIO,"https://www.youtube.com/watch?v=ml7IfUSfzCw&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home113);

            Home home114 = createHome("층간소음X 설명O) 살 빠지는 전신 다이어트 1만보 걷기운동 // 60분 걷기 유산소 홈트(땀폭발)\uD83D\uDD25왕초보 전신 유산소 운동(NO 스쿼트, 런지)", HomeType.CARDIO,"https://www.youtube.com/watch?v=JhcwRL9Hqig&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home114);

            Home home115 = createHome("하루 운동 이거로 끝! [유산소 + 미운지방] 한방에 정리하는 30분 홈트루틴\uD83D\uDD25", HomeType.CARDIO,"https://www.youtube.com/watch?v=3NlIO4PN-ic&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home115);

            Home home116 = createHome("유튜브 홈트 역사상 가장 살이 잘 빠지는 단 10분의 운동 죽음의 유산소", HomeType.CARDIO,"https://www.youtube.com/watch?v=niSkbOuQG9I&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home116);

            Home home117 = createHome("(층간소음X, 설명O) 복근운동과 유산소를 한번에❗️서서하는 복근운동 1탄\uD83D\uDD25", HomeType.CARDIO,"https://www.youtube.com/watch?v=kETh8T3it4k&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home117);

            Home home118 = createHome("전신 - 근력 유산소 다이어트 운동 / 100일 홈트 프로그램 - Day 1", HomeType.CARDIO,"https://www.youtube.com/watch?v=-956vy_VNqI&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home118);

            Home home119 = createHome("빠르게 칼로리 버닝 - 서서하는 유산소 - 다이어트 운동", HomeType.CARDIO,"https://www.youtube.com/watch?v=02K-k6daPb4&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home119);

            Home home120 = createHome("\uD83D\uDD25하자마자 -0.5kg 빠짐 보장\uD83D\uDD25전신 지방 칼로리 다 날려버리는 핵폭탄급 30분 걷기운동 (전신운동 다이어트, 유산소운동, 홈트)", HomeType.CARDIO,"https://www.youtube.com/watch?v=TwAujNfKhqs&pp=ygUQ7ZmI7Yq4IOycoOyCsOyGjA%3D%3D");
            em.persist(home120);


        }

        private Gym createGym(String name, GymType gymType, String information, String url, Double kcal) {
            Gym gym = new Gym();
            gym.setName(name);
            gym.setType(gymType);
            gym.setInformation(information);
            gym.setUrl(url);
            gym.setKcal(kcal);
            return gym;
        }

        private Home createHome(String videoName, HomeType homeType, String url) {
            Home home = new Home();
            home.setVideoName(videoName);
            home.setUrl(url);
            home.setType(homeType);
            return home;
        }
    }
}

